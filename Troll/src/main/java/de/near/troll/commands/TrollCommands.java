package de.near.troll.commands;

import de.near.troll.Troll;
import de.near.troll.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TrollCommands implements CommandExecutor {
    public TrollCommands(de.near.troll.Troll Main){
        this.pl = Main;
    }
    private de.near.troll.Troll pl;
    ArrayList<Player> spamlist = new ArrayList<Player>();
    int spamint;
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        Player p = (Player)sender;

        if(cmd.getName().equalsIgnoreCase("troll")){
            if(args.length == 0){
                if(p.hasPermission("troll.allow")){
                    p.sendMessage(Troll.Prefix + "§7/§8T§7roll §aan §8§ §eUnsichtbar + Gamemode");
                    p.sendMessage(Troll.Prefix +  "§7/§8T§7roll §7Vanish §8§ §eUnsichtbar");
                    p.sendMessage(Troll.Prefix +  "§7/§8T§7roll §7Gamemode §8§ §eGamemode");
                    p.sendMessage(Troll.Prefix +  "§7/§8T§7roll §7Push §8[§7Spieler§8] §8§ §eKnockback geben");
                    p.sendMessage(Troll.Prefix +  "§7/§8T§7roll §7Lag §aan §8[§7Spieler§8] §8§ §eLösst den Spieler laggen");
                    p.sendMessage(Troll.Prefix +  "§7/§8T§7roll §7Lag §caus §8[§7Spieler§8] §8§§eLösst den Spieler nicht mehr laggen");
                    p.sendMessage(Troll.Prefix +  "§7/§8T§7roll §7Kick §8[§7Spieler§8] §8§ §eKickt den Spieler");
                    p.sendMessage(Troll.Prefix +  "§7/§8T§7roll §7FakeOP §8[§7Spieler§8] §8§ §eSpieler FakeOP'n");
                    p.sendMessage(Troll.Prefix +  "§7/§8T§7roll §7FakeDEOP §8[§7Spieler§8] §8§ §eSpieler FakeDEOP'n");
                    p.sendMessage(Troll.Prefix +  "§7/§8T§7roll §7Spam §8[§7Spieler§8] §8§ §eSpame einen Spieler zu c:");
                    p.sendMessage(Troll.Prefix +  "§7/§8T§7roll §7AntiCheat §8[§7Spieler§8] §8§ §eMessage, dass der Spieler vom AntiCheat detected wurde!");
                }
            }else if(args.length == 1){
                if(args[0].equalsIgnoreCase("dev")){
                    p.sendMessage(Troll.Prefix + "§eNear78");
                }else if(args[0].equalsIgnoreCase("an")){
                    if(p.hasPermission("troll.allow")){
                        for(Player all : Bukkit.getOnlinePlayers()){
                            all.hidePlayer(p);
                        }
                        p.sendMessage(Troll.Prefix + "§7Du bist nun im Troll Modus!");
                        p.setGameMode(GameMode.CREATIVE);
                    }
                }else if(args[0].equalsIgnoreCase("vanish")){
                    if(p.hasPermission("troll.allow")){
                        for(Player all : Bukkit.getOnlinePlayers()){
                            all.hidePlayer(p);
                        }
                        p.sendMessage(Troll.Prefix + "§7Du bist nun Unsichtbar!");
                    }
                }else if(args[0].equalsIgnoreCase("gamemode")){
                    if(p.hasPermission("troll.allow")){
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Troll.Prefix + "�7Du bist nun im GameMode!");
                    }
                }
            }else if(args.length == 2){
                if(args[0].equalsIgnoreCase("push")){
                    if(p.hasPermission("troll.allow")){
                        Player target = Bukkit.getPlayer(args[1]);
                        target.setVelocity(target.getLocation().getDirection().multiply(-1));
                        p.sendMessage(Troll.Prefix + "§7Der Spieler §c" + target.getName() + "�7 hat Knockback bekommen c:");
                    }
                }else if(args[0].equalsIgnoreCase("kick")){
                    if(p.hasPermission("troll.allow")){
                        Player target = Bukkit.getPlayer(args[1]);
                        Utils.kick(target);
                        p.sendMessage(Troll.Prefix + "§7Der Spieler �c" + target.getName() + "�7wurde gekickt");
                    }
                }else if(args[0].equalsIgnoreCase("anticheat")){
                    if(p.hasPermission("troll.allow")){
                        Player target = Bukkit.getPlayer(args[1]);
                        target.sendMessage("�8[�cAntiCheatSystem�8] �6Bitte schalte deine Killaura aus!");
                        p.sendMessage(Troll.Prefix + "§c" + target.getName() + "§7 >> §8[�cAntiCheatSystem�8] �6Bitte schalte deine Killaura aus!");
                    }
                }else if(args[0].equalsIgnoreCase("fakeop")){
                    if(p.hasPermission("troll.allow")){
                        Player target = Bukkit.getPlayer(args[1]);
                        if(target != null){
                            String FakeOP = Troll.FakeOPMessage.replace("%Player%", target.getName());
                            target.sendMessage(FakeOP);
                            p.sendMessage(Troll.Prefix + "§7Die FakeOP Message wurde an �c" + target.getName() + "�7 weitergeleitet!");

                        }else{
                            p.sendMessage(Troll.Prefix + "�cDieser Spieler ist nicht online!");
                        }
                    }
                }
                else if(args[0].equalsIgnoreCase("fakedeop")){
                    if(p.hasPermission("troll.allow")){
                        Player target = Bukkit.getPlayer(args[1]);
                        if(target != null){
                            p.sendMessage(Troll.Prefix + "�7Die FakeDEOP Message wurde an §c" + target.getName() + "�7 weitergeleitet!");
                            String FakeOP = Troll.FakeDEOPMessage.replace("%Player%", target.getName());
                            target.sendMessage(FakeOP);
                        }else{
                            p.sendMessage(Troll.Prefix + "$cDieser Spieler ist nicht online!");
                        }
                    }
                }else if(args[0].equalsIgnoreCase("spam")){
                    if(p.hasPermission("troll.allow")){
                        Player target = Bukkit.getPlayer(args[1]);
                        if(!spamlist.contains(target)){
                            spamlist.add(target);
                            if(target != null){
                                p.sendMessage(Troll.Prefix + "§7Der Spieler wird nun genervt :)");

                                spamint = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable(){

                                    @Override
                                    public void run() {
                                        int wert = (int) ((Math.random()*9999)+1);
                                        target.sendMessage("§7[Server: �fException in thread #" + wert +"�7]");
                                    }

                                }, 1, 10);

                            }else{
                                p.sendMessage(Troll.Prefix + "$cDer Spieler ist nicht online!");
                            }
                        }else{
                            p.sendMessage(Troll.Prefix + "$cDer Spieler wird nicht mehr genervt :c");
                            Bukkit.getScheduler().cancelTask(spamint);
                            spamlist.remove(target);

                        }
                    }
                }
            }else if(args.length == 3){
                if(args[0].equalsIgnoreCase("lag")){
                    if(args[1].equalsIgnoreCase("an")){
                        Player target = Bukkit.getPlayer(args[2]);
                        Utils.MoveList.add(target);
                        p.sendMessage(Troll.Prefix + "§c" + target.getName() + "§7 buggt herum :)");
                    }else if(args[1].equalsIgnoreCase("aus")){
                        Player target = Bukkit.getPlayer(args[2]);
                        Utils.MoveList.remove(target);
                        p.sendMessage(Troll.Prefix + "§c" + target.getName() + "§7 buggt nicht mehr herum :(");
                    }
                }
            }




        }
        return false;
    }
}
