name := "Testing Scala"

version := "1.0"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.9.1" % "test" withSources() withJavadoc(),
  "joda-time" % "joda-time" % "2.1" withSources() withJavadoc(),
  "org.joda" % "joda-convert" % "1.2",
  "junit" % "junit" % "4.10" withSources() withJavadoc(),
  "org.testng" % "testng" % "6.1.1" % "test" withSources() withJavadoc())
