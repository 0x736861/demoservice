package ru.demo.domain.service

import distage.ModuleDef
import izumi.distage.testkit.TestConfig
import org.scalamock.matchers.ArgCapture.CaptureAll
import ru.demo.BaseSpec
import ru.demo.domain.model.Order
import ru.demo.domain.repo.OrderRepository
import ru.demo.domain.service.OrderProcessor.LiveOrderProcessor
import ru.demo.infra.doobie.DbTransactor
import zio.{UIO, ZIO}

class LiveOrderProcessorSpec extends BaseSpec {

  override def config: TestConfig =
    super.config.copy(
      moduleOverrides = super.config.moduleOverrides ++ new ModuleDef {
        make[OrderProcessor].from[LiveOrderProcessor]
        make[RabbitProducer].from(mock[RabbitProducer])
        make[OrderRepository].from(mock[OrderRepository])
        make[DbTransactor].named("txProd").from(mock[DbTransactor])
        make[DbTransactor].named("txReplica").from(mock[DbTransactor])
      },
    )

  "LiveOrderProcessor" should {
    "process all orders" in {
      (orderProcessor: OrderProcessor, orderRepository: OrderRepository, rabbitProducer: RabbitProducer) =>
        for {
          orders          <- UIO(
            List(
              Order(1, "platform", "platformOrderId1"),
              Order(2, "platform", "platformOrderId2"),
            ),
          )
          publishedOrders <- UIO(CaptureAll[Order]())
          _               <- UIO(
            (orderRepository.getAllOrders _).expects().returning(UIO(orders)),
          )
          _               <- UIO(
            (rabbitProducer.sendOrder _).expects(capture(publishedOrders)).returning(ZIO.unit).anyNumberOfTimes,
          )
          processedCnt    <- orderProcessor.processAllOrders
        } yield {
          assert(processedCnt == 2)
          assert(publishedOrders.values.toSet == orders.toSet)
        }

    }
  }
}
