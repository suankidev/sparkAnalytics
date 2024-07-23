package com.suanki.appliedThree

object ListMain extends App {

  println("=" * 40)

  case class Person(name: String, age: Int)

  val listOfNumber = List(2, 3, 4, 53, 46, 89, 76, 43, 54)
  val listOfPerson = List(
    Person("Ram", 20),
    Person("Shyam", 30),
    Person("Karim", 25),
    Person("Nasty", 35)
  )

  println(listOfNumber.sorted)
  println(listOfNumber.sortWith(_ > _))
  println(listOfNumber.sortWith(_ < _))

  implicit object PersonOrdering extends Ordering[Person] {
    override def compare(x: Person, y: Person): Int = {
      if (x.name == y.name)
        x.age - y.age
      else if (x.name > y.name) 1
      else -1
    }
  }

  println(listOfPerson.sorted)
  println(listOfPerson.sortWith((x, y) => x.age > y.age))

  implicit class t(i: Int) {

    def time(s: String): String = s * i
  }

  implicit object t1 {
    def timeOne(i: Int): String = "hello" * i
  }
  println(5 time "hello")

  listOfPerson.collect {
    case a: Person if a.age > 30 => println(a.age, a.name)
  }

  val anotherList = List(1, 2, 4)
  println(listOfNumber)
  val an = listOfNumber.zip(anotherList)
  println(an)

  println(listOfNumber.zipWithIndex)
  println(an.unzip)

  println(listOfNumber.grouped((2)).toList) // List[List[Int]]

  println(listOfNumber.sliding(2).toList)

  println(listOfNumber.combinations(2).toList)

  println(listOfNumber.permutations.toList)

  println("=" * 40)

}
