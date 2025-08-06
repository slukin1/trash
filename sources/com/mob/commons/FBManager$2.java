package com.mob.commons;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import com.mob.tools.utils.ActivityTracker;

public class FBManager$2 implements ActivityTracker.Tracker {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f26891a;

    public FBManager$2(l lVar) {
        this.f26891a = lVar;
    }

    public void onCreated(Activity activity, Bundle bundle) {
    }

    public void onDestroyed(Activity activity) {
        if (this.f26891a.f27273e > 0) {
            onStopped(activity);
        }
    }

    public void onPaused(Activity activity) {
    }

    public void onResumed(Activity activity) {
        try {
            long unused = this.f26891a.f27274f = SystemClock.elapsedRealtime();
            if (this.f26891a.f27273e == 0) {
                long unused2 = this.f26891a.f27273e = SystemClock.elapsedRealtime();
                if (this.f26891a.f27271c != null) {
                    this.f26891a.f27271c.sendEmptyMessage(1);
                }
            }
            String unused3 = this.f26891a.f27272d = activity == null ? null : activity.toString();
        } catch (Throwable unused4) {
        }
    }

    public void onSaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onStarted(Activity activity) {
    }

    public void onStopped(Activity activity) {
        try {
            if (this.f26891a.f27272d != null) {
                if (!this.f26891a.f27272d.equals(activity == null ? null : activity.toString())) {
                    return;
                }
            }
            if (this.f26891a.f27271c != null) {
                long elapsedRealtime = this.f26891a.f27273e > 0 ? SystemClock.elapsedRealtime() - this.f26891a.f27273e : 0;
                Message message = new Message();
                message.what = 2;
                message.obj = Long.valueOf(elapsedRealtime);
                this.f26891a.f27271c.sendMessage(message);
            }
            long unused = this.f26891a.f27273e = 0;
            String unused2 = this.f26891a.f27272d = null;
        } catch (Throwable unused3) {
        }
    }
}
