// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath (Libs.Android.gradlePlugin)
        classpath (Libs.Kotlin.gradlePlugin)
        classpath (Libs.Hilt.gradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
