import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.androidX() {
    implementation(Libraries.ktxCore)
    implementation(Libraries.appcompat)
}

fun DependencyHandler.lifecycle() {
    implementation(Libraries.LifeCycle.runtimeKtx)
    implementation(Libraries.LifeCycle.viewmodelKtx)
}

fun DependencyHandler.hiltForLib() {
    implementation(Libraries.Hilt.hiltAndroid)
    kapt(Libraries.Hilt.daggerHiltAndroidCompiler)
    kapt(Libraries.Hilt.hiltCompile)
}

fun DependencyHandler.hiltNavAndCompose() {
    implementation(Libraries.Hilt.hiltNavigation)
    implementation(Libraries.Hilt.hiltNavigationCompose)
}

fun DependencyHandler.coroutines() {
    implementation(Libraries.Coroutines.core)
    implementation(Libraries.Coroutines.android)
    testImplementation(TestLibraries.CoroutinesTest)
}

fun DependencyHandler.room() {
    implementation(Libraries.Room.lib)
    implementation(Libraries.Room.ktx)
    kapt(Libraries.Room.compiler)
}

fun DependencyHandler.compose() {
    implementation(Libraries.Compose.composeUi)
    implementation(Libraries.Compose.composeMaterial)
    implementation(Libraries.Compose.composeMaterialIcon)
    implementation(Libraries.Compose.composetoolingPreview)
    implementation(Libraries.Compose.composeActivity)
    implementation(Libraries.Compose.composeViewModel)
    debugImplementation(Libraries.Compose.composeToolingUi)
    debugImplementation(Libraries.Compose.composeTestManifes)
    androidTestImplementation(Libraries.Compose.composeTestJunit)
}

fun DependencyHandler.testing() {
    testImplementation(TestLibraries.Junit)
    androidTestImplementation(TestLibraries.JunitExt)
    androidTestImplementation(TestLibraries.espresso)

}

fun DependencyHandler.retrofit() {
    implementation(Libraries.Retrofit2.lib)
    implementation(Libraries.Retrofit2.gsonConverter)
    implementation(Libraries.Retrofit2.gson)
}

fun DependencyHandler.okhttp3() {
    implementation(Libraries.Okhttp3.lib)
    implementation(Libraries.Okhttp3.logging)
}

private fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

private fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}

private fun DependencyHandler.debugImplementation(depName: String) {
    add("debugImplementation", depName)
}
