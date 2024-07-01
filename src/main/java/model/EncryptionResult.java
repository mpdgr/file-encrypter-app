package model;

public class EncryptionResult {
    public enum Operation {
        ENCRYPTION, DECRYPTION
    }

    public static final String INVALID_PASS = "Invalid Password!";
    public static final String ERROR = "Error! ";
    public static final String ENCRYPTION_SUCCESS = "Encryption complete!";
    public static final String DECRYPTION_SUCCESS = "Decryption complete!";

    private final Operation operation;
    private final boolean success;
    private final String errorMsg;

    public EncryptionResult(Operation operation, boolean success, String errorMsg) {
        this.operation = operation;
        this.success = success;
        this.errorMsg = errorMsg;
    }

    public Operation getOperation() {
        return operation;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
