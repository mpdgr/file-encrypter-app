package view;

import javax.swing.*;
import java.awt.*;

public class CryptMessageDialog extends JDialog {
    //default size
    private final static int WIDTH = Config.getScreenHeight() / 6;
    private final static int HEIGHT = Config.getScreenHeight() / 10;

    public CryptMessageDialog(Frame owner, boolean modal, String label) {
        super(owner, modal);
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setTitle("FileCrypt");
        setLocationRelativeTo(owner);
        setIconImage(new ImageIcon("src/main/resources/icons/crypticon.png").getImage());
        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(Config.getColor());

        BorderLayout borderLayout = new BorderLayout();
//        messagePanel.setLayout(borderLayout);
        messagePanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        messagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        JPasswordField passwordField = new JPasswordField(16);
//        passwordPanel.add(passwordField);
        JLabel messageLabel = new JLabel(label);
//        passwordLabel.set
        Font sizedFont = Config.getFontBold().deriveFont(13f);
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
//        button.addActionListener(event -> AppActions.encryptFiles());

//            l1.setBounds(20,100, 80,30);
//            passwordField.setBounds(100,100,100,30);
//            add(passwordField);  passwordField.add(l1);
//        passwordField.setSize(300,300);
//        passwordField.setLayout(null);
//        passwordPanel.add(passwordLabel);
//        passwordPanel.add(passwordField);
        messagePanel.add(messageLabel);
        messagePanel.add(button);
        add(messagePanel);
        setVisible(true);
    }
}
