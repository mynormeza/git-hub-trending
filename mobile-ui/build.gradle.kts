
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
    implementation(project(":Presentation"))
    implementation(project(":Data"))
    implementation(project(":Remote"))
    implementation(project(":Cache"))
    implementation(project(":Domain"))

    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.recyclerView)
    implementation(Dependencies.javaxAnnotation)
    implementation(Dependencies.kotlin)
    implementation(Dependencies.javaxInject)
    implementation(Dependencies.rxKotlin)
    implementation(Dependencies.androidAnnotations)
    implementation(Dependencies.timber)
    implementation(Dependencies.rxAndroid)
    implementation(Dependencies.glide)
    implementation(Dependencies.hilt)
    implementation(Dependencies.activityExt)
    implementation(Dependencies.hiltViewModel)
    implementation(Dependencies.dagger)
    implementation(Dependencies.daggerSupportAndroid)
    implementation(Dependencies.androidCore)
    implementation(Dependencies.androidCompat)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.lifecycleViewModel)
    implementation(Dependencies.lifecycleLiveData)
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomRxJava)

    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.lifecycleCompiler)
    kapt(Dependencies.hiltAndroidCompiler)
    kapt(Dependencies.daggerCompiler)
    kapt(Dependencies.daggerAndroidProcessor)
    kapt(Dependencies.roomCompiler)

    testImplementation(Dependencies.androidTestCore)
    testImplementation(Dependencies.kotlinJUnit)
    testImplementation(Dependencies.hiltTest)

    // Instrumentation test dependencies
    androidTestImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.mockito)
    androidTestImplementation(Dependencies.espressoCore)
    androidTestImplementation(Dependencies.androidTestRunner)
    androidTestImplementation(Dependencies.androidTestRules)
    androidTestImplementation(Dependencies.espressoContrib)
    androidTestImplementation(Dependencies.espressoIntents)
    androidTestImplementation(Dependencies.googleTruth)
    androidTestImplementation(Dependencies.hiltTest)
    androidTestImplementation(Dependencies.androidTestExt)

    kaptTest(Dependencies.daggerCompiler)
    kaptAndroidTest(Dependencies.daggerCompiler)
    kaptTest(Dependencies.hiltAndroidCompiler)
    kaptAndroidTest(Dependencies.hiltAndroidCompiler)
}