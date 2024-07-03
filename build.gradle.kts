import java.sql.DriverManager

plugins {

    idea
    jacoco
}


version = "1.0"

allprojects{

    version = project.property("version").toString()
    group   = "com.suanki"


    repositories{

        mavenLocal()
//        maven {url = uri("http://localhost:8081/artifactory/libs-release-local")}
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

}


subprojects{
    version = "1.0"
    apply {
        plugin("com.suanki.scala-spark-library-conventions")
    }


    task("printName"){
            doLast(){
                println("project Name: ${project.name}")
                println("project Version: ${project.version}")
            }
        }
}
