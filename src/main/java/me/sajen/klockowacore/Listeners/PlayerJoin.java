package me.sajen.klockowacore.Listeners;

import me.sajen.klockowacore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MainHand;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class PlayerJoin implements Listener {
    private Main plugin;
    public PlayerJoin(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        ItemStack helmet = p.getInventory().getHelmet();

        if (helmet != null && helmet.hasItemMeta() && helmet.getItemMeta().hasLore()) {
            if(!plugin.getConfig().getBoolean("latarka")) return;
            List<String> lore = helmet.getItemMeta().getLore();
            if (lore.get(0).equals(ChatColor.translateAlternateColorCodes('&', "&7Latarka"))) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000000, 0, true, false));
            }
        }

        if (p.getMainHand().equals(MainHand.LEFT)) {
            if(!plugin.getConfig().getBoolean("antyTryHard")) return;
            p.kickPlayer(ChatColor.translateAlternateColorCodes('&', "&cNie używaj lewej ręki!"));
        }
    }

}
