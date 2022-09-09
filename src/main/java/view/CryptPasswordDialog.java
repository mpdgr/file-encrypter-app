package view;

import config.Config;
import javax.swing.*;
import java.awt.*;

public class CryptPasswordDialog extends JDialog{
    private final static int WIDTH = Config.getSizeReference() / 4;
    private final static int HEIGHT = Config.getSizeReference() / 8;

    private final JButton button;
    private char[] password;
    private final JPasswordField passwordField;
    private final Frame owner;

    public CryptPasswordDialog(Frame owner, boolean modal, String buttonLabel) {
        super(owner, modal);
        this.owner = owner;

        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setTitle("FileCrypt");
        setLocationRelativeTo(owner);
        setIconImage(Config.getIcon().getImage());

        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(Config.getColor());
        passwordPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        this.passwordField = new JPasswordField(16);
        passwordPanel.add(passwordField);

        JLabel passwordLabel = new JLabel("Input password:");
        Font sizedFont = Config.getFont().deriveFont(15f);
        passwordLabel.setFont(sizedFont);

        int y = (int)(CryptFrame.getHEIGHT() * 0.1);
        JButton button = new JButton(buttonLabel);
        Font sizedButtonFont = Config.getFontBold().deriveFont(11f);
        button.setFont(sizedButtonFont);
        button.setPreferredSize(new Dimension(y + y / 4, y / 3 + y / 8));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(new Color(240, 112, 26));
        button.setForeground(Color.white);
        button.setMargin(new Insets(0, 0, 0, 0));
        this.button = button;

        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        passwordPanel.add(button);

        add(passwordPanel);

        setVisible(false);
    }

    public void updatePassword(){
        password = passwordField.getPassword();
        passwordField.setText("");
    }

    public void showDialog(){
        setLocationRelativeTo(owner);
        setVisible(true);
    }

    public JButton getButton() {
        return button;
    }

    public char[] getPassword() {
        return password;
    }
}
