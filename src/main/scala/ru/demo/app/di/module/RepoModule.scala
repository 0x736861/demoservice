package ru.demo.app.di.module

import izumi.distage.model.definition.ModuleDef
import ru.demo.app.config.{ConfigLoader, DbConfig}
import ru.demo.domain.repo.OrderRepository
import ru.demo.infra.doobie.{DbTransactor, DoobieOrderRepository}

object RepoModule extends ModuleDef {
  make[DbConfig].from(ConfigLoader[DbConfig]("db"))
  make[DbTransactor].from(DbTransactor.make _)
  make[OrderRepository].from[DoobieOrderRepository]
}
