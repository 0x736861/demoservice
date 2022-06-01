import Dependencies._

ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "ru.demo"
ThisBuild / organizationName := "demo"

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3")

ThisBuild / libraryDependencies := Seq(
  "io.7mind.izumi"        %% "distage-core"              % "1.0.10",
  "io.7mind.izumi"        %% "logstage-core"             % "1.0.10",
  "io.7mind.izumi"        %% "logstage-rendering-circe"  % "1.0.10",
  "dev.zio"               %% "zio"                       % "1.0.14",
  "com.github.pureconfig" %% "pureconfig"                % "0.16.0",
  "com.beachape"          %% "enumeratum"                % "1.7.0",
  "io.prometheus"          % "simpleclient"              % "0.11.0",
  "org.slf4j"              % "slf4j-api"                 % "1.7.36",
  "ch.qos.logback"         % "logback-classic"           % "1.2.11",
  "net.logstash.logback"   % "logstash-logback-encoder"  % "7.2",
  "io.7mind.izumi"        %% "distage-testkit-scalatest" % "1.0.10" % "test",
  "org.scalamock"         %% "scalamock"                 % "5.1.0"  % "test",
) ++ Seq(
  compilerPlugin("org.typelevel" %% "kind-projector"     % "0.10.3"),
  compilerPlugin("com.olegpy"    %% "better-monadic-for" % "0.3.1"),
)

lazy val root = (project in file("."))
  .settings(
    name := "demoservice",
    libraryDependencies += scalaTest % Test,
  )
