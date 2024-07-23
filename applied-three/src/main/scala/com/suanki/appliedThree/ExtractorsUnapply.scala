package com.suanki.appliedThree

case class Person(first: String, last: String, age: Int)
class Human(val first: String, val last: String, val age: Int)

object Human {

  def apply(first: String, last: String, age: Int): Human =
    new Human(first, last, age)

  def unapply(h: Human): Option[(String, String, Int)] = scala.util.Try {
    ((h.first, h.last, h.age))
  }.toOption

}

object ExtractorsUnapply {

  def main(args: Array[String]): Unit = {
    println("=" * 50)

    val p1 = Person("sk", "sharma", 29)
//     val h = new Human("sk","sharma",29)
    val h = Human("sk", "sharma", 29)
    val h1 = Human("pk", "sharma", 20)

    val listOfNumber = List(1, 2, 3)

    println(Person.unapply(p1)) // Some(first,last,age)
    println(Human.unapply(h)) // Some(first,last,age)

    println(List.unapplySeq(listOfNumber))

    h1 match {
      case Human("sk", _, _)      => println(s"matched sk")
      case Human("pk", _, _ @ 20) => println(s"matched pk")
    }

    // Custom extractors
    object Custom {
      def unapply(t: (String, String, Int)): Option[(String, String, Int)] = {
        scala.util.Try { (t._1, t._2, t._3) }.toOption
      }

    }

    val t = ("first", "last", 24)

    t match {
      case Custom(a, b, c) => println(a)

    }

    println("=" * 50)

  }
}
