
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

    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {

    implementation(project(":Domain"))

    implementation(Dependencies.kotlin)
    implementation(Dependencies.javaxInject)
    implementation(Dependencies.rxKotlin)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.lifecycleViewModel)
    implementation(Dependencies.lifecycleLiveData)
    kapt(Dependencies.lifecycleCompiler)
    implementation(Dependencies.hiltViewModel)
    kapt(Dependencies.hiltCompiler)
    implementation(Dependencies.activityExt)
    androidTestImplementation(Dependencies.androidTestExt)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.mockito)
    testImplementation(Dependencies.assertj)
    testImplementation(Dependencies.robolectric)
    testImplementation(Dependencies.archTesting)

}