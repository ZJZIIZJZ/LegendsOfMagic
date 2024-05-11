package personal.zjziizjz.legendsofmagic.Util;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;

public class LineOfSight {

    public static LivingEntity generateParticles(Player player, int range, int density) {
        World world = player.getWorld();
        Location origin = player.getEyeLocation();
        Vector direction = origin.getDirection();
        direction.normalize();

        for (int i = 0; i < range; i++) {
            Location location = origin.clone().add(direction.clone().multiply(i));
            player.getWorld().playEffect(location, Effect.BLAZE_SHOOT, 1);

            List<Entity> entities = player.getNearbyEntities(range, range, range);
            for (Entity entity : entities) {
                if (entity instanceof LivingEntity) {
                    LivingEntity livingEntity = (LivingEntity) entity;
                    if (livingEntity.getLocation().distance(location) < 1.0) {
                        player.getWorld().playEffect(location, Effect.HEART, 1);

                        return livingEntity;
                    }
                }
            }
        }
        return null;
    }
}
