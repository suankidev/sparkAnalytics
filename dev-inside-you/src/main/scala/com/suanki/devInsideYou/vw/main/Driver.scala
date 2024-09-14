package com.suanki.devInsideYou.vw.main

import com.suanki.devInsideYou.vw.operation.SourceReader
import com.suanki.devInsideYou.vw.utils.AppLogger

object Driver  extends AppLogger {

    def main(args:Array[String]):Unit= {

        println("="*50)
       info("applogger testing")

        try {
            SourceReader.show("Dividing 4/0 from try block")
            4 / 0
        } catch {
            case e: ArithmeticException =>
                warn(s"err msg ${e.getMessage}")
        }



        println("="*50)
    }

}
