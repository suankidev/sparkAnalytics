



final class `04$minusclasses$minustraits$minusand$minusinitialization$_` {
def args = `04$minusclasses$minustraits$minusand$minusinitialization_sc`.args$
def scriptPath = """04-classes-traits-and-initialization.sc"""
/*<script>*/
class CoordsC(val x: Double, val y: Double) {
  override def toString: String = s"($x, $y)"
  val distToOrigin: Double = math.sqrt((x * x) + (y * y))
}

val c1 = new CoordsC(3.0, 4.0)
c1.distToOrigin

// will not compile, traits can't have constructor params
//trait CoordsT(x: Double, y: Double) {
//  override def toString: String = s"($x, $y)"
//}

trait CoordsT {
  val x: Double
  val y: Double
  override def toString: String = s"($x, $y)"
  lazy val distToOrigin: Double = math.sqrt((x * x) + (y * y))
}

case class Coords(x: Double, y: Double) extends CoordsT

val c2 = Coords(3.0, 4.0)
c2.distToOrigin


val c3 = new CoordsT {
  val x: Double = 3.0
  val y: Double = 4.0
}

c3.distToOrigin

val c4 = new {
  val x: Double = 3.0
  val y: Double = 4.0
} with CoordsT

c4.distToOrigin
/*</script>*/ /*<generated>*/
/*</generated>*/
}

object `04$minusclasses$minustraits$minusand$minusinitialization_sc` {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new `04$minusclasses$minustraits$minusand$minusinitialization$_`

  def main(args: Array[String]): Unit = {
    args$set(args)
    script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export `04$minusclasses$minustraits$minusand$minusinitialization_sc`.script as `04$minusclasses$minustraits$minusand$minusinitialization`

