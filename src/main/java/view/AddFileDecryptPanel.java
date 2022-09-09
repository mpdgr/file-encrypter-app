package view;

import config.AppProperties;
import config.Config;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class AddFileDecryptPanel extends JPanel {
    JButton buttonAdd;
    JButton buttonRemove;
    JFileChooser fileChooserAdd;
    JFileChooser fileChooserRemove;

    public AddFileDecryptPanel() {
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
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFileChooser fileChooserAdd = new JFileChooser();
        fileChooserAdd.setMultiSelectionEnabled(true);
        fileChooserAdd.setCurrentDirectory(new File(AppProperties.getCurrentWorkdir()));
        fileChooserAdd.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooserAdd.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Encrypted files", "enc");
        fileChooserAdd.addChoosableFileFilter(filter);

        JFileChooser fileChooserRemove = new JFileChooser();
        fileChooserRemove.setMultiSelectionEnabled(true);
        fileChooserRemove.setCurrentDirectory(new File(AppProperties.getCurrentWorkdir()));
        fileChooserRemove.setFileSelectionMode(JFileChooser.FILES_ONLY);

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        this.buttonAdd = buttonAdd;
        this.buttonRemove = buttonRemove;
        this.fileChooserAdd = fileChooserAdd;
        this.fileChooserRemove = fileChooserRemove;
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public JButton getButtonRemove() {
        return buttonRemove;
    }

    public JFileChooser getFileChooserAdd() {
        return fileChooserAdd;
    }

    public JFileChooser getFileChooserRemove() {
        return fileChooserRemove;
    }

}
