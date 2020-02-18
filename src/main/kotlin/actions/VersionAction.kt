package actions

import com.intellij.ide.plugins.PluginManager
import com.intellij.notification.NotificationDisplayType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.extensions.PluginId
import utils.showNotification

class VersionAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val version =
            PluginManager.getPlugin(
                PluginId.getId("dev.birjuvachhani.spider")
            )?.version ?: "Unable to get version!"

        e.showNotification(
            title = "Spider Version",
            content = version,
            type = NotificationDisplayType.TOOL_WINDOW
        )
    }
}