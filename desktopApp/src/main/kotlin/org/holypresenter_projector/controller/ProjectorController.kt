package org.holypresenter_projector.controller

import holypresenter.org.platform.api.presentation.Presentation
import holypresenter.org.platform.api.presentation.PresentationSlide
import holypresenter.org.platform.api.presentation.SlotId
import holypresenter.org.platform.api.presentation.element.TextElement
import org.holypresenter_projector.services.ProjectionService
import java.util.UUID

class ProjectorController(
    private val projectionService: ProjectionService
) {
    fun present(presentation: Presentation) {
        projectionService.present(presentation)
    }

    fun clear() {
        projectionService.clear()
    }

    fun presentText(text: String) {
        present(
            Presentation(
                id = UUID.randomUUID().toString(),
                slides = listOf(
                    PresentationSlide(
                        id = "slide-1",
                        elements = listOf(
                            TextElement(
                                id = "lyrics",
                                slot = SlotId("lyrics"),
                                text = text
                            )
                        )
                    )
                )
            )
        )
    }
}