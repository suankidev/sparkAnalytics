object Routine {
  def method = {
    var currentIteration: Int = 1

    @scala.annotation.tailrec
    def loop: String = {
      if (currentIteration % 5 != 0) {
        println(currentIteration)
        currentIteration += 1
        loop
      } else
        "done"
    }

    loop
  }

  def method2: String = {
    @scala.annotation.tailrec
    def loop(currentIteration: Int): String = {
      if (currentIteration % 5 != 0) {
        println(currentIteration)
        loop(currentIteration + 1)
      } else
        "done"
    }

    loop(1)
  }

  def method3: String = {
    var currentIteration = 1
    while (currentIteration % 5 != 0) {
      println(currentIteration)
      currentIteration += 1
    }

    "done"
  }
}
//currentIteration=1
//1, loop(2)
//2, loop(3)
//3, loop(4)

DevMain.method
DevMain.method2
DevMain.method3

/** tail recursion if last call is either a call to itself or value
  */
