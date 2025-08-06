package com.hbg.lib.common.utils;

import java.io.PrintStream;

public class SystemUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f67493a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f67494b = a("1.6");

    /* renamed from: c  reason: collision with root package name */
    public static final String f67495c = b("java.specification.version");

    public static boolean a(String str) {
        return d(f67495c, str);
    }

    public static String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            PrintStream printStream = System.err;
            printStream.println("Caught a SecurityException reading the system property '" + str + "'; the SystemUtils property value will default to null.");
            return null;
        }
    }

    public static boolean c() {
        return true;
    }

    public static boolean d(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }
}
