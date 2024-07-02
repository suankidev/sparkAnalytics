/*
 * This Scala source file was generated by the Gradle 'init' task.
 */
package com.suanki.app
import com.suanki.utilities.Spark
import org.apache.spark.sql.DataFrame

object FlightData extends Spark {

  val path = "C:\\Users\\sujee\\Desktop\\spark_input\\fligtData\\2010-summary.csv"

  def getData: DataFrame = spark.read.format("csv").option("header",value = true).load(path)

}

