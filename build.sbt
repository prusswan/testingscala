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
  "org.scalatest" %% "scalatest" % "2.0.M5b" % "test" withSources() withJavadoc(),
  "joda-time" % "joda-time" % "2.1" withSources() withJavadoc(),
  "org.joda" % "joda-convert" % "1.2",
  "junit" % "junit" % "4.10" withSources() withJavadoc(),
  "org.testng" % "testng" % "6.1.1" % "test" withSources() withJavadoc(),
  "org.specs2" %% "specs2" % "2.1.1" withSources() withJavadoc(),
  "org.easymock" % "easymock" % "3.2" withSources() withJavadoc(),
  "org.mockito" % "mockito-core" % "1.9.5" % "test" withSources() withJavadoc(),
  "org.scalamock" %% "scalamock-scalatest-support" % "3.0.1" % "test",
  "org.scalamock" %% "scalamock-specs2-support" % "3.0.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.10.1" % "test" withSources() withJavadoc())

fork := true
