package view;

import config.Config;

import javax.swing.*;
import java.awt.*;

public class CryptFrame extends JFrame {

    //default size
    private final static int WIDTH = Config.getSizeReference() / 2;
    private final static int HEIGHT = Config.getSizeReference() / 2;

    public CryptFrame() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
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
