package com.oreilly.testingscala

import org.specs2.Specification
import org.specs2.specification.Around
import org.joda.time.{ DateTime, DateMidnight }
import org.specs2.execute.AsResult
import org.specs2.execute.Result

class UsingTheAroundOutsideProcess extends Specification {
  def is =
    "this will log something before running" ! logWithFakeDateTime(dateTime =>
      e1(dateTime))

  lazy val lst = List(
    new Album("Storms of Life", 1986, new Artist("Randy", "Travis")),
    new Album("The Bad Touch", 1999, new Band("Bloodhound Gang")),
    new Album("Billie Holiday Sings", 1952, new Artist("Billie", "Holiday")))

  def e1(dt: DateTime) = {
    println("Running test at " + dt)
    lst.drop(1) must have size (2)
  }

  object logWithFakeDateTime extends org.specs2.specification.AroundOutside[DateTime] {
    def outside = { new DateTime }
    def around[T: AsResult](t: => T): Result = {
      println(outside + ": Start process")
      val result = t
      println(outside + ": End process")
      AsResult(result)
    }
  }
}
