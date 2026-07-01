package org.holypresenter_projector.render

import androidx.compose.runtime.Composable
import holypresenter.org.platform.api.presentation.Presentation

@Composable
fun PresentationRenderer(
    presentation: Presentation
) {
    val slide = presentation.slides.firstOrNull()

    if (slide == null) {
        EmptyContentView()
        return
    }

    SlideRenderer(slide)
}