package me.sajen.klockowacore.Listeners;

import me.sajen.klockowacore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.List;

public class PlayerInteract implements Listener {
    private final List<String> blockedMaterials;
    public PlayerInteract(Main plugin, List<String> blockedMaterials) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.blockedMaterials = blockedMaterials;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if(e.getPlayer().getInventory().getHelmet() != null) return;
        if (e.useItemInHand().equals(Event.Result.DENY)) return;
        if (e.getAction() == Action.PHYSICAL) return;
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player p = e.getPlayer();
            if (!e.useInteractedBlock().equals(Event.Result.DENY)) {
                if (e.getClickedBlock() != null && e.getAction() == Action.RIGHT_CLICK_BLOCK && !p.isSneaking()) {
                    Material mat = e.getClickedBlock().getType();
                    for (String s : blockedMaterials){
                        if(mat.name().equalsIgnoreCase(s)) return;
                    }
                }
            }
            if(isAirOrNull(e.getItem())) return;
            if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().hasLore()) {
                List<String> lore = e.getItem().getItemMeta().getLore();
                if (lore.get(0).equals(ChatColor.translateAlternateColorCodes('&', "&7Latarka"))) {
                    // Gracz ma hełm "Latarka" - dodaj efekt night vision
                    p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000000, 0, true, false));
                }
            }
        }
    }

    public static boolean isAirOrNull(ItemStack item){
        return item == null || item.getType().equals(Material.AIR);
    }
}
