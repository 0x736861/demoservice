package ru.demo.infra.doobie

import ru.demo.domain.AppIO
import ru.demo.domain.error.DbError
import ru.demo.domain.model.Order
import ru.demo.domain.repo.OrderRepository
import zio.Task

class DoobieOrderRepository extends OrderRepository {

  def getAllOrders: AppIO[List[Order]] = {
    Task {
      List(
        Order(1, "boxberry", "1123423"),
        Order(2, "boxberry", "asfsdfas"),
      )
    }.mapError(e => DbError(s"Failed to get all orders: ${e.getMessage}", Some(e)))
  }
}
