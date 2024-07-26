



final class `02$minusmultiple$minustraits$_` {
def args = `02$minusmultiple$minustraits_sc`.args$
def scriptPath = """02-multiple-traits.sc"""
/*<script>*/
abstract class Car {
  def color: String
  def describe: String = s"$color"
  override def toString = s"$describe car"
}

trait Classic extends Car {
  def vintage: Int
  override def describe: String =
    s"vintage $vintage ${super.describe}"
}

trait Convertible extends Car {
  def poweredTop: Boolean
  override def describe: String = {
    val top = if (poweredTop)
      "powered convertible" else "convertible"
    s"$top ${super.describe}"
  }
}

class ClassicConvertible(
  val color: String, val vintage: Int, val poweredTop: Boolean
) extends Car with Classic with Convertible

val mustang = new ClassicConvertible("red", 1965, false)


//when mixed in
//scala figured out through DAG , called linearization

/*</script>*/ /*<generated>*/
/*</generated>*/
}

object `02$minusmultiple$minustraits_sc` {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new `02$minusmultiple$minustraits$_`

  def main(args: Array[String]): Unit = {
    args$set(args)
    script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export `02$minusmultiple$minustraits_sc`.script as `02$minusmultiple$minustraits`

