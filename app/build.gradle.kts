import com.android.lifeassistant.Dependencies

plugins {
    id(com.android.lifeassistant.Dependencies.Plugin.hilt)
    id(com.android.lifeassistant.Dependencies.Plugin.kotlin)
    kotlin(com.android.lifeassistant.Dependencies.Plugin.kapt)
    id(com.android.lifeassistant.Dependencies.Plugin.application)
    id(com.android.lifeassistant.Dependencies.Plugin.googleService)
    id(com.android.lifeassistant.Dependencies.Plugin.serialization)
}

android {
    namespace = Dependencies.Config.applicationName
    compileSdk = Dependencies.Config.targetSdk

    defaultConfig {
        applicationId = Dependencies.Config.applicationId
        minSdk = Dependencies.Config.minSdk
        targetSdk = Dependencies.Config.targetSdk
        versionCode = Dependencies.Config.versionCode
        versionName = Dependencies.Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        javaCompileOptions {
            annotationProcessorOptions {
                argument("room.schemaLocation", "$projectDir/schemas".toString())

            }
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
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }

    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        // ...
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlin.RequiresOptIn"
    }
}

kotlin {
    sourceSets {
        all {
            languageSettings.optIn("io.ktor.util.InternalAPI")
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    //Core
    implementation(Dependencies.Androidx.core)
    //LifeCycle
    implementation(Dependencies.Lifecycle.runtime)
    //Compose
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.preview)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.material)
    //Network
    implementation(Dependencies.Ktor.cio)
    implementation(Dependencies.Ktor.core)
    implementation(Dependencies.Ktor.android)
    implementation(Dependencies.Ktor.negotiation)
    implementation(Dependencies.Ktor.serialization)
    implementation(Dependencies.Ktor.clientSerialization)
    //FreeScroll
    implementation("com.github.chihsuanwu:compose-free-scroll:0.2.1")
    //Navigation
    implementation(Dependencies.Navigation.hilt)
    implementation(Dependencies.Navigation.compose)
    //Serialization
    implementation(Dependencies.Serialization.gson)
    implementation(Dependencies.Serialization.runtime)
    //Firebase
    implementation(platform(Dependencies.Firebase.boom))
    implementation(Dependencies.Firebase.auth)
    implementation(Dependencies.Firebase.storage)
    implementation(Dependencies.Firebase.analytics)
    implementation(Dependencies.Firebase.firestore)
    implementation(Dependencies.Firebase.messaging)
    implementation(Dependencies.Firebase.bootAware)
    //Preferences
    implementation(Dependencies.Preferences.datastore)
    //Hilt
    kapt(Dependencies.Hilt.hiltKapt)
    implementation(Dependencies.Hilt.hilt)
    //Test
    testImplementation(Dependencies.Test.junit)
    debugImplementation(Dependencies.DebugTest.uiTooling)
    debugImplementation(Dependencies.DebugTest.uiManifest)
    androidTestImplementation(Dependencies.AndroidTest.junit)
    androidTestImplementation(Dependencies.AndroidTest.uiJunit)
    androidTestImplementation(Dependencies.AndroidTest.espresso)
}