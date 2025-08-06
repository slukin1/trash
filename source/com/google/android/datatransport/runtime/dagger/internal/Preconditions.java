package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Objects;

public final class Preconditions {
    private Preconditions() {
    }

    public static <T> void checkBuilderRequirement(T t11, Class<T> cls) {
        if (t11 == null) {
            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
        }
    }

    public static <T> T checkNotNull(T t11) {
        Objects.requireNonNull(t11);
        return t11;
    }

    public static <T> T checkNotNull(T t11, String str) {
        Objects.requireNonNull(t11, str);
        return t11;
    }

    public static <T> T checkNotNull(T t11, String str, Object obj) {
        String str2;
        if (t11 != null) {
            return t11;
        }
        if (!str.contains("%s")) {
            throw new IllegalArgumentException("errorMessageTemplate has no format specifiers");
        } else if (str.indexOf("%s") == str.lastIndexOf("%s")) {
            if (obj instanceof Class) {
                str2 = ((Class) obj).getCanonicalName();
            } else {
                str2 = String.valueOf(obj);
            }
            throw new NullPointerException(str.replace("%s", str2));
        } else {
            throw new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
        }
    }
}
