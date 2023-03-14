package serverutils.serverutils.Item;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {

    public static ItemStack tool;

    public static void init() {

        createTool();

    }

    public static void createTool() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();

        meta.displayName(Component.text("§dStick"));
        meta.setCustomModelData(420);
        meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 10000, true);

        item.setItemMeta(meta);

        tool = item;
    }

}
