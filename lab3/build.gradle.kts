plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.13.0")
    implementation ("javax.xml.bind:jaxb-api:2.3.1")
    implementation ("com.sun.xml.bind:jaxb-core:2.3.0.1")
    implementation ("com.sun.xml.bind:jaxb-impl:2.3.3")
}

tasks.test {
    useJUnitPlatform()
}