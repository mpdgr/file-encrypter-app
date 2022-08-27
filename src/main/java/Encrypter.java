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
import java.util.Arrays;

public class Encrypter {


    public static void encryptFile(SecretKey key) throws IOException, NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        String algorithm = "AES/CBC/PKCS5Padding";

        byte[] ivBytes = new byte[16];
        byte[] salt = new byte[16];
        SecureRandom rand = new SecureRandom();
        rand.nextBytes(ivBytes);
        rand.nextBytes(salt);

        System.out.println(Arrays.toString(ivBytes));
        System.out.println(Arrays.toString(salt));

        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        String inputFilePath = "src/main/resources/files/pliktekstowy.txt";
//        String inputFilePath = "src/main/resources/files/ppttest.pptx";
        File inputFile = new File(inputFilePath);

        String outputFilePath = "src/main/resources/files/pliktekstowy.txt.enc";
//        String outputFilePath = "src/main/resources/files/ppttest.pptx.enc";
        File outputFile = new File(outputFilePath);


        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        byte[] buffer = new byte[64];
        outputStream.write(ivBytes);
        outputStream.write(salt);
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
    }

    public static void decryptFile(SecretKey key) throws IOException, NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        String algorithm = "AES/CBC/PKCS5Padding";

        String inputFilePath = "src/main/resources/files/pliktekstowy.txt.enc";
//        String inputFilePath = "src/main/resources/files/ppttest.pptx.enc";
        File inputFile = new File(inputFilePath);
        FileInputStream inputStream = new FileInputStream(inputFile);

        String outputFilePath = "src/main/resources/files/pliktekstowy_decrypt.txt";
//        String outputFilePath = "src/main/resources/files/ppttest_decrypt.pptx";
        File outputFile = new File(outputFilePath);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        byte[] ivBytes = new byte[16];
        byte[] salt = new byte[16];
        inputStream.read(ivBytes);
        inputStream.read(salt);


//        byte[] nextBytes = new byte[16];
//        inputStream.read(nextBytes);

        System.out.println(Arrays.toString(ivBytes));
        System.out.println(Arrays.toString(salt));

        IvParameterSpec iv = new IvParameterSpec(ivBytes);

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
    }


// AES/CBC/PKCS5Padding
// Original size + padding + 16 bytes for IV
// params: input, key, IV

    //KEY GENERATOR; n = size 128/192/256
    public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(n);
        SecretKey key = keyGenerator.generateKey();
        return key;
    }
}
//    //IV generator - size = block size = 16 bytes
//    public static IvParameterSpec generateIv() {
//        byte[] iv = new byte[16];
//        new SecureRandom().nextBytes(iv);
//        return new IvParameterSpec(iv);
//    }


