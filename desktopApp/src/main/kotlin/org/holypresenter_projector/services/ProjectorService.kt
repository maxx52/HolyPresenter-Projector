package org.holypresenter_projector.services

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.holypresenter_projector.model.ProjectorContent

class ProjectorService {
    var content by mutableStateOf<ProjectorContent>(ProjectorContent.Empty)
        private set

    fun showText(text: String) {
        content = ProjectorContent.Text(text)
    }

    fun clear() {
        content = ProjectorContent.Empty
    }
}