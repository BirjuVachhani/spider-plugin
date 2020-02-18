package actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import utils.isFlutterProject

abstract class SpiderAction : AnAction() {

    override fun update(e: AnActionEvent) {
        super.update(e)
        if (e.project?.isFlutterProject() == true) {
            e.presentation.isEnabled = false
        }
    }
}