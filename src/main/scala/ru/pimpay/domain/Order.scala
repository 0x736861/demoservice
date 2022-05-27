package ru.pimpay.domain

case class Order(
    id: Long,
    platform: String,
    platformOrderId: String
)
