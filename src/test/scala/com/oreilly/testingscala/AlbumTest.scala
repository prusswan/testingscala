package com.oreilly.testingscala

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.GivenWhenThen

class AlbumSpec extends FunSpec with ShouldMatchers with GivenWhenThen {
  describe("An Album") {
    it("can add an Artist to the album at construction time") {
      given("The album Thriller by Michael Jackson")
      val album = new Album("Thriller", 1981, new Artist("Michael", "Jackson"))

      when("the album\'s artist is obtained")
      val artist = album.artist

      then("the artist obtained should be an instance of Artist")
      artist.isInstanceOf[Artist] should be(true)

      and("the artist's first name and last name should be Michael Jackson")
      artist.firstName should be("Michael")
      artist.lastName should be("Jackson")
    }
  }
}
