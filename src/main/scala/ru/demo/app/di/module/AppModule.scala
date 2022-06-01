package ru.demo.app.di.module

import izumi.distage.model.definition.ModuleDef

object AppModule extends ModuleDef {
  include(LogModule)
  include(RepoModule)
  include(ServiceModule)
}
