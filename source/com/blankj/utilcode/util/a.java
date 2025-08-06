package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.util.Objects;

public final class a {
    public static void a(Class<? extends Activity> cls) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        b(cls, false);
    }

    public static void b(Class<? extends Activity> cls, boolean z11) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity next : a0.g()) {
            if (next.getClass().equals(cls)) {
                next.finish();
                if (!z11) {
                    next.overridePendingTransition(0, 0);
                }
            }
        }
    }

    public static Activity c() {
        return a0.t();
    }

    public static Context d() {
        if (!a0.w()) {
            return Utils.a();
        }
        Activity c11 = c();
        return c11 == null ? Utils.a() : c11;
    }

    public static boolean e(Activity activity) {
        return activity != null && !activity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed());
    }

    public static boolean f(Intent intent) {
        return Utils.a().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean g(Intent intent) {
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return h(intent, d(), (Bundle) null);
    }

    public static boolean h(Intent intent, Context context, Bundle bundle) {
        if (!f(intent)) {
            Log.e("ActivityUtils", "intent is unavailable");
            return false;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (bundle == null || Build.VERSION.SDK_INT < 16) {
            context.startActivity(intent);
            return true;
        }
        context.startActivity(intent, bundle);
        return true;
    }
}
