package ru.demo

import ru.demo.domain.error.AppError
import zio.ZIO

package object domain {
  type AppRIO[R, A] = ZIO[R, AppError, A]
  type AppIO[A] = AppRIO[Any, A]
}
