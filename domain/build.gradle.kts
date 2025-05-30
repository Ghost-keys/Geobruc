plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    implementation(libs.rxjava)
    // Testing
    testImplementation(libs.junit)
    testImplementation(libs.mockito.core)

}
