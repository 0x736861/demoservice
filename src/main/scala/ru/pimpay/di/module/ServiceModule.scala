package ru.pimpay.di.module

import izumi.distage.model.definition.ModuleDef
import ru.pimpay.service.OrderProcessor.LiveOrderProcessor
import ru.pimpay.service.{OrderProcessor, RabbitProducer}
import ru.pimpay.service.RabbitProducer.LiveRabbitProducer

object ServiceModule extends ModuleDef {
  make[RabbitProducer].from[LiveRabbitProducer]
  make[OrderProcessor].from[LiveOrderProcessor]
}
