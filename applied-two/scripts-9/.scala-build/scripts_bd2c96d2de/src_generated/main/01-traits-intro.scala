



final class `01$minustraits$minusintro$_` {
def args = `01$minustraits$minusintro_sc`.args$
def scriptPath = """01-traits-intro.sc"""
/*<script>*/
trait Car {
  def color: String
  def describe: String = s"$color car"
}

val mustang = new Car {
  val color = "red"
}

mustang.describe

class ActualCar(val color: String, val name: String) extends Car

val modelT = new ActualCar("black", "Model T")

modelT.describe

val car: Car = modelT

car.describe

class Demo extends Car with Function1[String, String] {
  override def color = "red"
  override def apply(v1: String): String = s"$v1 $color"
}

val demo = new Demo

demo("cherry")

val descriptionLength = demo.andThen(_.length)

descriptionLength("cherry")
/*</script>*/ /*<generated>*/
/*</generated>*/
}

object `01$minustraits$minusintro_sc` {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new `01$minustraits$minusintro$_`

  def main(args: Array[String]): Unit = {
    args$set(args)
    script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export `01$minustraits$minusintro_sc`.script as `01$minustraits$minusintro`

