plugins {
    id("java-library")
}

repositories {
    mavenCentral()
}

dependencies {
    api(platform(project(":eon-bom")))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}