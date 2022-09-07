package view;

import config.Config;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class EncryptWindowPanel extends JPanel {
    JList<File> fileList;
    DefaultListModel<File> listModel;

    public JList<File> getFileList() {
        return fileList;
    }

    public void setFileList(JList<File> fileList) {
        this.fileList = fileList;
    }

    public DefaultListModel<File> getListModel() {
        return listModel;
    }

    public void setListModel(DefaultListModel<File> listModel) {
        this.listModel = listModel;
    }

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
                {"kot", "pies", "małpa", "ryba","lew", "pantera", "słoń", "mysz", "hiena", "łoś", "lis", "wąż"};

//        JList<String> list = new JList<>(strings);

        File testfolder = new File("C:\\Users\\Michał Podgórski\\OneDrive - Minds & Roses Sp. z o.o\\Pulpit\\testFolder\\");
        File testfile1 = new File("C:\\Users\\Michał Podgórski\\OneDrive - Minds & Roses Sp. z o.o\\Pulpit\\testFolder\\testFile1.txt");
        File testfile2 = new File("C:\\Users\\Michał Podgórski\\OneDrive - Minds & Roses Sp. z o.o\\Pulpit\\testFolder\\testFile2.txt");

        File[] files = new File[]
                {testfile1, testfile2, testfolder};


        DefaultListModel<File> listModel = new DefaultListModel<>();
        JList<File> fileList = new JList<>(listModel);
//        listModel.addElement(testfile1);



        fileList.setCellRenderer(new CryptListCellRenderer());
        Font sizedFont = Config.getFont().deriveFont(13f);
        fileList.setFont(sizedFont);

        fileList.setBackground(new Color(157, 185, 188));
        fileList.setSelectionBackground(new Color(64, 156, 172));



        scrollPanel.setViewportView(fileList);
//        scrollPanel.getVerticalScrollBar().setBackground(Config.getColor());
//        scrollPanel.getHorizontalScrollBar().setBackground(Config.getColor());
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        CryptScrollBarUI scrollBarUI = new CryptScrollBarUI();
        scrollPanel.getVerticalScrollBar().setUI(scrollBarUI);
        scrollPanel.getHorizontalScrollBar().setUI(scrollBarUI);
        scrollBarUI.uninstallComponents();
        scrollBarUI.removeGap();

        this.fileList = fileList;
        this.listModel = listModel;
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
