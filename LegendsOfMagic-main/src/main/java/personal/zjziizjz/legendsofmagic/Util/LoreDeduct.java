package personal.zjziizjz.legendsofmagic.Util;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.regex.Pattern;

public class LoreDeduct {
    public void LoreDeduct(Player player, String lore) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasLore()) {
                    for (String line : meta.getLore()) {
                        if (line.matches(".*" + Pattern.quote(lore) + ".*")) {
                            int amount = item.getAmount();

                            if (amount > 0) {
                                item.setAmount(amount - 1);
                                return;
                        }
                    }
                }
            }
        }
            player.updateInventory();

    }
}
}
