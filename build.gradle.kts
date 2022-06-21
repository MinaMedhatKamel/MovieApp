buildscript {
    dependencies {
        classpath(RepoClassPaths.hiltAndroidGradlePlugin)
    }
}
plugins {
    id(BuildPlugins.androidApplication) version Versions.gradleVersion apply false
    id(BuildPlugins.androidLibrary) version Versions.gradleVersion apply false
    id(BuildPlugins.kotlinAndroid) version Versions.kotlinVersion apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}