package personal.zjziizjz.legendsofmagic.Util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class InCircleLocation implements Listener {
    public static boolean inBall(Player player, Location centre, double r) {
        return player.getLocation().distance(centre) <= r;
    }
}
