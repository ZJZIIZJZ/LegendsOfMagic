package personal.zjziizjz.legendsofmagic.Listener.MagicBook;

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

public class MysteryMagicBook implements Listener {


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            for (int i=0;i<player.getInventory().getItemInMainHand().getAmount();i++){
            if (meta.hasLore() && meta.getLore().contains(ChatColor.GOLD + "\u5b83\u53ef\u4ee5\u8ba9\u4f60\u5b66\u4e60\u5230\u4e0d\u540c\u7684\u9b54\u6cd5\u4ee5\u89e3\u9501\u4f60\u9b54\u6cd5\u83dc\u5355\u4e2d\u7684\u6cd5\u672f")) {
                String magicget = RandomMagic.getRandomMagic();
                ItemStack MagicBook = new ItemStack(Material.PAPER);
                ItemMeta MagicBookMeta = MagicBook.getItemMeta();
                MagicBookMeta.setDisplayName(ChatColor.YELLOW + magicget);
                if (magicget.equals("\u5bd2\u51b0")) {
                    MagicBookMeta.setLore(Arrays.asList(ChatColor.GOLD+"\u4f7f\u4f606*6\u8303\u56f4\u5185\u7684\u654c\u4eba\u901f\u5ea6\u964d\u4f4e50%",
                            "CD:25s",
                            "\u8bf7\u52a1\u5fc5\u5c06\u6b64\u4e66\u7f6e\u4e8e\u80cc\u5305\u5185\u624d\u53ef\u4f7f\u7528\u6b64\u6cd5\u672f"));
                } else if (magicget.equals("\u7981\u672f")) {
                    MagicBookMeta.setLore(Arrays.asList(ChatColor.GOLD+"25%\u6982\u7387\u76f4\u63a5\u6740\u6b7b\u4f60\u7684\u654c\u4eba",
                            "CD:50s",
                            "\u8bf7\u52a1\u5fc5\u5c06\u6b64\u4e66\u7f6e\u4e8e\u80cc\u5305\u5185\u624d\u53ef\u4f7f\u7528\u6b64\u6cd5\u672f"));
                } else if (magicget.equals("\u5723\u5149\u73af")) {
                    MagicBookMeta.setLore(Arrays.asList(ChatColor.GOLD+"\u4e24\u500d\u6548\u679c\u7684\u5149\u73af",
                            "CD:50s",
                            "\u8bf7\u52a1\u5fc5\u5c06\u6b64\u4e66\u7f6e\u4e8e\u80cc\u5305\u5185\u624d\u53ef\u4f7f\u7528\u6b64\u6cd5\u672f"));
                } else if (magicget.equals("\u8bde\u5492")) {
                    MagicBookMeta.setLore(Arrays.asList(ChatColor.GOLD+"\u7ed9\u4e88\u5bf9\u624b\u5929\u8c34\u6548\u679c,\u654c\u4eba\u79fb\u52a8\u65f6\u4f1a\u53d7\u5230\u96f7\u51fb\u7684\u771f\u5b9e\u4f24\u5bb3",
                            "CD:25s"
                    ,   "\u8bf7\u52a1\u5fc5\u5c06\u6b64\u4e66\u7f6e\u4e8e\u80cc\u5305\u5185\u624d\u53ef\u4f7f\u7528\u6b64\u6cd5\u672f"));
                }
                MagicBook.setItemMeta(MagicBookMeta);
                player.getInventory().setItemInMainHand(MagicBook);
                player.sendMessage("\u4f60\u6253\u5f00\u4e86\u4e00\u672c\u795e\u79d8\u9b54\u6cd5\u4e66,\u83b7\u5f97" + ChatColor.YELLOW + magicget);
            }
            }
        }

    }
}



