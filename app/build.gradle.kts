plugins {
    id ("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id ("dagger.hilt.android.plugin")
}

repositories {
    maven { url = uri("https://jitpack.io") }
}


android {
    defaultConfig {
        applicationId = "com.ankerapps.template"
        minSdkVersion(Versions.Build.mindSdk)
        targetSdkVersion(Versions.Build.targetSdk)
        compileSdkVersion(Versions.Build.targetSdk)
        versionCode(Versions.Build.versionCode)
        versionName(Versions.Build.versionName)
    }

    kapt {
        generateStubs = true
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    packagingOptions {
        exclude("DebugProbesKt.bin")
    }

    kotlinOptions {
        freeCompilerArgs = listOf("-Xallow-result-return-type")
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // KOTLIN
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlin.coroutines)
    implementation(Libs.Kotlin.coroutinesAndroid)

    // ANDROID
    implementation(Libs.AndroidX.core)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.coordinatorLayout)
    implementation(Libs.AndroidX.recyclerview)
    implementation(Libs.AndroidX.preference)
    implementation(Libs.AndroidX.Lifecycle.runtime)
    implementation(Libs.AndroidX.Lifecycle.viewModel)

    // DESIGN
    implementation(Libs.Design.material)

    // DEPENDENCY INJECTIONS
    implementation(Libs.Hilt.daggerHilt)
    implementation(Libs.Hilt.viewModel)
    kapt(Libs.Hilt.androidCompiler)
    kapt(Libs.Hilt.compiler)

    // UNIT TESTING
    testImplementation(Libs.Testing.junit)
    testImplementation(Libs.Testing.mockito)
    testImplementation(Libs.Testing.mockitoKotlin)
    kaptTest(Libs.Hilt.testing)

    // INSTRUMENTATION TESTING
    androidTestImplementation(Libs.AndroidX.Testing.junit)
    androidTestImplementation(Libs.AndroidX.Testing.espresso)
    androidTestImplementation(Libs.Hilt.testing)
    kaptAndroidTest(Libs.Hilt.testing)

    // UTILITY
    implementation(Libs.Logging.timber)
    implementation(Libs.Misc.flowPreferences)
}
