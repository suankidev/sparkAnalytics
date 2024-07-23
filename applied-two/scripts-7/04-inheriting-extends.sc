abstract class Food {
  def name: String
}

abstract class Fruit extends Food

class Orange(val name: String) extends Fruit

val jaffa = new Orange("Jaffa")
val mango = new Orange("Mango")

println(mango.name)

println(jaffa.name)
