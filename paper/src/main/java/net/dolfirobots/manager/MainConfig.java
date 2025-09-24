package net.dolfirobots.manager;

import net.dolfirobots.Main;
import org.bukkit.configuration.Configuration;

public class MainConfig {
    public static void reload() {
        Main.getInstance().saveDefaultConfig();
        Main.getInstance().reloadConfig();
    }
    public static Configuration getConfig() {
        return Main.getInstance().getConfig();
    }
    public static String prefix() {
        String prefix = getConfig().getString("prefix");
        if (prefix == null || prefix.replace(" ", "").isEmpty()) prefix = "&7[&bPlayer Sync&7]";
        return prefix + " ";
    }
}
