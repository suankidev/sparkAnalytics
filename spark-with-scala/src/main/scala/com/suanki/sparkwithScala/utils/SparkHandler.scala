package com.suanki.sparkwithScala.utils

import com.suanki.sparkwithScala.model.AppConstants
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

trait SparkHandler {

  private val _sparkConf: SparkConf =
    new SparkConf()
      .setAppName(AppConstants.APPNAME)
      .set("spark.sql.sources.partitionColumnTypeInference.enabled", "false")

  private val _sparkSession: SparkSession =
    SparkSession.builder().config(_sparkConf).getOrCreate()

  val sparkSession: SparkSession = _sparkSession
  val sparkContext: SparkContext = _sparkSession.sparkContext

}
