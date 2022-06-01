package ru.demo.infra.doobie

import ru.demo.app.config.DbConfig
import ru.demo.app.log.Logger

case class DbTransactor(host: String, port: Int, username: String, password: String, dbname: String)

object DbTransactor {

  def make(
            log: Logger,
            config: DbConfig,
  ): DbTransactor = {
    log.info(s"Build transactor with config $config")
    DbTransactor(
      host = config.host,
      port = config.port,
      username = config.username,
      password = config.password,
      dbname = config.dbname,
    )
  }

}
