buildscript {
//    ext = {
//        compose_version = "1.1.0-beta01"
//    }
    dependencies {
        classpath( "com.google.dagger:hilt-android-gradle-plugin:2.42")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.2.1" apply false
    id ("com.android.library") version "7.2.1" apply false
    id ("org.jetbrains.kotlin.android") version "1.6.21" apply false
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}