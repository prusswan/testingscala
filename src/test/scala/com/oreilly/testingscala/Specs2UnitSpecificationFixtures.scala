package com.oreilly.testingscala

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class Specs2UnitSpecificationFixtures extends Specification {
  "Add an album to a shared list" in new ListMaker {
    lst.append(new Album("Prokofiev and Rachmaninoff: Cello Sonatas", 1991, new Artist("Yo", "Yo", "Ma")))
    lst must have size (3)
  }
  "Remove an album to a shared list" in new ListMaker {
    lst.drop(1) must have size (1)
  }

  trait ListMaker extends Scope {
    lazy val lst = scala.collection.mutable.Buffer(
      new Album("Fly By Night", 1974, new Band("Rush")),
      new Album("19", 2008, new Artist("Adele", "Laurie", "Adkins").withAlias("Adele")))
  }
}
