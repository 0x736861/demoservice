import Dependencies._

ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "ru.pimpay"
ThisBuild / organizationName := "pimpay"

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3")

ThisBuild / libraryDependencies := Seq(
  "io.7mind.izumi" %% "distage-core"     % "1.0.10",
  "dev.zio"        %% "zio"              % "1.0.14",
  "org.scalatest"  %% "scalatest"        % "3.2.12" % "test",
) ++ Seq(
  compilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3"),
  compilerPlugin("com.olegpy"      %% "better-monadic-for" % "0.3.1"),
)

lazy val root = (project in file("."))
  .settings(
    name := "demoservice",
    libraryDependencies += scalaTest % Test,
  )
