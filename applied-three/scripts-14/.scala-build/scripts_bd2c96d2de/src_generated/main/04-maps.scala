



final class `04$minusmaps$_` {
def args = `04$minusmaps_sc`.args$
def scriptPath = """04-maps.sc"""
/*<script>*/
import scala.collection.mutable
import scala.collection.immutable

val numWords = Map(1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five")


numWords(1)     // don't use this
numWords.get(1) // use this
numWords.getOrElse(1, "?") // or this

val nums = List(1,2,3,2,5)
nums.map(numWords)

for ((num, word) <- numWords) {
  println(s"$num -> $word")
}


val tm = immutable.TreeMap.empty[Int, String] ++ numWords


val mm = mutable.Map.empty[Int, String] ++ numWords

mm -= 2
mm += 2 -> "two"


numWords.keys
numWords.keySet
numWords.values

numWords.filterKeys(_ % 2 == 0)
numWords.mapValues(_.reverse)

numWords.transform { case (k, v) => s"$v($k)" }

numWords.map(_.swap)

val evens = (for (i <- 1 to 5) yield i -> (i % 2 == 0)).toMap
evens.map(_.swap)



/*</script>*/ /*<generated>*/
/*</generated>*/
}

object `04$minusmaps_sc` {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new `04$minusmaps$_`

  def main(args: Array[String]): Unit = {
    args$set(args)
    script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export `04$minusmaps_sc`.script as `04$minusmaps`

