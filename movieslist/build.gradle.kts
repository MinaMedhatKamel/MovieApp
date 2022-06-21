plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    implementation(project(mapOf("path" to ":common")))
    implementation("androidx.paging:paging-common-ktx:3.1.1")
    androidX()
    implementation(Libraries.Coroutines.android)
    implementation(Libraries.androidMaterial)
    lifecycle()
    hiltForLib()
    hiltNavAndCompose()
    compose()
    okhttp3()
    retrofit()
    implementation(Libraries.Glide.lib)
    //testing
    testing()
    testImplementation(TestLibraries.CoroutinesTest)
    testImplementation(TestLibraries.mockk)
    testImplementation(TestLibraries.turbine)
    //Paging 3.0
    implementation("androidx.paging:paging-compose:1.1.0")
}