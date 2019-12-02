import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "mmeylan"
ThisBuild / organizationName := "mmeylan"

lazy val root = (project in file("."))
  .settings(
    name := "Advent of Code 2019",
    libraryDependencies += scalaTest % Test
  )
