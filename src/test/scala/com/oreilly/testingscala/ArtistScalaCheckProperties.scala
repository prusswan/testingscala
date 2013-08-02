package com.oreilly.testingscala

import org.scalacheck.{ Prop, Properties, Gen }

object ArtistScalaCheckProperties extends Properties("Testing Artists Thoroughly") {
  property("middleNames") =
    Prop.forAll(Gen.alphaStr, Gen.oneOf(Gen.alphaStr.sample, None), Gen.alphaStr) {
      (firstName: String, middleName: Option[String], lastName: String) =>
        println(firstName, middleName, lastName)
        middleName match {
          case Some(x) =>
            val artist = new Artist(firstName, x, lastName)
            artist.fullName == firstName + " " + x + " " + lastName
          case _ =>
            val artist = new Artist(firstName, lastName)
            artist.fullName == firstName + " " + lastName
        }
    }
}

object CombiningGenScalaCheckProperties extends Properties("Combining Properties") {
  val stringsOnly = Prop.forAll(Gen.alphaStr) {
    x: String => (x != "") || x.size >= 0
  }
  val positiveNumbersOnly = Prop.forAll(Gen.posNum[Int]) {
    x: Int => x >= 0
  }
  val positiveNumbers2Only = Prop.forAll(Gen.posNum[Int]) {
    x: Int => x > 0
  }

  val alwaysPass = Prop.forAll {
    x: Int => true
  }

  val wontPass = Prop.forAll((x: Int, y: Int) => x + y > 0)

  property("And") = stringsOnly && positiveNumbersOnly
  property("Or") = stringsOnly || wontPass
}
