package personal.zjziizjz.legendsofmagic.Entity;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import personal.zjziizjz.legendsofmagic.LegendsOfMagic;
import personal.zjziizjz.legendsofmagic.Util.InCircleLocation;

import java.util.List;
import java.util.Random;

//封装了使用魔法方法 获取魔法ID 时间等
public class Magic{

    private final String modeName;
    private final int modeId;
    private final long useDelay;

    public Magic(String modeName, int modeId, long useDelay) {
        this.modeName = modeName;
        this.modeId = modeId;
        this.useDelay = useDelay;
    }

    public String getModeName() {
        return modeName;
    }

    public int getModeId() {
        return modeId;
    }

    public long getUseDelay() {
        return useDelay;
    }

    public void use(Player player) {
        switch (modeId) {
            case 999:
                spawnFireball(player);
                break;
            case 1000:
                spawnDragonball(player);
                break;
            case 1001:
                regen(player);
                break;
            case 1002:
                Imprison(player);
                break;
            case 1003:
                buff(player);
                break;
            case 1004:
                slow(player);
                break;
            case 1005:
                damnation(player);
                break;
            case 1006:
                power(player);
                break;
            case 1007:
                kill(player);
                break;
            case 1008:
                bless(player);
                break;
            case 1009:
                frostArrow(player);
                break;
            case 1010:
                flameRain(player);
                break;
            case 1011:
                earthquake(player);
                break;
        }
    }

    private void spawnFireball(Player player) {
        Location loc = player.getEyeLocation();
        Vector dir = loc.getDirection().normalize();
        double x = dir.getX();
        double y = dir.getY();
        double z = dir.getZ();
        player.getWorld().spawnEntity(loc.add(x, y, z), EntityType.FIREBALL);
    }

    private void spawnDragonball(Player player){
        Location loc = player.getEyeLocation();
        Vector dir = loc.getDirection().normalize();
        player.launchProjectile(DragonFireball.class, dir);
    }

