package net.noobblade.actionbarapi;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class ActionBarAPI extends JavaPlugin {
    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Server server =  getServer();
        getLogger().info(ChatColor.AQUA + plugin.getName() + ChatColor.GREEN + " has been enabled." );

    }
    //removed onDisable() because nothing to do with that

}
