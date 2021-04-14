plugins {
    `java-library`
    `maven-publish`
    signing
}

group = "dev.yavin"
version = "0.5"

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
            // change URLs to point to your repos, e.g. http://my.org/repo
            val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/") //uri(layout.buildDirectory.dir("repos/releases"))
            val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/") //uri(layout.buildDirectory.dir("repos/snapshots"))
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            credentials {
//                username = project.findProperty("ossrhUsername") as String? ?: System.getenv("OSSRH_USER")
//                password = project.findProperty("ossrhPassword") as String? ?: System.getenv("OSSRH_TOKEN")
                username = System.getenv("OSSRH_USER")
                password = System.getenv("OSSRH_TOKEN")

            }
        }
    }
}

project.setProperty("signing.gnupg.keyName", System.getenv("GPG_KEY"))
project.setProperty("signing.gnupg.passphrase", System.getenv("GPG_ENCPHRASE"))

signing {
    useGpgCmd()
    sign(publishing.publications["mavenJava"])
}

