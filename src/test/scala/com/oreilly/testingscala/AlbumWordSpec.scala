package com.oreilly.testingscala

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec

class AlbumWordSpec extends WordSpec with ShouldMatchers {
  "An Album" when {
    "created" should {
      "accept the title, the year, and a Band as a parameter, and be able to read those parameters back" in {
        new Album("Hotel California", 1977,
          new Band("The Eagles", List(new Artist("Don", "Henley"),
            new Artist("Glenn", "Frey"),
            new Artist("Joe", "Walsh"),
            new Artist("Randy", "Meisner"),
            new Artist("Don", "Felder"))))
      }
    }
  }

  "An album" should {
    "throw an IllegalArgumentException if there are no acts when created" in {
      intercept[IllegalArgumentException] {
        new Album("The Joy of Listening to Nothing", 1980, List():_*)
      }
    }
  }
}
