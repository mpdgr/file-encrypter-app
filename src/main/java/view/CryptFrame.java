package view;

import config.Config;
import javax.swing.*;

public class CryptFrame extends JFrame {
    private final static int WIDTH = Config.getSizeReference() / 2;
    private final static int HEIGHT = Config.getSizeReference() / 2;

    public CryptFrame() {
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setTitle("FileCrypt");
        setIconImage(Config.getIcon().getImage());
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }
}
