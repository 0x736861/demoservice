package ru.pimpay.repo

import ru.pimpay.domain.Order
import zio.Task

trait OrderRepository {
  def getPendingOrders(limit: Int): Task[List[Order]]
}

object OrderRepository {

  final case class DoobieOrderRepository() extends OrderRepository {

    def getPendingOrders(limit: Int): Task[List[Order]] =
      Task {
        List(
          Order(1, "boxberry", "1123423"),
          Order(2, "boxberry", "asfsdfas"),
        )
      }
  }

  final case class InMemOrderRepository() extends OrderRepository {
    def getPendingOrders(limit: Int): Task[List[Order]] = ???
  }

}
