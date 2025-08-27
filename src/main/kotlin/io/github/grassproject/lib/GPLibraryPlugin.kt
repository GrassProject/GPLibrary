package io.github.grassproject.lib

import org.bukkit.plugin.java.JavaPlugin

class GPLibraryPlugin : JavaPlugin() {

    companion object {
        lateinit var INSTANCE: GPLibraryPlugin
            private set
    }

    override fun onLoad() {
        INSTANCE = this
    }

}