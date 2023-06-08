plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinJvm)
    //Kapt
    kotlin (Plugins.kapt)
    //Hilt
    id (Plugins.hilt)
}

android {
    namespace = Config.applicationIdData
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {

    implementation(Dependencies.AndroidCore.core)
    implementation(Dependencies.UIComponents.appCompat)
    implementation(Dependencies.UIComponents.material)

    //hilt
    implementation (Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.hiltCompiler)

    //Domain
    api (project(":domain"))
}