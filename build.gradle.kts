plugins {
    id(com.android.lifeassistant.Dependencies.Plugin.application) version "7.4.2" apply false
    id(com.android.lifeassistant.Dependencies.Plugin.hilt) version "2.44" apply false
    id(com.android.lifeassistant.Dependencies.Plugin.library) version "7.4.2" apply false
    id(com.android.lifeassistant.Dependencies.Plugin.kotlin) version "1.8.10" apply false
    kotlin("jvm") version "1.8.10"
    kotlin("plugin.serialization") version "1.8.10"
}

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        val kotlinVersion = "1.8.10"
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
        classpath(kotlin("serialization", version = kotlinVersion))
        classpath(com.android.lifeassistant.Dependencies.Gradle.android)
        classpath(com.android.lifeassistant.Dependencies.Gradle.googleService)
    }
}