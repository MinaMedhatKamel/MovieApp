object Moviesapp {
    // Common Modules
    const val baseModule = ":base"
    const val networkModule = ":network"

    // Feature Modules
    const val movies = ":movies"
}


object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlin = "kotlin"
    const val javaLibrary = "java-library"
    const val kotlinParcelize = "kotlin-parcelize"
}

object RepoClassPaths {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
}


object Libraries {

    /** ******************************************/
    /*       Kotlin Core Dependencies           */
    /** ******************************************/
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val ktxCore = "androidx.core:core-ktx:1.3.2"
    const val fragmentX = "androidx.fragment:fragment-ktx:1.2.5"

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    /** ******************************************/
    /*             Dependency Injection          */
    /** ******************************************/
    object Dagger {
        const val lib = "com.google.dagger:dagger:${Versions.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
        const val android = "com.google.dagger:dagger-android-support:${Versions.dagger}"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    }

    /** ******************************************/
    /*              NETWORKING                   */
    /** ******************************************/
    object Retrofit2 {
        const val lib = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object Okhttp3 {
        const val lib = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    }

    /** ******************************************/
    /*              Caching                   */
    /** ******************************************/
    object Room {
        const val lib = "androidx.room:room-runtime:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
    }

    /** ******************************************/
    /*              ANDROID X                    */
    /** ******************************************/
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"

    /** ******************************************/
    /*                     UI                    */
    /** ******************************************/
    const val appCompat = "androidx.appcompat:appcompat:1.2.0"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val androidMaterial = "com.google.android.material:material:${Versions.materialDesign}"

    const val paging = "androidx.paging:paging-runtime:${Versions.paging}"

    object Glide {
        const val lib = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object Compose {
        const val composeUi ="androidx.compose.ui:ui:${Versions.compose}"
        const val composeMaterial3 ="androidx.compose.material3:material3:${Versions.compose}"
        const val composetoolingPreview ="androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val composeActivity ="androidx.activity:activity-compose:${Versions.composeActivity}"
        const val composeTestJunit ="androidx.compose.ui:ui-test-junit4:${Versions.compose}"
        const val composeToolingUi ="androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val composeTestManifes ="androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    }
}


object TestLibraries {
    const val Junit = "junit:junit:${Versions.junit}"
    const val Mockk = "io.mockk:mockk:${Versions.mockk}"
    const val CoroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val AndroidXAchTest = "androidx.arch.core:core-testing:${Versions.archTesting}"
    const val AndroidXCoreTest = "androidx.test:core:${Versions.androidXTestCore}"

    const val PagingTest = "androidx.paging:paging-common:${Versions.paging}"
}
