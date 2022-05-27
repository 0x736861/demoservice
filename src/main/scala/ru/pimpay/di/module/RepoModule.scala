package ru.pimpay.di.module

import izumi.distage.model.definition.ModuleDef
import ru.pimpay.repo.OrderRepository
import ru.pimpay.repo.OrderRepository.DoobieOrderRepository

object RepoModule extends ModuleDef{
  make[OrderRepository].from[DoobieOrderRepository]
}
