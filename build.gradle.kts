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
    compile("com.querydsl", "querydsl-jpa", "4.2.1")
    compile("org.eclipse.persistence", "javax.persistence", "2.2.1")
    testCompile("org.junit.jupiter", "junit-jupiter-api", "5.4.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<Test> {
    useJUnitPlatform()
}