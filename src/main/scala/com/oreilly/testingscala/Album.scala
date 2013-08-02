package com.oreilly.testingscala

import org.joda.time.Period

class Album(val title: String, val year: Int, val tracks: Option[List[Track]],
  val acts: Act*) {
  require(acts.size > 0)
  def this(title: String, year: Int, acts: Act*) = this(title, year, None,
    acts: _*)

  def this(title: String, year: Int, artist: Artist) = this(title, year, None, artist)

  def artist = acts.head.asInstanceOf[Artist]

  def ageFrom(now: Int) = now - year

  def period = { tracks.getOrElse(List()).foldLeft(Period.ZERO)((sum,track) => sum.plus(track.period)) }
}
