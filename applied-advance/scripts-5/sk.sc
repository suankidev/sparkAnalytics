
abstract class  Fruit[T]{

  def Color(f:T):T= s"$f"
}

def tset[T](x:T)(implicit frt:Fruit[T]): Unit =
  println(x + frt.Color("Red"))

tset[String]("Orange")