    private void regen(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5 * 20, 4));
        player.sendTitle("\u4f60\u7684\u4f24\u53e3\u5728\u6108\u5408...", "\u4f60\u7684\u4f24\u53e3\u5728\u6108\u5408", 10, 70, 20);
    }


    private void Imprison(Player player){
        List<Entity> nearbyEntities = player.getNearbyEntities(10, 10, 10);
        if (nearbyEntities.isEmpty()){player.sendMessage("\u4f60\u9644\u8fd1\u6ca1\u6709\u654c\u4eba \u53ea\u80fd\u7981\u952210*10\u8303\u56f4\u5185\u7684");
            return;}
        for (Entity entity : nearbyEntities) {
            if (entity instanceof LivingEntity) {
                player.sendMessage(ChatColor.DARK_PURPLE+"\u4f60\u7981\u9522\u4e86 [10*10] \u654c\u4eba");
                Location location=((LivingEntity) entity).getLocation();
                Location location2=new Location(player.getWorld(),location.getX(),location.getY()+2.4,location.getZ());
                entity.getWorld().spawnEntity(location2,EntityType.SHULKER_BULLET);
            }
        }
    }

    private void damnation(Player player) {
        player.sendTitle(ChatColor.DARK_PURPLE+"\u4f60\u8bc5\u5492\u7684\u8eab\u8fb910*10\u7684\u751f\u7269","\u4ed6\u4eec\u5c06\u4f1a\u906d\u9047\u96f7\u5288\u3002\u3002\u3002");
        List<Entity> nearbyEntities = player.getNearbyEntities(10, 10, 10);

        for (Entity entity : nearbyEntities) {
            // 计算实体当前的生命值
            double health = ((LivingEntity) entity).getHealth();
            // 计算每秒应该减少的生命值
            double damage = health * 0.1;
            // 让实体受到雷击，并减少生命值
            if (entity instanceof LivingEntity) {
                final int[] p = {0};
                    Bukkit.getScheduler().runTaskTimer(
                        LegendsOfMagic.getPlugin(LegendsOfMagic.class),
                        new BukkitRunnable() {

                            public void run() {
                                if (p[0] >= 5) {
                                    return;
                                }
                                p[0]++;


                                entity.getWorld().strikeLightningEffect(entity.getLocation());
                                ((LivingEntity) entity).damage(damage);

                            }
                            }, 0, 50);
            }
        }
    }

    private void buff(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 2000, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 400, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 400, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 0));
        Location playerLoc = player.getLocation();
        int radius = 2;
        double x, y, z;

        for (double t = 0; t < 2 * Math.PI; t += Math.PI / 24) {
            x = playerLoc.getX() + radius * Math.cos(t);
            y = playerLoc.getY() + 0.5;
            z = playerLoc.getZ() + radius * Math.sin(t);
            player.getWorld().spawnParticle(Particle.REDSTONE, x, y, z, 1, 0, 0, 0, 0);
        }

        player.sendTitle("\u5149\u73af\u56f4\u7ed5\uff01", "\u4f60\u611f\u89c9\u6d51\u8eab\u5145\u6ee1\u4e86\u529b\u91cf", 10, 70, 20);
    }

    private void slow(Player player) {
        List<Entity> nearbyEntities = player.getNearbyEntities(10, 10, 10);
        for (Entity entity : nearbyEntities) {
            if (entity instanceof LivingEntity) {
                player.sendMessage(ChatColor.BOLD+"\u4f60\u4f7f\u7528\u4e86\u51bb\u7ed3\u672f!");
                ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5 * 20, 4));

            }
        }
    }


    private void power(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 4000, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 400, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 400, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 2));
        Location playerLoc = player.getLocation();
        int radius = 2;
        double x, y, z;

        for (double t = 0; t < 12 * Math.PI; t += Math.PI / 32) {
            x = playerLoc.getX() + radius * Math.cos(t);
            y = playerLoc.getY() + 0.5;
            z = playerLoc.getZ() + radius * Math.sin(t);
            player.getWorld().spawnParticle(Particle.REDSTONE, x, y, z, 1, 1, 0.5, 0, 1);
        }
        player.sendTitle(ChatColor.GOLD + "\u5149\u73af\u56f4\u7ed5\uff01", "\u4f60\u611f\u89c9\u6d51\u8eab\u5145\u6ee1\u4e86\u529b\u91cf", 10, 70, 20);
    }

    private void kill(Player player) {
        Vector direction = player.getLocation().getDirection();
        double offset = -1.5;
        Location spawnLocation = player.getLocation().add(direction.clone().multiply(2));

            Location missileLocation = spawnLocation.clone().add(direction.clone().multiply(offset));
            Location missileLocation2=new Location(missileLocation.getWorld(),missileLocation.getX(),missileLocation.getY()+1,missileLocation.getZ());
            ShulkerBullet missile = (ShulkerBullet) player.getWorld().spawnEntity(missileLocation2, EntityType.SHULKER_BULLET);
            missile.setVelocity(direction.clone().multiply(3));
            missile.setCustomName("missile");
            missile.setCustomNameVisible(false);
            missile.addScoreboardTag("missile");
            missile.setGravity(false);
            missile.setShooter(player);
            Random random = new Random();
            int chance = random.nextInt(4); // 生成0到3之间的随机整数
            if (chance == 0) {
                missile.setMetadata("damage", new FixedMetadataValue(LegendsOfMagic.getPlugin(LegendsOfMagic.class), 10000000.0)); // 存储导弹的伤害值

                player.sendTitle("\u6b7b\u4ea1\u4e86!", "\u4f60\u5c31\u5730\u89e3\u51b3\u4e86\u8fd9\u4e9b\u751f\u547d", 10, 70, 20);
            }else {
                player.sendMessage("\u4e0d\u5e78\u7684.\u4f60\u7684\u9b54\u6cd5\u5931\u6548\u4e86(3/4\u6982\u7387)");
            }

            missile.setSilent(true);

            missile.setInvulnerable(true);


        // 向玩家发送消息

    }

    private void bless(Player player){
        player.setMetadata("nextDamageReduction", new FixedMetadataValue(LegendsOfMagic.getPlugin(LegendsOfMagic.class),1000));
        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "[魔法瀑布的庇佑！] " + ChatColor.RESET + player.getName()+"\u83b7\u5f97\u4e86\u6cd5\u7011\u5e03\u7684\u5e87\u4f51 \u4ed6\u5c06\u514d\u9664\u4e0b\u6b21\u4f24\u5bb3");
    }

    private void frostArrow(Player player) {
        Vector direction = player.getLocation().getDirection();
        double offset = 1.5;
        Location spawnLocation = player.getLocation().add(direction.clone().multiply(2));

        Arrow arrow = player.getWorld().spawnArrow(spawnLocation.add(direction.clone().multiply(offset)), direction, 3, 0);
        arrow.setMetadata("frostArrow", new FixedMetadataValue(LegendsOfMagic.getPlugin(LegendsOfMagic.class), true));
        List<Entity> nearbyEntities = arrow.getNearbyEntities(5, 5, 5);
        for (Entity entity : nearbyEntities) {
            if (entity instanceof LivingEntity) {
                ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5 * 20, 2));
                ((LivingEntity) entity).damage(10);
            }
        }
    }
    private void flameRain(Player player) {
        Location playerLoc = player.getLocation();
        int radius = 5;

        for (double t = 0; t < 2 * Math.PI; t += Math.PI / 24) {
            double x = playerLoc.getX() + radius * Math.cos(t);
            double y = playerLoc.getY() + 5;
            double z = playerLoc.getZ() + radius * Math.sin(t);
            player.getWorld().spawnParticle(Particle.FLAME, x, y, z, 10, 2, 2, 2, 0);
            player.getWorld().spawnParticle(Particle.LAVA, x, y, z, 10, 2, 2, 2, 0);


        }Location loc = player.getLocation();
        World world = loc.getWorld();

// 设置火球生成位置为玩家前方10*10位置，高度为玩家y轴+10
        Location fireballLoc = loc.add(loc.getDirection().multiply(10)).add(0, 10, 0);

// 生成向下发射小火球
        for (int x = -5; x <= 5; x++) {
            for (int z = -5; z <= 5; z++) {
                Location targetLoc = fireballLoc.clone().add(x, 0, z);
                SmallFireball fireball = world.spawn(targetLoc, SmallFireball.class);
                fireball.setVelocity(new Vector(0, -1, 0));
            }
        }



    }

    private void earthquake(Player player) {
        if (player.isOnGround()){
        Location playerLoc = player.getLocation();
        int radius = 12;


                final int[] p = {0};
                Bukkit.getScheduler().runTaskTimer(
                        LegendsOfMagic.getPlugin(LegendsOfMagic.class),
                        new BukkitRunnable() {

                            public void run() {
                                if (p[0] >= 5) {
                                    return;
                                }
                                p[0]++;

                                for (double t = 0; t < 2 * Math.PI; t += Math.PI / 24) {
                                    double x = playerLoc.getX() + radius * Math.cos(t);
                                    double y = playerLoc.getY();
                                    double z = playerLoc.getZ() + radius * Math.sin(t);
                                    // 添加震动效果
                                    player.getWorld().spawnParticle(Particle.SLIME, x, y, z, 20, 0.5, 0.5, 0.5, 0);

                                    List<Entity> nearbyEntities = player.getNearbyEntities(10, 10, 10);
                                    for (Entity entity : nearbyEntities) {
                                        if (entity instanceof LivingEntity) {
                                            ((LivingEntity) entity).damage(5);
                                            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 5 * 20, 2));
                                            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5 * 20, 2));
                                        }
                                    }
                                }
                            }
                        }, 0, 20);
            }else {
            player.sendMessage(ChatColor.BOLD+"\u4f60\u9700\u8981\u5728\u5730\u9762\u4e0a\u4f7f\u7528\u8be5\u9b54\u6cd5\uff01");}
    }

}