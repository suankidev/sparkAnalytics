package com.suanki.appliedOne

class Module01 extends AbstractSuit {

  test("Something works") {

    require(1 == 1, "both are equals")
  }

  def devide(a: Int, b: Int): Int = a / b

  test("exception") {

    an[IllegalArgumentException] should be thrownBy {
      require(1 == 2, "One equals 2 ?")
    }

    val ae = intercept[ArithmeticException](devide(10, 0))
    ae.getMessage should be("/ by zero")

  }

}
