package ru.pimpay.service

import ru.pimpay.repo.OrderRepository
import zio.{Task, UIO, ZIO}

trait OrderProcessor {
  def processPendingOrders: Task[Int]
}

object OrderProcessor {

  final case class LiveOrderProcessor(
      orderRepository: OrderRepository,
      rabbitProducer: RabbitProducer,
  ) extends OrderProcessor {
    def processPendingOrders: Task[Int] = {
      for {
        _ <- UIO("println processing pending orders")
        orders <- orderRepository.getPendingOrders(100)
        _ <- ZIO.foreach(orders)(order => rabbitProducer.sendMessage(order.toString))
        _ <- UIO(s"println processed ${orders.size} orders")
      } yield orders.size
    }
  }

}
