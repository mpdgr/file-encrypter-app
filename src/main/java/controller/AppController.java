package controller;

import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;

public class AppController {
    public static void main(String[] args) {

        EventQueue.invokeLater(() ->
        {
            CryptFrame frame = new CryptFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MainPanel mainPanel = new MainPanel();
            frame.add(mainPanel);

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
            JFileChooser fileChooserRemoveFilesToEncrypt = mainPanel.getAddFileEncryptPanel().getFileChooserRemove();

            JFileChooser fileChooserAddFilesToDecrypt = mainPanel.getAddFileDecryptPanel().getFileChooserAdd();
            JFileChooser fileChooserRemoveFilesToDecrypt = mainPanel.getAddFileDecryptPanel().getFileChooserRemove();

            addFilesToEncryptButton.addActionListener(event -> fileChooserAddFilesToEncrypt.showOpenDialog(mainPanel));
            fileChooserAddFilesToEncrypt.addActionListener(event -> {
                System.out.println(event.getActionCommand());
                if(event.getActionCommand().equals("ApproveSelection")) {
                    for (File f : fileChooserAddFilesToEncrypt.getSelectedFiles()) {
                        encryptListModel.addElement(!encryptListModel.contains(f) ? f : null);
                    }
                    mainPanel.repaint();
                }
            });
            removeFilesToEncryptButton.addActionListener(event -> {
                int[] toRemove = encryptList.getSelectedIndices();
                System.out.println(Arrays.toString(toRemove));
                System.out.println(encryptListModel);
                for (int i : toRemove){
                encryptListModel.remove(i);
                }
            });

            addFilesToDecryptButton.addActionListener(event -> fileChooserAddFilesToDecrypt.showOpenDialog(mainPanel));
            fileChooserAddFilesToDecrypt.addActionListener(event -> {
                System.out.println(event.getActionCommand());
                if(event.getActionCommand().equals("ApproveSelection")) {
                    for (File f : fileChooserAddFilesToDecrypt.getSelectedFiles()) {
                        decryptListModel.addElement(!decryptListModel.contains(f) ? f : null);
                    }
                    mainPanel.repaint();
                }
            });
            removeFilesToDecryptButton.addActionListener(event -> {
                int[] toRemove = decryptList.getSelectedIndices();
                System.out.println(Arrays.toString(toRemove));
                System.out.println(decryptListModel);
                for (int i : toRemove){
                    decryptListModel.remove(i);
                }
            });
//            CryptPassword passwordField = new CryptPassword();
//            passwordField.addActionListener();

            frame.setVisible(true);

            CryptPasswordDialog encryptPassDialog = new CryptPasswordDialog(frame, true, "Encrypt!");
            CryptPasswordDialog decryptPassDialog = new CryptPasswordDialog(frame, true, "Decrypt!");
            JButton encryptPassButton = encryptPassDialog.getButton();
            JButton decryptPassButton = decryptPassDialog.getButton();

            encryptButton.addActionListener(event -> {
                if (encryptListModel.isEmpty()) {
                    new CryptMessageDialog(frame, true, "Add files to encrypt");
                } else {
                    encryptPassDialog.setVisible(true);
                }
            });

            encryptPassButton.addActionListener(event -> runDecrypt(encryptListModel, password));
            decryptPassButton.addActionListener(event -> runEncrypt(decryptListModel, password));


//            decryptButton.addActionListener(event -> encryptPassDialog = new CryptPasswordDialog(frame, true, "Decrypt!"));




        });


    }
    }

