package com.deathsdoor.configuration

import org.gradle.api.JavaVersion
import org.gradle.api.initialization.Settings
import kotlin.math.pow

object Configuration {
    const val packageName = "advanced-chiptextfield-compose"
    const val namespace = "com.deathsdoor.advancedchiptextfield"
    const val description = "Discover a dynamic Editable Chip Text Field implementation for Kotlin Multiplatform Mobile (KMM) applications using Jetpack Compose. This repository showcases a versatile UI component that enables users to create chips by typing and converting text entries. Harnessing the power of Jetpack Compose, this project provides a cross-platform solution for seamlessly managing chip-like elements without the need for images or complex UI elements.\n"
    const val homepage = "https://github.com/${publish.userName}/advanced-chiptextfield-compose-kmp"

    const val versionName = "1.0.0"
    val versionCode = versionName
        .split(".")
        .foldIndexed(0) { index, acc, part ->
            val versionPart = part.toInt()
            if (versionPart == 0) acc
            else acc + versionPart * (1000000 / 100.0.pow(index)).toInt()
        }


    object android {
        const val namespace = "${Configuration.namespace}.android"

        const val javaVersion = "11"
        val asJavaVersionEnum = JavaVersion.values().find { it.name.endsWith(javaVersion) }

        const val minSdk = 26
        const val maxSdk = 33
    }

    object desktop {
        const val entryPoint = "com.deathsdoor.radixconvertor.MainKt"
    }

    object ios {
        const val deploymentTarget = "14.1"
        const val baseName = "shared"
    }

    object publish {
        const val artifact = "chiptextfield-compose"
        const val userName = "Deaths-Door"
        const val userNameHomePage = "https://github.com/Deaths-Door"
        const val connection = "scm:git:git://github.com/${userName}/${packageName}.git"
        const val developerConnection = "scm:git:ssh://git@github.com/${userName}/${packageName}.git"
    }
}