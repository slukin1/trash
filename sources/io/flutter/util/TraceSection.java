package io.flutter.util;

import u1.a;

public final class TraceSection {
    public static void begin(String str) {
        a.c(cropSectionName(str));
    }

    public static void beginAsyncSection(String str, int i11) {
        a.a(cropSectionName(str), i11);
    }

    private static String cropSectionName(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void end() throws RuntimeException {
        a.f();
    }

    public static void endAsyncSection(String str, int i11) {
        a.d(cropSectionName(str), i11);
    }
}
