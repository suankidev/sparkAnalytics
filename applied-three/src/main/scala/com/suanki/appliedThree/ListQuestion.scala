package com.suanki.appliedThree

import scala.languageFeature.implicitConversions

object ListQuestion {
  implicitConversions
  def main(args: Array[String]): Unit = {
    println("=" * 50)

    implicit def show(x: Any): Unit = println(x)

    val fruitList = List("Apple", "Orange", "Mango", "Banana")
    val listOfNumber = List(87, 4, 5, 67, 23, 4, 5, 6, 72, 98, 76, 43)

    // //reverse list
    for {
      i <- 1 to fruitList.length - 1
      t = i - fruitList.length
      idx = t
    } {
      show(fruitList(-idx))
    }

    /** list = 1,2,3,5 list1 = 6,7,8,9,10 op = 7, 9, 11,14,10
      */

    val listOne = List(1, 2, 3, 4)
    val listTwo = List(6, 7, 8, 9, 10)

    show(listOne.zip(listTwo)) // not working

    // listOne is small so lets. make big as listTwo
    val diffList = List.fill(listTwo.length - listOne.length)(0)
    show(diffList)
    val finalListOne = listOne ::: diffList
    show(finalListOne.zip(listTwo).map(x => x._1 + x._2))

    // sum of listOne 3 way
    // 1.
    show(listOne.sum)

    show(listOne.foldLeft(0)((x, y) => x + y))

    var sum: Int = 0

    for {
      i <- 0 until listOne.length
      value = listOne(i)
    } yield sum = sum + value
    show(sum)

    // how many time a charecter 'i' present in a line

    val myString =
      "this is test with data and list string having big data string"

    val charList = myString.toList

    show(charList)

    show(
      charList.count(_ == 'd')
    )

    val groupedList = charList.groupBy(x => x)

    show(charList.groupBy(x => x))
    show(
      groupedList.map(x => (x._1, x._2.size))
    )

    println()
    println("==>sort the words according to their length")

    show(myString)

    show(myString.sorted) // make the char and sort alphabetically

    val splittedWords = myString.split(" ").toList
    show(splittedWords)

    show(splittedWords.sortWith((x, y) => x.length > y.length))

    val reduceWord =
      splittedWords.reduce((x, y) => if (x.length > y.length) x else y)

    show(reduceWord)

    // read a file line by line find how many times 'United State is their'

    println("=" * 50)

  }
}
