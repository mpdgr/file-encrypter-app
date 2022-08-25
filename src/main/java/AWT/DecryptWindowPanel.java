package AWT;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.SliderUI;
import java.awt.*;
import java.util.Arrays;

public class DecryptWindowPanel extends JPanel {
    public DecryptWindowPanel() {
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
                {"kot", "pies", "lew", "pantera", "słoń", "mysz", "hiena", "łoś"};
        JList<String> list = new JList<>(strings);
        Font sizedFont = Config.getFont().deriveFont(13f);
        list.setFont(sizedFont);
        list.setBackground(new Color(157, 185, 188));

        scrollPanel.setViewportView(list);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        CryptScrollBarUI scrollBarUI = new CryptScrollBarUI();
        scrollPanel.getVerticalScrollBar().setUI(scrollBarUI);
        scrollBarUI.uninstallComponents();

    }
}


//
//    public DecryptWindowPanel() {
//        this.setBackground(Color.DARK_GRAY);
//        int y = (int)(CryptFrame.getHEIGHT() * 0.35);
//        this.setPreferredSize(new Dimension(0, y));
//        JPanel listPanel = new JPanel();
//        int listPanelX = (int)(CryptFrame.getHEIGHT() * 0.35);
//        int listPanelY = (int)(CryptFrame.getHEIGHT() * 0.34);
//        int listX = (int)(CryptFrame.getHEIGHT() * 0.3);
//        int listY = (int)(CryptFrame.getHEIGHT() * 0.45);
//        listPanel.setPreferredSize(new Dimension(listPanelX,listPanelY));
//        listPanel.setBackground(new Color(144, 238, 144));
//        listPanel.setBorder(BorderFactory.createLoweredBevelBorder());
////        FlowLayout flowLayout = new FlowLayout();
////        flowLayout.setAlignment(FlowLayout.LEFT);
////        listPanel.setLayout(flowLayout);
//        BorderLayout borderLayout = new BorderLayout();
//        this.add(listPanel, BorderLayout.CENTER);
//        String[] strings = new String[]
//                {"kot", "pies", "małpa", "ryba","lew", "pantera", "słoń", "mysz", "hiena", "łoś"};
//        JList<String> stringJList = new JList<>(strings);
//        Font sizedFont = Config.getFont().deriveFont(15f);
//        stringJList.setFont(sizedFont);
//
//        stringJList.setPreferredSize(new Dimension(listX,0));
////        JScrollPane jScrollPane = new JScrollPane(stringJList,
////                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
////                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
////        listPanel.add(jScrollPane);
//
//        JScrollPane scrollPane = new JScrollPane(stringJList);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//
////        stringJList.setLayout(new BoxLayout(stringJList, BoxLayout.Y_AXIS));
//
////        setViewportView(verticalPanel); // ********** changed *******
////
////        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
////        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//
//
//
////        scrollPane.setViewportView(stringJList);
//        listPanel.add(scrollPane, BorderLayout.CENTER);
////        listPanel.add(stringJList);
//
//
//
//
//
//    }
//}
















