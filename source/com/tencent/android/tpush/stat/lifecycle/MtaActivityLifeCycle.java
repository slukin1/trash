package com.tencent.android.tpush.stat.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;

public class MtaActivityLifeCycle {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static int f70051a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static long f70052b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static Activity f70053c;

    public static /* synthetic */ int b(int i11) {
        int i12 = f70051a + i11;
        f70051a = i12;
        return i12;
    }

    public static long getAppOnForegroundTime() {
        return f70052b;
    }

    public static Activity getCurrentTopActivity() {
        return f70053c;
    }

    public static Boolean registerActivityLifecycleCallbacks(Application application, final a aVar) {
        if (application == null || aVar == null || Build.VERSION.SDK_INT < 14) {
            return Boolean.FALSE;
        }
        try {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    a.this.b(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity) {
                    a.this.e(activity);
                }

                public void onActivityPaused(Activity activity) {
                    Activity unused = MtaActivityLifeCycle.f70053c = null;
                    a.this.d(activity);
                }

                public void onActivityResumed(Activity activity) {
                    Activity unused = MtaActivityLifeCycle.f70053c = activity;
                    a.this.c(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    a.this.a(activity, bundle);
                }

                public void onActivityStarted(Activity activity) {
                    if (MtaActivityLifeCycle.f70051a == 0) {
                        long unused = MtaActivityLifeCycle.f70052b = System.currentTimeMillis();
                    }
                    MtaActivityLifeCycle.b(1);
                    a.this.b(activity);
                }

                public void onActivityStopped(Activity activity) {
                    MtaActivityLifeCycle.a(1);
                    a.this.a(activity);
                }
            });
            return Boolean.TRUE;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public static /* synthetic */ int a(int i11) {
        int i12 = f70051a - i11;
        f70051a = i12;
        return i12;
    }
}
