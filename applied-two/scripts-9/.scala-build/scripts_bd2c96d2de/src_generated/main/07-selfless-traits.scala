



final class `07$minusselfless$minustraits$_` {
def args = `07$minusselfless$minustraits_sc`.args$
def scriptPath = """07-selfless-traits.sc"""
/*<script>*/
trait Logging {
  def error(msg: String): Unit = println(s"Error: $msg")
  def warn(msg: String): Unit = println(s"Warn: $msg")
  def info(msg: String): Unit = println(s"Info: $msg")
}

object Logging extends Logging

class Process1 extends Logging {
  def doIt(): Unit = {
    info("Checking the cell structure")
    error("It's all gone pear shaped")
  }
}

val p1 = new Process1
p1.doIt()

class Process2 {
  import Logging._

  def doIt(): Unit = {
    info("Checking the cell structure")
    error("It's all gone pear shaped")
  }
}

val p2 = new Process2
p2.doIt()
/*</script>*/ /*<generated>*/
/*</generated>*/
}

object `07$minusselfless$minustraits_sc` {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new `07$minusselfless$minustraits$_`

  def main(args: Array[String]): Unit = {
    args$set(args)
    script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export `07$minusselfless$minustraits_sc`.script as `07$minusselfless$minustraits`

