package me.sajen.klockowacore.Listeners;

import me.sajen.klockowacore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class PlayerItemBreak implements Listener {
    private Main plugin;
    public PlayerItemBreak(Main plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerItemBreak(PlayerItemBreakEvent e) {
        if (!plugin.getConfig().getBoolean("latarka")) return;
        if (!(e.getBrokenItem().hasItemMeta() && e.getBrokenItem().getItemMeta().hasLore())) return;
        List<String> lore = e.getBrokenItem().getItemMeta().getLore();
        Player p = e.getPlayer();
        if (lore.get(0).equals(ChatColor.translateAlternateColorCodes('&', "&7Latarka"))) {
            p.removePotionEffect(PotionEffectType.NIGHT_VISION);
        }


    }
}
