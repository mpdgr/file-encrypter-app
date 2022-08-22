import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EncrypterTest {
    @Test
    void stringToBytes(){
        String test = "test";
        byte[] testBytes = test.getBytes(StandardCharsets.US_ASCII);
        System.out.println(Arrays.toString(testBytes));
    }
}