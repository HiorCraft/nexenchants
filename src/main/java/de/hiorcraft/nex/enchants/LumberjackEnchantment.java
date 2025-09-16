package de.hiorcraft.nex.enchants;

import net.kyori.adventure.text.Component;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.NamespacedKey;

import java.util.Set;

public class LumberjackEnchantment extends Enchantment {

    public LumberjackEnchantment() {
        super(NamespacedKey.minecraft("lumberjack"));
    }

    @Override
    public Set<Enchantment> getExclusiveWith() {
        return Set.of();
    }

    @Override
    public String translationKey() {
        return "enchantment.nex.lumberjack";
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return item.getType().name().endsWith("_AXE");
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @Override
    public Component displayName(int level) {
        return Component.text("Lumberjack");
    }

    @Override
    public Set<EquipmentSlot> getActiveSlots() {
        return Set.of(EquipmentSlot.HAND);
    }
}