package org.bouncycastle.util;

public class Exceptions {
    public static IllegalArgumentException illegalArgumentException(String str, Throwable th2) {
        return new IllegalArgumentException(str, th2);
    }

    public static IllegalStateException illegalStateException(String str, Throwable th2) {
        return new IllegalStateException(str, th2);
    }
}
