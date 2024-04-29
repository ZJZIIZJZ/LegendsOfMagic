package personal.zjziizjz.legendsofmagic.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import personal.zjziizjz.legendsofmagic.LegendsOfMagic;

public class OnPlayerDamage implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            // 获取元数据 nextDamageReduction
            if (player.hasMetadata("nextDamageReduction")) {
                double reduction = player.getMetadata("nextDamageReduction").get(0).asDouble();
                // 减少受到的伤害
                event.setDamage(0);
                // 移除元数据
                player.removeMetadata("nextDamageReduction",LegendsOfMagic.getPlugin(LegendsOfMagic.class));
                event.getEntity().sendMessage("\u5e87\u4f51\u7ed3\u675f\u4e86....");
            }
        }
    }

}
