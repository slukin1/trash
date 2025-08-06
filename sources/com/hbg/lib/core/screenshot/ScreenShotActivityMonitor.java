package com.hbg.lib.core.screenshot;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import gj.d;
import oa.a;
import t6.g;

public final class ScreenShotActivityMonitor implements Application.ActivityLifecycleCallbacks {

    /* renamed from: d  reason: collision with root package name */
    public static ScreenShotActivityMonitor f68527d = new ScreenShotActivityMonitor();

    /* renamed from: b  reason: collision with root package name */
    public int f68528b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f68529c;

    public static ScreenShotActivityMonitor b() {
        return f68527d;
    }

    public boolean a() {
        return d.n().C();
    }

    public boolean c() {
        return this.f68528b > 0;
    }

    public void d() {
        boolean a11 = a();
        i6.d.j("ScreenShotActivityMonitor", "ScreenShotActivityMonitor reloadConfigData newSupportScreenshot:" + a11 + " mSupportScreenshot:" + this.f68529c);
        if (a11 != this.f68529c) {
            if (!a11) {
                g.f().m();
            } else if (c()) {
                g.f().l();
            }
            this.f68529c = a11;
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        a.g().a(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        a.g().k(activity);
    }

    public void onActivityPaused(Activity activity) {
        i6.d.j("ScreenShotActivityMonitor", "ScreenShotActivityMonitor onActivityPaused:" + activity.getClass().getName() + " mSupportScreenshot:" + this.f68529c);
    }

    public void onActivityResumed(Activity activity) {
        a.g().l(activity);
        i6.d.j("ScreenShotActivityMonitor", "ScreenShotActivityMonitor onActivityResumed:" + activity.getClass().getName() + " mSupportScreenshot:" + this.f68529c);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (this.f68528b == 0) {
            this.f68529c = a();
            i6.d.j("ScreenShotActivityMonitor", "ScreenShotActivityMonitor onActivityStarted:" + activity.getClass().getName() + " mSupportScreenshot:" + this.f68529c);
            if (this.f68529c) {
                g.f().l();
            }
        }
        this.f68528b++;
    }

    public void onActivityStopped(Activity activity) {
        int i11 = this.f68528b - 1;
        this.f68528b = i11;
        if (i11 == 0 && this.f68529c) {
            g.f().m();
        }
    }
}
