plugins {
    id("kotlin")
}

dependencies {

    implementation(project(":Domain"))

    implementation(Dependencies.javaxAnnotation)
    implementation(Dependencies.kotlin)
    implementation(Dependencies.javaxInject)
    implementation(Dependencies.rxKotlin)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.kotlinJUnit)
    testImplementation(Dependencies.assertj)
    testImplementation(Dependencies.mockito)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
