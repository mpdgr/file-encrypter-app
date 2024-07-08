package controller;

import config.AppProperties;
import model.Encrypter;
import model.EncryptionResult;

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
import java.util.Arrays;

public class EncrypterController {
    EncryptionResult runEncrypt (DefaultListModel<File> listModel, char[] password){
        String errorMsg = null;
        File[] files = new File[listModel.getSize()];
        listModel.copyInto(files);
        for (File f : files) {
            String parent = f.getParent();
            String fileName = f.getName();
            String outputParent = getTargetDir(parent);
            String outputFileName = outputParent + '/' + fileName + ".enc";

            Encrypter encrypter = new Encrypter();
            try {
                encrypter.encryptFile(f.getPath(), outputFileName, password);
            } catch (IOException | NoSuchPaddingException | NoSuchAlgorithmException |
                     InvalidAlgorithmParameterException | InvalidKeyException |
                     BadPaddingException | IllegalBlockSizeException | InvalidKeySpecException e) {
                e.printStackTrace();
                errorMsg = e.getClass().getSimpleName();
                break;
            }
        }
        Arrays.fill(password, '0');
        boolean success = errorMsg == null;
        return new EncryptionResult(EncryptionResult.Operation.ENCRYPTION, success, errorMsg);
    }

    EncryptionResult runDecrypt (DefaultListModel<File> listModel, char[] password){
        String errorMsg = null;
        File[] files = new File[listModel.getSize()];
        listModel.copyInto(files);
        for (File f : files) {
            String parent = f.getParent();
            String fileName = f.getName();
            String outputParent = getTargetDir(parent);
            String outputFileName = outputParent + '/' + fileName.replaceFirst(".enc", "");

            Encrypter encrypter = new Encrypter();
            try {
                encrypter.decryptFile(f.getPath(), outputFileName, password);
            } catch (IOException | NoSuchAlgorithmException | InvalidAlgorithmParameterException |
                    InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException |
                    InvalidKeySpecException e) {
                e.printStackTrace();
                errorMsg = e.getClass().getSimpleName();
                break;
            } catch (BadPaddingException e) {
                errorMsg = EncryptionResult.INVALID_PASS;
                break;
            }
        }
        Arrays.fill(password, '0');
        boolean success = errorMsg == null;
        return new EncryptionResult(EncryptionResult.Operation.DECRYPTION, success, errorMsg);
    }

    String getTargetDir(String inputParent){
        return AppProperties.getSaveSetting().equals(AppProperties.SaveOption.saveInDefaultDir) ?
            AppProperties.getDefaultDir() : inputParent;
    }
}
