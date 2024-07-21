var x = 0

while (x < 10) {
  println(s"the square of $x is ${x * x}")
  x += 1
}

x = 0
do {
  println(s"the square of $x is ${x * x}")
  x += 1
  x
} while (x < 10)

def someMethod(x:Int):Int={
  try{
    x/0
  }catch {
    case e:NoSuchElementException => 0
    case e:ArithmeticException => 10
  }finally {
    println("als")
  }
}

val x = someMethod(10)

if(x == 10){
  println("returned zero")
}



var z=10
do{
  println(z)
  z = z-1
}while(z > 0)
