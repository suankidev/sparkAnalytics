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
    implementation(project(":dataTest"))
}



tasks{
    shadowJar{

        isZip64=true
        archiveClassifier.set("fatjar")
        archiveBaseName.set("shadow")
        archiveFilename.set("project.name")
    }
}