package com.amazonaws.mobileconnectors.s3.transferutility;

public class TransferUtilityException extends Exception {
    public TransferUtilityException() {
    }

    public TransferUtilityException(String str) {
        super(str);
    }

    public TransferUtilityException(String str, Throwable th2) {
        super(str, th2);
    }

    public TransferUtilityException(Throwable th2) {
        super(th2);
    }
}
