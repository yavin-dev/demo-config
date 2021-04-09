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
                password = System.getenv("GH_TOKEN")
                username = "anupkumangodan"
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
