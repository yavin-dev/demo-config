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
                password = "token"
            }
        }
    }

    publications {
        create<MavenPublication>("maven") {
            groupId = "com.yahoo.yavin-dev.demo-config"
            artifactId = "demo-config"
            version = "0.4"

            from(components["java"])
            pom {
                name.set("Yavin app demo config")
                description.set("demo hjson files for netflix")
                url.set("https://github.com/yavin-dev/demo-config")
                developers {
                    developer {
                        id.set("kilroy")
                        name.set("Jon Kilroy")
                        email.set("kilroy@verizonmedia.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/yavin-dev/demo-config.git")
                    developerConnection.set("scm:git:ssh://github.com/yavin-dev/demo-config.git")
                    url.set("http://github.com/yavin-dev/demo-config")
                }
            }

        }
    }
}