package net.dolfirobots.dolfi;

import net.dolfirobots.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;


import static net.dolfirobots.manager.MainConfig.prefix;
import static net.dolfirobots.dolfi.MessageAPI.sendConsole;

public class LogsManager implements Runnable {

    private static final String service = "Logs";
    private static final File logsFolder = new File(Main.getInstance().getDataFolder(), "logs");

    public static void register() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getInstance(), new LogsManager(), ChronoUnit.SECONDS.between(LocalDateTime.now(), LocalDateTime.now().toLocalDate().plusDays(1).atStartOfDay()) * 20 , (24 * (60 * 60)) * 20);
        saveFile();
    }

    public static void saveFile() {
        if (!logsFolder.exists()) {
            if (!logsFolder.mkdir()) {
                newError(service, );
                sendConsole(prefix() + "§c[Logs] Error by creating the logs folder!");
            }
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(new Date());
            File logFile = new File(logsFolder, "log_" + dateString + ".log");
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
        } catch (IOException e) {
            sendConsole(prefix() + "§c[Logs] Error by creating the log file: " + e.getMessage());
        }
    }

    public static void newLogEntry(String provider, String logEntry) {
        saveFile();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timestampFormatter = new SimpleDateFormat("HH:mm:ss");
        String timestamp = timestampFormatter.format(new Date());

        File logFile = new File(logsFolder, "log_" + formatter.format(new Date()) + ".log");
        new TextFilesAPI(new CustomConfigAPI(logFile)).addLine(timestamp + " [" + provider + "] " + logEntry);
    }

    public static void newError(String service, String message) {
        sendConsole(prefix() + "[§c" + message + "§7] " + message);
        message = ChatColor.stripColor(message);
        newLogEntry(service, message);
    }
    public static void newError(String provider, String message, Player player) {
        player.sendMessage(prefix() + message);
        sendConsole(prefix() + "§c" + message);
        message = ChatColor.stripColor(message);
        newLogEntry(provider, message);
    }

    @Override
    public void run() {
        saveFile();
    }
}
