package ru.demo.app.config

import pureconfig.ConfigReader
import pureconfig.generic.semiauto.deriveReader

case class DbConfig(
    host: String,
    port: Int,
    username: String,
    password: String,
    dbname: String,
)

object DbConfig {
  implicit val reader: ConfigReader[DbConfig] = deriveReader
}
