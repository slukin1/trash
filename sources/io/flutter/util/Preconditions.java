package io.flutter.util;

import java.util.Objects;

public final class Preconditions {
    private Preconditions() {
    }

    public static <T> T checkNotNull(T t11) {
        Objects.requireNonNull(t11);
        return t11;
    }

    public static void checkState(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
