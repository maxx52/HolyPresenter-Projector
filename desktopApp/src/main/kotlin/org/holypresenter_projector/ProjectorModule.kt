package org.holypresenter.projector

import androidx.compose.runtime.Composable
import holypresenter.org.platform.api.module.HolyModule
import holypresenter.org.platform.api.module.ModuleContext
import holypresenter.org.platform.api.module.ModuleMetadata
import org.holypresenter_projector.workspace.ProjectorWorkspace

class ProjectorModule : HolyModule {

    override val metadata = ModuleMetadata(
        id = "projector",
        name = "Projector",
        version = "1.0.0",
        apiVersion = "0.1.0",
        author = "HolyPresenter",
        description = "External projector module"
    )

    override fun onLoad(context: ModuleContext) {
        println("ProjectorModule loaded")
    }

    @Composable
    override fun Workspace() {
        ProjectorWorkspace()
    }
}