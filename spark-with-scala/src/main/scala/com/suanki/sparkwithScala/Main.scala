package com.suanki.sparkwithScala

import com.suanki.sparkwithScala.sourcing._
import com.suanki.utilities.sparkUtils.SparkUtils


object Main {

  def main(args: Array[String]): Unit = {


     val weiredFileSourcing = new   WeiredFileSourcing(new SparkUtils().getSparkSession())

    weiredFileSourcing.run()

    println("End....")
    println("=" * 50)
  }
}
