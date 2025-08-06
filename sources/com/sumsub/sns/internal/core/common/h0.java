package com.sumsub.sns.internal.core.common;

import android.content.Context;
import kotlin.jvm.internal.x;

public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final h0 f32066a = new h0();

    public final boolean a(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String b11 : strArr) {
                    if (x.b(b11, str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
