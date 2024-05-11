package personal.zjziizjz.legendsofmagic.Listener;

import org.bukkit.entity.ShulkerBullet;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageSetByEntiy implements Listener {
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof ShulkerBullet) { // 判断伤害实体是否是导弹
            ShulkerBullet missile = (ShulkerBullet) event.getDamager();
            if (missile.hasMetadata("damage")) { // 判断导弹是否设置了伤害值
                double damage = missile.getMetadata("damage").get(0).asDouble();
                event.setDamage(damage); // 设置受害者的伤害值
            }

        }

    }
}
