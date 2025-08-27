package io.github.grassproject.lib.util

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer

fun Component.toLegacy(): String = LegacyComponentSerializer.legacySection().serialize(this)
fun Component.toPlainText(): String = PlainTextComponentSerializer.plainText().serialize(this)
fun String.toMiniMessage(): Component = MiniMessage.miniMessage().deserialize(this)

fun Component.toDefaultStyle(color: TextColor? = NamedTextColor.WHITE): Component =
    this.decorationIfAbsent(TextDecoration.ITALIC, TextDecoration.State.FALSE).colorIfAbsent(color)

fun List<Component>?.toDefaultStyle(): List<Component>? =
    this?.map { it.toDefaultStyle() }