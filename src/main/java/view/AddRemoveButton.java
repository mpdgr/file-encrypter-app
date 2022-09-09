package view;

import config.Config;
import javax.swing.*;
import java.awt.*;

public class AddRemoveButton extends JButton {
    public AddRemoveButton(String desc){
        super(desc);

        Font sizedFont = Config.getFontBold().deriveFont(10f);
        setFont(sizedFont);

        setBackground(new Color(193, 209, 201));
        setForeground(Color.darkGray);
        setBorder(BorderFactory.createEmptyBorder());

        int x = (int) (CryptFrame.getHEIGHT() * 0.12);
        int y = (int) (CryptFrame.getHEIGHT() * 0.04);
        setPreferredSize(new Dimension(x, y));

        setMargin(new Insets(0, 0, 0, 0));
    }
}
