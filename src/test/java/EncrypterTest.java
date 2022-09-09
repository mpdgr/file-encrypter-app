import model.Encrypter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

class EncrypterTest {

    @Test
    void encryptAndDecryptShouldSuccseedWithCorrectPassword() throws IOException {
        File plain = new File("C:\\java\\FileEncryption\\src\\main\\resources\\files\\plain.txt");
        String passwordString = "test";
        char[] password = passwordString.toCharArray();

        File encrypted = encryptFileTest(plain, password);
        File decrypted = decryptFileTest(encrypted, password);

        FileInputStream plainStream = new FileInputStream(plain);
        FileInputStream decryptedStream = new FileInputStream(decrypted);
        byte[] plainBytes = plainStream.readAllBytes();
        byte[] decryptedBytes = decryptedStream.readAllBytes();

        Assertions.assertArrayEquals(plainBytes, decryptedBytes);
    }

    @Test
    void encryptAndDecryptShouldFailWithWrongPassword() throws IOException {

        File plain = new File("C:\\java\\FileEncryption\\src\\main\\resources\\files\\plain.txt");
        String passwordString = "test";
        char[] password = passwordString.toCharArray();
        String wrongPasswordString = "wrong";
        char[] wrongPassword = wrongPasswordString.toCharArray();

        File encrypted = encryptFileTest(plain, password);
        File decrypted = decryptFileTest(encrypted, wrongPassword);

        FileInputStream plainStream = new FileInputStream(plain);
        FileInputStream decryptedStream = new FileInputStream(decrypted);
        byte[] plainBytes = plainStream.readAllBytes();
        byte[] decryptedBytes = decryptedStream.readAllBytes();

        Assertions.assertFalse(Arrays.equals(plainBytes, decryptedBytes));
    }

    File encryptFileTest(File file, char[] password){

        String outputPath = "C:\\java\\FileEncryption\\src\\main\\resources\\files\\encrypted.txt.enc";

        Encrypter encrypter = new Encrypter();
        try {
            encrypter.encryptFile(file.getPath(), outputPath, password);
        } catch (IOException | NoSuchPaddingException | NoSuchAlgorithmException |
                InvalidAlgorithmParameterException | InvalidKeyException |
                BadPaddingException | IllegalBlockSizeException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return new File(outputPath);
    }

    File decryptFileTest(File file, char[] password){

        String outputPath = "C:\\java\\FileEncryption\\src\\main\\resources\\files\\decrypted.txt";

        Encrypter encrypter = new Encrypter();
        try {
            encrypter.decryptFile(file.getPath(), outputPath, password);
        } catch (IOException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return new File(outputPath);
    }
}

