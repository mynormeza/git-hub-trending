
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {

    compileSdkVersion(Versions.androidCompileSdkVersion)
    buildToolsVersion = Versions.androidBuildToolsVersion

    defaultConfig {
        minSdkVersion(Versions.androidMinSdkVersion)
        targetSdkVersion(Versions.androidTargetSdkVersion)

        testInstrumentationRunner = "com.mynormeza.mobile_ui.test.TestRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    implementation("androidx.constraintlayout:constraintlayout:2.0.1")
    implementation("androidx.recyclerview:recyclerview:1.1.0")

    implementation(project(":Presentation"))
    implementation(project(":Data"))
    implementation(project(":Remote"))
    implementation(project(":Cache"))
    implementation(project(":Domain"))

    implementation(Dependencies.javaxAnnotation)
    implementation(Dependencies.kotlin)
    implementation(Dependencies.javaxInject)
    implementation(Dependencies.rxKotlin)
    implementation(Dependencies.androidAnnotations)
    implementation(Dependencies.timber)
    implementation(Dependencies.rxAndroid)
    implementation(Dependencies.glide)
    implementation("com.google.dagger:hilt-android:${Versions.hiltVersion}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}")
    implementation("androidx.activity:activity-ktx:1.1.0")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02")
    kapt("androidx.hilt:hilt-compiler:1.0.0-alpha02")
    implementation(Dependencies.dagger)
    implementation(Dependencies.daggerSupportAndroid)
    implementation(Dependencies.androidCore)
    implementation(Dependencies.androidCompat)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.lifecycleViewModel)
    implementation(Dependencies.lifecycleLiveData)
    kapt(Dependencies.lifecycleCompiler)

    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomRxJava)
    kapt(Dependencies.roomCompiler)

    testImplementation(Dependencies.kotlinJUnit)

    kapt(Dependencies.daggerCompiler)
    kapt(Dependencies.daggerAndroidProcessor)

    // Instrumentation test dependencies
    androidTestImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.mockito)
    androidTestImplementation(Dependencies.espressoCore)
    androidTestImplementation(Dependencies.androidTestRunner)
    androidTestImplementation(Dependencies.androidTestRules)
    testImplementation(Dependencies.androidTestCore)
//    androidTestImplementation mobileUiTestDependencies.espressoIntents
//    androidTestImplementation mobileUiTestDependencies.espressoContrib
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.3.0")
    androidTestImplementation("com.google.truth:truth:1.1")

    testImplementation("com.google.dagger:hilt-android-testing:2.29-alpha")
    // ...with Kotlin.
    kaptTest("com.google.dagger:hilt-android-compiler:2.29-alpha")
    // For instrumented tests.
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.29-alpha")
    // ...with Kotlin.
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.29-alpha")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")

    kaptTest(Dependencies.daggerCompiler)
    kaptAndroidTest(Dependencies.daggerCompiler)

}