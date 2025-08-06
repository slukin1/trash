package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.firebase.messaging.Constants;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class FcmLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private final Set<Intent> seenIntents = Collections.newSetFromMap(new WeakHashMap());

    /* access modifiers changed from: private */
    /* renamed from: logNotificationOpen */
    public void lambda$onActivityCreated$0(Intent intent) {
        Bundle bundle = null;
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                bundle = extras.getBundle(Constants.MessageNotificationKeys.ANALYTICS_DATA);
            }
        } catch (RuntimeException e11) {
            Log.w("FirebaseMessaging", "Failed trying to get analytics data from Intent extras.", e11);
        }
        if (MessagingAnalytics.shouldUploadScionMetrics(bundle)) {
            MessagingAnalytics.logNotificationOpen(bundle);
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intent intent = activity.getIntent();
        if (intent != null && this.seenIntents.add(intent)) {
            if (Build.VERSION.SDK_INT <= 25) {
                new Handler(Looper.getMainLooper()).post(new g(this, intent));
            } else {
                lambda$onActivityCreated$0(intent);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        if (activity.isFinishing()) {
            this.seenIntents.remove(activity.getIntent());
        }
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
