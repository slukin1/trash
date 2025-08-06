package com.sumsub.sns.internal.core.common;

public final class u0 {
    public static final boolean a() {
        try {
            Class.forName("com.sumsub.sns.eid.BuildConfig");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final boolean b() {
        try {
            Class.forName("com.sumsub.sns.videoident.BuildConfig");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
