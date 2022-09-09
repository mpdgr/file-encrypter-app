package view;

import config.Config;
import javax.swing.*;
import java.awt.*;

public class EncryptLabelPanel extends JPanel {
    public EncryptLabelPanel() {
        setBackground(Config.getColor());
        int y = (int)(CryptFrame.getHEIGHT() * 0.08);
        setPreferredSize(new Dimension(0, y));

        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        setAlignmentY(Component.CENTER_ALIGNMENT);

        Font sizedFont = Config.getFont().deriveFont(15f);
        JLabel label = new JLabel("   Choose files to encrypt:");
        label.setFont(sizedFont);

        add(label, BorderLayout.SOUTH);
    }
}
