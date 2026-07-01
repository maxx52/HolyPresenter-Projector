package org.holypresenter_projector.services

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import holypresenter.org.platform.api.presentation.Presentation
import holypresenter.org.platform.api.presentation.PresentationSlide

class DefaultProjectionService : ProjectionService {
    override var currentPresentation by mutableStateOf<Presentation?>(null)
        private set

    override var currentSlideIndex by mutableStateOf(0)
        private set

    override val currentSlide: PresentationSlide?
        get() = currentPresentation
            ?.slides
            ?.getOrNull(currentSlideIndex)

    override fun present(presentation: Presentation) {
        currentPresentation = presentation
        currentSlideIndex = 0
    }

    override fun next() {
        val presentation = currentPresentation ?: return

        if (currentSlideIndex < presentation.slides.lastIndex) {
            currentSlideIndex++
        }
    }

    override fun previous() {
        if (currentSlideIndex > 0) {
            currentSlideIndex--
        }
    }

    override fun goTo(index: Int) {
        val presentation = currentPresentation ?: return

        if (index in presentation.slides.indices) {
            currentSlideIndex = index
        }
    }

    override fun clear() {
        currentPresentation = null
        currentSlideIndex = 0
    }
}