abstract class Vehicle(val name: String, val age: Int) {
  override def toString: String =
    s"$name, $age years old"
}

class Car(
           override val name: String,
  val make: String,
  val model: String,
  override val age: Int
) extends Vehicle(name, age) {

  override def toString: String =
    s"a $make $model, named ${super.toString}"
}

val mustang = new Car("Sally", "Ford", "Mustang", 50)




class AnotherCar( name:String,
                  val make:String,
                  val model:String,
                  age:Int
                ) extends Vehicle(name,age){


  override def toString(): String = s"$make $model ${super.toString()}"

}


val mustangAnother = new AnotherCar("Sally", "Ford", "Mustang", 50)

println(mustang.name)
println(mustangAnother.name) //name is still available without override private[this] gets converted ot val b/c
//of super class