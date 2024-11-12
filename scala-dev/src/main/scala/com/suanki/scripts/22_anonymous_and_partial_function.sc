



//https://www.scala-lang.org/api/2.13.4/scala/Function1.html



val succ = (x: Int) => x + 1
val anonfun1 = new Function1[Int, Int] {
 def apply(x: Int): Int = x + 1
}

try{
 assert(succ(0) == anonfun1(1))
}
catch {
 case e:java.lang.AssertionError => println(s"assertion err ${e.getMessage}")
}




trait SimpleFunction1[A,B]{

 def apply(msg:A):B
}

val myTotalFunction:SimpleFunction1[Int,String] = new SimpleFunction1[Int,String] {
 override def apply(msg: Int): String = msg.toString
}
val totalFunction:Int=>String = msg => msg.toString
val functionWithoutSyntaticSugar:Function1[Int,String] = new Function[Int,String] {
 override def apply(arg: Int): String = arg.toString
}

//test

myTotalFunction(5)
totalFunction(5)
functionWithoutSyntaticSugar(5)


//Partial Function

class NumberCriteriaDoesNotMatchException(msg:String) extends Exception(msg)

val partialFunctionWithoutSyntacticSugar:PartialFunction[Int,String] = new PartialFunction[Int,String] {

 override def apply(v1: Int): String = if(v1 >= 5) v1.toString else throw new NumberCriteriaDoesNotMatchException("not matched")


 override def isDefinedAt(v1: Int): Boolean = {
   println("hello in isDefined At")
  if (v1 >= 5) true else false
 }

}

partialFunctionWithoutSyntacticSugar(5)
scala.util.Try(partialFunctionWithoutSyntacticSugar(4)).isSuccess //isDefinedAt is not called here

//so, basically caller should check for isDefinedAt in case of partial function
if(partialFunctionWithoutSyntacticSugar.isDefinedAt(5)) partialFunctionWithoutSyntacticSugar(6)

def partialFunctionWithCaseClass(x:Int):String = x match {
 case v:Int if(v>=5) => v.toString
 case v:Int if (v<5) => throw new NumberCriteriaDoesNotMatchException(s"not matched $v")
}

scala.util.Try(partialFunctionWithCaseClass(4))



//USAGE of partial function

val range = 1 to 10

range foreach println

val function:Int => Int = _ + 1

range map function foreach println

range map totalFunction foreach println

//predicate like isDefinedAt

val predicate:Int => Boolean = _ == 4
range filter predicate map totalFunction


range collect partialFunctionWithoutSyntacticSugar foreach println
  //how collect is implemented..is doing isDefinedAt then calling apply
scala.util.Try(range map partialFunctionWithoutSyntacticSugar) //should fail b/c passing partitial functino to map



//type alias
{
 type ~>[-A, +R] = PartialFunction[A, R]
 val partialFunction1: Int ~> String = x => x.toString
 val partialFunction2: ~>[Int, String] = x => x.toString
}

{
// type ~>[-A, -B, +R] = Function2[A, B, R]
 type ~>[-A, -B, +R] = (A, B) => R

 val totalFunction: ~>[Int,Int,String] = (x,y) => (x+y).toString
}


type ~>[-T1,+R] = PartialFunction[T1,R]

val partialFunction1: Int ~> String =  {
 case 4 => 4.toString
 case _ => throw new NumberCriteriaDoesNotMatchException("match failed")
}  //this is being converted to partialFunctionWithoutSyntacticSugar

scala.util.Try(partialFunction1(4))
scala.util.Try(partialFunction1(5))

396