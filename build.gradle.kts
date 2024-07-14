plugins{
    id("com.diffplug.spotless")
    id("org.sonarqube")
}

subprojects {

    apply {
        plugin("com.diffplug.spotless")
    }

    spotless {
        scala {
            // version and configFile, scalaMajorVersion are all optional
//            scalafmt("3.5.9")
//                .configFile("../.scalafmt.conf")
//                .scalaMajorVersion("2.13")
            scalafmt()
        }
    }

    tasks.spotlessCheck{dependsOn(tasks.spotlessApply)}
}

allprojects {

    sonar {
        properties {
            property("sonar.projectKey", "sparkAnalytics")
            property("sonar.host.url", "http://localhost:9000")
            property("sonar.login","sqp_93797e9130cf66816741d495bc462a2e26ac5ccb")
            property("sonar.java.coveragePlugin","jacoco")
            property("sonar.jacoco.reportPaths","build/reports/jacoco/test/index.html")
        }
    }

}