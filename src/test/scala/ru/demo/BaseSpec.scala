package ru.demo

import izumi.distage.testkit.scalatest.{AssertZIO, Spec3}
import org.scalamock.scalatest.MockFactory
import org.scalatest.Assertion
import zio.ZIO

abstract class BaseSpec extends Spec3[ZIO] with AssertZIO with MockFactory {

  def assertAppError[R, E, A](zio: ZIO[R, E, A])(x: E => Assertion): ZIO[R, Any, Assertion] =
    zio.either.map { e: Either[E, A] =>
      e.fold[Assertion](x, _ => assert(false))
    }

}
