package org.project.demo

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.project.demo.expect.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "DemoKtorKoin",
        ) {
            App()
        }
    }
}