package net.dolfirobots.dolfi;

import net.dolfirobots.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import static net.dolfirobots.dolfi.LogsManager.newError;

public class CustomConfigAPI {

    private final String service = "CustomConfigAPI";

    private File file;

    public CustomConfigAPI(File file) {
        if (file != null) {
            this.file = file;
        } else {
            newError("CustomConfigAPI","File is null!");
        }
    }

    public File getFile() {
        return file;
    }
    public void setFile(File file) {
        if (file != null) {
            this.file = file;
        } else {
            newError("CustomConfigAPI","File is null!");
        }
    }


    public YamlConfiguration getConfig() {
        if (getFile() != null) {
            if (getFile().exists()) {
                return YamlConfiguration.loadConfiguration(getFile());
            }
        }
        newError("CustomConfigAPI","File is null or not exists!");
        return null;
    }
    public void setConfig(YamlConfiguration config) {
        if (getFile() != null) {
            if (getFile().exists()) {
                try {
                    config.save(getFile());
                } catch (IOException e) {
                    newError("CustomConfigAPI","§cError by saving the file: §e" + e);
                    throw new RuntimeException(e);
                }
            } else {
                newError("CustomConfigAPI","File not exists!");
            }
        } else {
            newError("CustomConfigAPI","File is null!");
        }
    }

    public void registerConfig(String path) {
        if (getFile() != null) {
            if (!getFile().exists()) {
                Main.getInstance().saveResource(path, false);
            }
        } else {
            newError("CustomConfigAPI","File is null!");
        }
    }
}