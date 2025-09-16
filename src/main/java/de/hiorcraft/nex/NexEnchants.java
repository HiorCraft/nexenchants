package de.hiorcraft.nex;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.enchantments.Enchantment;

public final class NexEnchants extends JavaPlugin {

    public static Enchantment LUMBERJACK;

    @Override
    public void onEnable() {
        registerEnchants();
        getLogger().info("Lumberjack-Enchantment aktiviert!");
    }

    private void registerEnchants() {
        LUMBERJACK = new LumberjackEnchantment();

        try {
            Field byKeyField = Enchantment.class.getDeclaredField("byKey");
            Field byNameField = Enchantment.class.getDeclaredField("byName");

            byKeyField.setAccessible(true);
            byNameField.setAccessible(true);

            Map<?, ?> byKey = (Map<?, ?>) byKeyField.get(null);
            Map<?, ?> byName = (Map<?, ?>) byNameField.get(null);

            if (!byKey.containsKey(LUMBERJACK.getKey())) {
                Enchantment.registerEnchantment(LUMBERJACK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}