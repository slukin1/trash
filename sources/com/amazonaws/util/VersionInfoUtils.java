package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

public class VersionInfoUtils {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f15574a = "2.76.1";

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f15575b = "android";

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f15576c;

    /* renamed from: d  reason: collision with root package name */
    public static final Log f15577d = LogFactory.b(VersionInfoUtils.class);

    public static String a() {
        return f15575b;
    }

    public static String b() {
        if (f15576c == null) {
            synchronized (VersionInfoUtils.class) {
                if (f15576c == null) {
                    d();
                }
            }
        }
        return f15576c;
    }

    public static String c() {
        return f15574a;
    }

    public static void d() {
        f15576c = f();
    }

    public static String e(String str) {
        return str != null ? str.replace(' ', '_') : str;
    }

    public static String f() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("aws-sdk-");
        sb2.append(StringUtils.b(a()));
        sb2.append("/");
        sb2.append(c());
        sb2.append(" ");
        sb2.append(e(System.getProperty("os.name")));
        sb2.append("/");
        sb2.append(e(System.getProperty("os.version")));
        sb2.append(" ");
        sb2.append(e(System.getProperty("java.vm.name")));
        sb2.append("/");
        sb2.append(e(System.getProperty("java.vm.version")));
        sb2.append("/");
        sb2.append(e(System.getProperty("java.version")));
        String property = System.getProperty("user.language");
        String property2 = System.getProperty("user.region");
        if (!(property == null || property2 == null)) {
            sb2.append(" ");
            sb2.append(e(property));
            sb2.append("_");
            sb2.append(e(property2));
        }
        return sb2.toString();
    }
}
