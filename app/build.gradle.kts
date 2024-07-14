plugins {
    id("com.suanki.scala-spark-library-conventions")
    id("com.github.johnrengelman.shadow")
    id("jacoco-report-aggregation")
}


version="1.0.0"

repositories{
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":datapull"))
    implementation(project(":utilities"))
    implementation(project(":datatest"))

    //jacoco Aggregation reports
    jacocoAggregation(project(":datapull"))
    jacocoAggregation(project(":utilities"))
    jacocoAggregation(project(":datatest"))
}



tasks{
    shadowJar{

        isZip64=true
        archiveClassifier.set("fatjar")
        archiveBaseName.set("shadow")
        archiveFileName.set(project.name+"_"+"1.0.0"+".jar")

    }
}

//reporting {
//    reports {
//        val testCodeCoverageReport by creating(JacocoCoverageReport::class) {
//            testType.set(TestSuiteType.UNIT_TEST)
//        }
//    }
//}
//
//tasks.check {
//    dependsOn(tasks.named<JacocoReport>("testCodeCoverageReport"))
//}

//tasks.check{
//    dependsOn(tasks.testCodeCoverageReport)
//}