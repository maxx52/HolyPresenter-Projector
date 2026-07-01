package org.holypresenter_projector.render

import androidx.compose.runtime.Composable
import holypresenter.org.platform.api.presentation.Presentation

@Composable
fun ProjectorRenderer(
    presentation: Presentation?
) {
    val slide = presentation?.slides?.firstOrNull()

    if (slide == null) {
        EmptyContentView()
        return
    }

    slide.elements
        .filter { it.visible }
        .sortedBy { it.zIndex }
        .forEach { element ->
            PresentationElementRenderer(element)
        }
}