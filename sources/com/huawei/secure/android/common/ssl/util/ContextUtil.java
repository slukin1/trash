package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

public class ContextUtil {

    /* renamed from: a  reason: collision with root package name */
    public static Context f38655a;

    public static Context a() {
        return f38655a;
    }

    public static void b(Context context) {
        if (context != null && f38655a == null) {
            f38655a = context.getApplicationContext();
        }
    }
}
