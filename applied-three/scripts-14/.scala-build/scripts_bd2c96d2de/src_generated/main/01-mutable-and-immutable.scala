



final class `01$minusmutable$minusand$minusimmutable$_` {
def args = `01$minusmutable$minusand$minusimmutable_sc`.args$
def scriptPath = """01-mutable-and-immutable.sc"""
/*<script>*/
import scala.collection.mutable
import scala.collection.immutable

def popImmutableQueue(q: immutable.Queue[Int]): (Int, immutable.Queue[Int]) = {
  q.dequeue
}

def popMutableQueue(q: mutable.Queue[Int]): Int = {
  q.dequeue()
}


val immQ = immutable.Queue(1,2,3,4)
val mQ = mutable.Queue(1,2,3,4)

popImmutableQueue(immQ)
popMutableQueue(mQ)

immQ
mQ

/*</script>*/ /*<generated>*/
/*</generated>*/
}

object `01$minusmutable$minusand$minusimmutable_sc` {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new `01$minusmutable$minusand$minusimmutable$_`

  def main(args: Array[String]): Unit = {
    args$set(args)
    script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export `01$minusmutable$minusand$minusimmutable_sc`.script as `01$minusmutable$minusand$minusimmutable`

