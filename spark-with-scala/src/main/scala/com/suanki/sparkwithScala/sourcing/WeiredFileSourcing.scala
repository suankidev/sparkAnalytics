package com.suanki.sparkwithScala.sourcing

import org.apache.spark.sql.{Row, SparkSession}

class WeiredFileSourcing(spark: SparkSession) {
  self =>

  def run(): Unit = {

    val file = "spark-with-scala/src/main/resources/delim_test.csv"

    val filedf = {
      spark.read
        .format("csv")
        .option("header", value = false)
        .option("sep", ",")
        .option("emptyValue", "")
        .option("inferSchema", value = false)
        .option("quoteAll", value = false)
        .load(file)
    }

    // 8381044237
    /*Fixing "" charecter since, it's loading double quote instead of null
 +----+-----+----+-------------+
| _c0|  _c1| _c2|          _c3|
+----+-----+----+-------------+
|  id| name| age|      address|
|1001|   ""|  23|   Karvenager|
|1002|   ""|  24|RajendarNagar|
|1003|   ""|  25|         NULL|
+----+-----+----+-------------+
     */

    // solving above issue with rdd along with handling of header and footer automatically
    val fileRdd = spark.sparkContext.textFile(file)

    val fileRddWithIndex = fileRdd.zipWithIndex().filter(x => x._2 > 0)

    val collength = filedf.columns.length

    val splittedArrayString = {
      fileRddWithIndex
        .map(row => row._1)
        .map(x => {
          val splitedStr = x.split(",")
          println(s"splitedStr: ${splitedStr.mkString("|")}")
          val stringLength: Int = splitedStr.length
          if (stringLength == collength) splitedStr
//          else if(stringLength < collength) {
//            for(idx <- stringLength until  collength) {
//              println(s"idx:$idx length of string: $stringLength  and collength $collength splitedStr: ${splitedStr.mkString("-")}")
//              splitedStr :+ "tt"
//            }
//          }
          else splitedStr :+ ""
        })
    }

    import scala.util.matching.Regex
    {
      fileRddWithIndex
        .filter(x => x._2 == 4)
        .map(x => {

          val pattern = new Regex("^\".*$\"")
          if (x._1.contains("\""))
            x._1.replace("\"", "")
          else x._1
        })
    }

    val finalRdd = {
      splittedArrayString.map({ row =>
        Row.fromSeq(
          row.toSeq
            .map(x => {
              if (x.isEmpty) null.asInstanceOf[String]
              else if (x.contains(f"""\"\"""")) null.asInstanceOf[String]
              else x
            })
        )
      })
    }

    val finalDF = spark.createDataFrame(finalRdd, filedf.schema)
    finalDF.show(truncate = false)
    /*
     o/p of finalDF
+----+----+---+-------------+
| _c0| _c1|_c2|          _c3|
+----+----+---+-------------+
|1001|NULL| 23|   Karvenager|
|1002|NULL| 24|RajendarNagar|
|1003|NULL| 25|         NULL|
+----+----+---+-------------+
     */

    // Solving issue after writing the file with option("quote",value="") and reading it back

    val outputFileName = "spark-with-scala/src/main/resources/output/weiredcsv"

    filedf.write
      .mode("overwrite")
      .option("quote", value = "")
      .csv(outputFileName)

    spark.read
      .format("csv")
      .option("header", value = false)
      .load(outputFileName)
      .show()
    /*
 +----+----+---+-------------+
| _c0| _c1|_c2|          _c3|
+----+----+---+-------------+
|  id|name|age|      address|
|1001|NULL| 23|   Karvenager|
|1002|NULL| 24|RajendarNagar|
|1003|NULL| 25|         NULL|
+----+----+---+-------------+
     */
  }

}
