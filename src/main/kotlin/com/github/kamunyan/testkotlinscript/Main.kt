package com.github.kamunyan.testkotlinscript

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.server.ServerLoadEvent
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin(),Listener {

    companion object{
        lateinit var instance:JavaPlugin
    }

    init {
        instance = this
    }

    override fun onEnable() {
        Bukkit.getLogger().info("${ChatColor.AQUA}よみこんだよ！")
        this.server.pluginManager.registerEvents(this,this)
    }

    override fun onDisable() {

    }

    @EventHandler
    fun onLoad(e: ServerLoadEvent){
        this.logger.info("${ChatColor.GOLD}サーバーがロードしたよ！")
    }

    @EventHandler
    fun onPlayerJoin(e:PlayerJoinEvent){
        this.logger.info("${ChatColor.AQUA}${e.player.displayName}がサーバーにJoinしたよ！")
        e.joinMessage = "${ChatColor.AQUA}${e.player.displayName}がサーバーにJoinしたよ！"
    }
}