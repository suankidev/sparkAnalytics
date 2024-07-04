plugins {
    id("com.suanki.scala-spark-library-conventions")
    id("com.github.johnrengelman.shadow") version("8.1.1")
}


repositories{
    mavenCentral()
}

dependencies {
                          implementation("org.apache.commons:commons-text")

    implementation(project(":utilities"))
}



tasks{
    shadowJar{

        isZip64=true
        archiveClassifier.set("fatjar")
        archiveBaseName.set("shadow")
        archiveFilename.set("project.name")
    }
}