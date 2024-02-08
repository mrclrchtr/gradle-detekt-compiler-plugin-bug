plugins {
    kotlin("jvm") version "1.9.22"
    id("io.github.detekt.gradle.compiler-plugin") version "1.23.5"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
    compilerOptions {
        allWarningsAsErrors = true
    }
}

detekt {
    // Define the detekt configuration(s) you want to use.
    // Defaults to the default detekt configuration.
    config.setFrom("config.yml")

    // Kill switch to turn off the Compiler Plugin execution entirely.
    enableCompilerPlugin = true
}