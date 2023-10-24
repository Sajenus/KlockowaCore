package me.sajen.klockowacore.Commands;

import me.sajen.klockowacore.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
        } else if (args.length == 1) {
            String arg0 = args[0].toLowerCase();
            if(arg0.equals("komendy")){
                Komendy(sender);
            } else if(arg0.equals("uprawnienia")){

            } else if(arg0.equals("reload")){

            } else if(arg0.equals("freeze")){

            }
        }


        return true;
    }




    private void Info(CommandSender s) {
        s.sendMessage("&8&mo------------------------------------------o".replace('&', '§'));
        s.sendMessage("&e> &aSerwer korzysta z pluginu &bKlockowaCore".replace('&', '§'));
        s.sendMessage("&e> &aAutor: &bSajen".replace('&', '§'));
        s.sendMessage("&e> &aWersja: &b1.17.x".replace('&', '§'));
        s.sendMessage("&e> &aLista komend: &6/klockowa komendy".replace('&', '§'));
        s.sendMessage("&e> &aLista uprawnień: &6/klockowa uprawnienia".replace('&', '§'));
        s.sendMessage("&8&mo------------------------------------------o".replace('&', '§'));
    }
    
    private void Komendy(CommandSender s) {
        s.sendMessage("&8&mo------------------------------------------o".replace('&', '§'));
        s.sendMessage("&6&lLista komend:".replace('&', '§'));
        s.sendMessage("&e> &a/klockowa komendy".replace('&', '§'));
        s.sendMessage("&e> &a/klockowa uprawnienia".replace('&', '§'));
        s.sendMessage("&e> &a/klockowa reload".replace('&', '§'));
        s.sendMessage("&e> &a/klockowa freeze".replace('&', '§'));
        s.sendMessage("&8&mo------------------------------------------o".replace('&', '§'));
    }


    private String Color(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
