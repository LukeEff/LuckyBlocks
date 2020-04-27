package io.github.lukeeff.luckyblocks.util;

import io.github.lukeeff.luckyblocks.blocks.LuckyBlockInterface;
import lombok.NonNull;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.DoubleStream;

public class WeightUtil {

    /**
     * Gets the largest value inside the probability map.
     *
     * @return the largest value inside the probability map or 0 if the map is empty.
     */
    public static double getCollectiveWeight(@NonNull final Collection<Double> valueSet) {
        return toDoubleStream(valueSet).max().orElse(0);
    }

    public static double getWeight(LuckyBlockInterface ability) {
        return ability.getWeight();
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
        return toDoubleStream(valueSet).filter(num -> key < num).min().orElse(getCollectiveWeight(valueSet));
    }

    /**
     * Converts a Set of Double objects to a DoubleStream.
     *
     * @param doubleCollection the set of doubles to be streamed.
     * @return a DoubleStream containing the doubleCollection values.
     */
    private static DoubleStream toDoubleStream(@NonNull final Collection<Double> doubleCollection) {
        return doubleCollection.stream().mapToDouble(num -> (double) num);
    }


}
