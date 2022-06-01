package ru.demo.app.log

import enumeratum.{Enum, EnumEntry}

import scala.collection.immutable

sealed abstract class ContextKey(override val entryName: String) extends EnumEntry

object ContextKey extends Enum[ContextKey] {
  case object MDCOrderId extends ContextKey("order_id")
  case object MDCPlatform extends ContextKey("platform")
  case object MDCException extends ContextKey("exception")
  case object MDCCause extends ContextKey("cause")

  override def values: immutable.IndexedSeq[ContextKey] = findValues
}
