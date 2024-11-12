 //function literal is anonymous class

 val totalFunction:Int => String =
   argument => "\"" + argument


   val randomNumber = scala.util.Random.nextInt


 randomNumber

 totalFunction(randomNumber)



 trait SimpleFunction1{

   def apply(greeting:String):Unit
 }

 class NamedFunction1(name:String) extends SimpleFunction1{
   def apply(greeting: String): Unit = println(s"Hi I'm $name, $greeting")
 }


 val alice:SimpleFunction1 = new NamedFunction1("Alice")
 val bob:SimpleFunction1 = new NamedFunction1("Bob")

 
 alice("How are you going?")
 bob("What's Up?")


 val singleton:SimpleFunction1 = new SimpleFunction1 {
  override def apply(greeting: String): Unit = println(s"Hi I'm a singleton it doesn't even make sense for me to have a constructor: ( $greeting")
 }

 val singleton:SimpleFunction1 = (greeting: String) => println(s"Hi I'm a singleton it doesn't even make sense for me to have a constructor: ( $greeting")
 val x = (x:Int) => x.toString
 val y:Int=>String = (x:Int) => x.toString

 singleton("Whoaaa.!") 