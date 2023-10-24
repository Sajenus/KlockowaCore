package me.sajen.klockowacore.Listeners;

import me.sajen.klockowacore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class InventoryClick implements Listener {
    private Main plugin;
    public InventoryClick(Main plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(!plugin.getConfig().getBoolean("latarka"))return;

        Player player = (Player) e.getWhoClicked();
        int slot = e.getRawSlot();

        if (slot == 5) {

            ItemStack currentHelmet = player.getInventory().getHelmet();

            if (e.getCursor() != null && czyToLatarka(e.getCursor())) {
                // Gracz próbuje założyć latarkę
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, false));
                return;
            } else if (czyToLatarka(currentHelmet)) {
                // Gracz próbuje zdjąć latarkę
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                return;
            }
        }

        if (player.getInventory().getHelmet() == null && czyToLatarka(e.getCurrentItem()) && e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY && e.getInventory().getType() == InventoryType.CRAFTING && !(slot <= 4)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, false));
        }

    }

    public boolean czyToLatarka(ItemStack item) {
        if (isAirOrNull(item)) return false;
        if (item.hasItemMeta() && item.getItemMeta().hasLore()) {
            List<String> lore = item.getItemMeta().getLore();
            return lore.get(0).equals(ChatColor.translateAlternateColorCodes('&', "&7Latarka"));
        }
        return false;
    }

    public static boolean isAirOrNull(ItemStack item){
        return item == null || item.getType().equals(Material.AIR);
    }

}
