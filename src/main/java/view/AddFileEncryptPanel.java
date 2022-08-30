package view;

import javax.swing.*;
import java.awt.*;

public class AddFileEncryptPanel extends JPanel {
    JButton buttonAdd;
    JButton buttonRemove;
    JFileChooser fileChooserAdd;
    JFileChooser fileChooserRemove;

    public AddFileEncryptPanel() {
        this.setBackground(Config.getColor());

        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        this.setLayout(layout);

        JButton buttonAdd = new AddRemoveButton("Add files...");
        this.add(buttonAdd);

        JButton buttonRemove = new AddRemoveButton("Remove files");
        this.add(buttonRemove);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFileChooser fileChooserAdd = new JFileChooser();
        fileChooserAdd.setMultiSelectionEnabled(true);
        fileChooserAdd.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        buttonAdd.addActionListener(event -> fileChooserAdd.showOpenDialog(this));

        JFileChooser fileChooserRemove = new JFileChooser();
        fileChooserRemove.setMultiSelectionEnabled(true);
        fileChooserRemove.setFileSelectionMode(JFileChooser.FILES_ONLY);

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


//        buttonRemove.addActionListener(event -> fileChooserRemove.showOpenDialog(this));

        this.buttonAdd = buttonAdd;
        this.buttonRemove = buttonRemove;
        this.fileChooserAdd = fileChooserAdd;
        this.fileChooserRemove = fileChooserRemove;

        System.out.println(buttonAdd);
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public void setButtonAdd(JButton buttonAdd) {
        this.buttonAdd = buttonAdd;
    }

    public JButton getButtonRemove() {
        return buttonRemove;
    }

    public void setButtonRemove(JButton buttonRemove) {
        this.buttonRemove = buttonRemove;
    }

    public JFileChooser getFileChooserAdd() {
        return fileChooserAdd;
    }

    public void setFileChooserAdd(JFileChooser fileChooserAdd) {
        this.fileChooserAdd = fileChooserAdd;
    }

    public JFileChooser getFileChooserRemove() {
        return fileChooserRemove;
    }

    public void setFileChooserRemove(JFileChooser fileChooserRemove) {
        this.fileChooserRemove = fileChooserRemove;
    }
}
