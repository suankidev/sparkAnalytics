
plugins{
    id("com.suanki.scala-spark-library-conventions")
    id("java")
    id("application")
}

application{

    mainClass.set("com.suanki.SampleFibonacciMain")
}

tasks.named<AbstractCompile>("compileScala") {
    // Groovy only needs the declared dependencies
    // (and not longer the output of compileJava)
    classpath = sourceSets.main.get().compileClasspath
}
tasks.named<AbstractCompile>("compileJava") {
    // Java also depends on the result of Groovy compilation
    // (which automatically makes it depend of compileGroovy)
    classpath += files(sourceSets.main.get().scala.classesDirectory)
}