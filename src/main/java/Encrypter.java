import javax.crypto.*;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Encrypter {
    SecretKey secretKey;
    Cipher cipher;
//    Encrypter(String transformation) throws NoSuchPaddingException, NoSuchAlgorithmException {
//        this.secretKey = KeyGenerator.getInstance("AES").generateKey();
//        this.cipher = Cipher.getInstance(transformation);
//    }
//
//    void encrypt(String content) throws InvalidKeyException, IOException {
//        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//        byte[] iv = cipher.getIV();
//
//        CipherOutputStream cipherOut = new CipherOutputStream(new ByteArrayOutputStream(content.getBytes().length), cipher) {
//            fileOut.write(iv);
//            cipherOut.write(content.getBytes());
//        }
//    }
}
