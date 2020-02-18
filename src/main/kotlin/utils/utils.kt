package utils

import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import java.nio.file.Paths

fun AnActionEvent.showNotification(
    title: String,
    content: String,
    type: NotificationDisplayType = NotificationDisplayType.BALLOON
) {
    NotificationGroup(
        "spider",
        type,
        true
    ).createNotification(
        title,
        content,
        NotificationType.INFORMATION,
        null
    ).notify(project)
}

fun Project.isFlutterProject(): Boolean =
    this.basePath?.let {
        Paths.get(it, "pubspec.yaml").toFile().exists()
                && Paths.get(it, "lib").toFile().exists()
    } ?: false