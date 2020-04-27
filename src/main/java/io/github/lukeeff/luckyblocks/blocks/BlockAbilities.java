package io.github.lukeeff.luckyblocks.blocks;

import io.github.lukeeff.luckyblocks.util.WeightUtil;
import lombok.Getter;

import java.util.*;

abstract public class BlockAbilities implements LuckyBlockInterface {

    //Holds all registered abilities.
    //The double's purpose is to establish a range for the random function.
    @Getter private static final Map<LuckyBlockInterface, Double> ROLL_MAP = new HashMap<>();


    /**
     * Registers a new ability.
     *
     * @param ability the ability.
     */
    private void registerAbility(LuckyBlockInterface ability) {
        if(ability.isEnabled() && ability.getWeight() > 0) {
            final double collectiveWeight = WeightUtil.getCollectiveWeight(getROLL_MAP().values());
            final double weight = ability.getWeight();
            getROLL_MAP().put(ability, collectiveWeight + weight);
        }
    }

}
