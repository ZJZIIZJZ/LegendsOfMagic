package personal.zjziizjz.legendsofmagic.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import personal.zjziizjz.legendsofmagic.Entity.Magic;
import personal.zjziizjz.legendsofmagic.Util.LoreDeduct;
import personal.zjziizjz.legendsofmagic.Util.LoreVerify;
import personal.zjziizjz.legendsofmagic.Util.MagicCircle;

import java.util.HashMap;
import java.util.Map;

public class UseMagic implements Listener {
    private final Map<Integer, Magic> magicMap = new HashMap<>();
    private final Map<Player, Long> lastUsedTimeMap = new HashMap<>();

    public UseMagic() {
        magicMap.put(999, new Magic("Fireball", 999, 3_000));
        magicMap.put(1000, new Magic("Dragonball", 1000, 8_000));
        magicMap.put(1001, new Magic("Heal", 1001, 25_000));
        magicMap.put(1002, new Magic("Missiles", 1002, 30_000));
        magicMap.put(1003, new Magic("Buff", 1003, 25_000));
        magicMap.put(1004, new Magic("Slow", 1004, 25_000));
        magicMap.put(1005, new Magic("Damnation", 1005, 25_000));
        magicMap.put(1006, new Magic("Power", 1006, 50_000));
        magicMap.put(1007, new Magic("Kill", 1007, 50_000));
        magicMap.put(1008,new Magic("Blees",1008,120_000));
        magicMap.put(1009,new Magic("SlowArrow",1009,2_000));
        magicMap.put(1010,new Magic("FireRain",1010,10_000));
        magicMap.put(1011,new Magic("Earthquake",1011,15_000));
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand() == null) {
            return;
        }
        ItemStack item = player.getInventory().getItemInMainHand();
        if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) && item.getType() == Material.STICK) {
            if (item.hasItemMeta() && item.getItemMeta().hasEnchant(Enchantment.DURABILITY)) {
                int enchantLevel = item.getEnchantmentLevel(Enchantment.DURABILITY);
                Magic magic = magicMap.get(enchantLevel);
                if (magic != null) {
                    if (checkCanUseMagic(player, magic)) {
                        new MagicCircle().generate(player);
                        magic.use(player);
                        lastUsedTimeMap.put(player, System.currentTimeMillis());
                    } else {
                        player.sendMessage(ChatColor.RED + "\u4f60\u9700\u8981\u7b49\u5f85" + (magic.getUseDelay() / 1000) + "\u79d2\u540e\u624d\u80fd\u4f7f\u7528\u6b64\u9b54\u6cd5");
                    }
                }
            }
        }
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (item.getType() == Material.STICK && item.hasItemMeta() && item.getItemMeta().hasEnchant(Enchantment.DURABILITY)) {
                int enchantLevel = item.getEnchantmentLevel(Enchantment.DURABILITY);
                    player.performCommand("magic2 chest");

            }
        }
    }

    private boolean checkCanUseMagic(Player player, Magic magic) {
        long lastUsedTime = lastUsedTimeMap.getOrDefault(player, 0L);
        long currentTime = System.currentTimeMillis();
        if (new LoreVerify().hasItemWithLore(player,"\u653e\u5165\u80cc\u5305\u5185\u53ef\u62b5\u6d88\u4e00\u6b21\u9b54\u6cd5\u51b7\u5374\u65f6\u95f4,\u6bcf\u6b21\u6d88\u8017\u4e00\u5f20")){
            new LoreDeduct().LoreDeduct(player,"\u653e\u5165\u80cc\u5305\u5185\u53ef\u62b5\u6d88\u4e00\u6b21\u9b54\u6cd5\u51b7\u5374\u65f6\u95f4,\u6bcf\u6b21\u6d88\u8017\u4e00\u5f20");
            return true;
        }
        return currentTime - lastUsedTime >= magic.getUseDelay();
    }
}
