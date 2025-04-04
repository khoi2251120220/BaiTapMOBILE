plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.baitaptuan6"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.baitaptuan6"
        minSdk = 35
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Kotlin
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")

    // Jetpack Compose
    implementation ("androidx.compose.ui:ui:1.5.3")
    implementation ("androidx.compose.material:material:1.5.3")
    implementation ("androidx.compose.runtime:runtime:1.5.3")
    implementation( "androidx.compose.ui:ui-tooling-preview:1.5.3")
    debugImplementation( "androidx.compose.ui:ui-tooling:1.5.3")

    // Activity Compose (để sử dụng setContent trong MainActivity)
    implementation ("androidx.activity:activity-compose:1.8.0")

    // Navigation Compose (để điều hướng giữa các màn hình)
    implementation ("androidx.navigation:navigation-compose:2.7.5")

    // ViewModel Compose (để sử dụng ViewModel trong Compose)
    implementation( "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    // Coroutines (để sử dụng trong ViewModel với viewModelScope)
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Core AndroidX
    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")

    // Material Design
    implementation ("com.google.android.material:material:1.10.0")

    // Testing
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.5.3")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.5.3")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}