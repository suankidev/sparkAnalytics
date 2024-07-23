



final class `05$minusiterators$minusviews$minusstreams$_` {
def args = `05$minusiterators$minusviews$minusstreams_sc`.args$
def scriptPath = """05-iterators-views-streams.sc"""
/*<script>*/
val nums = List.range(1, 21)

val numsIter = nums.iterator

numsIter.hasNext

// An example of what not to do!
// if (numsIter.length > 0) numsIter.next()


val vec = Vector.range(0, 20)

val vecView = vec.view

def calcSquare(x: Int): Int = {
  println(s"Calculating for $x")
  x * x
}

val squaresView = vecView.map(calcSquare)

squaresView(2)
squaresView(4)
squaresView(2)

val squares = squaresView.force

squares(2)

squares


val numsFromOne = Stream.from(1)

val firstTenNums = numsFromOne.take(10)
firstTenNums.toList

val powersOfTwo: Stream[Int] = 1 #:: powersOfTwo.map(_ * 2)
powersOfTwo.take(5).toList

val factorial: Stream[BigInt] = BigInt(1) #:: factorial.zip(Stream.from(2)).
  map { case(a, b) => a * b }

val firstTenFacs = factorial.take(10)

firstTenFacs.toList


val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).
  map { case(x, y) => x + y }

fibs.take(20).toList

/*</script>*/ /*<generated>*/
/*</generated>*/
}

object `05$minusiterators$minusviews$minusstreams_sc` {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new `05$minusiterators$minusviews$minusstreams$_`

  def main(args: Array[String]): Unit = {
    args$set(args)
    script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export `05$minusiterators$minusviews$minusstreams_sc`.script as `05$minusiterators$minusviews$minusstreams`

