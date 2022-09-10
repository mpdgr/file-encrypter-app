package view;

import config.Config;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DecryptWindowPanel extends JPanel {
    private final JList<File> fileList;
    private final DefaultListModel<File> listModel;


    public DecryptWindowPanel() {
        setBackground(Config.getColor());
        int y = (int) (CryptFrame.getHEIGHT() * 0.35);
        setPreferredSize(new Dimension(0, y));

        JScrollPane scrollPanel = new JScrollPane();
        int scrollPanelX = (int) (CryptFrame.getHEIGHT() * 0.43);
        int scrollPanelY = (int) (CryptFrame.getHEIGHT() * 0.34);
        scrollPanel.setPreferredSize(new Dimension(scrollPanelX, scrollPanelY));
        scrollPanel.setBackground(Color.white);
        scrollPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        add(scrollPanel, BorderLayout.CENTER);

        DefaultListModel<File> listModel = new DefaultListModel<>();
        JList<File> fileList = new JList<>(listModel);
        fileList.setCellRenderer(new CryptListCellRenderer());
        Font sizedFont = Config.getFont().deriveFont(13f);
        fileList.setFont(sizedFont);
        fileList.setBackground(new Color(157, 185, 188));
        fileList.setSelectionBackground(new Color(64, 156, 172));

        scrollPanel.setViewportView(fileList);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        CryptScrollBarUI vScrollBarUI = new CryptScrollBarUI();
        scrollPanel.getVerticalScrollBar().setUI(vScrollBarUI);
        vScrollBarUI.uninstallComponents();
        vScrollBarUI.removeGap();

        CryptScrollBarUI hScrollBarUI = new CryptScrollBarUI();
        scrollPanel.getHorizontalScrollBar().setUI(hScrollBarUI);
        hScrollBarUI.uninstallComponents();
        hScrollBarUI.removeGap();

        this.fileList = fileList;
        this.listModel = listModel;
    }

    public JList<File> getFileList() {
        return fileList;
    }

    public DefaultListModel<File> getListModel() {
        return listModel;
    }
}















