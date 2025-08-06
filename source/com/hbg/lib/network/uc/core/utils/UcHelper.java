package com.hbg.lib.network.uc.core.utils;

import android.os.Build;
import android.text.TextUtils;
import java.util.UUID;

public class UcHelper {

    /* renamed from: a  reason: collision with root package name */
    public static String f70779a;

    public static String a() {
        String str = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10);
        try {
            return new UUID((long) str.hashCode(), (long) Build.class.getField("SERIAL").get((Object) null).toString().hashCode()).toString();
        } catch (Exception unused) {
            return new UUID((long) str.hashCode(), (long) -905839116).toString();
        }
    }

    public static String b(boolean z11) {
        if (!z11) {
            return a();
        }
        if (TextUtils.isEmpty(f70779a)) {
            f70779a = a();
        }
        return f70779a;
    }
}
