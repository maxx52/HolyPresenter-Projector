package org.holypresenter_projector.render

import androidx.compose.runtime.Composable
import holypresenter.org.platform.api.presentation.PresentationSlide

@Composable
fun ProjectorRenderer(
    slide: PresentationSlide?
) {
    if (slide == null) {
        EmptyContentView()
        return
    }

    SlideRenderer(slide)
}