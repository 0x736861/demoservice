package ru.pimpay

import distage.Injector
import izumi.distage.model.definition.StandardAxis
import ru.pimpay.di.module.AppModule
import ru.pimpay.service.OrderProcessor
import zio.{ExitCode, Task, URIO}

object App extends zio.App {

  def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = {
    Injector[Task]()
      .produceGet[OrderProcessor](AppModule, StandardAxis.prodActivation)
      .use(_.processPendingOrders)
      .exitCode
  }
}
