import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "advent",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Advent2018",
    libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6",
    libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.20.0",
    libraryDependencies += scalaTest % Test
  )
