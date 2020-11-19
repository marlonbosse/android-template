object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:3.5.0"

    object AndroidX {
        const val core = "androidx.arch.core:core-common:2.1.0"
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val preference = "androidx.preference:preference-ktx:1.1.1"
        const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:1.1.0"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0"

        object Lifecycle {
            private const val version = "2.2.0"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val runtime = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        }

        object Test {

        }
    }

    object Design {
        const val material = "com.google.android.material:material:1.2.1"
    }

    object Kotlin {
        private const val version = "1.4.10"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1"
        const val coroutinesAndroid = "'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1'"
    }

    object Test {
        const val junit = "junit:junit:4.12"
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:4.1.1"
    }

    object Hilt {
        private const val version = ""
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:2.29.1-alpha"
        const val daggerHilt = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:1.0.0-alpha02"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
    }
}
