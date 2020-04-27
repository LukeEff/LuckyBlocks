package io.github.lukeeff.luckyblocks.blocks;

import io.github.lukeeff.luckyblocks.util.ChanceUtil;
import lombok.Getter;
import lombok.NonNull;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

abstract public class BlockAbilities implements LuckyBlockInterface{

    //Holds all registered abilities.
    @Getter private static final Map<String, LuckyBlockInterface> ROLL_MAP = new HashMap<>();
    @Getter private static final Map<Double, LuckyBlockInterface> CHANCE_MAP = new HashMap<>();

    /**
     * Registers a new ability.
     *
     * @param key the key for retrieving the ability.
     * @param ability the ability.
     */
    private void registerAbility(String key, LuckyBlockInterface ability) {
        if(ability.isEnabled()) {
            final double randomRange = ChanceUtil.getChanceValue(getCHANCE_MAP().keySet()) + ability.getChance();
            double random = ThreadLocalRandom.current().nextDouble(0, randomRange);
            getROLL_MAP().put(key, ability); //Identification
            getCHANCE_MAP().put(randomRange, ability); //Rolling
        }
    }




}
