package ru.demo.domain.repo

import ru.demo.domain.AppIO
import ru.demo.domain.model.Order

trait OrderRepository {
  def getAllOrders: AppIO[List[Order]]
}
