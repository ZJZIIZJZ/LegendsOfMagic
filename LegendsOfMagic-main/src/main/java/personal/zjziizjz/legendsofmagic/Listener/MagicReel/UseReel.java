package personal.zjziizjz.legendsofmagic.Listener.MagicReel;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.ShulkerBullet;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import personal.zjziizjz.legendsofmagic.LegendsOfMagic;
import personal.zjziizjz.legendsofmagic.Util.InCircleLocation;
import personal.zjziizjz.legendsofmagic.Util.LoreDeduct;
import personal.zjziizjz.legendsofmagic.Util.LoreVerifyInHand;

public class UseReel implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.LEFT_CLICK_AIR||event.getAction()==Action.LEFT_CLICK_BLOCK) {


            ItemMeta itemmeta = player.getInventory().getItemInMainHand().getItemMeta();
            if (new LoreVerifyInHand().hasItemWithLoreInHand(player, "\u5728\u4f60\u5468\u56f4\u521b\u5efa\u4e00\u4e2a\u5c5e\u4e8e\u4f60\u7684\u9886\u57df\uff01\u5728\u8303\u56f4\u5185 \u4f60\u5c06\u83b7\u5f97\u5927\u5e45\u5f3a\u5316-\u6301\u7eed\u65f6\u95f4 30\u79d2")) {
                player.sendTitle(ChatColor.RED + "\u6218\u6597\u5427", "\u5c5e\u4e8e\u6211\u7684\u9886\u57df\uff01");
                Location location = player.getLocation();
                player.sendMessage("\u4f60\u4f7f\u7528\u4e86\u9886\u57df\u5377\u8f74\uff01");
                new LoreDeduct().LoreDeduct(player, ChatColor.GOLD + "\u5728\u4f60\u5468\u56f4\u521b\u5efa\u4e00\u4e2a\u5c5e\u4e8e\u4f60\u7684\u9886\u57df\uff01\u5728\u8303\u56f4\u5185 \u4f60\u5c06\u83b7\u5f97\u5927\u5e45\u5f3a\u5316-\u6301\u7eed\u65f6\u95f4 30\u79d2");
                double x1 = location.getX() + 6;
                double y1 = location.getY() + 6;
                double z1 = location.getZ() + 6;
                double x2 = location.getX() - 6;
                double y2 = location.getY() - 6;
                double z2 = location.getZ() - 6;
                final double[] x = {location.getX()};
                double y = location.getY();
                double z = location.getZ();
                double y3 = y - 3.5;
                for (int n = 0; n < 14; n++) {
                    y3 = y3 + 0.75;
                    for (int i = 0; i <= 72; i++) {
                        double x3 = x[0] + 10 * Math.sin((double) i * Math.PI / 36.0);
                        //y轴是竖轴，z才是纵轴!
                        double z3 = z + 10 * Math.cos((double) i * Math.PI / 36.0);

                        player.spawnParticle(Particle.BARRIER, new Location(player.getWorld(), x3, y3, z3), 2);
                        World world = player.getWorld();

                    }
                    for (int i = 0; i <= 36; i++) {
                    double x3 = x[0] + 10 * Math.sin((double) i * Math.PI / 18.0);
                    //y轴是竖轴，z才是纵轴!
                    double z3 = z + 10 * Math.cos((double) i * Math.PI / 18.0);
                    Location location1 = new Location(player.getWorld(), x3, y3+10, z3);
                    ShulkerBullet missile = (ShulkerBullet) player.getWorld().spawnEntity(location1, EntityType.SHULKER_BULLET);
                    }


            }   final Location location1=player.getLocation();
                double x4=player.getLocation().getX();
                double z4=player.getLocation().getZ();
                final int[] p = {0};
                Bukkit.getScheduler().runTaskTimer(
                       LegendsOfMagic.getPlugin(LegendsOfMagic.class),
                        new BukkitRunnable() {

                    Player player=event.getPlayer();
                    public void run() {
                        if (p[0] >= 30) {
                        return;
                        }
                        p[0]++;
                        if (InCircleLocation.inBall(player, location1, 9)) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 40, 5));
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 5));
                            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 2000, 5));
                            for (int i = 0; i <= 36; i++) {
                                double x3 = x4 + 10 * Math.sin((double) i * Math.PI / 18.0);
                                double z3 = z4 + 10 * Math.cos((double) i * Math.PI / 18.0);
                                Location location1 = new Location(player.getWorld(), x3, player.getLocation().getY(), z3);
                                player.getWorld().spawnEntity(location1, EntityType.EVOKER_FANGS);
                                Location location2 = new Location(player.getWorld(), x3+0.5, player.getLocation().getY(), z3+0.5);
                                player.getWorld().spawnEntity(location2, EntityType.EVOKER_FANGS);
                                Location location3 = new Location(player.getWorld(), x3+1, player.getLocation().getY(), z3+1);
                                player.getWorld().spawnEntity(location3, EntityType.EVOKER_FANGS);
                            }

                        }
                    }}, 0, 20);



                }
        }
    }
}












