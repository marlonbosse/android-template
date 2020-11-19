plugins {
    id ("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
//    id ("dagger.hilt.android.plugin")
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
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // KOTLIN
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlin.coroutines)
    implementation(Libs.Kotlin.coroutinesAndroid)

    // ANDROID

    // DEPENDENCY INJECTIONS


}
