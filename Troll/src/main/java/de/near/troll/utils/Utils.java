package de.near.troll.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.ArrayList;

public class Utils {
    public static ArrayList<Player> MoveList = new ArrayList<Player>();
    public static void kick(Player target) {
        Inventory inv = Bukkit.createInventory((InventoryHolder)null, (int)1152000);
        target.openInventory(inv);
    }

}
