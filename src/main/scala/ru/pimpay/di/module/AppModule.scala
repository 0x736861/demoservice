package ru.pimpay.di.module

import izumi.distage.model.definition.ModuleDef

object AppModule extends ModuleDef {
  include(RepoModule)
  include(ServiceModule)
}
