package io.github.lukeeff.luckyblocks.config;

import com.sun.media.jfxmedia.logging.Logger;
import io.github.lukeeff.luckyblocks.LuckyBlocks;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * The ConfigManager class's responsibility is
 * to establish a connection to the config file
 * and provide a reference to the contents inside
 * of it.
 *
 * ConfigManager also takes care of the creation
 * of the config file and the data folder when
 * it does not exist.
 *
 * @author lukeeff
 * @since 4/26/2020
 */
public class ConfigManager {

    @Getter private final LuckyBlocks plugin;
    @Getter @Setter private FileConfiguration config;
    @Getter @Setter private File configFile;

    /**
     * Constructor for ConfigManager. Assigns instance to
     * the main class and gets a connection to the config
     * file.
     *
     * @param plugin the instance to the main class.
     */
    public ConfigManager(@NonNull final LuckyBlocks plugin) {
        this.plugin = plugin;
        createRootDirectory();
        createConfigFile();
        loadConfig();
    }

    /**
     * Creates root plugin folder directory
     */
    private void createRootDirectory() {
        final File folder = getPlugin().getDataFolder();
        if (!folder.exists() && folder.mkdirs()) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Config folder created successfully.");
        }
    }

    /**
     * Initializes the configuration value
     * When a config file does not exist, a
     * brand new config file with the compiled
     * config values is written
     */
    private void loadConfig() {
        setConfig(new YamlConfiguration());
        try {
            getConfig().load(getConfigFile());
        } catch (InvalidConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the configuration file. Required to update news values inputted by a user.
     */
    public void saveConfig() {
        try {
            getConfig().save(createConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the config file from the plugin folder
     *
     * This method looks for an existing config
     * file inside of its root folder and return it.
     * When it is not found, it creates a new config.yml
     * file and returns the information inside of the
     * default config instead
     *
     * @return A reference to the config file in the dataFolder
     */
    private File createConfigFile() {
        setConfigFile(new File(getPlugin().getDataFolder(), "config.yml"));
        if(!getConfigFile().exists()) {
            getPlugin().saveDefaultConfig();
        }
        return configFile;
    }

}
