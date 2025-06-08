plugins {
    kotlin("jvm") version "2.1.0"
    `maven-publish`
}

group = "com.kpiljoong"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.13.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.13.0")
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("default") {
            from(components["java"])
            groupId = "com.github.kpiljoong"
            artifactId = "lightweight-statemachine-kotlin"
            version = "1.0.0"
        }
    }
}