

abstract class Food { val name: String }

abstract class Fruit extends Food
case class Banana(name: String) extends Fruit
case class Apple(name: String) extends Fruit
case class Orange(name: String) extends Fruit

abstract class Cereal extends Food
case class Granola(name: String) extends Cereal
case class Muesli(name: String) extends Cereal

val fuji = Apple("Fuji")
val alpen = Muesli("Alpen")


trait Description {
  val describe: String
}
case class Taste(describe: String) extends Description
case class Texture(describe: String) extends Description

def describeAnApple(fn: Apple => Description) = fn(Apple("Fuji"))
def describeAFruit(fn: Fruit => Description) = fn(Orange("kinno"))


val juicyFruit: Fruit => Taste =
fruit => Taste(s"This ${fruit.name} is nice and juicy")

val bumpyOrange: Fruit => Texture = {
  orange => Texture(s"This ${orange.name} is bumpy")
}
val m:Food => Description = f => Taste(s"yummy test $f")

describeAnApple(juicyFruit)
//describeAnApple(m)
//describeAFruit(juicyFruit)
describeAFruit(bumpyOrange)

