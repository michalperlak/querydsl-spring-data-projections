plugins {
    java
}

group = "pl.michalperlak"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile("org.springframework.data", "spring-data-jpa", "2.1.5.RELEASE")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}