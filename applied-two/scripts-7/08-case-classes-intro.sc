import java.time.LocalDate

case class Car(make: String, model: String, year: Int) {
  lazy val isVintage: Boolean =
    LocalDate.now.getYear - year > 20
}

val mustang = Car("Ford", "Mustang", 1965)

mustang.make
mustang.model
mustang.year
mustang.isVintage

mustang == Car("Ford", "Mustang", 1965)
mustang == Car("Ford", "Mustang", 1964)
mustang.equals(Car("Ford", "Mustang", 1964))


val t = new String("test")
val t1 = new String("test")


t==t1  //containt
t.eq(t1)  //ref compar
t.equals(t1) //contain comparison

//========

