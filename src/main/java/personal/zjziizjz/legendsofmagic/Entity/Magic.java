package personal.zjziizjz.legendsofmagic.Entity;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.List;

//封装了使用魔法方法 获取魔法ID 时间等
public class Magic {

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
                launchMissiles(player);
                break;
            case 1003:
                buff(player);
                break;
            case 1004:
                slow(player);
                break;
            case 1005:
                // TODO: 实现此模式
                break;
            case 1006:
                power(player);
                break;
            case 1007:
                kill(player);
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

    private void launchMissiles(Player player) {
        Vector direction = player.getLocation().getDirection();
        double offset = -6.0;
        player.sendMessage(ChatColor.DARK_PURPLE + "\u4f60\u53ec\u5524\u4e8610\u4e2a\u6f5c\u5f71\u5bfc\u5f39!");
        Location spawnLocation = player.getLocation().add(direction.clone().multiply(10));
        for (int i = 0; i < 20; i++) {
            Location missileLocation = spawnLocation.clone().add(direction.clone().multiply(offset));
            ShulkerBullet missile = (ShulkerBullet) player.getWorld().spawnEntity(missileLocation, EntityType.SHULKER_BULLET);
            missile.setVelocity(direction.clone().multiply(0.5));
            missile.setCustomName("missile");
            missile.setCustomNameVisible(false);
            missile.addScoreboardTag("missile");
            missile.setGravity(false);
            missile.setShooter(player);
            missile.setSilent(true);
            missile.setInvulnerable(true);
            offset += 1.0;
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
        Location loc = player.getEyeLocation();
        Vector dir = loc.getDirection();
        double distance = 5;
        Location endLoc = loc.add(dir.multiply(distance));

        List<Entity> nearbyEntities = player.getNearbyEntities(5, 5, 5);
        boolean killed = false;
        for (Entity entity : nearbyEntities) {
            if (entity instanceof LivingEntity && !(entity instanceof Player)) {
                Vector vec = entity.getLocation().subtract(loc).toVector();
                if (vec.normalize().dot(dir) > 0.99) {
                    ((LivingEntity) entity).setHealth(0);
                    killed = true;
                }
            }
        }

        // 向玩家发送消息
        if (killed) {
            player.sendTitle("\u6b7b\u4ea1\u4e86!", "\u4f60\u5c31\u5730\u89e3\u51b3\u4e86\u8fd9\u4e9b\u751f\u547d", 10, 70, 20);
        } else {
            player.sendMessage(ChatColor.RED + "\u4f3c\u4e4e\u5e76\u6ca1\u6709\u6740\u6389\u4ec0\u4e48!");
        }
    }
}
