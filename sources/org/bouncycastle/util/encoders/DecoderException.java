package org.bouncycastle.util.encoders;

public class DecoderException extends IllegalStateException {
    private Throwable cause;

    public DecoderException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
