package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.g;
import com.xiaomi.push.ax;

public class s {
    public static AbstractPushManager a(Context context, d dVar) {
        return b(context, dVar);
    }

    private static AbstractPushManager b(Context context, d dVar) {
        g.a a11 = g.a(dVar);
        if (a11 == null || TextUtils.isEmpty(a11.f51317a) || TextUtils.isEmpty(a11.f51318b)) {
            return null;
        }
        return (AbstractPushManager) ax.a(a11.f51317a, a11.f51318b, context);
    }
}
