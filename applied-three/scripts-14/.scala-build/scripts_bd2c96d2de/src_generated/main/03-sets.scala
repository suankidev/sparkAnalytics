



final class `03$minussets$_` {
def args = `03$minussets_sc`.args$
def scriptPath = """03-sets.sc"""
/*<script>*/

// immutable Sets


val vowels = Set('a', 'e', 'i', 'o', 'u')

vowels.contains('a')
vowels.contains('t')

vowels('a')
vowels('t')

vowels + 'y'
vowels + 'e'

val commonLetters = Set('e','t','a','o','i','n','s','r','h')

commonLetters intersect vowels
commonLetters diff vowels
vowels diff commonLetters
commonLetters union vowels

// set can be used like a predicate

"hello to me".count(vowels)

import scala.collection.immutable

// not ordered, but can be sorted
immutable.TreeSet('u', 'o', 'i', 'e', 'a')


// mutable

import scala.collection.mutable

val vowelsMut = mutable.Set('a', 'e', 'i', 'o', 'u')

vowelsMut += 'y'
vowelsMut('y')

vowelsMut -= 'y'
vowelsMut('y')

vowelsMut('y') = true
vowelsMut('y')

vowelsMut('y') = false
vowelsMut('y')



/*</script>*/ /*<generated>*/
/*</generated>*/
}

object `03$minussets_sc` {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new `03$minussets$_`

  def main(args: Array[String]): Unit = {
    args$set(args)
    script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export `03$minussets_sc`.script as `03$minussets`

