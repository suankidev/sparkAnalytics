



final class `03$minusstacking$minustraits$_` {
def args = `03$minusstacking$minustraits_sc`.args$
def scriptPath = """03-stacking-traits.sc"""
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
  override def describe: String =
    s"convertible ${super.describe}"
}

trait PoweredConvertible extends Convertible {
  override def describe: String =
    s"powered ${super.describe}"
}

trait HardtopConvertible extends Convertible {
  override def describe: String =
    s"hard-top ${super.describe}"
}

class ClassicConvertible1(val color: String, val vintage: Int)
  extends Car with PoweredConvertible with Classic with HardtopConvertible

new ClassicConvertible1("red", 1965).describe
//o/p hardtop converitble vintage 1965 red car


class ClassicConvertible2(val color: String, val vintage: Int)
  extends Car with Classic with PoweredConvertible with HardtopConvertible

new ClassicConvertible2("red", 1965).describe

class ClassicConvertible3(val color: String, val vintage: Int)
  extends Car with PoweredConvertible with HardtopConvertible with Classic

new ClassicConvertible3("red", 1965).describe

//
//class ClassicCar(val color: String, val vintage: Int) extends Car with Classic
//
//val ccc = new ClassicCar("red", 1965) with PoweredConvertible with HardtopConvertible
//
//ccc.describe
/*</script>*/ /*<generated>*/
/*</generated>*/
}

object `03$minusstacking$minustraits_sc` {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new `03$minusstacking$minustraits$_`

  def main(args: Array[String]): Unit = {
    args$set(args)
    script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export `03$minusstacking$minustraits_sc`.script as `03$minusstacking$minustraits`

