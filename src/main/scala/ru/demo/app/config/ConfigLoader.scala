package ru.demo.app.config

import com.typesafe.config.ConfigFactory
import pureconfig.{ConfigReader, ConfigSource}

import scala.reflect.ClassTag

object ConfigLoader {

  def apply[A: ClassTag](path: String)(implicit cr: ConfigReader[A]): A = {
    Option(System.getenv("CONFIG_RESOURCE")).foreach { configName =>
      System.setProperty("config.resource", configName)
      ConfigFactory.invalidateCaches()
    }
    ConfigSource.default.at(path).loadOrThrow[A]
  }

}
