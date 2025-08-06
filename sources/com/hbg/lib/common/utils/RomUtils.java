package com.hbg.lib.common.utils;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

public class RomUtils {
    public static String a(String str) {
        return SystemProperties.b(str, (String) null);
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toUpperCase(Locale.US).contains("QIKU");
    }

    public static boolean c() {
        String str = Build.MODEL;
        String str2 = Build.FINGERPRINT;
        return (!TextUtils.isEmpty(str) && str.toLowerCase().contains("COOLPAD")) || (!TextUtils.isEmpty(str2) && str2.toLowerCase().contains("COOLPAD"));
    }

    public static boolean d() {
        return i() || e() || h() || b() || j() || k() || g() || l() || f() || c();
    }

    public static boolean e() {
        return !TextUtils.isEmpty(a("ro.build.version.emui"));
    }

    public static boolean f() {
        return !TextUtils.isEmpty(a("ro.lenovo.lvp.version"));
    }

    public static boolean g() {
        return !TextUtils.isEmpty(a("ro.letv.eui"));
    }

    public static boolean h() {
        String a11 = a("ro.build.display.id");
        return !TextUtils.isEmpty(a11) && a11.toUpperCase(Locale.US).contains("FLYME");
    }

    public static boolean i() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name"));
    }

    public static boolean j() {
        return !TextUtils.isEmpty(a("ro.build.version.opporom"));
    }

    public static boolean k() {
        return !TextUtils.isEmpty(a("ro.vivo.os.version"));
    }

    public static boolean l() {
        String str = Build.MANUFACTURER;
        String str2 = Build.FINGERPRINT;
        return (!TextUtils.isEmpty(str) && (str2.toLowerCase().contains("NUBIA") || str2.toLowerCase().contains("ZTE"))) || (!TextUtils.isEmpty(str2) && (str2.toLowerCase().contains("NUBIA") || str2.toLowerCase().contains("ZTE")));
    }
}
