
 trait SimpleFunction1[Input1,Output]{

   def apply(greeting:Input1):Output
 }

 class NamedFunction1(name:String) extends SimpleFunction1[String ,Unit]{
   def apply(greeting: String): Unit = println(s"Hi I'm $name, $greeting")
 }


 val alice:SimpleFunction1[String,Unit] = new NamedFunction1("Alice")
 val bob:SimpleFunction1[String,Unit] = new NamedFunction1("Bob")

 
 alice("How are you going?")
 bob("What's Up?")


 val totalFunctionWithoutSyntaticSugar:SimpleFunction1[Int,String] = new SimpleFunction1[Int,String] {
  override def apply(greeting: Int): String ="\"" + greeting + "\""
 }

 val totalFunctionWithSyntaticSugar:SimpleFunction1[Int,String] = argument => "\"" + argument + "\""


 val totalFunction:Int => String = argument => "\"" + argument + "\""



 totalFunction(scala.util.Random.nextInt())
 totalFunctionWithSyntaticSugar(scala.util.Random.nextInt())

 //scala inbuild has Function1 ro Function22

 val f0:Function0[String] = () => "hello"
 val ff = () => "hello"


 val f1:Function1[Int, String] = (x:Int) => x.toString
 val ff1 = (argument:Int) => argument.toString


 val f2:Function2[Int,Int,String] = (x:Int,y:Int) => (x+y).toString
 val ff2 = (x:Int,y:Int) => (x + y) .toString()


 
