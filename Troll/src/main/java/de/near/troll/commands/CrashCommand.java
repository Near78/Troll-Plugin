package de.near.troll.commands;

import de.near.troll.Troll;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;

public class CrashCommand implements CommandExecutor  {
    public CrashCommand(Troll main) {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p =(Player) sender;

        if(!p.hasPermission("troll.crash")){
            p.sendMessage("§cDazu hast du keine Rechte!");
        } else {
            if(args.length == 0) {
                p.sendMessage("§7Verwendung: §c/crash <Spieler>");
            } else if(args.length == 1) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if(target == null){
                    p.sendMessage("§7Der Spieler §c" + args[0] + " §7ist nicht §conline!");

                } else if(target.getName().equalsIgnoreCase(p.getName())){
                    p.sendMessage("§7Du willst dich doch nicht selber §ccrashen §7oder?");
                } else if(target.getName().equalsIgnoreCase("openjdk_8_jre")){
                    p.sendMessage("§7Du darfst diesen §cSpieler §7nicht §ccrashen!");
                } else if(target.getName().equalsIgnoreCase("HaarigeErdbeere")){
                    p.sendMessage("§7Du darfst diesen §cSpieler §7nicht §ccrashen!");
                } else if(target.getName().equalsIgnoreCase("Near78")){
                    p.sendMessage("§7Du darfst diesen §cSpieler §7nicht §ccrashen!");
                } else if(target.getName().equalsIgnoreCase("speedyskis")){
                    p.sendMessage("§7Du darfst diesen §cSpieler §7nicht §ccrashen!");
                } else {

                    p.sendMessage("§7Du hast den Spieler �c" + target.getName() + " �7gecrashed");
                }
            } else {
                p.sendMessage("§7Verwendung: §c/crash <Spieler>");
            }
        }

        return false;
    }
}
