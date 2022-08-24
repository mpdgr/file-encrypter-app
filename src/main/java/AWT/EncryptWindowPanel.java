package AWT;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class EncryptWindowPanel extends JPanel {
    public EncryptWindowPanel() {
        this.setBackground(Config.getColor());
        int y = (int)(CryptFrame.getHEIGHT() * 0.35);
        this.setPreferredSize(new Dimension(0, y));
        JScrollPane scrollPanel = new JScrollPane();
        int scrollPanelX = (int)(CryptFrame.getHEIGHT() * 0.43);
        int scrollPanelY = (int)(CryptFrame.getHEIGHT() * 0.34);
        scrollPanel.setPreferredSize(new Dimension(scrollPanelX,scrollPanelY));
        scrollPanel.setBackground(new Color(144, 238, 144));
        scrollPanel.setBorder(BorderFactory.createLoweredBevelBorder());

        this.add(scrollPanel, BorderLayout.CENTER);
        String[] strings = new String[]
                {"kot", "pies", "małpa"};//, "ryba","lew", "pantera", "słoń", "mysz", "hiena", "łoś"};
        JList<String> list = new JList<>(strings);
        Font sizedFont = Config.getFont().deriveFont(13f);
        list.setFont(sizedFont);
        list.setBackground(new Color(157, 185, 188));

        scrollPanel.setViewportView(list);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    }
}
