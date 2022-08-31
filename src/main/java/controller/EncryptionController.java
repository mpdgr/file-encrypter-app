package controller;

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
import java.util.Arrays;

public class EncryptionController {
    String runEncrypt (DefaultListModel<File> listModel, char[] password){
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
        System.out.println(Arrays.toString(password));
        return "test";
    }

    String runDecrypt (DefaultListModel<File> listModel, char[] password){
        System.out.println(Arrays.toString(password));
        return "test";
    }

    String getTargetDir(String inputParent){
        return inputParent;
//        TODO: targetDir options
    }

}
