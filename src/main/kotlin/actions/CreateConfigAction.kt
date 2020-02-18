package actions

import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnActionEvent
import utils.Configs
import java.nio.file.Paths


class CreateConfigAction : SpiderAction() {
    override fun actionPerformed(e: AnActionEvent) {
        e.project?.basePath?.let { projectDir ->
            Paths.get(projectDir, "spider.json").toFile().writeText(Configs.JSON)
            val noti = NotificationGroup("spider", NotificationDisplayType.BALLOON, true)
            noti.createNotification(
                "Spider",
                "Configuration file created successfully.",
                NotificationType.INFORMATION,
                null
            ).notify(e.project)
        }
    }
}