

var x = 7

def openTerm(x:Int):Int=>Int=
  boundVariable => x + boundVariable


def addToSeven:Int=>Int=y=>x+y

val addToX:Int=>Int=
  y=>x+y

val addToX1:Int=>Int=x+_

openTerm(7)(0)

val partitialComputation = openTerm((7))

partitialComputation(0)
partitialComputation(10)