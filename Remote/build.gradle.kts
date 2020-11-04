plugins {
    id("kotlin")
}

dependencies {
    implementation(project(":Data"))

    implementation(Dependencies.javaxAnnotation)
    implementation(Dependencies.kotlin)
    implementation(Dependencies.javaxInject)
    implementation(Dependencies.rxKotlin)
    implementation(Dependencies.gson)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLogger)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitConverter)
    implementation(Dependencies.retrofitAdapter)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.kotlinJUnit)
    testImplementation(Dependencies.mockito)
    testImplementation(Dependencies.assertj)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

