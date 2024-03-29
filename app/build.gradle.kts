plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.segunda"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.segunda"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"


    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")




    // Room
    val room_version = "2.5.1"
    implementation ("androidx.room:room-runtime:$room_version")
    kapt ("androidx.room:room-compiler:$room_version")
    implementation ("androidx.room:room-ktx:$room_version")

    // Fragment
    val fragment_version = "1.5.6"
    implementation( "androidx.fragment:fragment-ktx:$fragment_version")

    val lifecycle_version = "2.5.1"
    val arch_version = "2.1.0"

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // ViewModel utilities for Compose
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    // LiveData
    implementation( "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // Lifecycles only (without ViewModel or LiveData)
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")

    // Saved state module for ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")

    // Annotation processor
    kapt ("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation( "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")

    // optional - helpers for implementing LifecycleOwner in a Service
    implementation ( "androidx.lifecycle:lifecycle-service:$lifecycle_version")

    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
    implementation( "androidx.lifecycle:lifecycle-process:$lifecycle_version")

    // optional - ReactiveStreams support for LiveData
    implementation ("androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycle_version")

    // optional - Test helpers for LiveData
    testImplementation ("androidx.arch.core:core-testing:$arch_version")

    testImplementation ("androidx.room:room-testing:$room_version")

    // JUnit e Espresso
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    // Coroutines test
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")

}