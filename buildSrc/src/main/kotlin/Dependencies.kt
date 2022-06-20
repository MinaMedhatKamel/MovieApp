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
    object Hilt {
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltLibVersion}"
        const val daggerHiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltLibVersion}"
        const val hiltCompile = "androidx.hilt:hilt-compiler:${Versions.hiltCompilerVersion}"
        const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompilerVersion}"
        const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompilerVersion}"
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
//        const val composeMaterial3 ="androidx.compose.material3:material3:1.0.0-alpha13"
        const val composeMaterial ="androidx.compose.material:material:${Versions.compose}"
        const val composeMaterialIcon ="androidx.compose.material:material-icons-extended:${Versions.compose}"
        const val composetoolingPreview ="androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val composeActivity ="androidx.activity:activity-compose:${Versions.composeActivity}"
        const val composeTestJunit ="androidx.compose.ui:ui-test-junit4:${Versions.compose}"
        const val composeToolingUi ="androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val composeTestManifes ="androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    }
}


object TestLibraries {
    const val Junit = "junit:junit:${Versions.junit}"
    const val JunitExt = "junit:junit:${Versions.junitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val CoroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

}
