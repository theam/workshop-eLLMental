import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "com.theagilemonkeys"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    // eLLMental
    implementation("com.github.theam.ellmental:core:main-SNAPSHOT")
    implementation("com.github.theam.ellmental:semanticsearch:main-SNAPSHOT")
    implementation("com.github.theam.ellmental:vectorstore:main-SNAPSHOT")
    implementation("com.github.theam.ellmental:embeddingsmodel:main-SNAPSHOT")
    implementation("com.aallam.openai:openai-client:3.3.0")

    // Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions { freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers" }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
