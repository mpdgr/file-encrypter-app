package controller;

import config.AppProperties;
import view.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class AppController {
    public static void main(String[] args) {

        EventQueue.invokeLater(() ->
        {
            CryptFrame frame = new CryptFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MainPanel mainPanel = new MainPanel();
            frame.add(mainPanel);
            CryptMenu menu = new CryptMenu();
            frame.setJMenuBar(menu);

            JButton addFilesToEncryptButton = mainPanel.getAddFileEncryptPanel().getButtonAdd();
            JButton removeFilesToEncryptButton = mainPanel.getAddFileEncryptPanel().getButtonRemove();
            JButton addFilesToDecryptButton = mainPanel.getAddFileDecryptPanel().getButtonAdd();
            JButton removeFilesToDecryptButton = mainPanel.getAddFileDecryptPanel().getButtonRemove();

            DefaultListModel<File> encryptListModel = mainPanel.getEncryptWindowPanel().getListModel();
            DefaultListModel<File> decryptListModel = mainPanel.getDecryptWindowPanel().getListModel();

            JList<File> encryptList = mainPanel.getEncryptWindowPanel().getFileList();
            JList<File> decryptList = mainPanel.getDecryptWindowPanel().getFileList();

            JButton encryptButton = mainPanel.getEncryptButtonPanel().getButton();
            JButton decryptButton = mainPanel.getDecryptButtonPanel().getButton();

            JFileChooser fileChooserAddFilesToEncrypt = mainPanel.getAddFileEncryptPanel().getFileChooserAdd();

            JFileChooser fileChooserAddFilesToDecrypt = mainPanel.getAddFileDecryptPanel().getFileChooserAdd();

            addFilesToEncryptButton.addActionListener(event -> fileChooserAddFilesToEncrypt.showOpenDialog(mainPanel));
            fileChooserAddFilesToEncrypt.addActionListener(event -> {
                if (event.getActionCommand().equals("ApproveSelection")) {
                    for (File f : fileChooserAddFilesToEncrypt.getSelectedFiles()) {
                        encryptListModel.addElement(!encryptListModel.contains(f) ? f : null);
                    }
                    mainPanel.repaint();
                }
                AppProperties.setCurrentWorkdir(fileChooserAddFilesToEncrypt.getCurrentDirectory().getAbsolutePath());
            });
            removeFilesToEncryptButton.addActionListener(event -> {
                int[] toRemove = encryptList.getSelectedIndices();
                System.out.println(Arrays.toString(toRemove));
                System.out.println(encryptListModel);
                for (int i : toRemove) {
                    encryptListModel.remove(i);
                }
            });

            addFilesToDecryptButton.addActionListener(event -> fileChooserAddFilesToDecrypt.showOpenDialog(mainPanel));
            fileChooserAddFilesToDecrypt.addActionListener(event -> {
                if (event.getActionCommand().equals("ApproveSelection")) {
                    for (File f : fileChooserAddFilesToDecrypt.getSelectedFiles()) {
                        decryptListModel.addElement(!decryptListModel.contains(f) ? f : null);
                    }
                    mainPanel.repaint();
                }
                AppProperties.setCurrentWorkdir(fileChooserAddFilesToDecrypt.getCurrentDirectory().getAbsolutePath());
            });

            removeFilesToDecryptButton.addActionListener(event -> {
                int[] toRemove = decryptList.getSelectedIndices();
                for (int i : toRemove) {
                    decryptListModel.remove(i);
                }
            });

            CryptPasswordDialog encryptPassDialog = new CryptPasswordDialog(frame, true, "Encrypt!");
            CryptPasswordDialog decryptPassDialog = new CryptPasswordDialog(frame, true, "Decrypt!");
            JButton encryptPassButton = encryptPassDialog.getButton();
            JButton decryptPassButton = decryptPassDialog.getButton();

            encryptPassButton.addActionListener(event -> {
                encryptPassDialog.updatePassword();
                if (encryptPassDialog.getPassword().length == 0) {
                    new CryptMessageDialog(frame, true, "Password cannot be empty");
                } else {
                    EncrypterController encrypterController = new EncrypterController();
                    encrypterController.runEncrypt(encryptListModel, encryptPassDialog.getPassword());
                    encryptPassDialog.setVisible(false);
                    encryptListModel.clear();
                    new FinishedMessageDialog(frame, true, "       Encryption complete!       ");
                }
            });


            ActionListener encryptListener = event ->
            {
                if (encryptListModel.isEmpty()) {
                    new CryptMessageDialog(frame, true, "Add files to encrypt");
                } else {
                    encryptPassDialog.showDialog();
                }
            };
            encryptButton.addActionListener(encryptListener);

            decryptPassButton.addActionListener(event -> {
                decryptPassDialog.updatePassword();
                if (decryptPassDialog.getPassword().length == 0) {
                    new CryptMessageDialog(frame, true, "Password cannot be empty");
                } else {
                    EncrypterController encrypterController = new EncrypterController();
                    encrypterController.runDecrypt(decryptListModel, decryptPassDialog.getPassword());
                    decryptPassDialog.setVisible(false);
                    decryptListModel.clear();
                    new FinishedMessageDialog(frame, true, "       Decryption complete!       ");
                }
            });

            ActionListener decryptListener = event ->
            {
                if (decryptListModel.isEmpty()) {
                    new CryptMessageDialog(frame, true, "Add files to decrypt");
                } else {
                    decryptPassDialog.showDialog();
                }
            };

            decryptButton.addActionListener(decryptListener);


            /* Menu actions */

            JMenuItem encrypt = menu.getEncrypt();
            JMenuItem decrypt = menu.getDecrypt();
            JMenuItem openDefaultDir = menu.getOpenDefaultDir();
            JMenuItem exit = menu.getExit();
            JRadioButtonMenuItem saveInCurrentDir = menu.getSaveInCurrentDir();
            JRadioButtonMenuItem saveInDefaultDir = menu.getSaveInDefaultDir();
            JMenuItem setDefaultFolder = menu.getSetDefaultDir();
            JMenuItem aboutFileCrypt = menu.getAboutFileCrypt();

            encrypt.addActionListener(encryptListener);

            decrypt.addActionListener(decryptListener);

            openDefaultDir.addActionListener(event ->
            {
                try {
                    Desktop.getDesktop().open(new File(AppProperties.getDefaultDir()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            exit.addActionListener(event -> System.exit(0));

            saveInCurrentDir.addActionListener(event ->
                    AppProperties.saveIn(AppProperties.SaveOption.saveInCurrentDir)
            );
            saveInDefaultDir.addActionListener(event ->
                    AppProperties.saveIn(AppProperties.SaveOption.saveInDefaultDir)
            );

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }

            JFileChooser dirChooser = new JFileChooser();

            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            dirChooser.addActionListener(event ->
            {
                if (event.getActionCommand().equals("ApproveSelection")) {
                    AppProperties.setDefaultDir(dirChooser.getSelectedFile().getPath());
                    openDefaultDir.setEnabled(true);
                    saveInDefaultDir.setEnabled(true);
                }
            });

            setDefaultFolder.addActionListener(event -> {
                dirChooser.setMultiSelectionEnabled(false);
                dirChooser.setCurrentDirectory(new File(AppProperties.getCurrentWorkdir()));
                dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                dirChooser.showOpenDialog(mainPanel);
            });

            aboutFileCrypt.addActionListener(event -> {
                try {
                    new CryptAboutDialog(frame);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            frame.setVisible(true);
        });
    }
}

