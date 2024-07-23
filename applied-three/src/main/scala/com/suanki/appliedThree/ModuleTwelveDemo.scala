package com.suanki.appliedThree

sealed abstract class AccountType

case class Saving(amnt: Double) extends AccountType {
  val accountName: String = "saving"
}

case class Current(amnt: Double) extends AccountType {
  val accountName: String = "Current"
}

object ModuleTwelveDemo {

  def main(args: Array[String]): Unit = {
    println("=" * 60)
    println()

    val tup = ('a', "Apple", "true")

    val numberList = List(1, 3, 4, 7, 89, 34, 25, 34, 9, 87, 24, 54, 32, 26)

    val numberMap =
      numberList.map(x => (x, x > 20 && x < 30)).toMap // .filter(_._2==true)

    def checking(a: AccountType): Boolean = {
      a match {
        case a: Saving  => println(s"${a.accountName} ${a.amnt}"); true
        case a: Current => println(s" ${a.accountName}"); true
      }
    }

    checking(Saving(89.83))

    println()
    println("=" * 60)

  }
}
