//widening
def toBinary(n:Long):String={
    def loop(x:Long, accu:String):String={
      if(x==0)
        accu
      else
        loop(
          x = x/2,
          accu = (x%2).toString() + accu
        )
    }

    loop(n,"")

  }

  println(toBinary(0))
println(toBinary(1))
  toBinary(2)
  toBinary(3)
  toBinary(4)




//

val g:Symbol = Symbol("hello")

println(g + " world")


