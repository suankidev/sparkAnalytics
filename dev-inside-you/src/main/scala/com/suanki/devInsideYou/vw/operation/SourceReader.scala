package com.suanki.devInsideYou.vw.operation

import com.suanki.devInsideYou.vw.utils.AppLogger

object SourceReader extends AppLogger {

  def show(i: String): Unit =
    logger.error(s"show(): $i")

}
