import com.deathsdoor.configuration.Configuration
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("com.vanniktech.maven.publish")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions.jvmTarget = Configuration.android.javaVersion
        }
        
        publishLibraryVariants("release", "debug")
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm()

    js(IR) {
        binaries.executable()
        browser()
        nodejs()
    }

    cocoapods {
        version = Configuration.versionName
        homepage =  Configuration.homepage
        summary = Configuration.description
        ios.deploymentTarget = Configuration.ios.deploymentTarget

        framework {
            baseName = Configuration.ios.baseName
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.runtime)
            }
        }
    }
}

android {
    namespace = Configuration.namespace
    compileSdk = Configuration.android.maxSdk

    defaultConfig.minSdk = Configuration.android.minSdk

    compileOptions.sourceCompatibility = Configuration.android.asJavaVersionEnum
    compileOptions.targetCompatibility = Configuration.android.asJavaVersionEnum

    buildTypes.getByName("release"){
        isMinifyEnabled = true
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01) //,automaticRelease = true)
    signAllPublications()

    // io.github.deaths-door.advancedchiptextfield
    coordinates("io.github.deaths-door.advancedchiptextfield", "advancedchiptextfield"/* Configuration.publish.artifact*/,Configuration.versionName)

    pom {
        name.set("advancedchiptextfield")
        //name.set(Configuration.packageName)
        description.set(Configuration.description)
        inceptionYear.set("2023")
        url.set(Configuration.homepage)
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                name.set(Configuration.publish.userName)
                url.set(Configuration.publish.userNameHomePage)
            }
        }
        scm {
            url.set(Configuration.homepage)
            connection.set(Configuration.publish.connection)
            developerConnection.set(Configuration.publish.developerConnection)
        }
    }
}
