package de.near.troll;

import de.near.troll.commands.CrashCommand;
import de.near.troll.commands.TrollCommands;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Troll extends JavaPlugin {
    public static String Prefix = "§8§ ";
    public static String FakeOPMessage;
    public static String FakeDEOPMessage;

    public void onEnable(){
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2Troll Plugin wurde gestartet!");
        getCommand("troll").setExecutor(new TrollCommands(this));
        getCommand("crash").setExecutor(new CrashCommand(this));
        File file = new File("plugins//Troll//config.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if(cfg.get("FakeOPMessage") == null){
            cfg.set("FakeOPMessage", "§7[Server: Oppend %Player%]");
            try {
                cfg.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(cfg.get("FakeDEOPMessage") == null){
            cfg.set("FakeDEOPMessage", "§7[Server: De-opped %Player%]");
            try {
                cfg.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        registerMessagesFromConfig();
    }
    public void registerMessagesFromConfig(){
        File file = new File("plugins//Troll//config.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        FakeOPMessage = cfg.getString("FakeOPMessage");
        FakeDEOPMessage = cfg.getString("FakeDEOPMessage");
    }
}
