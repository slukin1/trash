package com.sensorsdata.analytics.android.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.sensorsdata.analytics.android.sdk.util.ViewUtil;
import com.sensorsdata.analytics.android.sdk.visual.ViewTreeStatusObservable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

@SuppressLint({"NewApi"})
public class AppStateManager implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "SA.AppStateManager";
    private static volatile AppStateManager mSingleton;
    private String mCurrentFragmentName = null;
    private int mCurrentRootWindowsHashCode = -1;
    private WeakReference<Activity> mForeGroundActivity = new WeakReference<>((Object) null);

    private AppStateManager() {
    }

    public static AppStateManager getInstance() {
        if (mSingleton == null) {
            synchronized (AppStateManager.class) {
                if (mSingleton == null) {
                    mSingleton = new AppStateManager();
                }
            }
        }
        return mSingleton;
    }

    private void setForegroundActivity(Activity activity) {
        this.mForeGroundActivity = new WeakReference<>(activity);
    }

    public int getCurrentRootWindowsHashCode() {
        WeakReference<Activity> weakReference;
        Activity activity;
        Window window;
        if (!(this.mCurrentRootWindowsHashCode != -1 || (weakReference = this.mForeGroundActivity) == null || weakReference.get() == null || (activity = (Activity) this.mForeGroundActivity.get()) == null || (window = activity.getWindow()) == null || !window.isActive())) {
            this.mCurrentRootWindowsHashCode = window.getDecorView().hashCode();
        }
        return this.mCurrentRootWindowsHashCode;
    }

    public Activity getForegroundActivity() {
        return (Activity) this.mForeGroundActivity.get();
    }

    public String getFragmentScreenName() {
        return this.mCurrentFragmentName;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        setForegroundActivity(activity);
        if (!activity.isChild()) {
            this.mCurrentRootWindowsHashCode = -1;
        }
    }

    public void onActivityDestroyed(Activity activity) {
        ViewTreeStatusObservable.getInstance().clearWebViewCache();
        ViewUtil.clear();
    }

    public void onActivityPaused(Activity activity) {
        if (!activity.isChild()) {
            this.mCurrentRootWindowsHashCode = -1;
        }
    }

    public void onActivityResumed(Activity activity) {
        setForegroundActivity(activity);
        View view = null;
        try {
            Window window = activity.getWindow();
            if (window != null) {
                view = window.getDecorView();
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        if (!activity.isChild() && view != null) {
            this.mCurrentRootWindowsHashCode = view.hashCode();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void setFragmentScreenName(Object obj, String str) {
        try {
            Method method = obj.getClass().getMethod("getParentFragment", new Class[0]);
            if (method == null) {
                return;
            }
            if (method.invoke(obj, new Object[0]) == null) {
                this.mCurrentFragmentName = str;
                SALog.i(TAG, "setFragmentScreenName | " + str + " is not nested fragment and set");
                return;
            }
            SALog.i(TAG, "setFragmentScreenName | " + str + " is nested fragment and ignored");
        } catch (Exception unused) {
        }
    }
}
