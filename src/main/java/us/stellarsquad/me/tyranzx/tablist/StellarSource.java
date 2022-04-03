package us.stellersquad.me.tyranzx.tablist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.scheduler.BukkitScheduler;

public class StellarSource {

    public static BukkitScheduler sh = Bukkit.getServer().getScheduler();
    public static Server server = Bukkit.getServer();

    public static String c(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
