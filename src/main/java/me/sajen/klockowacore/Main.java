package me.sajen.klockowacore;

import me.sajen.klockowacore.Commands.Klockowa;
import me.sajen.klockowacore.Listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        new Klockowa(this);

        new BlockBurn(this);
        new BlockDispenseArmor(this);
        new InventoryClick(this);
        new InventoryDrag(this);
        new PlayerChangedMainHand(this);
        new PlayerDeath(this);
        new PlayerInteract(this, getConfig().getStringList("blocked"));
        new PlayerJoin(this);
        new PlayerItemBreak(this);
        new PlayerRespawn(this);

        saveDefaultConfig();
    }

    @Override
    public void onDisable() {

    }
}
