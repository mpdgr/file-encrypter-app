package AWT;

import javax.swing.*;
import java.awt.*;

public class EncryptButtonPanel extends JPanel {
    public EncryptButtonPanel() {
        this.setBackground(Config.getColor());
        int y = (int)(CryptFrame.getHEIGHT() * 0.1);
        this.setPreferredSize(new Dimension(0, y));
        Font sizedFont = Config.getFontBold().deriveFont(12f);
        JButton button = new JButton("Encrypt!");
        button.setFont(sizedFont);
        button.setPreferredSize(new Dimension(y + y / 3, y / 2));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(new Color(10, 86, 90));
        button.setForeground(Color.white);
        button.setMargin(new Insets(0, 0, 0, 0));
        this.add(button);
    }
}
