plugins {
   id("java")
    `maven-publish`
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com")
            credentials {
                //username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                //password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
                username = "anupkumangodan"
                password = "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"
            }
        }
    }

    publications {
        create<MavenPublication>("maven") {
            groupId = "yavin-dev.app"
            artifactId = "demo-config"
            version = "0.1"

            from(components["java"])
        }
    }
}