package net.dolfirobots;

import net.dolfirobots.dolfi.GitHub;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static net.dolfirobots.dolfi.MessageAPI.centerMessage;
import static net.dolfirobots.dolfi.MessageAPI.sendConsole;

public final class Main extends JavaPlugin {

    private static final String GITHUB_USER = "Dolfirobots";
    private static final String GITHUB_REPO = "PlayerSyncer";

    private static Main main;

    @Override
    public void onEnable() {
        main = this;
        int length = 29;
        String lastetVersion = GitHub.getLastedVersion(GITHUB_USER, GITHUB_REPO);
        String pluginVersion = getDescription().getVersion();

        sendConsole("-----------------------------");
        sendConsole(centerMessage("Player Sync is now §aenabled§7!", length));
        if (Bukkit.getServer().getMinecraftVersion().contains("1.21")) {
            sendConsole(centerMessage("MC Version: §aCompatible", length));
        } else {
            sendConsole(centerMessage("MC Version: §cNot Compatible", length));
        }
        if (pluginVersion.equalsIgnoreCase(lastetVersion)) {
            sendConsole(centerMessage("Version: §a" + pluginVersion, length));
        } else {
            sendConsole(centerMessage("Version: §c" + pluginVersion, length));
        }
        sendConsole("-----------------------------");

    }

    @Override
    public void onDisable() {
        int length = 29;
        String lastetVersion = GitHub.getLastedVersion(GITHUB_USER, GITHUB_REPO);
        String pluginVersion = getDescription().getVersion();

        sendConsole("-----------------------------");
        sendConsole(centerMessage("Player Sync is now §cdisabled§7!", length));
        if (Bukkit.getServer().getMinecraftVersion().contains("1.21")) {
            sendConsole(centerMessage("MC Version: §aCompatible", length));
        } else {
            sendConsole(centerMessage("MC Version: §cNot Compatible", length));
        }
        if (pluginVersion.equalsIgnoreCase(lastetVersion)) {
            sendConsole(centerMessage("Version: §a" + pluginVersion, length));
        } else {
            sendConsole(centerMessage("Version: §c" + pluginVersion, length));
            sendConsole(centerMessage("There is a new update outside!", length));
        }
        sendConsole("-----------------------------");
    }

    public static Main getInstance() {
        return main;
    }
}
