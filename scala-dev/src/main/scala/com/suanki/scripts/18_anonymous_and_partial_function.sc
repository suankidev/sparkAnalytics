 //function literal is anonymous class

 val totalFunction:Int => String =
   argument => "\"" + argument


   val randomNumber = scala.util.Random.nextInt


 randomNumber

 totalFunction(randomNumber)



 trait Chatty{

   def sayHI(greeting:String):Unit
 }

 class Person(name:String) extends Chatty{
   override def sayHI(greeting: String): Unit = println(s"Hi I'm $name, $greeting")
 }


 val alice:Chatty = new Person("Alice")
 val bob:Chatty = new Person("Bob")

 
 alice.sayHI("How are you going?")
 bob.sayHI("What's Up?")


 val singleton:Chatty = new Chatty {
   override def sayHI(greeting: String): Unit = println(s"Hi I'm a singleton it doesn't even make sense for me to have a constructor: ( $greeting")
 }

 singleton.sayHI("Whoaaa.!")