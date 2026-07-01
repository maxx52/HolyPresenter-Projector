package org.holypresenter_projector.services

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import holypresenter.org.platform.api.presentation.Presentation

class DefaultProjectionService : ProjectionService {
    override var currentPresentation by mutableStateOf<Presentation?>(null)
        private set

    override fun present(presentation: Presentation) {
        currentPresentation = presentation
    }

    override fun clear() {
        currentPresentation = null
    }
}