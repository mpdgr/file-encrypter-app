package view;

import config.Config;

import javax.swing.*;
import java.awt.*;

public class CryptMessageDialog extends JDialog {
    private final static int WIDTH = Config.getSizeReference() / 6;
    private final static int HEIGHT = Config.getSizeReference() / 10;

    public CryptMessageDialog(Frame owner, boolean modal, String label) {
        super(owner, modal);
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setTitle("FileCrypt");
        setLocationRelativeTo(owner);
        setIconImage(Config.getIcon().getImage());

        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(Config.getColor());
        messagePanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        messagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel messageLabel = new JLabel(label);
        Font sizedFont = Config.getFont().deriveFont(13f);
        messageLabel.setFont(sizedFont);

        int y = (int)(CryptFrame.getHEIGHT() * 0.1);
        JButton button = new JButton("Ok");
        Font sizedButtonFont = Config.getFontBold().deriveFont(11f);
        button.setFont(sizedButtonFont);
        button.setPreferredSize(new Dimension(y + y / 4, y / 3 + y / 8));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(new Color(240, 112, 26));
        button.setForeground(Color.white);
        button.setMargin(new Insets(0, 0, 0, 0));

        button.addActionListener(event -> this.dispose());

        messagePanel.add(messageLabel);
        messagePanel.add(button);

        add(messagePanel);

        setVisible(true);
    }
}
