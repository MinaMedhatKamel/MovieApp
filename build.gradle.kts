buildscript {

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.42")
    }
}
plugins {
    id("com.android.application") version "7.1.0" apply false
    id("com.android.library") version "7.1.0" apply false
    id("org.jetbrains.kotlin.android") version Versions.kotlinVersion apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}