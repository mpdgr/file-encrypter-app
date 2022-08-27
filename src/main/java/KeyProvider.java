import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class KeyProvider {
    public static SecretKey generateKey (char[] password, byte[] salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec keySpec = new PBEKeySpec(password, salt, 65536, 256);
        return new SecretKeySpec(secretKeyFactory.generateSecret(keySpec).getEncoded(), "AES");
    }
}

    //TODO: password overwrite

//    public static SecretKey generateKey(char[] password, byte[] salt)
//            throws NoSuchAlgorithmException, InvalidKeySpecException {
//
//        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
//        KeySpec keySpec = new PBEKeySpec(password, salt, 65536, 256);
//        return new SecretKeySpec(keyFactory.generateSecret(keySpec).getEncoded(), "AES");
//    }
//
//    public static SecretKey getKeyFromPassword(char[] password)
//            throws NoSuchAlgorithmException, InvalidKeySpecException {
//
//        byte[] salt = new byte[16];
//        SecureRandom rand = new SecureRandom();
//        rand.nextBytes(salt);
//
//        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
//        KeySpec keySpec = new PBEKeySpec(password, salt, 65536, 256);
//        return new SecretKeySpec(keyFactory.generateSecret(keySpec).getEncoded(), "AES");
//    }



