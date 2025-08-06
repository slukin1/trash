package com.huobi.woodpecker.monitor.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.utils.ContextUtil;
import kv.e;

public class BaseLifecycleMonitor extends BaseMonitor implements Application.ActivityLifecycleCallbacks, ActionType.a {
    public void a(boolean z11) {
        e.k("BMonitor", "onEnableChange by " + getClass().getCanonicalName() + " , isEnable:" + z11);
        if (z11) {
            f();
        } else {
            g();
        }
    }

    public void d() {
        ContextUtil.b().registerActivityLifecycleCallbacks(this);
    }

    public void e() {
        ContextUtil.b().unregisterActivityLifecycleCallbacks(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
