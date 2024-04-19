inThisBuild(
  List(
    organization := "io.github.streetcontxt",
    homepage := Some(url("https://github.com/streetcontxt/kcl-akka-stream")),
    licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    developers := List(
      Developer(
        "agenovese",
        "Angelo Gerard Genovese",
        "angelo.gerard.genovese@gmail.com",
        url("https://github.com/agenovese")
      ),
      Developer(
        "elise-scx",
        "Elise Cormie",
        "elise@streetcontxt.com",
        url("https://github.com/elise-scx")
      )
    )
  )
)

configs(IntegrationTest)
Defaults.itSettings
val TestAndIntegrationTest = "test,it"

ThisBuild / organization := "io.github.streetcontxt"
ThisBuild / scalaVersion := "2.13.6"
scalacOptions ++= Seq("-deprecation", "-feature")
ThisBuild / crossScalaVersions := Seq("2.13.6")
ThisBuild / licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))
sonatypeCredentialHost := "s01.oss.sonatype.org"

name := "kcl-akka-stream"

val PekkoVersion = "1.0.2"

val slf4j = "org.slf4j" % "slf4j-api" % "1.7.32"
val logback = "ch.qos.logback" % "logback-classic" % "1.2.5"
val amazonKinesisClient = "software.amazon.kinesis" % "amazon-kinesis-client" % "2.3.6"
val scalaKinesisProducer = "io.github.streetcontxt" %% "kpl-scala" % "2.0.0"
val scalaCollectionCompat = "org.scala-lang.modules" %% "scala-collection-compat" % "2.5.0"
val scalaTest = "org.scalatest" %% "scalatest" % "3.2.9"
val scalaMock = "org.scalamock" %% "scalamock" % "5.1.0"
val pekkoStream = "org.apache.pekko" %% "pekko-stream" % PekkoVersion
val pekkoStreamTestkit = "org.apache.pekko" %% "pekko-stream-testkit" % PekkoVersion

libraryDependencies ++= Seq(
  pekkoStream,
  amazonKinesisClient,
  slf4j,
  scalaCollectionCompat,
  scalaTest % TestAndIntegrationTest,
  pekkoStreamTestkit % TestAndIntegrationTest,
  logback % TestAndIntegrationTest,
  scalaKinesisProducer,
  scalaMock % Test
)
