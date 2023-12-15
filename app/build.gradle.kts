import com.android.build.gradle.ProguardFiles.getDefaultProguardFile

plugins {
    id("com.android.library")
}

android {
    namespace = "com.moin.qrcodeffiandroid"
    compileSdk = 33

    defaultConfig {
     //   applicationId = "com.moin.qrcodeffiandroid"
        minSdk = 24
        targetSdk = 33
    //    versionCode = 1
      //  versionName = "1.0"

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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.journeyapps:zxing-android-embedded:4.1.0")
    implementation(files("C:\\Users\\MuhammadMoin\\Downloads\\konywidgets.jar"))
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")


}