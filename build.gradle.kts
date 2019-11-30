plugins {
    id("org.springframework.boot") version "2.2.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    id("net.ltgt.apt") version "0.21"
    id("net.ltgt.apt-idea") version "0.21"
    java
}

group = "pl.michalperlak"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val queryDslVersion = "4.2.2"
dependencies {
    compileOnly("org.projectlombok", "lombok")
    compile("com.querydsl", "querydsl-jpa", queryDslVersion)
    runtime("com.h2database", "h2", "1.4.199")
    annotationProcessor("com.querydsl", "querydsl-apt", queryDslVersion, classifier = "jpa")
    annotationProcessor("org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.2.Final")
    annotationProcessor("javax.annotation:javax.annotation-api:1.3.2")
    annotationProcessor("org.projectlombok", "lombok")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<Test> {
    useJUnitPlatform()
}