package AWT;

import javax.swing.*;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
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
        scrollPanel.setBackground(Color.white);
        scrollPanel.setBorder(BorderFactory.createLoweredBevelBorder());

        this.add(scrollPanel, BorderLayout.CENTER);
        String[] strings = new String[]
                {"kot", "pies", "małpa", "rybaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","lew", "pantera", "słoń", "mysz", "hiena", "łoś", "lis", "wąż"};
        JList<String> list = new JList<>(strings);
        Font sizedFont = Config.getFont().deriveFont(13f);
        list.setFont(sizedFont);
        list.setBackground(new Color(157, 185, 188));

        scrollPanel.setViewportView(list);
//        scrollPanel.getVerticalScrollBar().setBackground(Config.getColor());
//        scrollPanel.getHorizontalScrollBar().setBackground(Config.getColor());
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

//        CryptScrollBarUI scrollBarUI = new CryptScrollBarUI();
//        scrollPanel.getVerticalScrollBar().setUI(scrollBarUI);
//        scrollPanel.getHorizontalScrollBar().setUI(scrollBarUI);
//        scrollBarUI.uninstallComponents();
//        scrollBarUI.removeGap();

        CryptScrollBarUI vScrollBarUI = new CryptScrollBarUI();
        scrollPanel.getVerticalScrollBar().setUI(vScrollBarUI);
        vScrollBarUI.uninstallComponents();
        vScrollBarUI.removeGap();

        CryptScrollBarUI hScrollBarUI = new CryptScrollBarUI();
        scrollPanel.getHorizontalScrollBar().setUI(hScrollBarUI);
        hScrollBarUI.uninstallComponents();
        hScrollBarUI.removeGap();



//        scrollPanel.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//            @Override
//            protected void configureScrollBarColors() {
//                this.thumbColor = Color.BLACK;
//            }
//        });
    }
}

//class CryptScrollBarUI extends BasicScrollBarUI{
//    @Override
//    protected void configureScrollBarColors() {
//        this.thumbColor = Color.BLACK;
//    }
//
////    public CryptScrollBarUI() {
////        super();
////        this.uninstallComponents();
////    }
//}
