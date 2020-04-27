package io.github.lukeeff.luckyblocks;

import io.github.lukeeff.luckyblocks.config.ConfigManager;
import io.github.lukeeff.luckyblocks.config.ConfigUtil;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class LuckyBlocks extends JavaPlugin {

    @Getter private ConfigUtil configUtil;
    @Getter private ConfigManager configManager;

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

}
