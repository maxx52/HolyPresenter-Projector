package org.holypresenter_projector.services

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.holypresenter_projector.model.ProjectorContent

class DefaultProjectionService : ProjectionService {
    override var currentContent by mutableStateOf<ProjectorContent>(
        ProjectorContent.Empty
    )
        private set

    override fun show(content: ProjectorContent) {
        currentContent = content
    }

    override fun clear() {
        currentContent = ProjectorContent.Empty
    }
}