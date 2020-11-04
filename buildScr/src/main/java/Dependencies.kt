object Versions {
    const val androidBuildToolsVersion = "30.0.0"
    const val androidMinSdkVersion = 21
    const val androidTargetSdkVersion = 30
    const val androidCompileSdkVersion = 30
    const val kotlinVersion = "1.4.10"

    const val rxKotlinVersion = "2.4.0"
    const val javaxAnnotationVersion = "1.0"
    const val javaxInjectVersion = "1"
    const val androidAnnotationsVersion = "1.1.0"
    const val daggerVersion = "2.29.1"
    const val gsonVersion = "2.8.6"
    const val okHttpVersion = "4.9.0"
    const val retrofitVersion = "2.9.0"
    const val archTestingVersion = "2.1.0"
    const val roomVersion = "2.2.5"
    const val androidLifecycleVersion = "2.2.0"
    const val glideVersion = "4.11.0"
    const val timberVersion = "4.7.1"
    const val androidCoreVersion = "1.3.1"
    const val androidCompatVersion = "1.2.0"
    const val rxAndroidVersion = "2.1.1"
    const val hiltVersion = "2.29-alpha"
    const val hiltViewModelVersion = "1.0.0-alpha02"

    const val jUnitVersion = "4.13"
    const val assertJVersion = "3.17.2"
    const val mockitoKotlinVersion = "2.2.0"
    const val robolectricVersion = "4.4"
    const val androidTestRunnerVersion = "1.1.0"
    const val androidTestRulesVersion = "1.1.0"
    const val espressoVersion = "3.3.0"
}

object Dependencies {
    const val javaxAnnotation = "javax.annotation:jsr250-api:${javaxAnnotationVersion}"
    const val javaxInject = "javax.inject:javax.inject:${javaxInjectVersion}"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${rxKotlinVersion}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${kotlinVersion}"

    const val gson = "com.google.code.gson:gson:${gsonVersion}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${okHttpVersion}"
    const val okHttpLogger = "com.squareup.okhttp3:logging-interceptor:${okHttpVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${retrofitVersion}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${retrofitVersion}"
    const val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:${retrofitVersion}"
    const val daggerCompiler= "com.google.dagger:dagger-compiler:${daggerVersion}"
    const val dagger= "com.google.dagger:dagger:${daggerVersion}"
    const val androidAnnotations= "androidx.annotation:annotation:${androidAnnotationsVersion}"
    const val roomRuntime= "androidx.room:room-runtime:${roomVersion}"
    const val roomCompiler= "androidx.room:room-compiler:${roomVersion}"
    const val roomRxJava= "androidx.room:room-rxjava2:${roomVersion}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${androidLifecycleVersion}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${androidLifecycleVersion}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${androidLifecycleVersion}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${androidLifecycleVersion}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${daggerVersion}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${rxAndroidVersion}"
    const val androidCore = "androidx.core:core-ktx:${androidCoreVersion}"
    const val androidCompat = "androidx.appcompat:appcompat:${androidCompatVersion}"
    const val timber = "com.jakewharton.timber:timber:${timberVersion}"
    const val glide = "com.github.bumptech.glide:glide:${glideVersion}"
    const val daggerSupportAndroid = "com.google.dagger:dagger-android-support:${daggerVersion}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${daggerVersion}"


    const val junit = "junit:junit:${jUnitVersion}"
    const val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:${mockitoKotlinVersion}"
    const val assertj = "org.assertj:assertj-core:${assertJVersion}"
    const val kotlinJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${kotlinVersion}"
    const val androidTestRunner = "androidx.test:runner:${androidTestRunnerVersion}"
    const val androidTestRules = "androidx.test:rules:${androidTestRulesVersion}"
    const val androidTestCore = "androidx.test:core:${androidTestRulesVersion}"
    const val archTesting = "androidx.arch.core:core-testing:${archTestingVersion}"
    const val roomTesting = "androidx.room:room-testing:${roomVersion}"
    const val robolectric = "org.robolectric:robolectric:${robolectricVersion}"
    const val androidTestRunner = "androidx.test:runner:${androidTestRunnerVersion}"
    const val androidTestRules = "androidx.test:rules:${androidTestRulesVersion}"
    const val androidTestCore = "androidx.test:core:${androidTestRulesVersion}"
    const val archTesting = "androidx.arch.core:core-testing:${archTestingVersion}"
    const val roomTesting = "androidx.room:room-testing:${roomVersion}"
    const val robolectric = "org.robolectric:robolectric:${robolectricVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${espressoVersion}"
}