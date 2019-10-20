import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.41"
    id("com.diffplug.gradle.spotless") version "3.25.0"
}

group = "com.uzhnu.epam.course"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    val spek_version = "2.0.8"
    testImplementation(kotlin("test"))
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spek_version")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spek_version")

    testImplementation("org.amshove.kluent:kluent:1.56") {
        exclude(group = "com.nhaarman.mockitokotlin2")
    }
}

tasks.withType<Test> {
    useJUnitPlatform {
        includeEngines("spek2")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

spotless {
    kotlin {
        ktlint("0.35.0")
    }
}
