



final class `05$minusoverride$minusabstract$_` {
def args = `05$minusoverride$minusabstract_sc`.args$
def scriptPath = """05-override-abstract.sc"""
/*<script>*/
abstract class Vehicle {
  def describe: String  // abstract describe
  override def toString = s"$describe"
}

trait Classic extends Vehicle {
  def vintage: Int
   abstract override def describe: String =
    s"vintage $vintage ${super.describe}"
}

trait Convertible extends Vehicle {
  def poweredTop: Boolean
   abstract override def describe: String = {
    val top = if (poweredTop)
      "powered convertible" else "convertible"
    s"$top ${super.describe}"
  }
}

trait Car extends Vehicle {
  def color: String
  def describe: String = s"$color car"
}

class ClassicConvertible(
  val color: String, val vintage: Int, val poweredTop: Boolean
) extends Car with Classic with Convertible

val mustang = new ClassicConvertible("red", 1965, false)


/*</script>*/ /*<generated>*/
/*</generated>*/
}

object `05$minusoverride$minusabstract_sc` {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new `05$minusoverride$minusabstract$_`

  def main(args: Array[String]): Unit = {
    args$set(args)
    script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export `05$minusoverride$minusabstract_sc`.script as `05$minusoverride$minusabstract`

