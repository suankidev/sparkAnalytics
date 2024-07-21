
val file = scala.io.Source.fromFile("C:\\Users\\sujee\\Desktop\\spark_input\\permissive_test.csv")

val lines = file.getLines()
var fileContain:List[String] = List.empty

for(line <- lines){
  //    println(s"adding line ${line}")
  fileContain = line :: fileContain
}
//how many times us came in file
println(
  fileContain
    .flatMap(x => x.split(","))
    .groupBy(identity)
    .mapValues(x => x.size)
    .get("United States")
)