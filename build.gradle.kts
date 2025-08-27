import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "2.2.0"
    java
    id("com.gradleup.shadow") version "9.0.0-beta11"
}

group = "io.github.grassproject"
version = "0.2-BETA"

repositories {
    mavenCentral()
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven("https://maven.devs.beer/")
    maven("https://repo.nexomc.com/releases")
    maven("https://repo.momirealms.net/releases/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT")
    compileOnly("dev.lone:api-itemsadder:4.0.10")
    compileOnly("com.nexomc:nexo:1.10.0")
    compileOnly("net.momirealms:craft-engine-core:0.0.61")
    compileOnly("net.momirealms:craft-engine-bukkit:0.0.61")
}

kotlin {
    jvmToolchain(21)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.register<ShadowJar>("shadowJarPlugin") {
    archiveFileName.set("ChaosCore-${project.version}-shaded.jar")

    from(sourceSets.main.get().output)
    configurations = listOf(project.configurations.runtimeClasspath.get())

    exclude("kotlin/**", "kotlinx/**")
    exclude("org/intellij/**")
    exclude("org/jetbrains/**")
}

tasks {
    build {
        dependsOn(named("shadowJarPlugin"))
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(21)
    }

    processResources {
        filteringCharset = Charsets.UTF_8.name()
        filesMatching("paper-plugin.yml") {
            expand(getProperties() + mapOf("version" to project.version))
        }
    }
}
