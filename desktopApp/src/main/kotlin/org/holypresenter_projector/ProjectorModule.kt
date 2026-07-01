package org.holypresenter_projector

import androidx.compose.runtime.Composable
import holypresenter.org.platform.api.module.HolyModule
import holypresenter.org.platform.api.module.ModuleContext
import holypresenter.org.platform.api.module.ModuleMetadata
import holypresenter.org.platform.api.presentation.Presentation
import holypresenter.org.platform.api.presentation.PresentationSlide
import holypresenter.org.platform.api.presentation.SlotId
import holypresenter.org.platform.api.presentation.element.TextElement
import org.holypresenter_projector.services.DefaultProjectionService
import org.holypresenter_projector.workspace.ProjectorWorkspace
import org.holypresenter_projector.commands.ShowTextCommand
import org.holypresenter_projector.controller.ProjectorController

class ProjectorModule : HolyModule {
    private val defaultProjectionService = DefaultProjectionService()
    private val projectorController = ProjectorController(defaultProjectionService)

    override val metadata = ModuleMetadata(
        id = "projector",
        name = "Projector",
        version = "1.0.0",
        apiVersion = "0.1.0",
        author = "HolyPresenter",
        description = "External projector module"
    )

    override fun onLoad(context: ModuleContext) {
        context.commands.register(
            commandName = "projector.showText"
        ) { command: ShowTextCommand ->
            defaultProjectionService.present(
                Presentation(
                    id = "command-presentation",
                    slides = listOf(
                        PresentationSlide(
                            id = "slide-1",
                            elements = listOf(
                                TextElement(
                                    id = "text-1",
                                    slot = SlotId("lyrics"),
                                    text = command.text
                                )
                            )
                        )
                    )
                )
            )
        }

        println("ProjectorModule loaded")
    }

    @Composable
    override fun Workspace() {
        ProjectorWorkspace(
            controller = projectorController,
            projectionService = defaultProjectionService
        )
    }
}