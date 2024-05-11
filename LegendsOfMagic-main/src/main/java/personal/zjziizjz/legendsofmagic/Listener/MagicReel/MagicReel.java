package personal.zjziizjz.legendsofmagic.Listener.MagicReel;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MagicReel implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            if (meta.hasLore() && meta.getLore().contains(ChatColor.GOLD + "\u9b54\u6cd5\u7ef4\u5ea6\u7684\u6d88\u8017\u54c1,\u7528\u4e8e\u65bd\u5c55\u5404\u79cd\u9ad8\u7ea7\u9b54\u6cd5\u4ee5\u53ca\u8f85\u52a9\u6548\u679c")) {
                for (int i=0;i<player.getInventory().getItemInMainHand().getAmount();i++){
                String Reelget = RandomReel.getRandomReel();
                ItemStack MagicReel = new ItemStack(Material.PAPER);
                ItemMeta MagicReelMeta = MagicReel.getItemMeta();
                MagicReelMeta.setDisplayName(ChatColor.YELLOW + Reelget);
                if (Reelget.equals("\u65e0\u9650\u5377\u8f74")) {
                    MagicReelMeta.setLore(Arrays.asList(ChatColor.GOLD+"\u653e\u5165\u80cc\u5305\u5185\u53ef\u62b5\u6d88\u4e00\u6b21\u9b54\u6cd5\u51b7\u5374\u65f6\u95f4,\u6bcf\u6b21\u6d88\u8017\u4e00\u5f20"));//无线卷轴

                } else if (Reelget.equals("\u9886\u57df\u5377\u8f74")) {
                    MagicReelMeta.setLore(Arrays.asList(ChatColor.GOLD+"\u5728\u4f60\u5468\u56f4\u521b\u5efa\u4e00\u4e2a\u5c5e\u4e8e\u4f60\u7684\u9886\u57df\uff01\u5728\u8303\u56f4\u5185 \u4f60\u5c06\u83b7\u5f97\u5927\u5e45\u5f3a\u5316-\u6301\u7eed\u65f6\u95f4 30\u79d2"));//领域卷轴

                }
                MagicReel.setItemMeta(MagicReelMeta);
                player.getInventory().setItemInMainHand(MagicReel);
                player.sendMessage("\u4f60\u6253\u5f00\u4e86\u4e00\u672c\u795e\u79d8\u9b54\u6cd5\u5377\u8f74,\u83b7\u5f97" + ChatColor.YELLOW + Reelget);
            }
        }}

    }


}
