package personal.zjziizjz.legendsofmagic.Listener.MagicReel;

import java.util.Random;

public class RandomReel {
    public static final String[] MAGIC_NAMES = {"\u9886\u57df\u5377\u8f74","\u65e0\u9650\u5377\u8f74"};

    public static String getRandomReel() {
        Random random = new Random();
        int index = random.nextInt(MAGIC_NAMES.length);
        return MAGIC_NAMES[index];
    }
}
