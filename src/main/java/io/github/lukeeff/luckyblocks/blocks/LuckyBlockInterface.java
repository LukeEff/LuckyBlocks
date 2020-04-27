package io.github.lukeeff.luckyblocks.blocks;

public interface LuckyBlockInterface {

    /**
     * Gets the chance of the ability
     * activating.
     *
     * @return an double representing the
     * probability of the ability
     */
    double getWeight();

    /**
     * The logic behind the ability about
     * to occur.
     */
    void Ability();

    /**
     * Checks if an ability is enabled
     *
     * @return true if the ability is enabled
     */
    boolean isEnabled();

    /**
     * Gets the key used to identify the
     * ability
     *
     * @return a String representing the
     * key used to identify the ability
     */
    String getKey();



}
