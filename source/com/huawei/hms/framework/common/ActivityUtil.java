package com.huawei.hms.framework.common;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class ActivityUtil {
    private static final int MAX_NUM = 20;
    private static final String TAG = "ActivityUtil";
    private static volatile ActivityUtil instance;
    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        private int activityStartCount = 0;

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
            int i11 = this.activityStartCount + 1;
            this.activityStartCount = i11;
            if (i11 == 1) {
                boolean unused = ActivityUtil.this.isForeground = true;
                Logger.d(ActivityUtil.TAG, "onActivityStarted");
                for (int i12 = 0; i12 < ActivityUtil.this.onAppStatusListeners.size(); i12++) {
                    ((OnAppStatusListener) ActivityUtil.this.onAppStatusListeners.get(i12)).onFront();
                }
            }
        }

        public void onActivityStopped(Activity activity) {
            int i11 = this.activityStartCount - 1;
            this.activityStartCount = i11;
            if (i11 == 0) {
                Logger.d(ActivityUtil.TAG, "onActivityStopped");
                boolean unused = ActivityUtil.this.isForeground = false;
                for (int i12 = 0; i12 < ActivityUtil.this.onAppStatusListeners.size(); i12++) {
                    ((OnAppStatusListener) ActivityUtil.this.onAppStatusListeners.get(i12)).onBack();
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean isForeground;
    /* access modifiers changed from: private */
    public List<OnAppStatusListener> onAppStatusListeners = new ArrayList();

    public interface OnAppStatusListener {
        void onBack();

        void onFront();
    }

    private ActivityUtil() {
    }

    public static PendingIntent getActivities(Context context, int i11, Intent[] intentArr, int i12) {
        if (context == null) {
            Logger.w(TAG, "context is null");
            return null;
        }
        try {
            return PendingIntent.getActivities(context, i11, intentArr, i12);
        } catch (RuntimeException e11) {
            Logger.e(TAG, "dealType rethrowFromSystemServer:", (Throwable) e11);
            return null;
        }
    }

    public static ActivityUtil getInstance() {
        if (instance == null) {
            synchronized (ActivityUtil.class) {
                if (instance == null) {
                    instance = new ActivityUtil();
                }
            }
        }
        return instance;
    }

    @Deprecated
    public static boolean isForeground(Context context) {
        return getInstance().isForeground();
    }

    public void register() {
        Context appContext = ContextHolder.getAppContext();
        if (appContext instanceof Application) {
            ((Application) appContext).registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        } else {
            Logger.w(TAG, "context is not application, register background fail");
        }
    }

    public void setOnAppStatusListener(OnAppStatusListener onAppStatusListener) {
        if (onAppStatusListener == null) {
            Logger.w(TAG, "onAppStatusListener is null");
        } else if (this.onAppStatusListeners.size() >= 20) {
            Logger.w(TAG, "onAppStatusListener of count is max");
        } else {
            this.onAppStatusListeners.add(onAppStatusListener);
        }
    }

    public void unRegister() {
        Context appContext = ContextHolder.getAppContext();
        if (appContext instanceof Application) {
            ((Application) appContext).unregisterActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        } else {
            Logger.w(TAG, "context is not application, unRegister background fail");
        }
    }

    public boolean isForeground() {
        return this.isForeground;
    }
}
