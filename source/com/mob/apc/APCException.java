package com.mob.apc;

public class APCException extends Exception {
    public int errorCode = 0;

    public APCException(String str) {
        super(str);
    }

    public APCException(int i11, String str) {
        super(str);
        this.errorCode = i11;
    }

    public APCException(Throwable th2) {
        super(th2);
    }
}
