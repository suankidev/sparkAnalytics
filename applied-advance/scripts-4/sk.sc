def lengthOfList[T](l:List[T]) = l.length
def lengthOfListOne(l:List[_]) = l.length


lengthOfList[Int](List(1,2,5))



trait Love[T1,T2]{

  def describe(i1:T2, i2:T2) = println(s"$i1 love $i2")
}

case class Person(name:String)

case class NameLover(p1:Person,p2:Person) extends Love[Person,Person]{

  def sayIt = describe(p1,p2)
  def sayItWithRoses(lovers: Person Love Person) = lovers.describe(p1,p2)
}

NameLover(Person("Ankita"), Person("Sujeet"))
  .sayIt