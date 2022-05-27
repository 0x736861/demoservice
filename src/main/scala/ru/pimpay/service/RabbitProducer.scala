package ru.pimpay.service

import zio.{Task, UIO}

trait RabbitProducer {
  def sendMessage(msg: String): Task[Unit]
}

object RabbitProducer {
  final class LiveRabbitProducer(                                      ) extends RabbitProducer {
    def sendMessage(msg: String): Task[Unit] = {
      UIO(println(s">>> $msg"))
    }
  }
}
