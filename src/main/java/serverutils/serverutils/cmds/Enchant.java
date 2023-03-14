package serverutils.serverutils.cmds;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import serverutils.serverutils.SubCommand;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Enchant extends SubCommand {
    @Override
    public String getName() { return "enchant"; }

    @Override
    public String getDescription() { return null; }

    @Override
    public String getSyntax() { return null; }

    @Override
    public void perform(Player player, String[] args) {

        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        try {
            meta.addEnchant(Enchantment.getByName(args[1]), Integer.parseInt(args[2]), true);
            item.setItemMeta(meta);
        } catch (IllegalArgumentException e) {
            player.sendMessage("you broke it");
        }


    }
    @Override
    public List<String> getSubcommandArguments(Player player, String[] args) {

        switch (args.length) {
            case 2:
                List<String> enchants = Arrays.stream(Enchantment.values())
                        .map(Enchantment::getName)
                        .collect(Collectors.toList());
                return enchants;
        }

        return null;
    }
}
