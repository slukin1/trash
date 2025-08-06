package com.huawei.hms.support.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import com.iproov.sdk.bridge.OptionsBridge;
import java.lang.ref.WeakReference;

public final class ActivityMgr implements Application.ActivityLifecycleCallbacks {
    public static final ActivityMgr INST = new ActivityMgr();

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Activity> f38498a;

    private ActivityMgr() {
    }

    private static String a(Object obj) {
        if (obj == null) {
            return OptionsBridge.NULL_VALUE;
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
    }

    public Activity getCurrentActivity() {
        if (this.f38498a == null) {
            HMSLog.i("ActivityMgr", "mCurrentActivity is " + this.f38498a);
            return null;
        }
        HMSLog.i("ActivityMgr", "mCurrentActivity.get() is " + this.f38498a.get());
        return (Activity) this.f38498a.get();
    }

    public void init(Application application) {
        HMSLog.d("ActivityMgr", ZendeskBlipsProvider.ACTION_CORE_INIT);
        if (application == null) {
            HMSLog.w("ActivityMgr", "init failed for app is null");
            return;
        }
        ActivityMgr activityMgr = INST;
        application.unregisterActivityLifecycleCallbacks(activityMgr);
        application.registerActivityLifecycleCallbacks(activityMgr);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        HMSLog.d("ActivityMgr", "onCreated:" + a(activity));
        this.f38498a = new WeakReference<>(activity);
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        HMSLog.d("ActivityMgr", "onResumed:" + a(activity));
        this.f38498a = new WeakReference<>(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        HMSLog.d("ActivityMgr", "onStarted:" + a(activity));
        this.f38498a = new WeakReference<>(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}
