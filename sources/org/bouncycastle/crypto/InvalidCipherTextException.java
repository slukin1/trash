package org.bouncycastle.crypto;

public class InvalidCipherTextException extends CryptoException {
    public InvalidCipherTextException() {
    }

    public InvalidCipherTextException(String str) {
        super(str);
    }

    public InvalidCipherTextException(String str, Throwable th2) {
        super(str, th2);
    }
}
