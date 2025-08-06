package com.huobi.edgeengine.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;

public class Utils {

    /* renamed from: a  reason: collision with root package name */
    public static Application f44363a;

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<Activity> f44364b;

    public class a implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            Utils.f44364b = new WeakReference<>(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static int a(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void b(Context context) {
        if (f44363a == null) {
            Application application = (Application) context.getApplicationContext();
            f44363a = application;
            application.registerActivityLifecycleCallbacks(new a());
        }
    }
}
