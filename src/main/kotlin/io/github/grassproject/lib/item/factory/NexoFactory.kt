package io.github.grassproject.lib.item.factory

import com.nexomc.nexo.api.NexoItems
import io.github.grassproject.lib.item.ItemHandler
import org.bukkit.inventory.ItemStack

object NexoFactory: ItemHandler.Factory {
    override fun create(id: String): ItemStack? {
        return NexoItems.itemFromId(id)?.build()
    }
}