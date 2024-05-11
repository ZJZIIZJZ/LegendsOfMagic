package personal.zjziizjz.legendsofmagic;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import personal.zjziizjz.legendsofmagic.Listener.ChestGUI;
import personal.zjziizjz.legendsofmagic.Listener.DamageSetByEntiy;
import personal.zjziizjz.legendsofmagic.Listener.MagicBook.MysteryMagicBook;
import personal.zjziizjz.legendsofmagic.Listener.MagicReel.MagicReel;
import personal.zjziizjz.legendsofmagic.Listener.MagicReel.UseReel;
import personal.zjziizjz.legendsofmagic.Listener.OnPlayerDamage;
import personal.zjziizjz.legendsofmagic.Listener.UseMagic;

public class LegendsOfMagic extends JavaPlugin implements Listener {
    private boolean isClose=false;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OnPlayerDamage(),this);
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new MagicReel(), this);
        getServer().getPluginManager().registerEvents(new MysteryMagicBook(), this);
        getServer().getPluginManager().registerEvents(new UseMagic(), this);
        getServer().getPluginManager().registerEvents(new ChestGUI(),this);
        getServer().getPluginManager().registerEvents(new UseReel(),this);
        getServer().getPluginManager().registerEvents(new DamageSetByEntiy(),this);
        getLogger().info("MagicWandPlugin has been enabled!");
        this.getCommand("magic2").setExecutor(this);
// 注册 Fireball 类中的事件监听器

    }


    @Override
    public void onDisable() {
        getLogger().info("MagicWandPlugin has been disabled!");
        isClose=true;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("magic2") && sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 1 && args[0].equalsIgnoreCase("help")||args.length == 0) {
                player.sendMessage(ChatColor.YELLOW+"magic2\u63d2\u4ef6\u5e2e\u52a9\n/magic2 \u67e5\u770b\u5e2e\u52a9\n/magic2 wand <player> \u7ed9\u4e88\u6307\u5b9a\u73a9\u5bb6\u9b54\u6cd5\u68d2\n/magic2 list \u67e5\u770b\u53ef\u4ee5\u4f7f\u7528\u7684\u9b54\u6cd5\n/magic2 chest \u6253\u5f00\u9b54\u6cd5\u83dc\u5355\uff08\u7528\u4e8e\u5b66\u4e60\u9b54\u6cd5/\u5207\u6362\u9b54\u6cd5\n/magic book <player>\u7ed9\u4e88\u73a9\u5bb6\u4e00\u672c\u795e\u79d8\u9b54\u6cd5\u4e66\n/magic2 reel <player> \u7ed9\u4e88\u73a9\u5bb6\u4e00\u4e2a\u9b54\u6cd5\u5377\u8f74\n  Copyright 2024 © ZJZIIZJZ");
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("chest")) {
                new ChestGUI().openGui(player);
            }

            if (args.length == 2 && args[0].equalsIgnoreCase("book")) {
                if (player.isOp()==true) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target != null) {
                        ItemStack BOOK = new ItemStack(Material.BOOK);
                        ItemMeta BOOKMeta = BOOK.getItemMeta();
                        BOOKMeta.setDisplayName(
                                ChatColor.MAGIC+"....."+ChatColor.RED+"Mystery book"+ChatColor.BLUE+"[\u53f3\u952e\u70b9\u51fb\u6253\u5f00]");
                        BOOKMeta.setLore(java.util.Arrays.asList(ChatColor.GOLD + "\u5b83\u53ef\u4ee5\u8ba9\u4f60\u5b66\u4e60\u5230\u4e0d\u540c\u7684\u9b54\u6cd5\u4ee5\u89e3\u9501\u4f60\u9b54\u6cd5\u83dc\u5355\u4e2d\u7684\u6cd5\u672f"));
                        BOOK.setItemMeta(BOOKMeta);
                        target.getInventory().addItem(BOOK);
                        player.sendMessage("You have given a Mystery Magic book to " + target.getName() + "!");
                        return true;
                    } else {
                        player.sendMessage("Player not found!");
                        return true;
                    }
                }else {player.sendMessage("\u65e0\u6743\u9650");}}


            if (args.length == 2 && args[0].equalsIgnoreCase("reel")) {
                if (player.isOp()==true) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target != null) {
                        ItemStack Reel = new ItemStack(Material.PAPER);
                        ItemMeta ReelMeta = Reel.getItemMeta();
                        ReelMeta.setDisplayName(
                                ChatColor.MAGIC+"....."+ChatColor.YELLOW+"Mystery Reel"+ChatColor.BLUE+"[\u53f3\u952e\u70b9\u51fb\u6253\u5f00]");
                        ReelMeta.setLore(java.util.Arrays.asList(ChatColor.GOLD + "\u9b54\u6cd5\u7ef4\u5ea6\u7684\u6d88\u8017\u54c1,\u7528\u4e8e\u65bd\u5c55\u5404\u79cd\u9ad8\u7ea7\u9b54\u6cd5\u4ee5\u53ca\u8f85\u52a9\u6548\u679c"));
                        Reel.setItemMeta(ReelMeta);
                        target.getInventory().addItem(Reel);
                        player.sendMessage("You have given a Mystery Magic Reel to " + target.getName() + "!");
                        return true;
                    } else {
                        player.sendMessage("Player not found!");
                        return true;
                    }
                }else {player.sendMessage("\u65e0\u6743\u9650");}}


            if (args.length == 2 && args[0].equalsIgnoreCase("wand")) {
                if (player.isOp()) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target != null) {
                        ItemStack wand = new ItemStack(Material.STICK);
                        ItemMeta wandMeta = wand.getItemMeta();
                        wandMeta.setDisplayName("Magic Wand");
                        wandMeta.setLore(java.util.Arrays.asList(ChatColor.DARK_RED + "\u636e\u8bf4\u62e5\u6709\u5b83\u5c31\u53ef\u4ee5\u8bd5\u7528\u9b54\u6cd5\uff1f" + ChatColor.BLUE + "[\u53f3\u952e\u5207\u6362\u6a21\u5f0f]"));
                        wandMeta.addEnchant(Enchantment.DURABILITY, 999, true);
                        wand.setItemMeta(wandMeta);
                        target.getInventory().addItem(wand);
                        player.sendMessage("You have given a Magic Wand to " + target.getName() + "!");
                        return true;
                    } else {
                        player.sendMessage("Player not found!");
                        return true;
                    }
                }else {player.sendMessage("\u65e0\u6743\u9650");}
            }

        }

        return false;
    }
}
