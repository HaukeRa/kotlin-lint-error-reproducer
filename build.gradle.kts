plugins {
    id("com.android.library").version("7.1.3")
    kotlin("android") version "1.6.20"
}

repositories {
    google()
    mavenCentral()
}

group = "me.hauke.reproducer.ktlightclassforfacade"
version = "1.0"

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 28
        targetSdk = 31
    }
}

dependencies{
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.6.20")
    testImplementation("junit:junit")
}