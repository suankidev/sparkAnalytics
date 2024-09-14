
def plusFive(input:Int):Int = input + 5
def divideByTwo(input:Int):Int = input / 2

val renderedPlusFiveOld:String =
  s"Function: plusFive Argument: ${10} Result:${plusFive(10)}"

val renderedPlusFive:String =
//  rendered("plusFive",10,result = plusFive(10))
  higherOrderRendered("plusFive",10,plusFive)

val renderedDivideByTwo:String =
//  rendered("divideByTwo",20,result = divideByTwo(20))
  higherOrderRendered("divideByTwo",20, divideByTwo)

def lowerOrderRendered(functionName:String,argument:Int, result:Int):String=
  s"Function: ${functionName} Argument: ${argument} Result:${result}"

def higherOrderRendered(functionName:String,argument:Int, function:Int=>Int):String=
//  s"Function: ${functionName} Argument: ${argument} Result:${result}"
  lowerOrderRendered(functionName,argument,function(argument))



//or

higherOrderRendered("plusFive",10, input => input+5)
higherOrderRendered("plusFive",10, _ + 5)
higherOrderRendered("multiply",10, _ * 5)



//hi 10 times

def loop(code:()=>Unit):Unit={
  1 to 10 foreach{
    _=>code()
}
}

//if function take unit
def loopTen(code: =>Unit):Unit={
  1 to 10 foreach{
    _=>code
  }
}


loop(()=>println("hi"))
loopTen(println("hi"))