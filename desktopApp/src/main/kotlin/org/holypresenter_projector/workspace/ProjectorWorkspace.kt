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
import org.holypresenter_projector.model.ProjectorContent
import org.holypresenter_projector.services.ProjectionService

@Composable
fun ProjectorWorkspace(
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
                projectionService.show(
                    ProjectorContent.Text(text)
                )
            }
        ) {
            Text("Показать")
        }

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                projectionService.clear()
            }
        ) {
            Text("Очистить")
        }

        Spacer(Modifier.height(16.dp))

        Text("Предпросмотр:")

        when (val content = projectionService.currentContent) {
            ProjectorContent.Empty -> Text("Пусто")
            is ProjectorContent.Text -> Text(content.value)
        }
    }
}