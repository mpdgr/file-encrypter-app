package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TitlePanel extends JPanel {
    public TitlePanel() {
        this.setBackground(Config.getColor());

        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        this.setAlignmentY(Component.CENTER_ALIGNMENT);

        int y = (int)(CryptFrame.getHEIGHT() * 0.18);
        int dLogo = (int)(y * 0.4);
        this.setPreferredSize(new Dimension(0, y));

        Font sizedFont = Config.getFont().deriveFont(35f);

        JLabel label = new JLabel(" FileCrypt ");
        label.setFont(sizedFont);

        BufferedImage logo = Config.getLogo();
//        try {
//            logo = ImageIO.read(new File("src/main/resources/icons/crypticon.png"));
//        } catch (IOException ignored) {}

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
