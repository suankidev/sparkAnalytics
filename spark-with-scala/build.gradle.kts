
plugins {
    id("com.suanki.scala-spark-library-conventions")
}

dependencies{
    implementation(project(":utilities"))
}


tasks.withType<ScalaCompile>().configureEach {
//    scalaCompileOptions.forkOptions.apply {
//        memoryMaximumSize = "1g"
//        jvmArgs = listOf("-XX:MaxMetaspaceSize=700m")
//    }
//    //https://docs.gradle.org/current/userguide/scala_plugin.html
    scalaCompileOptions.additionalParameters=listOf("-release:8")
}