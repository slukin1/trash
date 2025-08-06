package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class Platform {
    private Platform() {
    }

    public static boolean isInstanceOfThrowableClass(Throwable th2, Class<? extends Throwable> cls) {
        return cls.isInstance(th2);
    }
}
