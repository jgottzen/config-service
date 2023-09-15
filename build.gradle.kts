plugins {
    java
    id("org.springframework.boot") version "2.7.15"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "org.polarbookshop"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_20
}

repositories {
    mavenCentral()
}

val springCloudVersion by extra("2021.0.3")

dependencies {
    implementation(group = "org.springframework.cloud", name = "spring-cloud-config-server")

    testImplementation(group = "org.springframework.boot", name = "spring-boot-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
    }
}

tasks.test {
    useJUnitPlatform()
}
