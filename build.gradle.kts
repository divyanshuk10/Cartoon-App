// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22" apply false
    id("androidx.navigation.safeargs") version "2.5.0" apply false
    alias(libs.plugins.jetbrainsKotlinJvm) apply false
}