package com.mob.mcl;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.mob.mcl.a;
import com.mob.tools.utils.ActivityTracker;

public class Tmpc$3 implements ActivityTracker.Tracker {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.C0239a f27396a;

    /* renamed from: b  reason: collision with root package name */
    private long f27397b;

    /* renamed from: c  reason: collision with root package name */
    private String f27398c;

    public Tmpc$3(a.C0239a aVar) {
        this.f27396a = aVar;
    }

    public void onCreated(Activity activity, Bundle bundle) {
    }

    public void onDestroyed(Activity activity) {
    }

    public void onPaused(Activity activity) {
    }

    public void onResumed(Activity activity) {
        String str;
        try {
            if (this.f27397b == 0) {
                this.f27397b = SystemClock.elapsedRealtime();
                this.f27396a.a();
            }
            if (activity == null) {
                str = null;
            } else {
                str = activity.toString();
            }
            this.f27398c = str;
        } catch (Throwable unused) {
        }
    }

    public void onSaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onStarted(Activity activity) {
    }

    public void onStopped(Activity activity) {
        try {
            String str = this.f27398c;
            if (str != null) {
                if (!str.equals(activity == null ? null : activity.toString())) {
                    return;
                }
            }
            this.f27397b = 0;
            this.f27398c = null;
            this.f27396a.b();
        } catch (Throwable unused) {
        }
    }
}
