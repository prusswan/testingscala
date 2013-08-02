package com.oreilly.testingscala

import org.specs2.Specification

class Specs2WithoutFixtures extends Specification {
  def is =
    "Add an album to a shared list" ! test1 ^
    "Remove an album to a shared list" ! test2

  lazy val lst = scala.collection.mutable.Buffer(
    new Album("Fly By Night", 1974, new Band("Rush")),
    new Album("19", 2008, new Artist("Adele", "Laurie", "Adkins").withAlias("Adele")))

  def test1 = {
    lst.append(new Album("Prokofiev and Rachmaninoff: Cello Sonatas", 1991, new Artist("Yo", "Yo", "Ma")))
    lst must have size (3)
  }

  def test2 = lst.drop(1) must have size (1)
}
