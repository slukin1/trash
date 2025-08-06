package com.iproov.sdk.p009do;

import android.content.Context;
import android.os.Build;
import com.iproov.sdk.core.exception.IProovException;
import java.util.Arrays;
import kotlin.jvm.internal.d0;

/* renamed from: com.iproov.sdk.do.do  reason: invalid class name and invalid package */
public final class Cdo {
    /* renamed from: do  reason: not valid java name */
    public static final String m565do(IProovException iProovException) {
        return "Exception: " + iProovException.getClass().getSimpleName() + ' ' + iProovException.getReason();
    }

    /* renamed from: do  reason: not valid java name */
    public static final String m564do(double d11) {
        d0 d0Var = d0.f56774a;
        return String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d11)}, 1));
    }

    /* renamed from: do  reason: not valid java name */
    public static final boolean m566do(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return context.getPackageManager().isInstantApp();
        }
        try {
            context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
