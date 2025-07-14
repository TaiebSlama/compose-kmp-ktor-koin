package org.project.demo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform