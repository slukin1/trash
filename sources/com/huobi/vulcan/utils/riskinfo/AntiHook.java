package com.huobi.vulcan.utils.riskinfo;

import android.content.Context;
import com.huobi.vulcan.core.SecurityKey;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AntiHook {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f20625a = {"de.robv.android.xposed.installer", "me.weishu.exp", "com.saurik.substrate", "io.va.exposed"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f20626b = {"org.meowcat.edxposed.manager", "com.topjohnwu.magisk", "com.doubee.ig", "com.soft.apk008v", "com.soft.controllers", "biz.bokhorst.xprivacy"};

    public static boolean a() {
        try {
            Field declaredField = ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedBridge").getDeclaredField("disableHooks");
            declaredField.setAccessible(true);
            declaredField.set((Object) null, Boolean.TRUE);
            return true;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return false;
        }
    }

    public static boolean b() {
        return Utils.c("de.robv.android.xposed.XposedHelpers");
    }

    public static boolean c(Context context, List<String> list) {
        return PMUtils.b(context, list);
    }

    public static boolean d() {
        return SecurityKey.dxpm() > 0;
    }

    public static boolean e() {
        return SecurityKey.dxn() > 0;
    }

    public static boolean f() {
        return SecurityKey.dxr() > 0;
    }

    public static boolean g() {
        try {
            throw new Exception();
        } catch (Exception e11) {
            for (StackTraceElement className : e11.getStackTrace()) {
                if (ReUtils.a(className.getClassName(), "de.robv.android.xposed.XposedBridge|me.weishu.epic.|me.weishu.exposed.|com.saurik.substrate")) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean h() {
        try {
            Method declaredMethod = Throwable.class.getDeclaredMethod("getStackTrace", new Class[0]);
            if (declaredMethod != null) {
                return Modifier.isNative(declaredMethod.getModifiers());
            }
            return false;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    public static boolean i() {
        return System.getProperty("vxp") != null;
    }

    public static boolean j() {
        try {
            return System.getenv("CLASSPATH").contains("XposedBridge");
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static boolean k() {
        return Utils.c("com.elderdrivers.riru.edxp.config.EdXpConfigGlobal");
    }

    public static boolean l() {
        if (SecurityKey.dfpm() <= 0 && SecurityKey.dfn() <= 0 && SecurityKey.dft() <= 0 && SecurityKey.dffp() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean m(Context context) {
        return n(context) || l();
    }

    public static boolean n(Context context) {
        return a() || b() || c(context, new ArrayList(Arrays.asList(f20625a))) || g() || h() || i() || j() || k() || d() || e() || f();
    }
}
