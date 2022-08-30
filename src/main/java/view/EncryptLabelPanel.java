package view;

import javax.swing.*;
import java.awt.*;

public class EncryptLabelPanel extends JPanel {
    public EncryptLabelPanel() {
        this.setBackground(Config.getColor());
        int y = (int)(CryptFrame.getHEIGHT() * 0.08);
        this.setPreferredSize(new Dimension(0, y));

        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        this.setAlignmentY(Component.CENTER_ALIGNMENT);

        Font sizedFont = Config.getFont().deriveFont(15f);
        JLabel label = new JLabel("   Choose files to encrypt:");
        label.setFont(sizedFont);
        this.add(label, BorderLayout.SOUTH);
    }
}