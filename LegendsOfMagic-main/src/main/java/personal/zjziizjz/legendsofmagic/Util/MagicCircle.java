package personal.zjziizjz.legendsofmagic.Util;

import org.bukkit.*;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import personal.zjziizjz.legendsofmagic.LegendsOfMagic;

public class MagicCircle {
            public void generate(Player player) {
                // 生成魔法阵的粒子效果
                final int[] p = {0};
                Bukkit.getScheduler().runTaskTimer(
                        LegendsOfMagic.getPlugin(LegendsOfMagic.class),
                        new BukkitRunnable() {

                            public void run() {
                                if (p[0] >= 5) {
                                    return;
                                }
                                Location location=player.getLocation();
                                for (double t = 0; t < 20; t += 0.1) {
                                    double x = 0.5 * t * Math.cos(t);
                                    double y = 0.5 * t;
                                    double z = 0.5 * t * Math.sin(t);
                                    location.add(x, y, z);
                                    player.playEffect(location, Effect.HAPPY_VILLAGER, 0);
                                    location.subtract(x, y, z);
                                }
                                p[0]++;

                            }
                        }, 0, 3);

                player.sendMessage(ChatColor.BOLD+"\u4f7f\u7528\u9b54\u6cd5\u4e2d..");
                // 给玩家添加减速5的效果，持续2秒
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 4));


            }
        }



