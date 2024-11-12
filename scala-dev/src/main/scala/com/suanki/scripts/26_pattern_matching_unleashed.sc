class Person( name:String,  age:Int) {

  def isAdult:Boolean = age >=18

}


def method(input:Any):Any = input match {
  case person: Person if person.isAdult =>  s"guard : ${person.isAdult}"
  case person: Person => person.isAdult
}






val alice = new Person(name = "Alice" ,
  age = 27)


method(alice)

//pattern match
/*
type
datastructure
variable
 */