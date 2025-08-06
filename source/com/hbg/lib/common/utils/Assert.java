package com.hbg.lib.common.utils;

import i6.d;

public class Assert {
    public static void a(boolean z11) {
        if (!z11 && d.k()) {
            StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
            b(z11, "Assert error! Class:" + stackTrace[1].getClassName() + " Method:" + stackTrace[1].getMethodName() + " Line:" + stackTrace[1].getLineNumber());
        }
    }

    public static void b(boolean z11, String str) {
        if (!z11 && d.k()) {
            throw new RuntimeException(str);
        }
    }
}
