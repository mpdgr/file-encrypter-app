package controller;

import config.AppProperties;
import model.Encrypter;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class EncrypterController {
    void runEncrypt (DefaultListModel<File> listModel, char[] password){
        File[] files = new File[listModel.getSize()];
        listModel.copyInto(files);
        for (File f : files){
            String parent = f.getParent();
            String fileName = f.getName();
            String outputParent = getTargetDir(parent);
            String outputFileName = outputParent + '/' + fileName + ".enc";

            Encrypter encrypter = new Encrypter();
            //noinspection TryWithIdenticalCatches
            try {
                encrypter.encryptFile(f.getPath(), outputFileName, password);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidAlgorithmParameterException |
                    InvalidKeyException | BadPaddingException | IllegalBlockSizeException |
                    InvalidKeySpecException e) {
                e.printStackTrace();
            }
        }
    }

    void runDecrypt (DefaultListModel<File> listModel, char[] password){
        File[] files = new File[listModel.getSize()];
        listModel.copyInto(files);
        for (File f : files){
            String parent = f.getParent();
            String fileName = f.getName();
            String outputParent = getTargetDir(parent);
            String outputFileName = outputParent + '/' + fileName.replaceFirst(".enc", "");

            Encrypter encrypter = new Encrypter();
            //noinspection TryWithIdenticalCatches
            try {
                encrypter.decryptFile(f.getPath(), outputFileName, password);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidAlgorithmParameterException |
                    InvalidKeyException | BadPaddingException | IllegalBlockSizeException |
                    InvalidKeySpecException e) {
                e.printStackTrace();
            }
        }
    }

    String getTargetDir(String inputParent){
        return AppProperties.getSaveSetting().equals(AppProperties.SaveOption.saveInDefaultDir) ?
            AppProperties.getDefaultDir() : inputParent;
    }
}
