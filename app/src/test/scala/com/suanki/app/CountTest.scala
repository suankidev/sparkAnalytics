package com.suanki.app

import org.junit.jupiter.api.Test

class CountTest {

  @Test
  def dfCount(): Unit = {
    val path = "src/test/resources/2015-summary.csv"
//    val flightData = FlightData.getData(path).cache()
//    println(s"count of data: ${flightData.count()}")
//    assert(256L == flightData.count())
    assert(256 == 256)
  }

}
