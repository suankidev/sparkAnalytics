import scala.annotation.tailrec

def factSeq(n:Int):List[Long]={
  @tailrec
  def factSeqInner(longs: List[Long], i1: Int):List[Long]={
    if(i1 > n) longs
    else
      factSeqInner( i1 * longs.head :: longs, i1 + 1)
  }
  factSeqInner(List(1L),2)
}


val d:(Int) => Int = a => a*10
val e:(Int,Int) => Int = (a,b) => a*b
val f = (a:Int) => a*10

def g(a:Int):Int=>Int= b => a*b

println(e.curried(10)(20))
println(e.tupled(10,20))
println(g(10)(20))
println(e.apply(10,20))
println(e.curried.apply(10).apply(20))


//HOF

def compareNeighbours(xs:List[Int],compare:(Int,Int)=>Int):List[Int]={
  for(pair <- xs.sliding(2)) yield {
    compare(pair(0),pair(1))
  }
}.toList


println(
  compareNeighbours(List(1,2,5,6),(x,y) => x+y)
)
val  addPair = (_:Int) + (_:Int)
println(
  compareNeighbours(List(1,2,5,6),_ + _),
  compareNeighbours(List(1,2,5,6),addPair)
)

val c = compareNeighbours(_:List[Int],(x,y)=>x+y)
println(c(List(1,2,5,6)))