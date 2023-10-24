package me.sajen.klockowacore.Listeners;

import me.sajen.klockowacore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class InventoryDrag implements Listener {
    private Main plugin;
    public InventoryDrag(Main plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event){
        if(!plugin.getConfig().getBoolean("latarka"))return;
        if(isAirOrNull(event.getOldCursor()))return;
        if(event.getRawSlots().isEmpty()) return;// IDK if this will ever happen
        if(event.getRawSlots().stream().findFirst().orElse(0) == 5){
            if (event.getOldCursor().hasItemMeta() && event.getOldCursor().getItemMeta().hasLore()) {
                List<String> lore = event.getOldCursor().getItemMeta().getLore();
                if (lore.get(0).equals(ChatColor.translateAlternateColorCodes('&', "&7Latarka"))) {
                    event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000000, 0, true, false));
                }
            }
        }
    }

    public static boolean isAirOrNull(ItemStack item){
        return item == null || item.getType().equals(Material.AIR);
    }

}
