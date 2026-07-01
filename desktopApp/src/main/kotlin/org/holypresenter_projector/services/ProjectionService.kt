package org.holypresenter_projector.services

import holypresenter.org.platform.api.presentation.Presentation

interface ProjectionService {
    val currentPresentation: Presentation?

    fun present(presentation: Presentation)

    fun clear()
}