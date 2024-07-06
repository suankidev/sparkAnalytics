rootProject.name = "sparkAnalytics"

pluginManagement{

    repositories{
        gradlePluginPortal()
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

    plugins{
        id("com.diffplug.spotless") version("6.13.0")
        id("com.github.johnrengelman.shadow") version("8.1.1")
    }

}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.4.0")


}

include(    "app",    "datapull",    "utilities", "datatest")