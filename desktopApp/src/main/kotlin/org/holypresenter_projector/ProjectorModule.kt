package org.holypresenter_projector

import androidx.compose.runtime.Composable
import holypresenter.org.platform.api.module.HolyModule
import holypresenter.org.platform.api.module.ModuleContext
import holypresenter.org.platform.api.module.ModuleMetadata
import org.holypresenter_projector.services.DefaultProjectionService
import org.holypresenter_projector.services.ProjectionService
import org.holypresenter_projector.workspace.ProjectorWorkspace

class ProjectorModule : HolyModule {
    private val defaultProjectionService = DefaultProjectionService()

    override val metadata = ModuleMetadata(
        id = "projector",
        name = "Projector",
        version = "1.0.0",
        apiVersion = "0.1.0",
        author = "HolyPresenter",
        description = "External projector module"
    )

    override fun onLoad(context: ModuleContext) {
        context.services.register(
            ProjectionService::class,
            defaultProjectionService
        )

        println("ProjectorModule loaded")
    }

    @Composable
    override fun Workspace() {
        ProjectorWorkspace(
            projectionService = defaultProjectionService
        )
    }
}