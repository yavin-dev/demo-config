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
            groupId = "yavin-dev.demo-config"
            artifactId = "demo-config"
            version = "0.1"

            from(components["java"])
        }
    }
}
