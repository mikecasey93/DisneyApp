plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.disneyapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.disneyapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

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

    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-compiler:2.51.1")

    implementation ("androidx.compose.material:material:1.4.2")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    implementation("androidx.navigation:navigation-compose:2.7.7")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.6")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.6")

    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.navigation.common.ktx)
    implementation(libs.androidx.runtime.android)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.junit.ktx)
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.ktx)

    implementation ("androidx.compose.ui:ui:1.4.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.4.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.5.0")
    implementation ("androidx.activity:activity-compose:1.7.0")

    implementation ("androidx.compose.compiler:compiler:1.5.14")

    implementation ("com.google.code.gson:gson:2.8.2")

    implementation("io.coil-kt:coil-compose:2.0.0-rc01")

    implementation("androidx.compose.material3:material3:1.1.2")

    implementation("androidx.compose.ui:ui-text-google-fonts:1.2.0-beta02")

    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.mockito:mockito-core:3.11.2")
    testImplementation ("org.mockito:mockito-inline:3.11.2")
    testImplementation ("androidx.arch.core:core-testing:2.1.0")

    testImplementation ("org.mockito.kotlin:mockito-kotlin:3.2.0")

    testImplementation ("org.robolectric:robolectric:4.7.3")
    // Coroutines Test
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")

    // Core Testing for InstantTaskExecutorRule
    testImplementation("androidx.arch.core:core-testing:2.1.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    testImplementation("io.mockk:mockk:1.13.11")

    testImplementation("com.google.truth:truth:1.0.1")
    androidTestImplementation("com.google.truth:truth:1.0.1")
}