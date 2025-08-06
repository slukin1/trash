package com.google.firebase.components;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;

public final class Preconditions {
    public static void checkArgument(boolean z11, String str) {
        if (!z11) {
            throw new IllegalArgumentException(str);
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11) {
        Objects.requireNonNull(t11);
        return t11;
    }

    public static void checkState(boolean z11, String str) {
        if (!z11) {
            throw new IllegalStateException(str);
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str) {
        Objects.requireNonNull(t11, str);
        return t11;
    }
}
