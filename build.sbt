name := "Testing Scala"

version := "1.0"

scalaVersion := "2.10.2"

resolvers ++= Seq(
  "snapshots" at "http://scala-tools.org/repo-snapshots",
  "releases" at "http://scala-tools.org/repo-releases")

resolvers ++= Seq(
  "sonatype-snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "sonatype-releases" at "http://oss.sonatype.org/content/repositories/releases")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.9.1" % "test" withSources() withJavadoc(),
  "joda-time" % "joda-time" % "2.1" withSources() withJavadoc(),
  "org.joda" % "joda-convert" % "1.2",
  "junit" % "junit" % "4.10" withSources() withJavadoc(),
  "org.testng" % "testng" % "6.1.1" % "test" withSources() withJavadoc(),
  "org.specs2" %% "specs2" % "2.1.1" withSources() withJavadoc())

fork := true
