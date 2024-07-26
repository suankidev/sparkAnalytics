package com.suanki.dsa

import com.suanki.dsa.ArrayUtils._

object DsaApp {


  def main(args: Array[String]): Unit = {

    println("=" * 50)
    val arr= Array(1, 2, 3, 4, 5, 6, 7)

    show(
      leftRotateByReversedAlgo(arr, 2,arr.length)
    )


    println("=" * 50)
  }


}
