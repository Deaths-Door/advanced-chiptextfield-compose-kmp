package com.deathsdoor.advancedchiptextfield

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform