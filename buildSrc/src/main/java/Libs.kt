object Libs {

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

        object Testing {
            const val junit = "androidx.test.ext:junit:1.1.2"
            const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
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
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1"
    }

    object Testing {
        const val junit = "junit:junit:4.13"
        const val mockito = "org.mockito:mockito-inline:3.5.10"
        const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0"
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:4.1.1"
    }

    object Hilt {
        private const val version = "2.28-alpha"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:2.29.1-alpha"
        const val daggerHilt = "com.google.dagger:hilt-android:$version"
        const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
        //If want to inject into WorkManager
        const val workManager = "androidx.hilt:hilt-work:1.0.0-alpha01"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
    }


    object Logging {
        const val timber = "com.jakewharton.timber:timber:4.7.1"

    }
}
