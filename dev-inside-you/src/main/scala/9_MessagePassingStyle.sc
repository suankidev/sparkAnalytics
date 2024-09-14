

def bankAccount(initialBalance:Int):Symbol=>(Int=>Unit)={
  var balance:Int = initialBalance

  val withdraw:Int => Unit= amount =>
    if(balance >= amount)
      balance = balance - amount
    else
      throw new Exception("Insufficient funds")


  val deposit:Int=>Unit=amount=>
    if(amount >= 1) {
      balance = balance + amount
      balance
    }else
      throw new Exception("It's only possible to deposit positive amount_|_")


  val dispatch:Symbol=>(Int=>Unit)=operation=>
    if(operation == Symbol("withdraw")){
      withdraw
    }else if(operation == Symbol("deposit")){
      deposit
    }else
      throw new Exception(s"not implemented for ${operation}")

  dispatch

}



val bankAccount1 = bankAccount(1000)
val deposit= Symbol("deposit")
val withdraw= Symbol("withdraw")

bankAccount1(withdraw)(50)
bankAccount1(deposit)(100)

//https://stackoverflow.com/questions/65856527/what-is-a-side-effect-in-scala

