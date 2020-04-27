package io.github.lukeeff.luckyblocks.entity;

import org.bukkit.inventory.ItemStack;

public interface EntityTemplateInterface {


    void setArmor(ItemStack helmet, ItemStack chestPlate, ItemStack leggings, ItemStack boots);

    void setWeapon(ItemStack weapon);

}
