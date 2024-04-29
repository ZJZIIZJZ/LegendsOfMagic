package personal.zjziizjz.legendsofmagic.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import personal.zjziizjz.legendsofmagic.LegendsOfMagic;
import personal.zjziizjz.legendsofmagic.Util.LoreVerify;

import java.util.Arrays;


public class ChestGUI implements Listener {

    private static final String GUI_TITLE = "Magic GUI";
    private static final int GUI_SIZE = 18;
    private static final String DRAGON_HEAD_NAME = "DragonFire!";
    private static final String BLAZE_EGG_NAME = "Fire!";
    private static final String SAPLING_NAME = "Reply!";

    private static final String HUAN_NAME = "Imprisoning!";

    private static final String NONE_NAME = "Unable to use";
    private static final String AURA_NAME = "Aura!";

    private static final String SLOW_NAME = "Slow!";
    private static final String DAMN_NAME = "Damn!";
    private static final String AURA2_NAME = "Holy Aura!";
    private static final String DIE_NAME = "Kill!";
    private static final String BLESSING_NAME = "Blessing!";
    public String mode = ChatColor.RED + "\u706b\u7403";

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getClickedInventory();
        if (inventory != null) {
            if (inventory.getTitle().equals("Magic GUI")) {
                event.setCancelled(true);
                LegendsOfMagic plugin = (LegendsOfMagic) Bukkit.getPluginManager().getPlugin("LegendsOfMagic");
                Bukkit.getScheduler().runTaskLater(plugin, () -> event.setCancelled(false), 1L);
            }
            Player player = (Player) event.getWhoClicked();
            ItemStack item2 = event.getCurrentItem();
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            if (item2.hasItemMeta()) {
                if (item2.getItemMeta().getDisplayName().equals(DRAGON_HEAD_NAME)) {
                    mode = ChatColor.LIGHT_PURPLE + "\u9f99\u606f";
                    meta.addEnchant(Enchantment.DURABILITY, 1000, true);

                    meta.setDisplayName(ChatColor.GOLD + "Magic Wand" + ChatColor.BLUE + "[" + mode + ChatColor.BLUE + "]");
                    item.setItemMeta(meta);
                    player.sendMessage(ChatColor.YELLOW + "\u5df2\u5207\u6362\u81f3" + mode + ChatColor.YELLOW + "\u6a21\u5f0f");
                } else if (item2.getItemMeta().getDisplayName().equals(BLAZE_EGG_NAME)) {
                    mode = ChatColor.RED + "\u706b\u7403";
                    meta.addEnchant(Enchantment.DURABILITY, 999, true);
                    meta.setDisplayName(ChatColor.GOLD + "Magic Wand" + ChatColor.BLUE + "[" + mode + ChatColor.BLUE + "]");
                    item.setItemMeta(meta);
                    player.sendMessage(ChatColor.YELLOW + "\u5df2\u5207\u6362\u81f3" + mode + ChatColor.YELLOW + "\u6a21\u5f0f");
                } else if (item2.getItemMeta().getDisplayName().equals(SAPLING_NAME)) {

                    meta.addEnchant(Enchantment.DURABILITY, 1001, true);
                    mode = ChatColor.GREEN + "\u751f\u547d";
                    meta.setDisplayName(ChatColor.GOLD + "Magic Wand" + ChatColor.BLUE + "[" + mode + ChatColor.BLUE + "]");
                    item.setItemMeta(meta);
                    player.sendMessage(ChatColor.YELLOW + "\u5df2\u5207\u6362\u81f3" + mode + ChatColor.YELLOW + "\u6a21\u5f0f");
                } else if (item2.getItemMeta().getDisplayName().equals(AURA_NAME)) {

                    meta.addEnchant(Enchantment.DURABILITY, 1003, true);
                    mode = ChatColor.YELLOW + "\u5149\u73af";
                    meta.setDisplayName(ChatColor.GOLD + "Magic Wand" + ChatColor.BLUE + "[" + mode + ChatColor.BLUE + "]");
                    item.setItemMeta(meta);
                    player.sendMessage(ChatColor.YELLOW + "\u5df2\u5207\u6362\u81f3" + mode + ChatColor.YELLOW + "\u6a21\u5f0f");
                } else if (item2.getItemMeta().getDisplayName().equals(HUAN_NAME)) {

                    meta.addEnchant(Enchantment.DURABILITY, 1002, true);
                    mode = ChatColor.DARK_PURPLE + "\u7981\u9522";
                    meta.setDisplayName(ChatColor.GOLD + "Magic Wand" + ChatColor.BLUE + "[" + mode + ChatColor.BLUE + "]");
                    item.setItemMeta(meta);
                    player.sendMessage(ChatColor.YELLOW + "\u5df2\u5207\u6362\u81f3" + mode + ChatColor.YELLOW + "\u6a21\u5f0f");

                }//寒冰
                else if (item2.getItemMeta().getDisplayName().equals(SLOW_NAME)) {

                    meta.addEnchant(Enchantment.DURABILITY, 1004, true);
                    mode = ChatColor.BLUE + "\u5bd2\u51b0";
                    meta.setDisplayName(ChatColor.GOLD + "Magic Wand" + ChatColor.BLUE + "[" + mode + ChatColor.BLUE + "]");
                    item.setItemMeta(meta);
                    player.sendMessage(ChatColor.YELLOW + "\u5df2\u5207\u6362\u81f3" + mode + ChatColor.YELLOW + "\u6a21\u5f0f");

                } else if (item2.getItemMeta().getDisplayName().equals(DAMN_NAME)) {
//诅咒
                    meta.addEnchant(Enchantment.DURABILITY, 1005, true);
                    mode = ChatColor.DARK_GREEN + "\u8bc5\u5492";
                    meta.setDisplayName(ChatColor.GOLD + "Magic Wand" + ChatColor.BLUE + "[" + mode + ChatColor.BLUE + "]");
                    item.setItemMeta(meta);
                    player.sendMessage(ChatColor.YELLOW + "\u5df2\u5207\u6362\u81f3" + mode + ChatColor.YELLOW + "\u6a21\u5f0f");
                } else if (item2.getItemMeta().getDisplayName().equals(AURA2_NAME)) {
                    //圣光
                    meta.addEnchant(Enchantment.DURABILITY, 1006, true);
                    mode = ChatColor.YELLOW + "\u5723\u5149\u73af";
                    meta.setDisplayName(ChatColor.GOLD + "Magic Wand" + ChatColor.BLUE + "[" + mode + ChatColor.BLUE + "]");
                    item.setItemMeta(meta);
                    player.sendMessage(ChatColor.YELLOW + "\u5df2\u5207\u6362\u81f3" + mode + ChatColor.YELLOW + "\u6a21\u5f0f");
                } else if (item2.getItemMeta().getDisplayName().equals(DIE_NAME)) {
//禁术
                    meta.addEnchant(Enchantment.DURABILITY, 1007, true);
                    mode = ChatColor.MAGIC + "..." + ChatColor.RED + "\u7981\u672f";
                    meta.setDisplayName(ChatColor.GOLD + "Magic Wand" + ChatColor.BLUE + "[" + mode + ChatColor.BLUE + "]");
                    item.setItemMeta(meta);
                    player.sendMessage(ChatColor.YELLOW + "\u5df2\u5207\u6362\u81f3" + mode + ChatColor.YELLOW + "\u6a21\u5f0f");
                } else if (item2.getItemMeta().getDisplayName().equals(BLESSING_NAME)) {

                    meta.addEnchant(Enchantment.DURABILITY,1008,true);
                    mode = ChatColor.MAGIC + "..." + ChatColor.YELLOW+"\u5e87\u4f51 ";
                    meta.setDisplayName(ChatColor.GOLD + "Magic Wand" + ChatColor.BLUE + "[" + mode + ChatColor.BLUE + "]");
                    item.setItemMeta(meta);

                }
            }
        }

    }

    public void openGui(Player player) {
        Inventory inventory = Bukkit.createInventory(new MyInventoryHolder(), GUI_SIZE, GUI_TITLE);

        // 添加龙damn选项
        ItemStack dragonHead = new ItemStack(Material.DRAGON_EGG);
        ItemMeta dragonHeadMeta = dragonHead.getItemMeta();
        dragonHeadMeta.setDisplayName(DRAGON_HEAD_NAME);
        dragonHeadMeta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + "\u9f99\u606f\nCD:8s"));
        dragonHead.setItemMeta(dragonHeadMeta);
        inventory.setItem(0, dragonHead);

        // 添加烈焰damn选项
        ItemStack blazeEgg = new ItemStack(Material.FIREBALL);
        ItemMeta blazeEggMeta = blazeEgg.getItemMeta();
        blazeEggMeta.setDisplayName(BLAZE_EGG_NAME);
        blazeEggMeta.setLore(Arrays.asList(ChatColor.RED + "\u706b\u7403\nCD:2s"));
        blazeEgg.setItemMeta(blazeEggMeta);
        inventory.setItem(1, blazeEgg);

        // 添加金pp选项
        ItemStack sapling = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta saplingMeta = sapling.getItemMeta();
        saplingMeta.setDisplayName(SAPLING_NAME);
        saplingMeta.setLore(Arrays.asList(ChatColor.GREEN + "\u751f\u547d\nCD:25s"));
        sapling.setItemMeta(saplingMeta);
        inventory.setItem(2, sapling);

        ItemStack huan = new ItemStack(Material.IRON_FENCE);
        ItemMeta huanMeta = huan.getItemMeta();
        huanMeta.setDisplayName(HUAN_NAME);
        huanMeta.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "\u7981\u9522\nCD:30s"));
        huan.setItemMeta(huanMeta);
        inventory.setItem(3, huan);

        ItemStack aura = new ItemStack(Material.BEACON);
        ItemMeta auraMeta = aura.getItemMeta();
        auraMeta.setDisplayName(AURA_NAME);
        auraMeta.setLore(Arrays.asList(ChatColor.YELLOW + "\u5149\u73af\nCD:30s"));
        aura.setItemMeta(auraMeta);
        inventory.setItem(4, aura);
        if (new LoreVerify().hasItemWithLore(player, "\u4f7f\u4f606*6\u8303\u56f4\u5185\u7684\u654c\u4eba\u901f\u5ea6\u964d\u4f4e50%")) {
            ItemStack NONE3 = new ItemStack(Material.SNOW_BALL);
            ItemMeta NONE3Meta = NONE3.getItemMeta();
            NONE3Meta.setDisplayName(SLOW_NAME);
            NONE3Meta.setLore(Arrays.asList(ChatColor.BLUE + "\u5bd2\u51b0", "CD:25"));
            NONE3.setItemMeta(NONE3Meta);
            inventory.setItem(5, NONE3);
        } else {

            ItemStack NONE3 = new ItemStack(Material.BARRIER);
            ItemMeta NONE3Meta = NONE3.getItemMeta();
            NONE3Meta.setDisplayName(NONE_NAME
            );
            NONE3Meta.setLore(Arrays.asList(ChatColor.RED + "\u672a\u89e3\u9501"));
            NONE3.setItemMeta(NONE3Meta);
            inventory.setItem(5, NONE3);
        }
        if (new LoreVerify().hasItemWithLore(player, "\u7ed9\u4e88\u5bf9\u624b\u5929\u8c34\u6548\u679c,\u654c\u4eba\u79fb\u52a8\u65f6\u4f1a\u53d7\u5230\u96f7\u51fb\u7684\u771f\u5b9e\u4f24\u5bb3")) {
            ItemStack NONE2 = new ItemStack(Material.ROTTEN_FLESH);
            ItemMeta NONE2Meta = NONE2.getItemMeta();
            NONE2Meta.setDisplayName(DAMN_NAME);
            NONE2Meta.setLore(Arrays.asList(ChatColor.DARK_GREEN + "\u8bc5\u5492", "CD:25s"));
            NONE2.setItemMeta(NONE2Meta);
            inventory.setItem(6, NONE2);
        } else {
            ItemStack NONE2 = new ItemStack(Material.BARRIER);
            ItemMeta NONE2Meta = NONE2.getItemMeta();
            NONE2Meta.setDisplayName(NONE_NAME);
            NONE2Meta.setLore(Arrays.asList(ChatColor.RED + "\u672a\u89e3\u9501"));
            NONE2.setItemMeta(NONE2Meta);
            inventory.setItem(6, NONE2);
        }
        if (new LoreVerify().hasItemWithLore(player, "\u4e24\u500d\u6548\u679c\u7684\u5149\u73af")) {
            ItemStack NONE1 = new ItemStack(Material.TOTEM);
            ItemMeta NONE1Meta = NONE1.getItemMeta();
            NONE1Meta.setDisplayName(AURA2_NAME);
            NONE1Meta.setLore(Arrays.asList(ChatColor.YELLOW + "\u5723\u5149\u73af", "CD:50s"));
            NONE1.setItemMeta(NONE1Meta);
            inventory.setItem(7, NONE1);
        } else {
            ItemStack NONE1 = new ItemStack(Material.BARRIER);
            ItemMeta NONE1Meta = NONE1.getItemMeta();
            NONE1Meta.setDisplayName(NONE_NAME);
            NONE1Meta.setLore(Arrays.asList(ChatColor.RED + "\u672a\u89e3\u9501"));
            NONE1.setItemMeta(NONE1Meta);
            inventory.setItem(7, NONE1);
        }
        if (new LoreVerify().hasItemWithLore(player, "25%\u6982\u7387\u76f4\u63a5\u6740\u6b7b\u4f60\u7684\u654c\u4eba")) {
            ItemStack NONE = new ItemStack(Material.COMMAND);
            ItemMeta NONEMeta = NONE.getItemMeta();
            NONEMeta.setDisplayName(DIE_NAME);
            NONEMeta.setLore(Arrays.asList(ChatColor.MAGIC + "..." + ChatColor.RED + "\u7981\u672f", "CD:50s"));
            NONE.setItemMeta(NONEMeta);
            inventory.setItem(8, NONE);
        } else {

            ItemStack NONE = new ItemStack(Material.BARRIER);
            ItemMeta NONEMeta = NONE.getItemMeta();
            NONEMeta.setDisplayName(NONE_NAME);
            NONEMeta.setLore(Arrays.asList(ChatColor.RED + "\u672a\u89e3\u9501"));
            NONE.setItemMeta(NONEMeta);
            inventory.setItem(8, NONE);
        }
        if (new LoreVerify().hasItemWithLore(player,"\u83b7\u5f97\u9b54\u6cd5\u7011\u5e03\u7684\u5e87\u4f51,\u62b5\u6d88\u4e0b\u4e00\u6b21\u4f24\u5bb3\uff01[\u5305\u62ec\u7981\u672f]")){
            ItemStack NONE = new ItemStack(Material.TOTEM);
            ItemMeta NONEMeta = NONE.getItemMeta();
            NONEMeta.setDisplayName(BLESSING_NAME);
            NONEMeta.setLore(Arrays.asList(ChatColor.YELLOW + "\u5e87\u4f51","CD:120s"));
            NONE.setItemMeta(NONEMeta);
            inventory.setItem(9, NONE);
        }else {
            ItemStack NONE = new ItemStack(Material.BARRIER);
            ItemMeta NONEMeta = NONE.getItemMeta();
            NONEMeta.setDisplayName(NONE_NAME);
            NONEMeta.setLore(Arrays.asList(ChatColor.RED + "\u672a\u89e3\u9501"));
            NONE.setItemMeta(NONEMeta);
            inventory.setItem(9, NONE);
        }
        player.openInventory(inventory);
    }

    private static class MyInventoryHolder implements InventoryHolder {
        @Override
        public Inventory getInventory() {
            return null;
        }
    }
}
