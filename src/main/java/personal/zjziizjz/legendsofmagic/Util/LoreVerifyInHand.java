package personal.zjziizjz.legendsofmagic.Util;

import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.regex.Pattern;

public class LoreVerifyInHand {
    public boolean hasItemWithLoreInHand(Player player, String lore) {
        ItemMeta itemMeta=player.getInventory().getItemInMainHand().getItemMeta();
        if (itemMeta.hasLore()) {
            String line = itemMeta.getLore().toString();
            return line.matches(".*" + Pattern.quote(lore) + ".*");
        }else {
            return false;
        }
    }
}
