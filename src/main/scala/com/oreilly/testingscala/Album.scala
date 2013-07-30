package com.oreilly.testingscala

class Album(val title: String, val year: Int, val tracks: Option[List[Track]],
  val acts: Act*) {
  require(acts.size > 0)
  def this(title: String, year: Int, acts: Act*) = this(title, year, None,
    acts: _*)

  def this(title: String, year: Int, artist: Artist) = this(title, year, None, artist)

  def artist = acts.head.asInstanceOf[Artist]
}
