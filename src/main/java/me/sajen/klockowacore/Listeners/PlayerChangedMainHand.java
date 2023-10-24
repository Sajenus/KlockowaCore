package me.sajen.klockowacore.Listeners;

import me.sajen.klockowacore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedMainHandEvent;
import org.bukkit.inventory.MainHand;

public class PlayerChangedMainHand implements Listener {
    private Main plugin;
    public PlayerChangedMainHand(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChangedMainHand(PlayerChangedMainHandEvent e) {
        if(!plugin.getConfig().getBoolean("antyTryHard")) return;
        Player p = e.getPlayer();
        if (e.getMainHand().equals(MainHand.RIGHT)) {
            p.kickPlayer(ChatColor.translateAlternateColorCodes('&', "&cNie używaj lewej ręki!"));
        }
    }

}
