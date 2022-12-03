package de.craftsblock.craftscore.minecraft.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemBuilder {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemBuilder(Material material) {
        this(material, 1);
    }

    public ItemBuilder(Material material, int amount) {
        itemStack = new ItemStack(material, amount);
        itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder withName(String name) {
        itemMeta.setDisplayName(name.replace("&", "§"));
        return this;
    }

    public ItemBuilder withLore(String... lore) {
        itemMeta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder withEnchantment(Enchantment enchantment, int level) {
        itemMeta.addEnchant(enchantment, level, false);
        return this;
    }

    public ItemBuilder withFlags(ItemFlag itemFlag, ItemFlag... itemFlags) {
        itemMeta.addItemFlags(itemFlag);
        itemMeta.addItemFlags(itemFlags);
        return this;
    }

    public ItemBuilder withFlags(ItemFlag[] itemFlags) {
        itemMeta.addItemFlags(itemFlags);
        return this;
    }

    public ItemStack get() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemBuilder create(Material material) {
        return new ItemBuilder(material);
    }

    public static ItemBuilder create(Material material, int amount) {
        return new ItemBuilder(material, amount);
    }

}
