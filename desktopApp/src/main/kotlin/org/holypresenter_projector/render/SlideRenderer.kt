package org.holypresenter_projector.render

import androidx.compose.runtime.Composable
import holypresenter.org.platform.api.presentation.PresentationSlide

@Composable
fun SlideRenderer(
    slide: PresentationSlide
) {
    slide.elements
        .filter { it.visible }
        .sortedBy { it.zIndex }
        .forEach { element ->
            PresentationElementRenderer(element)
        }
}