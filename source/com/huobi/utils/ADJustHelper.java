package com.huobi.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.LogLevel;
import com.hbg.lib.common.utils.SP;
import i6.d;
import kotlin.jvm.internal.x;

public final class ADJustHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final ADJustHelper f83670a = new ADJustHelper();

    /* renamed from: b  reason: collision with root package name */
    public static String f83671b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f83672c = "";

    public static final class ADJustActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            Adjust.onPause();
        }

        public void onActivityResumed(Activity activity) {
            Adjust.onResume();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static final String d() {
        return f83671b;
    }

    public static final String e() {
        if (x.b("0", f83672c)) {
            return "";
        }
        return f83672c;
    }

    public static final void g(Application application) {
        d.c("HBADJust", "开始初始化");
        String i11 = SP.i("ADJUST_ADID", "");
        String i12 = SP.i("ADJUST_GPS_ADID", "");
        boolean z11 = true;
        if (i11.length() > 0) {
            if (i12.length() <= 0) {
                z11 = false;
            }
            if (z11 && !x.b(i12, "00000000-0000-0000-0000-000000000000")) {
                ADJustHelper aDJustHelper = f83670a;
                aDJustHelper.j(i11);
                aDJustHelper.k(i12);
                d.c("HBADJust", "缓存 Adid : " + d());
                d.c("HBADJust", "缓存 Google Play Store Adid : " + aDJustHelper.f());
                d.c("HBADJust", "结束初始化");
            }
        }
        d.c("HBADJust", "ADJust初始化");
        AdjustConfig adjustConfig = new AdjustConfig(application, "rognvu24p3wg", "production");
        adjustConfig.setLogLevel(LogLevel.WARN);
        Adjust.initSdk(adjustConfig);
        Adjust.getAdid(a.f83714a);
        Adjust.getGoogleAdId(application, b.f83717a);
        application.registerActivityLifecycleCallbacks(new ADJustActivityLifecycleCallbacks());
        d.c("HBADJust", "结束初始化");
    }

    public static final void h(String str) {
        if (str == null) {
            str = "";
        }
        d.c("HBADJust", "Adid : " + str);
        ADJustHelper aDJustHelper = f83670a;
        aDJustHelper.c(str, aDJustHelper.f());
    }

    public static final void i(String str) {
        if (str == null) {
            str = "0";
        }
        d.c("HBADJust", "Google Play Store Adid : " + str);
        f83670a.c(d(), str);
    }

    public final void c(String str, String str2) {
        j(str);
        k(str2);
        boolean z11 = true;
        if (str.length() > 0) {
            if (str2.length() <= 0) {
                z11 = false;
            }
            if (z11) {
                SP.s("ADJUST_ADID", str);
                SP.s("ADJUST_GPS_ADID", str2);
            }
        }
    }

    public final String f() {
        return f83672c;
    }

    public final void j(String str) {
        f83671b = str;
    }

    public final void k(String str) {
        f83672c = str;
    }
}
