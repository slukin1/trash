package com.google.android.exoplayer2.drm;

public class DecryptionException extends Exception {
    public final int errorCode;

    public DecryptionException(int i11, String str) {
        super(str);
        this.errorCode = i11;
    }
}
