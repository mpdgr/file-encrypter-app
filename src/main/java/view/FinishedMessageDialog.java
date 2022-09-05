package view;

import javax.swing.*;
import java.awt.*;

public class FinishedMessageDialog extends JDialog {

    /* default size */
    private final static int WIDTH = Config.getSizeReference() / 4;
    private final static int HEIGHT = Config.getSizeReference() / 8;


    public FinishedMessageDialog(Frame owner, boolean modal, String label) {
        super(owner, modal);

        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setTitle("FileCrypt");
        setLocationRelativeTo(owner);
        setIconImage(new ImageIcon("src/main/resources/icons/crypticon.png").getImage());
        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(Config.getColor());

        BorderLayout borderLayout = new BorderLayout();
        messagePanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        JLabel messageLabel = new JLabel(label);
        Font sizedFont = Config.getFont().deriveFont(15f);
        messageLabel.setFont(sizedFont);

        int y = (int)(CryptFrame.getHEIGHT() * 0.1);
        JButton button = new JButton("OK");
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
