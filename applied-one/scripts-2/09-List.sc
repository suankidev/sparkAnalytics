
val numList:List[Int] =  List(1,2,3,4,5)

val a = 9 :: numList //prepending value to list
val b = numList :: 9 :: Nil  //appending
val c = List(9,8) ::: numList  //adding two list
val d = c :+ 10 //append
val e = 10 +: d //prepend

println(numList)
println(numList.sum)
println(numList.reverse)
println(numList.max)
println(numList.min)
println(numList.size)
println(numList.length)
println(numList.takeRight(2)) //List(4,5)
println(numList.takeWhile(_ % 2 != 0)) //List(1)
println("fold left", numList.foldLeft(0)((x,y) => x + y))
println(numList.foldLeft(0)((acc,curr) => acc+curr))
numList.reduce((x,y) => x +y)
println(numList.map(x => x*20))
println(List("hello","thi,s").map(x => x.split(",").toList))
println(List("hello","thi,s").flatMap(x => x.split(",").toList))
println(numList.filter(_ % 2 == 0))
println(numList ++ List(10))
println(numList :: 10 :: Nil)
println(numList.drop(3))
println(numList.slice(0,3))
println(numList.splitAt(3))
println(List(1,2,3,4,3).count(x => x==3))
val someOtherNumberList = List(1,2,4,2,8,3,99,23,45,62).sorted
println((someOtherNumberList(someOtherNumberList.length - 2)))


println(numList)

println(numList.sliding(4).toList)
println(numList.grouped(2).toList)



val t = List(1,2,3)
val t1 =List("a","b","c")
val t2 = t.zip(t1)

t2.toMap
