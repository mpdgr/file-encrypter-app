package view;

import config.Config;

import javax.swing.*;
import java.awt.*;

public class AddRemoveButton extends JButton {
    public AddRemoveButton(String desc){
        super(desc);

        Font sizedFont = Config.getFontBold().deriveFont(10f);
        this.setFont(sizedFont);

        this.setBackground(new Color(193, 209, 201));
        this.setForeground(Color.darkGray);
        this.setBorder(BorderFactory.createEmptyBorder());

        int x = (int) (CryptFrame.getHEIGHT() * 0.12);
        int y = (int) (CryptFrame.getHEIGHT() * 0.04);
        this.setPreferredSize(new Dimension(x, y));

        this.setMargin(new Insets(0, 0, 0, 0));
    }
}
