package com.huobi.utils;

import android.text.TextUtils;
import com.hbg.lib.common.utils.SP;

public class UpgradeUtil {

    /* renamed from: a  reason: collision with root package name */
    public static String f83706a;

    public static String a() {
        return f83706a;
    }

    public static boolean b() {
        boolean z11 = !SP.l("ACCOUNT_NEW_VERSION_DOT_KEY105400", false);
        if (!c() || !z11) {
            return false;
        }
        return true;
    }

    public static boolean c() {
        return !TextUtils.isEmpty(f83706a);
    }

    public static void d(String str) {
        f83706a = str;
    }
}
