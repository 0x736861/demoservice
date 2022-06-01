package ru.demo.domain.error

abstract class AppError(message: String, cause: Option[Throwable] = None) extends Exception(message, cause.orNull)

final case class DbError(message: String, cause: Option[Throwable]) extends AppError(message, cause)
