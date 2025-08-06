package com.huobi.bugsdk;

import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.x;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.hbg.lib.common.utils.SP;
import li.a;

public class FirebaseHelper {

    /* renamed from: a  reason: collision with root package name */
    public static String f42856a = "";

    public static void b() {
        String i11 = SP.i("APP_INSTANCE_ID", "");
        if (!x.d(i11)) {
            f42856a = i11;
        } else {
            FirebaseAnalytics.getInstance(Utils.a()).getAppInstanceId().addOnCompleteListener(a.f58022a);
        }
    }

    public static String c() {
        if (x.d(f42856a)) {
            f42856a = SP.i("APP_INSTANCE_ID", "");
        }
        return f42856a;
    }

    public static /* synthetic */ void d(Task task) {
        if (task.isSuccessful()) {
            String str = (String) task.getResult();
            f42856a = str;
            SP.s("APP_INSTANCE_ID", str);
        }
    }

    public static void e(Throwable th2) {
        FirebaseCrashlytics.getInstance().recordException(th2);
    }

    public static void f(boolean z11) {
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(z11);
    }

    public static void g(String str, String str2) {
        FirebaseCrashlytics.getInstance().setCustomKey(str, str2);
    }

    public static void h(String str) {
        FirebaseCrashlytics.getInstance().setUserId(str);
    }
}
