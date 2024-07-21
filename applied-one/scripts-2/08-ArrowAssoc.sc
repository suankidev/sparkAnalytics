

1 -> "one"

2.->("two")

ArrowAssoc(3).->("three")


// easy map iteration

val mapToRiches = Map(
  1 -> "steal underpants",
  2 -> "???",
  3 -> "profit"
)

for ((step, instruction) <- mapToRiches) {
  println(s"Step $step - $instruction")
}


for (i <- mapToRiches){
  println(s"step: $i ${i._2}")
}


val t = scala.collection.mutable.Map((1,"One"),(2,"Two"),(3,"Three"))
val t1 = Map(11 -> "Apple",12 -> "Banana")
t += (4 -> "four")
t -= 3

t ++= t1
t