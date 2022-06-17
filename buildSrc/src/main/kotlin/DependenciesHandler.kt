import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.dagger() {
    implementation(Libraries.Dagger.lib)
    implementation(Libraries.Dagger.android)
    kapt(Libraries.Dagger.compiler)
    kapt(Libraries.Dagger.androidProcessor)
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
    implementation(Libraries.Compose.composeMaterial3)
    implementation(Libraries.Compose.composetoolingPreview)
    implementation(Libraries.Compose.composeActivity)
    debugImplementation(Libraries.Compose.composeToolingUi)
    debugImplementation(Libraries.Compose.composeTestManifes)
    androidTestImplementation(Libraries.Compose.composeTestJunit)
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
