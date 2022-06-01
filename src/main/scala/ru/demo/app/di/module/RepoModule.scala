package ru.demo.app.di.module

import izumi.distage.model.definition.ModuleDef
import ru.demo.app.config.{ConfigLoader, DbConfig}
import ru.demo.domain.repo.OrderRepository
import ru.demo.infra.doobie.{DbTransactor, DoobieOrderRepository}

object RepoModule extends ModuleDef {
  make[DbConfig].named("dbConfigProd")
    .from(ConfigLoader[DbConfig]("db"))

  make[DbConfig].named("dbConfigReplica")
    .from(ConfigLoader[DbConfig]("dbReplica"))

  make[DbTransactor].named("txProd")
    .from { DbTransactor.make _}
    .annotateParameter[DbConfig]("dbConfigProd")

  make[DbTransactor].named("txReplica")
    .from { DbTransactor.make _}
    .annotateParameter[DbConfig]("dbConfigReplica")

  make[OrderRepository].from[DoobieOrderRepository]
}
