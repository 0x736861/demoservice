package ru.demo.app.di.module

import izumi.distage.model.definition.ModuleDef
import izumi.logstage.api.IzLogger
import izumi.logstage.api.rendering.json.LogstageCirceRenderingPolicy
import izumi.logstage.sink.ConsoleSink
import logstage.LogZIO
import ru.demo.app.log.{Logger, LoggerIO}

object LogModule extends ModuleDef {
  make[Logger].fromValue {
    val sink = ConsoleSink(LogstageCirceRenderingPolicy())
    IzLogger(IzLogger.Level.Trace, sink)
  }

  make[LoggerIO].from { logger: Logger =>
    LogZIO.withFiberId(logger)
  }
}
