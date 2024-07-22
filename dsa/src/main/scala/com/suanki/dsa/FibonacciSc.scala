package com.suanki.dsa

import scala.annotation.tailrec

object FibonacciSc {

  def fibonacci(limit: Int): Array[Int] = {

    @tailrec
    def loop(
        num: Int = 0,
        first: Int = 0,
        second: Int = 1,
        acc: Array[Int] = Array.empty
    ): Array[Int] = {
//      println(s"num: $num,first: $first, second: $second acc: ${acc.mkString(",")}")
      if (num == 0) acc :+ 0
      if (num == 1) acc :+ 1
      if (num == limit) acc
      else {
        loop(
          num = num + 1,
          first = second,
          second = first + second,
          acc = acc :+ second
        )
      }
    }
    loop()
  }

}
