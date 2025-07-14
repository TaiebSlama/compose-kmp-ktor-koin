package org.project.demo

import androidx.compose.ui.window.ComposeUIViewController
import org.project.demo.expect.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }