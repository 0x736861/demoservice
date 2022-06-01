package ru.demo.app.di.module

import izumi.distage.model.definition.ModuleDef
import ru.demo.domain.service.{OrderProcessor, RabbitProducer}
import ru.demo.domain.service.OrderProcessor.LiveOrderProcessor
import ru.demo.infra.rabbit.LiveRabbitProducer

object ServiceModule extends ModuleDef {
  make[RabbitProducer].from[LiveRabbitProducer]
  make[OrderProcessor].from[LiveOrderProcessor]
}
