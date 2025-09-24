package net.dolfirobots.dolfi;

import net.dolfirobots.manager.MainConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageAPI {
    // Basic messages

    /**
     * Send a message in the console with prefix
     * @param msg
     */
    public static void sendConsole(String msg) {
        Bukkit.getConsoleSender().sendMessage(MainConfig.prefix() + "§7" + msg);
    }

    /**
     * Send a Player a message with prefix
     * @param player
     * @param msg
     */
    public static void sendMessage(String msg, Player player) {
        player.sendMessage(MainConfig.prefix() + "§7" + msg);
    }

    /**
     * Centers the message to make it looks better
     * @param message
     * @param length
     * @return String
     */
    public static String centerMessage(String message, int length) {
        return " ".repeat((length - ChatColor.stripColor(message).length()) / 2) + message;
    }
}
