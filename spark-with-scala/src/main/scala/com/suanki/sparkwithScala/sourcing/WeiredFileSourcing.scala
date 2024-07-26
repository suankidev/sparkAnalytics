package com.suanki.sparkwithScala.sourcing

import org.apache.spark.sql.{Row, SparkSession}

class WeiredFileSourcing(spark: SparkSession) { self =>
  this

  def run(): Unit = {

    val file = "spark-with-scala/src/main/resources/delim_test.csv"

    val filedf = {
      spark.read
        .format("csv")
        .option("header", value = false)
        .option("sep", ",")
        .option("emptyValue", "")
        .option("inferSchema", false)
        .option("quoteAll", value = false)
        .load(file)
    }

    val fileRdd = spark.sparkContext.textFile(file)

    val fileRddWithIndex = fileRdd.zipWithIndex().filter(x => x._2 > 0)

    val collength = filedf.columns.length

    val splittedArrayString = {
      fileRddWithIndex
        .map(row => row._1)
        .map(x => {
          var splitedStr = x.split(",")
          var str = splitedStr.length
          if (str == collength) splitedStr
          else splitedStr :+ ""
        })
    }

    val finalRdd = {
      splittedArrayString.map({ case row =>
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

  }

}
