package org.holypresenter_projector.services

import org.holypresenter_projector.model.ProjectorContent

interface ProjectionService {
    val currentContent: ProjectorContent
    fun show(content: ProjectorContent)
    fun clear()
}