package ru.demo.domain.service

import ru.demo.domain.AppIO
import ru.demo.domain.model.Order

trait RabbitProducer {
  def sendOrder(order: Order): AppIO[Unit]
}
