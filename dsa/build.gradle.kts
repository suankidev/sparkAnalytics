
plugins{
    id("com.suanki.applied-and-dsa.scala")
    id("java")
    id("application")
}

application{

    mainClass.set("com.suanki.dsa.DsaApp")
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