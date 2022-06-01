package ru.demo.app

import logstage.{IzLogger, LogIO2}
import zio.IO

package object log {
  type Logger =  IzLogger
  type LoggerIO = LogIO2[IO]
}
