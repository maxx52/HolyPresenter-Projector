package org.holypresenter_projector

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "HolyPresenter-Projector",
    ) {
        App()
    }
}