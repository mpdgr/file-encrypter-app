package AWT;

import javax.swing.*;
import java.awt.*;

public class CryptPanel extends JPanel {
    public CryptPanel(){
        this.setSize(CryptFrame.getWIDTH(), CryptFrame.getHEIGHT());
        this.setBackground(new Color(255, 255, 255));
        JLabel label = new JLabel("Test czcionki");
        Font sizedFont = Config.getFont().deriveFont(60f);
        label.setFont(sizedFont);
        label.setIcon(new ImageIcon("src/main/resources/icons/crypticon.png"));
        this.add(label);
    }
}
