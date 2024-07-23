
trait EndPoint{
  def show()=println("Test*")
}
trait Api extends EndPoint{


}

trait Table extends EndPoint{

}

trait Mdl[T]
trait Ref[T]

class MdlApi[T] extends Api with Mdl[T]

case class Instrument[T]() extends MdlApi[T]  {
}
case class CounterParty[T]() extends MdlApi[T]


class RefTable[T] extends Table with Ref[T]

case class SCRAGrade[T]() extends RefTable[T]


trait Factory{
  type ENDPOINT <: EndPoint
  val endPoint:ENDPOINT
}

object getObjectFactory{

  def apply[F <:  EndPoint](f:F) =new Factory {
    override type ENDPOINT = F
    override val endPoint: ENDPOINT = f
    endPoint.show
  }
}



