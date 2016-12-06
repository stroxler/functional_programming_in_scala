// ensime gets unhappy without this
scalaVersion in ThisBuild := "2.11.8"

lazy val root = (project in file(".")).
  settings(
    name := "hi",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.11.8"
  )

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.4" % "test" withSources() withJavadoc(),
  "org.testng" % "testng" % "6.1.1" % "test" withSources() withJavadoc()
)
