package model;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class Encrypter {

    public void encryptFile(String inputFilePath, String outputFilePath, char[] password)
            throws IOException, NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException, InvalidKeySpecException {

        SecureRandom rand = new SecureRandom();

        /* create IV vector */
        byte[] ivBytes = new byte[16];
        rand.nextBytes(ivBytes);
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        /* create salt for secret key */
        byte[] salt = new byte[16];
        rand.nextBytes(salt);

        /* create secret key */
        SecretKey key = KeyProvider.generateKey(password, salt);

        /* run cipher */
        String algorithm = "AES/CBC/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

        File inputFile = new File(inputFilePath);
        FileInputStream inputStream = new FileInputStream(inputFile);

        File outputFile = new File(outputFilePath);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        /* write iv and salt at the beginning of the output */
        outputStream.write(ivBytes);
        outputStream.write(salt);

        /* write encrypted file into the output */
        byte[] buffer = new byte[64];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byte[] output = cipher.update(buffer, 0, bytesRead);
            if (output != null) {
                outputStream.write(output);
            }
        }
        byte[] outputBytes = cipher.doFinal();
        if (outputBytes != null) {
            outputStream.write(outputBytes);
        }
        inputStream.close();
        outputStream.close();

        for (char c : password){
            c = '0';
        }
    }

    public void decryptFile(String inputFilePath, String outputFilePath, char[] password)
            throws IOException, NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException, InvalidKeySpecException {

        File inputFile = new File(inputFilePath);
        FileInputStream inputStream = new FileInputStream(inputFile);

        File outputFile = new File(outputFilePath);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        byte[] ivBytes = new byte[16];
        byte[] salt = new byte[16];

        /* read iv and salt from the beginning of the input */
        inputStream.read(ivBytes);
        inputStream.read(salt);

        /* retrieve secret key */
        SecretKey key = KeyProvider.generateKey(password, salt);

        /* create IV vector */
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        /* run cipher */
        String algorithm = "AES/CBC/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);

        byte[] buffer = new byte[64];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byte[] output = cipher.update(buffer, 0, bytesRead);
            if (output != null) {
                outputStream.write(output);
            }
        }
        byte[] output = cipher.doFinal();
        if (output != null) {
            outputStream.write(output);
        }
        inputStream.close();
        outputStream.close();

        for (char c : password){
            c = '0';
        }
    }
}
