val str = "this is test \"\" string "

str.contains(f"""\"\"""")

val splittedStr = str.split(" ")

splittedStr :+ "tests"
