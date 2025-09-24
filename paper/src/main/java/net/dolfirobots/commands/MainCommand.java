package net.dolfirobots.commands;

import net.dolfirobots.Main;
import net.dolfirobots.manager.MainConfig;
import net.dolfirobots.dolfi.GitHub;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MainCommand implements CommandExecutor, TabCompleter {

    public static void sendPlayerMessage(String message, CommandSender player) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', MainConfig.prefix()) + "§7" + message);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull org.bukkit.command.Command command, @NotNull String s, @NotNull String[] strings) {
        boolean noPermission = false;

        if (strings.length == 0) {
            sendPlayerMessage("-----------------------------------------", commandSender);
            sendPlayerMessage("§e" + centerMessage("OnlyProxy §7Plugin by §bDolfirobots", 41), commandSender);
            sendPlayerMessage(centerMessage("Loaded version: §e" + Main.getInstance().getDescription().getVersion(), 41), commandSender);
            sendPlayerMessage(centerMessage("Download it here:", 41), commandSender);
            sendPlayerMessage(centerMessage("https://github.com/Dolfirobots/OnlyProxy", 41), commandSender);
            sendPlayerMessage("-----------------------------------------", commandSender);
        } else if (strings.length == 1) {
            if (strings[0].equalsIgnoreCase("reload")) {
                if (!commandSender.hasPermission("onlyproxy.commands.reload")) {
                    noPermission = true;
                } else {
                    sendPlayerMessage("-----------------------------------------", commandSender);
                    sendPlayerMessage("§e" + centerMessage("Reloading Plugin OnlyProxy...", 41), commandSender);
                    MainConfig.reload();
                    sendPlayerMessage("§a" + centerMessage("Reloaded!", 41), commandSender);
                    sendPlayerMessage("-----------------------------------------", commandSender);
                }

            } else if (strings[0].equalsIgnoreCase("version")) {
                if (!commandSender.hasPermission("onlyproxy.commands")) {
                    noPermission = true;
                } else {

                    sendPlayerMessage("-----------------------------------------", commandSender);
                    sendPlayerMessage("§e" + centerMessage("Fetching last version...", 41), commandSender);

                    String lastetVersion = GitHub.getLastedVersion("Dolfirobots", GitHub.repo);

                    if (lastetVersion.equalsIgnoreCase(Main.getInstance().getDescription().getVersion())) {
                        sendPlayerMessage(centerMessage("Your version: §a" + Main.getInstance().getDescription().getVersion() + "§7 == §a" + lastetVersion, 41), commandSender);
                        sendPlayerMessage("§a" + centerMessage("Player Sync is up to date! (:", 41), commandSender);

                    } else if (!lastetVersion.equalsIgnoreCase("unknown")) {
                        sendPlayerMessage(centerMessage("Your version: §c" + Main.getInstance().getDescription().getVersion() + "§7 => §a" + lastetVersion, 41), commandSender);
                        sendPlayerMessage("§c" + centerMessage("Player Sync is not up to date! ):", 41), commandSender);
                        ArrayList<String> versions = GitHub.getAllVersions("Dolfirobots", GitHub.repo);

                        ArrayList<Integer> removeVersionIndex = new ArrayList<>();
                        int currentIndex = 0;

                        for (String version : versions) {
                            if (version.equalsIgnoreCase(Main.getInstance().getDescription().getVersion())) {
                                break;
                            }
                            removeVersionIndex.add(currentIndex);
                            currentIndex++;
                        }
                        for (int i = removeVersionIndex.size() - 1; i >= 0; i--) {
                            versions.remove((int) removeVersionIndex.get(i));
                        }

                        sendPlayerMessage(centerMessage("You are §e" + versions.size() + "§7 versions behind!", 41), commandSender);
                        sendPlayerMessage(centerMessage("Please download it here:", 41), commandSender);
                        sendPlayerMessage(centerMessage("https://github.com/Dolfirobots/" + GitHub.repo + "/", 41), commandSender);
                    } else {
                        sendPlayerMessage(centerMessage("Your version: " + Main.getInstance().getDescription().getVersion(), 41), commandSender);
                        sendPlayerMessage(centerMessage("§eWe couldn't check the lasted version!", 41), commandSender);
                        sendPlayerMessage(centerMessage("Please check the internet", 41), commandSender);
                        sendPlayerMessage(centerMessage("connection from your Server.", 41), commandSender);
                    }
                    sendPlayerMessage("-----------------------------------------", commandSender);
                }
            } else {
                sendPlayerMessage("-----------------------------------------", commandSender);
                if (commandSender.hasPermission("onlyproxy.commands")) {
                    sendPlayerMessage(centerMessage("§cUsage: §e/" + s + " [reload/version]", 41), commandSender);
                } else {
                    sendPlayerMessage(centerMessage("§cUsage: §e/" + s, 41), commandSender);
                }
                sendPlayerMessage("-----------------------------------------", commandSender);
            }
        } else {
            sendPlayerMessage("-----------------------------------------", commandSender);
            if (commandSender.hasPermission("onlyproxy.commands")) {
                sendPlayerMessage(centerMessage("§cUsage: §e/" + s + " [reload/version]", 41), commandSender);
            } else {
                sendPlayerMessage(centerMessage("§cUsage: §e/" + s, 41), commandSender);
            }
            sendPlayerMessage("-----------------------------------------", commandSender);
        }

        if (noPermission) {
            sendPlayerMessage("-----------------------------------------", commandSender);
            sendPlayerMessage("§c" + centerMessage("You don't have the Permission", 41), commandSender);
            sendPlayerMessage("§c" + centerMessage("for this command!", 41), commandSender);
            sendPlayerMessage("-----------------------------------------", commandSender);
        }
        return true;
    }
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull org.bukkit.command.Command command, @NotNull String s, @NotNull String[] strings) {
        List<String> list = new ArrayList<>();
        if (commandSender.hasPermission("onlyproxy.commands")) {
            if (strings.length == 1) {
                list.add("reload");
                list.add("version");
            }
        }
        return list;
    }
}
