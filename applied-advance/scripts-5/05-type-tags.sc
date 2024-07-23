import scala.reflect._
import runtime.universe._

val tt = typeTag[Map[String, List[Int]]]

case class Tagged[A](value: A)(implicit val tag: TypeTag[A])
val taggedMap1 = Tagged(Map(1 -> "one", 2 -> "two"))
val taggedMap2 = Tagged(Map(1 -> 1, 2 -> 2))
def taggedIsA[A, B](x: Tagged[Map[A, B]]): Boolean = x.tag.tpe match {
  case t if t =:= typeOf[Map[Int, String]] => true
  case _ => false
}
taggedIsA(taggedMap1)
taggedIsA(taggedMap2)


