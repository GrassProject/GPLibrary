package io.github.grassproject.lib.item.factory

import dev.lone.itemsadder.api.CustomStack
import io.github.grassproject.lib.item.ItemHandler
import org.bukkit.inventory.ItemStack

object IAFactory: ItemHandler.Factory {
    override fun create(id: String): ItemStack? {
        return CustomStack.getInstance(id)!!.itemStack
    }
}