package com.suanki.appliedTwo

import org.scalatest.funsuite.AsyncFunSuite
import org.scalatest.matchers.should.Matchers

class AsyncTestingSuiteDemo extends AsyncFunSuite with Matchers {
  test("Calculating PI") {
    val calcPi = new CalcPi

    val resultF = calcPi.calc(500, 1000000)

    for (result <- resultF) yield {
      println(result * 4)
      result * 4 should be(3.141 +- 0.001)
    }
  }
}
