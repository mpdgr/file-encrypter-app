package view;

import model.EncryptionResult;

public class Util {
    public static String padString (int targetLength, String inp) {
        boolean padRight = true;
        String space = " ";

        if (inp.length() < targetLength) {
            while (inp.length() < targetLength) {
                inp = padRight ? inp + space : space + inp;
                padRight = !padRight;
            }
        }

        return inp;
    }

    public static String formatResultInfo(EncryptionResult result) {
        String info;
        if (result.isSuccess() && result.getOperation() == EncryptionResult.Operation.ENCRYPTION) {
            info = padString(34, EncryptionResult.ENCRYPTION_SUCCESS);
        } else if (result.isSuccess() && result.getOperation() == EncryptionResult.Operation.DECRYPTION) {
            info = padString(34, EncryptionResult.DECRYPTION_SUCCESS);
        } else if (result.getErrorMsg().equals(EncryptionResult.INVALID_PASS)) {
            info = padString(34, EncryptionResult.INVALID_PASS);
        } else {
            info = padString(34, EncryptionResult.ERROR + result.getErrorMsg());
        }
        return info;
    }
}
