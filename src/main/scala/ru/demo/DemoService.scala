package ru.demo

import distage.Injector
import izumi.distage.model.definition.StandardAxis
import ru.demo.app.di.module.AppModule
import ru.demo.domain.service.OrderProcessor
import zio.{ExitCode, Task, URIO}

object DemoService extends zio.App {

  def run(args: List[String]): URIO[zio.ZEnv, ExitCode] =
    Injector[Task]()
      .produceGet[OrderProcessor](AppModule, StandardAxis.prodActivation)
      .use(_.processPendingOrders)
      .exitCode

}
