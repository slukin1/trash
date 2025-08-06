package com.tencent.android.tpush.service.util;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.Md5;

public class e {
    private static String a(String str) {
        return Md5.md5(str);
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            f.b(context, a(str), str2);
            return true;
        } catch (Throwable th2) {
            TLogger.e("ServicePushInfoMd5Pref", "putString", th2);
            return false;
        }
    }

    public static String a(Context context, String str) {
        try {
            return f.a(context, a(str), (String) null);
        } catch (Throwable th2) {
            TLogger.e("ServicePushInfoMd5Pref", "getString", th2);
            return null;
        }
    }
}
