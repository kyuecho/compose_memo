import Dependency.LibVersion.navigation_version
import Dependency.LibVersion.room_version

object Dependency {
    object AppVersion {
        const val minSdk = 29
        const val targetSdk = 34
    }

    object Version {
        const val versionCode = 1
        const val MAJOR_VERSION = 1
        const val MINOR_VERSION = 0
        const val PATCH_VERSION = 0
    }

    object LibVersion {
        const val retrofit_version = "2.9.0"
        const val gson_version = "2.10.1"
        const val Hilt = "2.50"
        const val navigation_version = "2.7.2"
        const val room_version = "2.5.2"
    }

    object Retrofit {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${LibVersion.retrofit_version}"
        const val GSON_CONVERTER =
            "com.squareup.retrofit2:converter-gson:${LibVersion.retrofit_version}"
        const val GSON = "com.google.code.gson:gson:${LibVersion.gson_version}"
        const val LOGGING = "com.squareup.okhttp3:logging-interceptor:4.8.0"
        const val JAVA = "com.squareup:javapoet:1.13.0"
    }

   object Hilt {
       const val HILT_ANDROID = "com.google.dagger:hilt-android:${LibVersion.Hilt}"
       const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${LibVersion.Hilt}"
       const val HILT_COMPILER = "androidx.hilt:hilt-compiler:1.0.0"
   }

    object Kotlin {
        const val SDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.21"
    }

    object AndroidX {
        const val MATERIAL = "com.google.android.material:material:1.5.0"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.3"
        const val APP_COMPAT = "androidx.appcompat:appcompat:1.3.1"
        const val ACTIVITY = "androidx.activity:activity-ktx:1.4.0"
        const val FRAGMENT = "androidx.fragment:fragment-ktx:1.5.2"
        const val PAGING = "androidx.paging:paging-runtime-ktx:3.1.1"
    }

    object Glide {
        const val GLIDE = "com.github.bumptech.glide:glide:4.13.0"
        const val FLEXIBLE = "com.google.android:flexbox:2.0.1"
    }

    object KTX {
        const val CORE = "androidx.core:core-ktx:1.7.0"
    }

    object Test {
        const val JUNIT = "junit:junit:4.13.2"
        const val ANDROID_JUNIT_RUNNER = "AndroidJUnitRunner"
    }

    object AndroidTest {
        const val TEST_RUNNER = "androidx.test.ext:junit:1.1.3"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"
    }

    object Compose {
        const val ACTIVITY = "androidx.activity:activity-compose:1.7.2"
        const val BOM = "androidx.compose:compose-bom:2023.03.00"
        const val UI = "androidx.compose.ui:ui"
        const val UI_GRAPHICS = "androidx.compose.ui:ui-graphics"
        const val PREVIEW = "androidx.compose.ui:ui-tooling-preview"
        const val MATERIAL3 = "androidx.compose.material3:material3"
        const val NAVIGATION_KTX = "androidx.navigation:navigation-fragment-ktx:$navigation_version"
        const val NAVIGATION = "androidx.navigation:navigation-compose:$navigation_version"
        const val HILT = "androidx.hilt:hilt-navigation-compose:1.2.0"
    }

    object Room {
        const val RUNTIME = "androidx.room:room-runtime:$room_version"
        const val KTX = "androidx.room:room-ktx:$room_version"
        const val COMPILER = "androidx.room:room-compiler:$room_version"
    }
}