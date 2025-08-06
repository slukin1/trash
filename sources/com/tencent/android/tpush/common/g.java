package com.tencent.android.tpush.common;

import android.os.Build;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static String f68912a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f68913b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f68914c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f68915d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f68916e = "";

    /* renamed from: f  reason: collision with root package name */
    private static String f68917f = "";

    public static String a() {
        try {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (lowerCase.contains(MTPushConstants.Manufacturer.HUAWEI)) {
                return f();
            }
            if (lowerCase.contains("xiaomi")) {
                return j();
            }
            if (lowerCase.contains(MTPushConstants.Manufacturer.MEIZU)) {
                return i();
            }
            if (!lowerCase.contains(MTPushConstants.Manufacturer.OPPO)) {
                if (!lowerCase.contains(MTPushConstants.Manufacturer.REALME)) {
                    if (lowerCase.contains("vivo")) {
                        return g();
                    }
                    if (lowerCase.contains(MTPushConstants.Manufacturer.ONEPLUS)) {
                        return k();
                    }
                    return "";
                }
            }
            return h();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean b() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    public static String c() {
        return a("hw_sc.build.platform.version");
    }

    public static int d() {
        int i11 = -1;
        try {
            String a11 = a("hw_sc.build.platform.version");
            String substring = a11.indexOf(InstructionFileId.DOT) >= 0 ? a11.substring(0, a11.indexOf(InstructionFileId.DOT)) : a11;
            if (substring == null || substring.length() < 1) {
                TLogger.i("RomVersionHelper", "substring:" + substring + ", harmonyVersionStr:" + a11);
            } else {
                i11 = Integer.valueOf(substring).intValue();
            }
            TLogger.i("RomVersionHelper", "harmonyOSMajoyVersionInt:" + i11);
        } catch (Throwable th2) {
            TLogger.w("RomVersionHelper", "getHarmonyVerionMajoyInt failed:" + th2);
        }
        return i11;
    }

    public static boolean e() {
        try {
            if (!b()) {
                TLogger.i("RomVersionHelper", " not HarmonyOS");
                return false;
            } else if (!ChannelUtils.isBrandHuaWei()) {
                TLogger.i("RomVersionHelper", "Brand not HuaWei");
                return false;
            } else if (d() >= 4) {
                return true;
            } else {
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String f() {
        if (!TextUtils.isEmpty(f68912a)) {
            return f68912a;
        }
        String a11 = a("ro.build.version.emui");
        f68912a = a11;
        return a11;
    }

    private static String g() {
        if (!TextUtils.isEmpty(f68914c)) {
            return f68914c;
        }
        String a11 = a("ro.vivo.os.build.display.id");
        f68914c = a11;
        return a11;
    }

    private static String h() {
        if (!TextUtils.isEmpty(f68913b)) {
            return f68913b;
        }
        String a11 = a("ro.build.version.opporom");
        f68913b = a11;
        return a11;
    }

    private static String i() {
        if (!TextUtils.isEmpty(f68917f)) {
            return f68917f;
        }
        String a11 = a("ro.build.display.id");
        f68917f = a11;
        return a11;
    }

    private static String j() {
        if (!TextUtils.isEmpty(f68916e)) {
            return f68916e;
        }
        String a11 = a("ro.miui.ui.version.name");
        f68916e = a11;
        return a11;
    }

    private static String k() {
        if (!TextUtils.isEmpty(f68915d)) {
            return f68915d;
        }
        String a11 = a("ro.rom.version");
        f68915d = a11;
        return a11;
    }

    private static String a(String str) {
        try {
            Object[] objArr = {str};
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, objArr);
            TLogger.i("RomVersionHelper", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable unused) {
            return "";
        }
    }
}
