import Dependencies._

val circeVersion = "0.12.3"

ThisBuild / scalaVersion := "2.13.4"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

val ScalacOptions = Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-language:higherKinds",
  "-language:postfixOps",
  "-feature",
  "-Xfatal-warnings",
  "-Ywarn-unused"
)
scalacOptions := ScalacOptions

lazy val root = (project in file("."))
  .settings(
    name := "distributed-fsm",
    libraryDependencies += "org.typelevel" %% "cats-effect" % "3.0.0",
    libraryDependencies += "org.typelevel" %% "cats-free" % "2.3.1",
    libraryDependencies += "io.monix" %% "minitest" % "2.9.4" % "test",
    libraryDependencies += "org.typelevel" %% "cats-effect-testing-minitest" % "1.0.0" % Test,
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser"
    ).map(_ % circeVersion)
  )

addCompilerPlugin("org.typelevel" % "kind-projector" % "0.11.3" cross CrossVersion.full)
addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")

testFrameworks += new TestFramework("minitest.runner.Framework")

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
