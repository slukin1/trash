package com.sensorsdata.analytics.android.sdk.exceptions;

public class InvalidDataException extends Exception {
    public InvalidDataException(String str) {
        super(str);
    }

    public InvalidDataException(Throwable th2) {
        super(th2);
    }
}
