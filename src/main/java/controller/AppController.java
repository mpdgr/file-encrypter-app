package controller;

import config.AppProperties;
import view.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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

            //region Objects
            /*buttons*/
            JButton addFilesToEncryptButton = mainPanel.getAddFileEncryptPanel().getButtonAdd();
            JButton removeFilesToEncryptButton = mainPanel.getAddFileEncryptPanel().getButtonRemove();
            JButton addFilesToDecryptButton = mainPanel.getAddFileDecryptPanel().getButtonAdd();
            JButton removeFilesToDecryptButton = mainPanel.getAddFileDecryptPanel().getButtonRemove();
            JButton encryptButton = mainPanel.getEncryptButtonPanel().getButton();
            JButton decryptButton = mainPanel.getDecryptButtonPanel().getButton();

            /*lists*/
            DefaultListModel<File> encryptListModel = mainPanel.getEncryptWindowPanel().getListModel();
            DefaultListModel<File> decryptListModel = mainPanel.getDecryptWindowPanel().getListModel();
            JList<File> encryptList = mainPanel.getEncryptWindowPanel().getFileList();
            JList<File> decryptList = mainPanel.getDecryptWindowPanel().getFileList();

            /*filechoosers*/
            JFileChooser fileChooserAddFilesToEncrypt = mainPanel.getAddFileEncryptPanel().getFileChooserAdd();
            JFileChooser fileChooserAddFilesToDecrypt = mainPanel.getAddFileDecryptPanel().getFileChooserAdd();
            //endregion

            //region Action listeners
            addFilesToEncryptButton.addActionListener(event ->
                    fileChooserAddFilesToEncrypt.showOpenDialog(mainPanel)
            );

            fileChooserAddFilesToEncrypt.addActionListener(event -> {
                if (event.getActionCommand().equals("ApproveSelection")) {
                    for (File f : fileChooserAddFilesToEncrypt.getSelectedFiles()) {
                        encryptListModel.addElement(!encryptListModel.contains(f) ? f : null);
                    }
                    mainPanel.repaint();
                }
                AppProperties.setCurrentWorkdir(fileChooserAddFilesToEncrypt
                        .getCurrentDirectory()
                        .getAbsolutePath());
            });

            removeFilesToEncryptButton.addActionListener(event -> {
                int[] toRemove = encryptList.getSelectedIndices();
                for (int i : toRemove) {
                    encryptListModel.remove(i);
                }
            });

            addFilesToDecryptButton.addActionListener(event ->
                    fileChooserAddFilesToDecrypt.showOpenDialog(mainPanel)
            );

            fileChooserAddFilesToDecrypt.addActionListener(event -> {
                if (event.getActionCommand().equals("ApproveSelection")) {
                    for (File f : fileChooserAddFilesToDecrypt.getSelectedFiles()) {
                        decryptListModel.addElement(!decryptListModel.contains(f) ? f : null);
                    }
                    mainPanel.repaint();
                }
                AppProperties.setCurrentWorkdir(fileChooserAddFilesToDecrypt
                        .getCurrentDirectory()
                        .getAbsolutePath());
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
            //endregion

            //region Menu
            /* Menu items */
            //File
            JMenuItem encrypt = menu.getEncrypt();
            JMenuItem decrypt = menu.getDecrypt();
            JMenuItem openDefaultDir = menu.getOpenDefaultDir();
            JMenuItem exit = menu.getExit();
            //Settings
            JRadioButtonMenuItem saveInCurrentDir = menu.getSaveInCurrentDir();
            JRadioButtonMenuItem saveInDefaultDir = menu.getSaveInDefaultDir();
            //Options
            JMenuItem setDefaultFolder = menu.getSetDefaultDir();
            //About
            JMenuItem aboutFileCrypt = menu.getAboutFileCrypt();

            /* Menu action listeners */
            //File
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
            //Settings
            saveInCurrentDir.addActionListener(event ->
                    AppProperties.saveIn(AppProperties.SaveOption.saveInCurrentDir)
            );
            saveInDefaultDir.addActionListener(event ->
                    AppProperties.saveIn(AppProperties.SaveOption.saveInDefaultDir)
            );
            //Options
            JFileChooser dirChooser = new JFileChooser(); //TODO: UI update
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
            //About
            aboutFileCrypt.addActionListener(event -> {
                try {
                    new CryptAboutDialog(frame);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            //endregion

            frame.setVisible(true);
        });
    }
}

