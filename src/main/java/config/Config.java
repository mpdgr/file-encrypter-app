package config;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Config {

    /* screen size */

    private static final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static final Dimension screenSize = toolkit.getScreenSize();
    private static final int SCREEN_HEIGHT = screenSize.height;;
    private static final int SCREEN_WIDTH = screenSize.width;

    /* size reference */

    public static int getSizeReference() {
        int reference = 0;
        if (SCREEN_HEIGHT >= 1080){reference = SCREEN_HEIGHT;}
        else if (SCREEN_HEIGHT >= 540){reference = 1080;}
        else {reference = SCREEN_HEIGHT * 2;}        //max frame size is screen height * 0.5
        return reference;
    }

    /* default fonts */

    private static Font font;
    private static Font fontBold;
    private static Font fontLight;

    static {
        InputStream fontStream = Config.class.getResourceAsStream("/fonts/lato/Lato-Regular.ttf");
        InputStream fontBoldStream = Config.class.getResourceAsStream("/fonts/lato/Lato-Bold.ttf");
        InputStream fontLightStream = Config.class.getResourceAsStream("/fonts/lato/Lato-Light.ttf");

        try {
            font = Font.createFont(Font.PLAIN, fontStream);
            fontBold = Font.createFont(Font.PLAIN, fontBoldStream);
            fontLight = Font.createFont(Font.PLAIN, fontLightStream);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Font getFont() {
        return font;
    }
    public static Font getFontBold() {
        return fontBold;
    }
    public static Font getFontLight() {
        return fontLight;
    }

    /* images */

    private static ImageIcon icon;
    private static BufferedImage logo;

    static {
        InputStream imgStreamIcon = AppProperties.class.getResourceAsStream("/icons/crypticon.png");
        InputStream imgStreamLogo = AppProperties.class.getResourceAsStream("/icons/crypticon.png");
        try {
            icon = new ImageIcon(imgStreamIcon.readAllBytes());
            logo = ImageIO.read(imgStreamLogo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ImageIcon getIcon() {
        return icon;
    }

    public static BufferedImage getLogo() {
        return logo;
    }

    /* default color */

    private final static Color color = new Color(236, 239, 236);

    public static Color getColor() {
        return color;
    }
}
