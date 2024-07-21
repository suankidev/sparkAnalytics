


def test[A](a:Int,f:Int=>A):A={
  f(a)
}

test(10, (x:Int) => x*10)