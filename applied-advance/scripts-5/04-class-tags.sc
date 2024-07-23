import scala.reflect._
def getClassTag[T: ClassTag](x: T): ClassTag[T] = classTag[T]
val intCT = getClassTag(10)
intCT.runtimeClass
getClassTag("hello").runtimeClass

val intArr = intCT.newArray(5)

def isABad[T](x: Any): Boolean = x match {
  case _: T => true
  case _ => false
}
isABad[Int](7)
isABad[Int]("Hello")

def isA[T: ClassTag](x: Any): Boolean = x match {
  case _: T => true
  case _ => false
}
// no warning
isA[Int](7)
isA[Int]("Hello")

isA[Map[String, Int]](Map("hello" -> 2))     // true
isA[Map[String, Int]](Map("hello" -> "foo")) // true :-(


