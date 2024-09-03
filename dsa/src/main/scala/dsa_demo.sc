import scala.util.matching.Regex

val str = "this is test \"\" string "

str.contains(f"""\"\"""")

val splittedStr = str.split(" ")

splittedStr :+ ""

val myStr = "1003, \"\",25,\"TX7947,Ystr\",Kharadi"

val pattern = new Regex("^\".*$\"")

println(
  (pattern findAllIn str).mkString("|")
)
