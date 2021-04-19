plugins {
    `java-library`
    `maven-publish`
    signing
}

group = "dev.yavin"
version = "0.7"


publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "demo-config"
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name.set("yavin demo config files")
                description.set("hjson files for demo")
                url.set("http://yavin.dev")
                licenses {
                    license {
                        name.set("MIT")
                    }
                }
                developers {
                    developer {
                        id.set("jkusa")
                        name.set("Jon Kilroy")
                        email.set("kilroy@verizonmedia.com")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/yavin-dev/demo-config.git")
                    developerConnection.set("scm:git:ssh:git@github.com:yavin-dev/demo-config.git")
                    url.set("http://yavin.devs")
                }
            }
        }
    }
    repositories {
        maven {
            val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            credentials {
                username = System.getenv("OSSRH_USER") as String?
                password = System.getenv("OSSRH_TOKEN") as String?

            }
        }
    }
}

project.setProperty("signing.password", System.getenv("GPG_SIGN_PASS"))

signing {
    sign(publishing.publications["mavenJava"])
}

