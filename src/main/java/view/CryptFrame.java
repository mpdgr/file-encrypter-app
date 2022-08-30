package view;

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
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(217, 221, 224));
        menuBar.setBorder(BorderFactory.createEmptyBorder());
        JMenu file = new JMenu("   File");
        Font sizedFont = Config.getFont().deriveFont(14f);
        file.setFont(sizedFont);
        JMenu options = new JMenu("Options");
        options.setFont(sizedFont);
        JMenu settings = new JMenu("Settings");
        settings.setFont(sizedFont);
        JMenu about = new JMenu("About");
        about.setFont(sizedFont);
        menuBar.add(file);
        menuBar.add(options);
        menuBar.add(settings);
        menuBar.add(about);
        menuBar.setEnabled(true);
        menuBar.setVisible(true);
        this.setJMenuBar(menuBar);
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }
}
