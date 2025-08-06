package com.google.android.exoplayer2.decoder;

public class DecoderException extends Exception {
    public DecoderException(String str) {
        super(str);
    }

    public DecoderException(Throwable th2) {
        super(th2);
    }

    public DecoderException(String str, Throwable th2) {
        super(str, th2);
    }
}
