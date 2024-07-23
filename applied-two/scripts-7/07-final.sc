// Can't do this, == is final

//class BadClass {
//  override def ==(other: Any): Boolean = {
//    println(s"Comparing $this to $other")
//    false
//  }
//}

class Authority {
  final def theWord: String =
    "This is the final word on the matter!"
}

// this won't compile either

//class Argumentative extends Authority {
//  override def theWord: String =
//    "No, it's not!"
//}

// String is final, so can't extend it

// class BadString extends String

final class Infinity

//class Beyond extends Infinity


//Play

final class Demo{

   def  getName:Int=>String = (x:Int) => x.toString

}

class Demo1 {
  final def demo(c: Int): String = c.toString
}


class chiled(var name:String){

  val demo = new Demo()
    demo.getName(10)
}
val child = new chiled("nine")
child.name
child.name = "ten"
child.name