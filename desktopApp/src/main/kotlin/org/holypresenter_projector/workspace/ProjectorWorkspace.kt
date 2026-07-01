package org.holypresenter_projector.workspace

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.holypresenter_projector.controller.ProjectorController
import org.holypresenter_projector.render.ProjectorRenderer
import org.holypresenter_projector.services.ProjectionService

@Composable
fun ProjectorWorkspace(
    controller: ProjectorController,
    projectionService: ProjectionService
) {
    var text by remember { mutableStateOf("") }

    Column {
        Text("Проектор")

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Текст для показа") }
        )

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                controller.presentText(text)
            }
        ) {
            Text("Показать")
        }

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                controller.clear()
            }
        ) {
            Text("Очистить")
        }

        Spacer(Modifier.height(16.dp))

        Text("Предпросмотр:")

        ProjectorRenderer(
            slide = projectionService.currentSlide
        )

        Button(
            onClick = {
                controller.previous()
            }
        ) {
            Text("Назад")
        }

        Button(
            onClick = {
                controller.next()
            }
        ) {
            Text("Далее")
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Слайд: ${projectionService.currentSlideIndex + 1} / ${
                projectionService.currentPresentation?.slides?.size ?: 0
            }"
        )
    }
}