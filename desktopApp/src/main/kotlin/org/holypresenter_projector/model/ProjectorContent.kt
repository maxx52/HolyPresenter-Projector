package org.holypresenter_projector.model

sealed interface ProjectorContent {
    data object Empty : ProjectorContent

    data class Text(
        val value: String
    ) : ProjectorContent
}