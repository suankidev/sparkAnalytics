
plugins {
    id("scala")
    id("jacoco")
}

repositories{
    mavenCentral()
}

dependencies {
    constraints {
        // Define dependency versions as constraints
        implementation("org.apache.commons:commons-text:1.10.0")

        implementation("org.scala-lang:scala-library:2.13.10")
    }

    // Use Scala 2.13 in our library project
    implementation("org.scala-lang:scala-library")

    // Use JUnit Jupiter for testing.
    implementation("org.junit.jupiter:junit-jupiter:5.9.1")
    implementation("org.scalatest:scalatest_2.13:3.2.19")
    implementation("org.scalactic:scalactic_2.13:3.2.13")
    implementation("org.scalacheck:scalacheck_2.13:1.15.4")
    implementation("org.junit.platform:junit-platform-engine:1.10.0")
    implementation("org.junit.platform:junit-platform-launcher:1.10.0")
    implementation("org.scalatestplus:junit-5-10_2.13:3.2.19.0")
}

  configurations.all{
        resolutionStrategy{
            eachDependency{
                when(requested.name){
                    "log4j-api" -> useVersion("2.17.2")
                    "log4j-core" -> useVersion("2.17.2")
                    "log4j-to-slf4j" -> useVersion("2.17.2")
                    "log4j-api-scala_2.13" -> useVersion("13.0")
                }
            }
        }
    }


tasks {
   test{
       useJUnitPlatform {
           includeEngines("scalatest","junit-jupiter")
           testLogging {
               events("passed", "skipped", "failed")
           }
       }
   }
}



 task("printName"){
            doLast(){
                println("project Name: ${project.name}")
                println("project Version: ${project.version}")
            }
}

tasks.withType<ScalaCompile>().configureEach {
//    scalaCompileOptions.forkOptions.apply {
//        memoryMaximumSize = "1g"
//        jvmArgs = listOf("-XX:MaxMetaspaceSize=700m")
//    }
//    //https://docs.gradle.org/current/userguide/scala_plugin.html
    scalaCompileOptions.additionalParameters=listOf("-release:8")
}


//tasks.named("test"){finalizedBy("jacocoTestReport")}
//tasks.named("jacocoTestReport"){dependsOn("test") }

tasks.test{finalizedBy(tasks.jacocoTestReport)}
tasks.jacocoTestReport{dependsOn(tasks.test)}
