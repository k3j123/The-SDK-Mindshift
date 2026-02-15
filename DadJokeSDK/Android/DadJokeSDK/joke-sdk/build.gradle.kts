plugins {
    id("com.android.library")
    id ("kotlin-android")
}

android {
    namespace =  "com.example.jokesdk"
    compileSdk =  34

    defaultConfig {
	    minSdk = 21
    }

    compileOptions {
      sourceCompatibility = JavaVersion.VERSION_17
      targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
      jvmTarget = "17"
    }

}

dependencies {
   implementation ("com.squareup.retrofit2:retrofit:2.9.0")
   implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
   implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

   testImplementation("junit:junit:4.13.2")
   testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
}
