package com.suanki.devInsideYou.vw.utils

import org.apache.log4j.Level

/** scala api: https://logging.apache.org/log4j/scala/latest/ Level Value
  * Description OFF 0 No logging FATAL 100 The application is unusable. Action
  * needs to be taken immediately. ERROR 200 An error occurred in the
  * application. WARN 300 Something unexpected—though not necessarily an
  * error—happened and needs to be watched. INFO 400 A normal, expected,
  * relevant event happened. DEBUG 500 Used for debugging purposes TRACE 600
  * Used for debugging purposes—includes the most detailed information
  */
trait AppLogger extends Serializable {
  @transient val logger: org.apache.log4j.Logger =
    org.apache.log4j.Logger.getLogger(this.getClass)

  logger.setLevel(Level.ERROR) // this or above this leve will be logged

  lazy val info: String => Unit = msg => logger.info(msg)
  lazy val warn: String => Unit = msg => logger.warn(msg)
  lazy val error: String => Unit = msg => logger.error(msg)
  lazy val debug: String => Unit = msg => logger.debug(msg)

}
