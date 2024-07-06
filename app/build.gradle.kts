plugins {
    id("com.suanki.scala-spark-library-conventions")
    id("com.github.johnrengelman.shadow")
}


version="1.0.0"

repositories{
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":datapull"))
    implementation(project(":utilities"))
}



tasks{
    shadowJar{
        isZip64=true
        archiveBaseName.set("fat-jar")
        archiveFileName.set(project.name + "_" + project.property("version").toString() + ".jar")
    }
}