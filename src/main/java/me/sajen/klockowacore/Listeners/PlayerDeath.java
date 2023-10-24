package me.sajen.klockowacore.Listeners;

import me.sajen.klockowacore.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerDeath implements Listener {
    private Main plugin;
    public PlayerDeath(Main plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player victim = e.getEntity();
        Player killer = victim.getKiller();

        if (killer == null) return;

        if (plugin.getConfig().getBoolean("piorun")) {
            Location deathLocation = victim.getLocation();
            World world = deathLocation.getWorld();
            world.strikeLightningEffect(deathLocation);

        }


        if (plugin.getConfig().getBoolean("glowka")) {
            ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
            skullMeta.setOwningPlayer(victim);
            skull.setItemMeta(skullMeta);

            // Dodaj głowę do dropów
            e.getDrops().add(skull);
        }

    }
}
