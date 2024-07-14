
plugins {
    id("com.suanki.scala-spark-library-conventions")
    id("java")
}

dependencies{
    implementation("com.github.scopt:scopt_2.13:4.1.0")
    implementation("com.typesafe:config:1.4.3")
    implementation("org.openjfx:javafx:11")
    implementation("com.oracle.database.jdbc:ojdbc8:23.2.0.0")
    implementation(project(":utilities"))
}


