package com.oreilly.testingscala

import org.specs2.Specification
import org.specs2.specification.Around
import org.specs2.execute.Result
import org.specs2.execute.AsResult

class UsingTheAroundProcess extends Specification {
  def is =
    "this will log something before running" ! log(e1)

  lazy val lst = List(
    new Album("Storms of Life", 1986, new Artist("Randy", "Travis")),
    new Album("The Bad Touch", 1999, new Band("Bloodhound Gang")),
    new Album("Billie Holiday Sings", 1952, new Artist("Billie", "Holiday")))

  def e1 = {
    println("Running test")
    lst.drop(1) must have size (2)
  }

  object log extends org.specs2.specification.Around {
    def around[T: AsResult](t: => T): Result = {
      println("Start process")
      val result: T = t
      println("End process")
      AsResult(result)
    }
  }
}
