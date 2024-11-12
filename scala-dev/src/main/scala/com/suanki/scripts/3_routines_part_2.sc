//sum till limit=num
def sum(num: Int): Int = {
  def loop(num: Int, sum: Int = 0): Int = {
    if (num < 0) sum
    else loop(num - 1, sum + num)
  }
  loop(num)
}

sum(5) //15
sum(6) //21

//count of 2

def counterOfNumber(num: Int): Int = {
  def loop(counter: Int = 2, acc: Int = 2): Int = {
    if (counter == 1) {
      println(num)
      loop(counter + 1, num * counter)
    } else if (counter > 11)
      acc
    else {
      println(acc)
      loop(counter + 1, num * counter)
    }
  }

  loop()
}

counterOfNumber(2)

//factorial of number

//5! = 5*4*3*2*1

def factorial_1(num: Long): Long = {
  if (num <= 1) 1
  else num * factorial_1(num - 1)
}

def factorial_2(num: Long): Long = {
  def loop(num: Long): Long = {
    if (num <= 1) 1
    else num * loop(num - 1)
  }
  loop(num)
}

def factorial(num: Long): Long = {
  var iteration = 0
  def loop(num: Long, acc: Long): Long = {
    iteration += 1

    if (num <= 1) acc
    else loop(num - 1, acc * num)
  }
  val result = loop(num, acc = 1)
  println(iteration)
  result
}

factorial(5)
factorial(10)
factorial_1(10)
factorial_2(10)

/** fibnacci
  */

def fib(num: Int): Int = {
  if (num > 100) 1
  else fib(num - 1) + fib(num + 2)
}

fib(100)
