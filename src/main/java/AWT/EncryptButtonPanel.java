package AWT;

import javax.swing.*;
import java.awt.*;

public class EncryptButtonPanel extends JPanel {
    public EncryptButtonPanel() {
        this.setBackground(Config.getColor());
        int y = (int)(CryptFrame.getHEIGHT() * 0.10);
        this.setPreferredSize(new Dimension(0, y));
        Font sizedFont = Config.getFontBold().deriveFont(10f);
        JButton button = new JButton("Encrypt!");
        button.setFont(sizedFont);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(Color.black);
        button.setForeground(Color.white);

//        button.setPreferredSize(new Dimension(scrollPanelX,scrollPanelY));
        button.setMargin(new Insets(0, 0, 0, 0));
        this.add(button);

    }
}
