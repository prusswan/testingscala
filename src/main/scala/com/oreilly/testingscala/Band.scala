package com.oreilly.testingscala

class Band(name: String, members: List[Artist]) extends Act {
  def this(name: String) = this(name, Nil)
}
