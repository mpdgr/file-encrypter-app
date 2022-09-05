package view;

import model.AppProperties;

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

    private static final int SIZE_REFERENCE = SCREEN_HEIGHT;

    public static int getSizeReference() {
        return SCREEN_HEIGHT;
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
        InputStream imgStream = AppProperties.class.getResourceAsStream("/icons/crypticon.png");
        try {
            icon = new ImageIcon(imgStream.readAllBytes());
            logo = ImageIO.read(imgStream);
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
