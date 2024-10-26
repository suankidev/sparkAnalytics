//side effect
//you should not mix a method
// which produce a value  balance=balance + amount
//and return a value   return balance

type bankAccount = Symbol => Any
//evaluation of any
// Symbol => (Int => Int)
//Symbol => Any

def bankAccount(initialBalance: Int): Symbol => Any = {
  var balance: Int = initialBalance

  val withdraw: Int => Unit = amount =>
    if (balance >= amount)
      balance = balance - amount
    else
      throw new Exception("Insufficient funds")

  val deposit: Int => Unit = amount =>
    if (amount >= 1) {
      balance = balance + amount
      balance
    } else
      throw new Exception("It's only possible to deposit positive amount_|_")

  val getBalance: () => Int = () => balance

  val dispatch: Symbol => Any = operation =>
    if (operation == Symbol("withdraw")) {
      withdraw
    } else if (operation == Symbol("deposit")) {
      deposit
    } else if (operation == Symbol("balance")) {
      getBalance
    } else
      throw new Exception(s"not implemented for ${operation}")

  dispatch

}

val thisOne = bankAccount(1000)
val thatOne = bankAccount(100)
val balance = Symbol("balance")

val deposit = Symbol("deposit")
val withdraw = Symbol("withdraw")

thisOne(withdraw).asInstanceOf[Int => Unit](50)
thatOne(deposit).asInstanceOf[Int => Unit](100)

thisOne(balance).asInstanceOf[() => Int]()
thatOne(balance).asInstanceOf[() => Int]()

//https://stackoverflow.com/questions/65856527/what-is-a-side-effect-in-scala

//transfer from thisOne to thatOne
