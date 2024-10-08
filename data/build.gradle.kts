plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies{


    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp3.logging.interceptor)
    implementation(libs.androidx.room.common)


//    room
    // Room database dependencies
    val room_version = "2.5.2"
    annotationProcessor("androidx.room:room-compiler:$room_version")
//    kapt "androidx.room:room-compiler:2.5.2"
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")
    kapt ("androidx.hilt:hilt-compiler:1.0.0")

}