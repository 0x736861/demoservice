package ru.demo.infra.rabbit

import ru.demo.app.log.ContextKey._
import ru.demo.app.log.LoggerIO
import ru.demo.domain.AppIO
import ru.demo.domain.model.Order
import ru.demo.domain.service.RabbitProducer
import zio.UIO

final class LiveRabbitProducer(logger: LoggerIO) extends RabbitProducer {

  def sendOrder(order: Order): AppIO[Unit] =
    for {
      ctxLogger <- UIO {
        logger(
          MDCOrderId.entryName -> order.id,
          MDCPlatform.entryName -> order.platform,
        )
      }
      _         <- ctxLogger.info(s">>> $order")
    } yield ()

}
