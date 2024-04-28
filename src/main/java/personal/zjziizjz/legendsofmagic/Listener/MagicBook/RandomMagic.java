package personal.zjziizjz.legendsofmagic.Listener.MagicBook;

import java.util.Random;

public class RandomMagic {
    public static final String[] MAGIC_NAMES = {"\u5bd2\u51b0", "\u7981\u672f", "\u5723\u5149\u73af", "\u8bde\u5492"};

    public static String getRandomMagic() {
        Random random = new Random();
        int index = random.nextInt(MAGIC_NAMES.length);
        return MAGIC_NAMES[index];
    }
}
