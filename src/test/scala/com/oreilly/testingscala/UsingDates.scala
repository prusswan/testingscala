package com.oreilly.testingscala

import org.specs2.Specification
import org.joda.time.{ DateTime, DateMidnight }

class UsingDates extends Specification {
  def is =
    "this will use the real date" ! (withCurrentDate(x => testDate(x))) ^
      "this will use a fake date" ! (withFakeDate(x => testDate(x)))
  def testDate(x: DateTime) = (x.plusDays(20).isAfterNow)

  object withCurrentDate extends org.specs2.specification.Outside[DateTime] {
    def outside = new DateTime
  }

  object withFakeDate extends org.specs2.specification.Outside[DateTime] {
    def outside = new DateMidnight(1980, 1, 2).toDateTime
  }
}
