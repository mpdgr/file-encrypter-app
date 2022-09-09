package view;

import config.Config;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TitlePanel extends JPanel {
    public TitlePanel() {
        setBackground(Config.getColor());
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        setAlignmentY(Component.CENTER_ALIGNMENT);

        int y = (int)(CryptFrame.getHEIGHT() * 0.18);
        int dLogo = (int)(y * 0.4);
        setPreferredSize(new Dimension(0, y));
        Font sizedFont = Config.getFont().deriveFont(35f);
        JLabel label = new JLabel(" FileCrypt ");
        label.setFont(sizedFont);

        BufferedImage logo = Config.getLogo();
        Image scaledLogo = null;
        if (logo != null) {
            scaledLogo = logo.getScaledInstance(dLogo, dLogo, Image.SCALE_SMOOTH);
        }
        JLabel logoLabel = new JLabel();
        if (scaledLogo != null) {
            logoLabel.setIcon(new ImageIcon(scaledLogo));
        }

        Font descriptionFont = Config.getFont().deriveFont(16f);
        JLabel description = new JLabel("   encrypt & decrypt files using AES algorithm");
        description.setFont(descriptionFont);

        this.add(label, BorderLayout.WEST);
        this.add(logoLabel);
        this.add(description, BorderLayout.SOUTH);
    }
}
