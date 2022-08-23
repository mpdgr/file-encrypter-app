package AWT;

import javax.swing.*;
import java.awt.*;

public class CryptFrame extends JFrame {

    //default size
    private final static int WIDTH = Config.getScreenHeight() / 2;
    private final static int HEIGHT = Config.getScreenHeight() / 2;

    public CryptFrame() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setTitle("FileCrypt");
        setIconImage(new ImageIcon("src/main/resources/icons/crypticon.png").getImage());
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }
}
