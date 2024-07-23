



final class `02$minusconsistent$minusapi$_` {
def args = `02$minusconsistent$minusapi_sc`.args$
def scriptPath = """02-consistent-api.sc"""
/*<script>*/
import scala.collection.immutable

val q = immutable.Stack(1,2,3,4)
val eq = immutable.Stack.empty[Int]

val xs = List(1,2,3,4)
val exs = List.empty[Int]

val v = Vector(1,2,3,4)
val ev = Vector.empty[Int]

val s = Set(1,2,3,4)
val es = Set.empty[Int]

q == xs
q == v
xs == v
xs == s


val arr = Array(1,2,3,4)
xs == arr
xs == arr.deep

xs.toVector
xs.toArray
xs.toSet
xs.zipWithIndex.toMap
val newXs = xs.toList
xs eq newXs  // it's a no op for List -> toList

val newVec = v.toVector
v eq newVec  // and for Vector -> toVector, etc.

// no built in toQueue
//xs.toQueue

// so do this instead
xs.to[immutable.Queue]

val vec = Vector.range(1, 9)

vec.updated(6, 20)

/*</script>*/ /*<generated>*/
/*</generated>*/
}

object `02$minusconsistent$minusapi_sc` {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new `02$minusconsistent$minusapi$_`

  def main(args: Array[String]): Unit = {
    args$set(args)
    script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export `02$minusconsistent$minusapi_sc`.script as `02$minusconsistent$minusapi`

