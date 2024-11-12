//side effect
//you should not mix a method
// which produce a value  balance=balance + amount
//and return a value   return balance

type bankAccount = Symbol => Any
//evaluation of any
// Symbol => (Int => Int)
//Symbol => Any


class BankAccount(private[this] val initialBalance: Int,name:String) {
  self =>
  private[this] var _balance: Int = initialBalance
  private var _accountHolderName:String = name
  private var shaddyBalance:Int = initialBalance

  val withdraw: Int => Unit = amount =>
    if (this._balance >= amount)
      this._balance = self._balance - amount //self or this point to this class only
    else
      throw new Exception("Insufficient funds")

  val deposit: Int => Unit = amount =>
    if (amount >= 1) {
      _balance = _balance + amount
      _balance
    } else
      throw new Exception("It's only possible to deposit positive amount_|_")

  val balance: () => Int = () => _balance
  val accountHolderName:String = _accountHolderName


  def doSomeShadyStuff(other: BankAccount): BankAccount = {
    //you can't access private[this]
    //println(other._balance)  // won't compile
    println(other.shaddyBalance)
    other
  }

  def this(initialBalance:Int)=this(initialBalance,name="UKNOWN")

  override def toString: String = s"name:${this.name}, balance:${this.balance()}"


}

val thisOne = new BankAccount(1000,"PersonA")
val thatOne = new BankAccount(100,"PersonB")
val balance = Symbol("balance")

val deposit = Symbol("deposit")
val withdraw = Symbol("withdraw")

thisOne.withdraw(50)
thatOne.withdraw(100)

val thisOneBalance = thisOne.balance()
val thatOneBalance = thatOne.balance()

//what is private[this] and private
//only thisOne object would be able to access private[this] variable
thisOne.doSomeShadyStuff(thatOne)



//https://stackoverflow.com/questions/65856527/what-is-a-side-effect-in-scala

//companion object can access to private member but not private[this] as well
object BankAccount{

  def f(b:BankAccount):Int = b.balance()
  var accountHolderName:String = null
  var initialAmount:Int = 0
  def withAmount(amount:Int):this.type = {
    initialAmount = amount
    BankAccount
  }

  def withName(name:String):BankAccount.type = {
    accountHolderName = name
    BankAccount
  };

  def createAccount:this.type =  BankAccount

  def build:BankAccount = new BankAccount(this.initialAmount, this.accountHolderName)

}


//transfer from thisOne to thatOne

object OperationForMultipleBankAccount{


  def makeTransfer(from:BankAccount,amount:Int, to:BankAccount):Unit={

       println(s"transfer is being made from ${from}  to ${to}")

      from withdraw(amount) //infix notation
      to deposit(amount)
      println(from)
      println(to)
  }

}



OperationForMultipleBankAccount.makeTransfer(thisOne,100,thatOne)

BankAccount.createAccount.withName("sujeet").withAmount(50000).build