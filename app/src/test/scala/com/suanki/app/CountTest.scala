package com.suanki.app

import org.junit.jupiter.api.Test

class CountTest {

  @Test
  def dfCount(): Unit = {
    val flightData = FlightData.getData.cache()
    println(s"count of data: ${flightData.count()}")
    assert(255 == flightData.count())
  }

}
