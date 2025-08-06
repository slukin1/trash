package com.adjust.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.CopyOnWriteArrayList;

public class SystemLifecycle implements Application.ActivityLifecycleCallbacks {
    private static volatile SystemLifecycle instance;
    private Application application = null;
    private volatile SystemLifecycleCallback callback;
    private final SystemLifecycleCache callbackCache;
    public final CopyOnWriteArrayList<String> logMessageList;

    public static class SystemLifecycleCache implements SystemLifecycleCallback {
        public volatile Boolean foregroundOrElseBackgroundCache = null;

        public void onActivityLifecycle(boolean z11) {
            this.foregroundOrElseBackgroundCache = Boolean.valueOf(z11);
        }
    }

    public interface SystemLifecycleCallback {
        void onActivityLifecycle(boolean z11);
    }

    public SystemLifecycle() {
        SystemLifecycleCache systemLifecycleCache = new SystemLifecycleCache();
        this.callbackCache = systemLifecycleCache;
        this.callback = systemLifecycleCache;
        this.logMessageList = new CopyOnWriteArrayList<>();
    }

    public static SystemLifecycle getSingletonInstance() {
        SystemLifecycle systemLifecycle = instance;
        if (systemLifecycle == null) {
            synchronized (SystemLifecycle.class) {
                systemLifecycle = instance;
                if (systemLifecycle == null) {
                    systemLifecycle = new SystemLifecycle();
                    instance = systemLifecycle;
                }
            }
        }
        return systemLifecycle;
    }

    public Boolean foregroundOrElseBackgroundCached() {
        return this.callbackCache.foregroundOrElseBackgroundCache;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.callback.onActivityLifecycle(false);
    }

    public void onActivityResumed(Activity activity) {
        this.callback.onActivityLifecycle(true);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void overwriteCallback(SystemLifecycleCallback systemLifecycleCallback) {
        this.callback = systemLifecycleCallback;
    }

    public synchronized void registerActivityLifecycleCallbacks(Context context) {
        if (this.application != null) {
            this.logMessageList.add("Cannot register activity lifecycle callbacks more than once");
        } else if (context == null) {
            this.logMessageList.add("Cannot register activity lifecycle callbacks without context");
        } else {
            Context applicationContext = context.getApplicationContext();
            if (!(applicationContext instanceof Application)) {
                this.logMessageList.add("Cannot register activity lifecycle callbacks without application context as Application");
                return;
            }
            this.logMessageList.add("Registering activity lifecycle callbacks");
            Application application2 = (Application) applicationContext;
            this.application = application2;
            application2.registerActivityLifecycleCallbacks(this);
        }
    }
}
