package me.sajen.klockowacore.Listeners;

import me.sajen.klockowacore.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlockBurn implements Listener {
    private Main plugin;
    public BlockBurn(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onKelpBlockBurn(BlockBurnEvent e) {
        if (!plugin.getConfig().getBoolean("jaranie")) return;
        if (e.getBlock().getType() != Material.DRIED_KELP_BLOCK) return;

        int dystans = plugin.getConfig().getInt("dystans");
        World w = e.getBlock().getWorld();
        Location loc = e.getBlock().getLocation();

        for (Player p : Bukkit.getOnlinePlayers()) {
            Location playerLocation = p.getLocation();
            if (playerLocation.getWorld() == w && playerLocation.distance(loc) <= dystans) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 2));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 200, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 200, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 200, 1));
            }
        }

    }

}
