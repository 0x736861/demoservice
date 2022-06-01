package ru.demo.domain.service

import ru.demo.app.log.LoggerIO
import ru.demo.domain.AppIO
import ru.demo.domain.repo.OrderRepository
import zio.ZIO

trait OrderProcessor {
  def processPendingOrders: AppIO[Int]
}

object OrderProcessor {

  final case class LiveOrderProcessor(
      logger: LoggerIO,
      orderRepository: OrderRepository,
      rabbitProducer: RabbitProducer,
  ) extends OrderProcessor {

    def processPendingOrders: AppIO[Int] =
      for {
        _      <- logger.info("println processing pending orders")
        orders <- orderRepository.getAllOrders
        _      <- ZIO.foreach(orders)(order => rabbitProducer.sendOrder(order))
        _      <- logger.info(s"processed ${orders.size} orders")
      } yield orders.size

  }

}
