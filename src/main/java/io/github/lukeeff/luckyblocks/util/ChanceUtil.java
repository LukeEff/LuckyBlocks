package io.github.lukeeff.luckyblocks.util;

import io.github.lukeeff.luckyblocks.blocks.LuckyBlockInterface;
import lombok.NonNull;

import java.util.Map;
import java.util.Set;
import java.util.stream.DoubleStream;

public class ChanceUtil {

    private static final int ceiling = 100;

    /**
     * Gets the largest value inside the probability map.
     *
     * @return the largest value inside the probability map or 0 if the map is empty.
     */
    public static double getChanceValue(@NonNull final Set<Double> valueSet) {
        return toDoubleStream(valueSet).max().orElse(0);
    }

    /**
     * Gets the closest larger value relative to a specified value
     * inside of a map.
     *
     * @param key the specified value to be looked for.
     * @param valueSet the set of values to be filtered.
     * @return a double that is the closest value that is larger than param value. Returns
     * the largest value in the set in the rare case that the key is larger than the biggest
     * value in the valueSet.
     */
    public static double getClosestLargerValue(@NonNull final double key, @NonNull final Set<Double> valueSet) {
        return toDoubleStream(valueSet).filter(num -> key < num).min().orElse(getChanceValue(valueSet));
    }

    /**
     * Converts a Set of Double objects to a DoubleStream.
     *
     * @param doubleSet the set to be streamed.
     * @return a DoubleStream containing the doubleSet values.
     */
    private static DoubleStream toDoubleStream(@NonNull final Set<Double> doubleSet) {
        return doubleSet.stream().mapToDouble(num -> num);
    }

    /**
     * Modifies the keys inside of the probability map to ensure
     * proper probability rolling.
     *
     * @param spaceUsed the space left in the probability field
     */
    private static void stretchValues(@NonNull final double spaceUsed, @NonNull final Map<Double, Object> map) {
        double spaceLeft = ceiling - spaceUsed;
        double addToEach = spaceLeft / map.size();
        for(double value : map.keySet()) {
            map.put(addToEach + value, map.remove(value));
        }
    }


    private void stretchValues(@NonNull final Map<Double, Object> map) {
        Set<Double> mapKeys = map.keySet();
        double spaceUsed = getChanceValue(mapKeys);
        if(spaceUsed < ceiling) {
            stretchValues(spaceUsed, map);
        }
    }

}
