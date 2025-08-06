package com.facebook.stetho.common;

public class ExceptionUtil {
    public static RuntimeException propagate(Throwable th2) {
        propagateIfInstanceOf(th2, Error.class);
        propagateIfInstanceOf(th2, RuntimeException.class);
        throw new RuntimeException(th2);
    }

    public static <T extends Throwable> void propagateIfInstanceOf(Throwable th2, Class<T> cls) throws Throwable {
        if (cls.isInstance(th2)) {
            throw th2;
        }
    }

    public static <T extends Throwable> void sneakyThrow(Throwable th2) throws Throwable {
        throw th2;
    }
}
