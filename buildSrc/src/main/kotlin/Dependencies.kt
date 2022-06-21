object Moviesapp {
    // Common Modules
    const val appModule = ":app"
    const val commonModule = ":common"
    // Feature Modules
    const val moviesList = ":movieslist"
    const val movieDetails = ":moviedetails"
}

object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlin = "kotlin"
    const val javaLibrary = "java-library"
    const val kotlinParcelize = "kotlin-parcelize"
}

object RepoClassPaths {
    const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:2.42"
}


object Libraries {

    /** ******************************************/
    /*       Kotlin Core Dependencies           */
    /** ******************************************/
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val ktxCore = "androidx.core:core-ktx:1.7.0"
    const val appcompat = "androidx.appcompat:appcompat:1.4.2"
    const val fragmentX = "androidx.fragment:fragment-ktx:1.2.5"

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    /** ******************************************/
    /*             Dependency Injection          */
    /** ******************************************/
    object Hilt {
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltLibVersion}"
        const val daggerHiltAndroidCompiler =
            "com.google.dagger:hilt-android-compiler:${Versions.hiltLibVersion}"
        const val hiltCompile = "androidx.hilt:hilt-compiler:${Versions.hiltCompilerVersion}"
        const val hiltNavigation =
            "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompilerVersion}"
        const val hiltNavigationCompose =
            "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompilerVersion}"
    }

    /** ******************************************/
    /*              NETWORKING                   */
    /** ******************************************/

    object Retrofit2 {
        const val lib = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    }

    object Okhttp3 {
        const val lib = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    }

    /** ******************************************/
    /*              Caching                   */
    /** ******************************************/
    // room database

    object Room {
        const val lib = "androidx.room:room-runtime:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
    }

    /** ******************************************/
    /*              ANDROID X                    */
    /** ******************************************/
    object LifeCycle {
        const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"
    }

    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleCommon =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"


    /** ******************************************/
    /*                     UI                    */
    /** ******************************************/
    const val appCompat = "androidx.appcompat:appcompat:1.2.0"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val androidMaterial =
        "com.google.android.material:material:${Versions.materialDesign}"

    const val paging = "androidx.paging:paging-runtime:${Versions.paging}"

    object Glide {
        const val lib = "com.github.skydoves:landscapist-glide:1.5.2"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object Compose {
        const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"

        //        const val composeMaterial3 ="androidx.compose.material3:material3:1.0.0-alpha13"
        const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
        const val composeMaterialIcon =
            "androidx.compose.material:material-icons-extended:${Versions.compose}"
        const val composetoolingPreview =
            "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val composeActivity =
            "androidx.activity:activity-compose:${Versions.composeActivity}"
        const val composeTestJunit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
        const val composeToolingUi = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val composeTestManifes =
            "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
        const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1"
    }
}


object TestLibraries {
    const val Junit = "junit:junit:${Versions.junit}"
    const val JunitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val mockk = "io.mockk:mockk:1.12.3"
    const val turbine = "app.cash.turbine:turbine:0.6.1"
    const val CoroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}

