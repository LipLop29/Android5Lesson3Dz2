plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinJvm)
    //Kapt
    kotlin(Plugins.kapt)
    //Safe args
    id(Plugins.safeArgs)
    //Hilt
    id(Plugins.hilt)
    id(Plugins.parcelize)
}

android {
    namespace = Config.applicationIdPresentation
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Dependencies.AndroidCore.core)
    implementation(Dependencies.UIComponents.appCompat)
    implementation(Dependencies.UIComponents.material)
    implementation(Dependencies.UIComponents.constraint)

    // Navigation
    implementation(Dependencies.NavigationComponent.navigationUI)
    implementation(Dependencies.NavigationComponent.navigationFragment)

    // ViewBindingPropertyDelegate
    implementation(Dependencies.ViewBindingPropertyDelegate.viewBindingPropertyDelegate)

    //hilt
    implementation(Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.hiltCompiler)

    //Domain
    implementation(project(":domain"))
}