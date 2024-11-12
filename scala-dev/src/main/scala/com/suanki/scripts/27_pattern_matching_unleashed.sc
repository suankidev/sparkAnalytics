//constructor pattern

final case class Person( name:String,  age:Int) {

  def isAdult:Boolean = age >=18

}


def method(input:Any):Any = input match {
  case Person(name,age @ 27) if name.startsWith("S") => s"matched $name who is $age year old"
  case Person(name,age @ 32) => s"32: matched $name who is $age year old"
  case Person(name,age) => s"matched $name who is $age year old"
  //pattern match on tuple
  case
    (
      first @ Person(name:String,age @ 19),
      second @ Person(name1 @ "sujeet",age1 @ 17)
      ) => s"first : ${first.name} second: ${name1}"
  case (p1:Person,p2:Person) if p1.name.toLowerCase.startsWith("a")=> s"tuppled name start with a ${p1.name} and ${p2.name}"
  case (p1:Person,p2:Person) => s"tuppled ${p1.name} and ${p2.name}"
}






val ankita = Person(name = "Ankita" ,
  age = 27)
val sujeet=Person("Sujeet",32)


method(ankita)
method(sujeet)
method((ankita,sujeet))
