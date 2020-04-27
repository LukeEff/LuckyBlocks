package io.github.lukeeff.luckyblocks.config;

import io.github.lukeeff.luckyblocks.LuckyBlocks;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Configuration utility class. Handles retrieval, storage,
 * and modification of data stored in the configuration
 * file.
 *
 * @author lukeeff
 * @since 4/26/2020
 */
public class ConfigUtil {

    @Getter private static final String COLOR_CODE_PATH = "color-code";

    @Getter private final LuckyBlocks plugin;
    @Getter private final FileConfiguration config;

    public ConfigUtil(LuckyBlocks plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfigManager().getConfig();
    }

    private Object getConfigObject(@NonNull final String path) {
        return getConfig().get(path);
    }

    /**
     * Gets a config string in color.
     *
     * @param path the path of the string.
     * @return the string from the config according to the colors defined by it.
     */
    private String getColoredConfigString(@NonNull final String path) {
        final String configString = getConfig().getString(path);
        return toColor(configString);
    }

    /**
     * Translates a string to color.
     *
     * @param string the string to be converted.
     * @return the string in color.
     */
    private String toColor(@NonNull final String string) {
        final char colorCode = (char) getConfigObject(getCOLOR_CODE_PATH());
        return ChatColor.translateAlternateColorCodes(colorCode, string);
    }

}
