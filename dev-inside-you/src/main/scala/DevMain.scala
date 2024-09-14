object DevMain {


  def method={
    var currentIteration: Int = 1
  def loop:String={
    if(currentIteration % 5 != 0) {
      println(currentIteration)
      currentIteration+=1
      loop
    } else
      "done"
  }
  loop
  }

  def method2: String = {
    def loop(currentIteration: Int): String = {
      if (currentIteration % 5 != 0) {
        println(currentIteration)
        loop(currentIteration + 1)
      } else
        "done"
    }

    loop(1)
  }


  def main(args:Array[String]):Unit={
    println("="*50)
    println("RoutineJ Object!")

   println(
         DevMain.method
       )


    println("="*50)


      }


}

