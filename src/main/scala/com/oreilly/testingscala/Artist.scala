package com.oreilly.testingscala

case class Artist(firstName: String, middleName: Option[String], lastName: String, albums: List[Album], alias: Option[String]) extends Act {
  def this(firstName: String, lastName: String) = this(firstName, None, lastName, Nil, None)

  def this(firstName: String, middleName: String, lastName: String) =
    this(firstName, Some(middleName), lastName, Nil, None)

  def getAlbums = albums

  def addAlbum(album: Album) = new Artist(firstName, middleName, lastName,
    album :: albums, alias)

  def fullName = middleName match {
    case Some(x) => firstName + " " + x + " " + lastName
    case _ => firstName + " " + lastName
  }

  def withAlias(alias: String) = new Artist(firstName, middleName, lastName, albums, Some(alias))
}
