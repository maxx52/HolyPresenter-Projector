package org.holypresenter_projector.render

import androidx.compose.ui.Alignment
import holypresenter.org.platform.api.presentation.SlotId

object SlotDefaults {
    fun alignment(slot: SlotId): Alignment {
        return when (slot.value) {
            "lyrics" -> Alignment.Center
            "title" -> Alignment.TopCenter
            "footer" -> Alignment.BottomCenter
            else -> Alignment.Center
        }
    }
}