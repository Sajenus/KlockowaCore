package me.sajen.klockowacore.Commands;

import me.sajen.klockowacore.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Klockowa implements CommandExecutor {
    private Main plugin;
    public Klockowa(Main plugin){
        plugin.getCommand("klockowa").setExecutor(this);
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // /klockowa
        if (args.length == 0) {
            Info(sender);
        }


        return true;
    }




    private void Info(CommandSender s) {
        s.sendMessage("&8&mo-------------------------o".replace('&', '§'));
        s.sendMessage("&e> &aSerwer korzysta z pluginu &bKlockowaCore".replace('&', '§'));
        s.sendMessage("&e> &aAutor: &bSajen".replace('&', '§'));
        s.sendMessage("&e> &aWersja: &b1.17.x".replace('&', '§'));
        s.sendMessage("&e> &aLista komend: &6/klockowa komendy".replace('&', '§'));
        s.sendMessage("&e> &aLista uprawnień: &6/klockowa uprawnienia".replace('&', '§'));
        s.sendMessage("&8&mo-------------------------o".replace('&', '§'));
    }

    private String Color(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
