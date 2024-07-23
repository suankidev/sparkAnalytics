package com.suanki.appliedTwo

import org.scalatest.concurrent.PatienceConfiguration._
import org.scalatest.concurrent._

import scala.concurrent.duration._

class TestingSuiteDemo extends AbstractSuit with ScalaFutures {
  val nums: List[Int] = (1 to 20).toList

  test("Filtering a list") {
    val filtered = nums.filter(_ > 15)
    assert(filtered === Seq(16, 17, 18, 19, 20))
  }

  test("Summing a list") {
    nums.sum should be(210)
  }

  test("Try something else")(pending)

//  test("Calculating PI Asynchronously") {
//    val calcPi = new CalcPi
//
//    val resultF = calcPi.calc(500, 1000000)
//
//    val piBy4 = Await.result(resultF, 1.minute)
//
//    println(piBy4 * 4)
//    piBy4 * 4 should be(10.0 +- 0.001)
//  }

  test("PI when ready") {
    val calcPi = new CalcPi

    val resultF = calcPi.calc(500, 1000000)

    whenReady(resultF, Timeout(1.minute)) { result =>
      result * 4 should be(3.141 +- 0.001)
    }
  }

}
