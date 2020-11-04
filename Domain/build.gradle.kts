plugins {
    id("kotlin")
}


dependencies {

    implementation(Dependencies.javaxAnnotation)
    implementation(Dependencies.javaxInject)
    implementation(Dependencies.rxKotlin)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.mockito)
    testImplementation(Dependencies.assertj)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

