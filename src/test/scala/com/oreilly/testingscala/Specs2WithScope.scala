package com.oreilly.testingscala

import org.specs2.Specification

class Specs2WithScope extends Specification {
  def is =
    "Add an album to a shared list" ! AddItemTest().test ^
    "Remove an album to a shared list" ! RemoveItemTest().test

  trait ListMaker {
    lazy val lst = scala.collection.mutable.Buffer(
      new Album("Fly By Night", 1974, new Band("Rush")),
      new Album("19", 2008, new Artist("Adele", "Laurie", "Adkins").withAlias("Adele")))
  }

  case class AddItemTest() extends ListMaker {
    def test = {
      lst.append(new Album("Prokofiev and Rachmaninoff: Cello Sonatas", 1991,
        new Artist("Yo", "Yo", "Ma")))
      lst must have size (3)
    }
  }

  case class RemoveItemTest() extends ListMaker {
    def test = lst.drop(1) must have size (1)
  }
}
