package com.suanki.appliedThree

object EvenMore extends App {

  println("=" * 50)

  implicit class MyPrinter(x: Any) {
    def show: Unit = println(x)
    def rstring: Any = x
  }

  val nums = List.range(0, 10)
  nums.show
  nums.grouped(3).take(5).toList.show
  nums.sliding(3, 3).take(5).toList.show
  nums.combinations(3).take(5).toList.show
  nums.permutations.take(5).toList

  val numsPlusOne = nums.map(_ + 1)

  nums.corresponds(numsPlusOne)((a, b) => a + 1 == b).show

  val chars = List.range('a', 'h')

  val idx = chars.indices
  idx.show
  chars.show
  println(chars.rstring)

  chars.zip(idx).show

  val zipped = chars.zipWithIndex
  zipped.show

  zipped.unzip.show

  println("=" * 50)
}
