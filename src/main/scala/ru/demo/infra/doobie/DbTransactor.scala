package ru.demo.infra.doobie

import ru.demo.app.config.DbConfig

case class DbTransactor(host: String, port: Int, username: String, password: String, dbname: String)

object DbTransactor {

  def make(dbConfig: DbConfig): DbTransactor =
    DbTransactor(
      host = dbConfig.host,
      port = dbConfig.port,
      username = dbConfig.username,
      password = dbConfig.password,
      dbname = dbConfig.dbname,
    )

}
