package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

public enum Throwables {
    ;
    
    private static final int MAX_RETRY = 1000;

    public static Throwable getRootCause(Throwable th2) {
        if (th2 == null) {
            return th2;
        }
        int i11 = 0;
        Throwable th3 = th2;
        while (i11 < 1000) {
            Throwable cause = th3.getCause();
            if (cause == null) {
                return th3;
            }
            i11++;
            th3 = cause;
        }
        Log b11 = LogFactory.b(Throwables.class);
        b11.h("Possible circular reference detected on " + th2.getClass() + ": [" + th2 + "]");
        return th2;
    }
}
