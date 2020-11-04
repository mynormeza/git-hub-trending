plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {

    compileSdkVersion(Versions.androidCompileSdkVersion)
    buildToolsVersion = Versions.androidBuildToolsVersion

    defaultConfig {
        minSdkVersion(Versions.androidMinSdkVersion)
        targetSdkVersion(Versions.androidTargetSdkVersion)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {

    compileOnly(Dependencies.javaxAnnotation)

    implementation(project(":Data"))

    implementation(Dependencies.kotlin)
    implementation(Dependencies.javaxInject)
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomRxJava)
    implementation(Dependencies.rxKotlin)
    kapt(Dependencies.roomCompiler)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.kotlinJUnit)
    testImplementation(Dependencies.mockito)
    testImplementation(Dependencies.assertj)
    testImplementation(Dependencies.archTesting)
    testImplementation(Dependencies.roomTesting)
    testImplementation(Dependencies.robolectric)
    testImplementation(Dependencies.androidTestRules)
    testImplementation(Dependencies.androidTestRunner)
    testImplementation(Dependencies.androidTestCore)
    androidTestImplementation("androidx.test.ext:junit:1.1.2")

    androidTestImplementation(Dependencies.androidAnnotations)
}