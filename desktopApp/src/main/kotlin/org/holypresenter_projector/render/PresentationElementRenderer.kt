package org.holypresenter_projector.render

import androidx.compose.runtime.Composable
import holypresenter.org.platform.api.presentation.PresentationElement
import holypresenter.org.platform.api.presentation.element.TextElement

@Composable
fun PresentationElementRenderer(
    element: PresentationElement
) {
    when (element) {
        is TextElement -> TextContentView(element.text)
    }
}