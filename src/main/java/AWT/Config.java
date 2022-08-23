package AWT;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Config {

    //screen size

    private static final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static final Dimension screenSize = toolkit.getScreenSize();
    private static final int SCREEN_HEIGHT = screenSize.height;;
    private static final int SCREEN_WIDTH = screenSize.width;

    public static int getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    public static int getScreenWidth() {
        return SCREEN_WIDTH;
    }

    //default font

    private static Font font;

    static {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/Fonts/Lato/Lato-Light.ttf"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Font getFont() {
        return font;
    }
}
