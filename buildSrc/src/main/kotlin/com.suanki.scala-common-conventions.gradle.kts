
plugins {
    scala
}

repositories {
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
    implementation("org.junit.platform:junit-platform-engine:1.10.0")
    implementation("org.junit.platform:junit-platform-launcher:1.10.0")
    implementation("org.scalatestplus:junit-5-10_2.13:3.2.19.0")
}

// tasks.named<Test>("test") {
//     // Use JUnit Platform for unit tests.
//     useJUnitPlatform()
// }



//tasks {
//   test{
//       useJUnitPlatform {
//           includeEngines("scalatest","junit-jupiter")
//           testLogging {
//               events("passed", "skipped", "failed")
//           }
//       }
//   }
//}
//
