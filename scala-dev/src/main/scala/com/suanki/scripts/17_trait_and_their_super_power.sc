import java.io.File


trait Timestamp{
  val creationTime:String = {
    val formatter = java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")

    java.time.LocalDateTime.now.format(formatter)

  }


}

class FileWithTimeStamp(path:String) extends java.io.File(path) with Timestamp

def showCreationTime(time:Timestamp):Unit = time.creationTime
val path = "scala-dev/src/main/resources/data/cars.json"

//val file = new File((path))
val file = new FileWithTimeStamp((path))

file.getName
file.creationTime
showCreationTime(file)


//or creation of anonymous class and only instance of File with TimeStamp

val fileOne = new File(path) with Timestamp {

  def show():Unit = println(java.time.LocalDateTime.now())
}

fileOne.show()

fileOne.getName

type TooLazyToType = java.io.File with Timestamp

fileOne:TooLazyToType



//===================================================

object Base{

  abstract  class Animal{
    def name:String
    def typeAnimal:String
  }
}