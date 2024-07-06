plugins{
    id("com.diffplug.spotless")
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
}