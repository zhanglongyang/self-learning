import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.0"
    )),
    name := "Hello",
    libraryDependencies += scalaTest % Test
  )

val gitHeadCommitSha = taskKey[String]("git head commit sha")
gitHeadCommitSha := Process("git rev-parse HEAD").lines.head
