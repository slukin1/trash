package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class ViewObserver implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final int MAX_TEXT_LENGTH = 300;
    private static final String TAG = ViewObserver.class.getCanonicalName();
    private static final Map<Integer, ViewObserver> observers = new HashMap();
    /* access modifiers changed from: private */
    public WeakReference<Activity> activityWeakReference;
    private AtomicBoolean isTracking = new AtomicBoolean(false);
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    private ViewObserver(Activity activity) {
        this.activityWeakReference = new WeakReference<>(activity);
    }

    /* access modifiers changed from: private */
    public View getRootView() {
        Window window;
        Activity activity = (Activity) this.activityWeakReference.get();
        if (activity == null || (window = activity.getWindow()) == null) {
            return null;
        }
        return window.getDecorView().getRootView();
    }

    private void process() {
        AnonymousClass1 r02 = new Runnable() {
            public void run() {
                try {
                    View access$000 = ViewObserver.this.getRootView();
                    Activity activity = (Activity) ViewObserver.this.activityWeakReference.get();
                    if (access$000 == null) {
                        return;
                    }
                    if (activity != null) {
                        for (View next : SuggestedEventViewHierarchy.getAllClickableViews(access$000)) {
                            if (!SensitiveUserDataUtils.isSensitiveUserData(next)) {
                                String textOfView = ViewHierarchy.getTextOfView(next);
                                if (!textOfView.isEmpty() && textOfView.length() <= 300) {
                                    ViewOnClickListener.attachListener(next, access$000, activity.getLocalClassName());
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r02.run();
        } else {
            this.uiThreadHandler.post(r02);
        }
    }

    private void startTracking() {
        View rootView;
        if (!this.isTracking.getAndSet(true) && (rootView = getRootView()) != null) {
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
                process();
            }
        }
    }

    public static void startTrackingActivity(Activity activity) {
        int hashCode = activity.hashCode();
        Map<Integer, ViewObserver> map = observers;
        if (!map.containsKey(Integer.valueOf(hashCode))) {
            ViewObserver viewObserver = new ViewObserver(activity);
            map.put(Integer.valueOf(hashCode), viewObserver);
            viewObserver.startTracking();
        }
    }

    private void stopTracking() {
        View rootView;
        if (this.isTracking.getAndSet(false) && (rootView = getRootView()) != null) {
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                if (Build.VERSION.SDK_INT < 16) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                } else {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
        }
    }

    public static void stopTrackingActivity(Activity activity) {
        int hashCode = activity.hashCode();
        Map<Integer, ViewObserver> map = observers;
        if (map.containsKey(Integer.valueOf(hashCode))) {
            map.remove(Integer.valueOf(hashCode));
            map.get(Integer.valueOf(hashCode)).stopTracking();
        }
    }

    public void onGlobalLayout() {
        process();
    }
}
