package me.sajen.klockowacore.Listeners;

import me.sajen.klockowacore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseArmorEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class BlockDispenseArmor implements Listener {
    private Main plugin;
    public BlockDispenseArmor(Main plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockDispenseArmor(BlockDispenseArmorEvent e) {
        if (!plugin.getConfig().getBoolean("latarka")) return;
        if (!(e.getTargetEntity() instanceof Player)) return;
        if (!(e.getItem().hasItemMeta() && e.getItem().getItemMeta().hasLore())) return;
        List<String> lore = e.getItem().getItemMeta().getLore();
        if (!lore.get(0).equals(ChatColor.translateAlternateColorCodes('&', "&7Latarka"))) return;

        Player p = (Player) e.getTargetEntity();
        p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000000, 0, true, false));

    }

}
