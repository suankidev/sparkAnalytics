package com.suanki.utilities

import org.apache.spark.sql.SparkSession

trait Spark {
  implicit var master: String = "local[2]"
  implicit var appName: String = "sparkAnalytics"
  implicit var hiveSupport: Boolean = false

  lazy val setName: String => Unit = name => appName = name
  lazy val setMaster: String => Unit = name => master = name
  lazy val enableHiveSupport: Boolean => Unit = name => hiveSupport = name

  implicit val spark: SparkSession = SparkSession
    .builder()
    .master(master)
    .appName(appName)
    .getOrCreate()
}
