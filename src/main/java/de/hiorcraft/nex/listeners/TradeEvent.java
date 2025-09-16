package de.hiorcraft.nex.listeners;

import de.hiorcraft.nex.NexEnchants;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public class TradeEvent implements Listener {

    @EventHandler
    public void onVillagerTrade(VillagerAcquireTradeEvent event) {
        Villager villager = event.getEntity(); // <-- Hier bekommst du den Villager
        if (villager.getProfession() == Villager.Profession.LIBRARIAN) {
            ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) book.getItemMeta();
            meta.addStoredEnchant(NexEnchants.LUMBERJACK, 1, true);
            book.setItemMeta(meta);

            MerchantRecipe recipe = new MerchantRecipe(book, 5);
            recipe.addIngredient(new ItemStack(Material.EMERALD, 20));
            recipe.addIngredient(new ItemStack(Material.BOOK));

            event.setRecipe(recipe);
        }
    }
}
