package me.sajen.klockowacore.Listeners;

import me.sajen.klockowacore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class PlayerRespawn implements Listener {
    private Main plugin;
    public PlayerRespawn(Main plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        if(plugin.getConfig().getBoolean("latarka")) {
            Player p = e.getPlayer();
            ItemStack helmet = p.getInventory().getHelmet();
            if (!(helmet != null && helmet.hasItemMeta() && helmet.getItemMeta().hasLore())) return;
            List<String> lore = helmet.getItemMeta().getLore();
            if (lore.get(0).equals(ChatColor.translateAlternateColorCodes('&', "&7Latarka"))) {
                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                    // Dodaj efekt Night Vision graczowi
                    p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000000, 0, true, false));
                }, 1);
            }
        }
    }
}
