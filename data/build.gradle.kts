plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")

}

android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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


    api(project(":domain"))
    api(project(":baseNetwork"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


//    implementation (libs.koin.android)
//    testImplementation (libs.koin.test.v315)
//    testImplementation (libs.koin.koin.test)


    implementation ("io.insert-koin:koin-core:3.5.3")
    implementation ("io.insert-koin:koin-android:3.5.3")
    implementation ("io.insert-koin:koin-androidx-compose:3.5.3")

    implementation (libs.retrofit)

    implementation (libs.converter.gson)

    implementation (libs.logging.interceptor)

//    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.core)

//    implementation (libs.gson)
    implementation (libs.gson)


//    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.android)

//


}