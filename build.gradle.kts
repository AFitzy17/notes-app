plugins {
    kotlin("jvm") version "2.2.0"
}

group = "ie.setu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // dependencies for logging
    implementation("io.github.oshai:kotlin-logging-jvm:7.0.13")
    implementation("org.slf4j:slf4j-simple:2.0.17")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}