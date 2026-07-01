package org.holypresenter_projector.render

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import holypresenter.org.platform.api.presentation.element.TextElement

@Composable
fun TextElementView(
    element: TextElement
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = SlotDefaults.alignment(element.slot)
    ) {
        Text(element.text)
    }
}