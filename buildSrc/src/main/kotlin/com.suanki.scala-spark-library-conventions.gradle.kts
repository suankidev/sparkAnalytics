plugins {
    id("com.suanki.scala-library-conventions")
}

repositories{
    mavenCentral()
}

dependencies{
    implementation("org.apache.spark:spark-core_2.13:3.5.0")
    implementation("org.apache.spark:spark-sql_2.13:3.5.0")
}