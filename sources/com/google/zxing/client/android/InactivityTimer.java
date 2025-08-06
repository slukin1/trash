package com.google.zxing.client.android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

final class InactivityTimer {
    private static final long INACTIVITY_DELAY_MS = 300000;
    /* access modifiers changed from: private */
    public static final String TAG = "InactivityTimer";
    /* access modifiers changed from: private */
    public final Activity activity;
    private AsyncTask<Object, Object, Object> inactivityTask;
    private final BroadcastReceiver powerStatusReceiver = new PowerStatusReceiver();
    private boolean registered = false;

    public final class InactivityAsyncTask extends AsyncTask<Object, Object, Object> {
        private InactivityAsyncTask() {
        }

        public Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(300000);
                Log.i(InactivityTimer.TAG, "Finishing activity due to inactivity");
                InactivityTimer.this.activity.finish();
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    public final class PowerStatusReceiver extends BroadcastReceiver {
        private PowerStatusReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", -1) <= 0) {
                    InactivityTimer.this.onActivity();
                } else {
                    InactivityTimer.this.cancel();
                }
            }
        }
    }

    public InactivityTimer(Activity activity2) {
        this.activity = activity2;
        onActivity();
    }

    /* access modifiers changed from: private */
    public synchronized void cancel() {
        AsyncTask<Object, Object, Object> asyncTask = this.inactivityTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.inactivityTask = null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:1|2|3|4|5|6|7) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivity() {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.cancel()     // Catch:{ all -> 0x001e }
            com.google.zxing.client.android.InactivityTimer$InactivityAsyncTask r0 = new com.google.zxing.client.android.InactivityTimer$InactivityAsyncTask     // Catch:{ all -> 0x001e }
            r1 = 0
            r0.<init>()     // Catch:{ all -> 0x001e }
            r3.inactivityTask = r0     // Catch:{ all -> 0x001e }
            java.util.concurrent.Executor r1 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch:{ RejectedExecutionException -> 0x0015 }
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ RejectedExecutionException -> 0x0015 }
            r0.executeOnExecutor(r1, r2)     // Catch:{ RejectedExecutionException -> 0x0015 }
            goto L_0x001c
        L_0x0015:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x001e }
            java.lang.String r1 = "Couldn't schedule inactivity task; ignoring"
            android.util.Log.w(r0, r1)     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r3)
            return
        L_0x001e:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.InactivityTimer.onActivity():void");
    }

    public synchronized void onPause() {
        cancel();
        if (this.registered) {
            this.activity.unregisterReceiver(this.powerStatusReceiver);
            this.registered = false;
        } else {
            Log.w(TAG, "PowerStatusReceiver was never registered?");
        }
    }

    public synchronized void onResume() {
        if (this.registered) {
            Log.w(TAG, "PowerStatusReceiver was already registered?");
        } else {
            if (Build.VERSION.SDK_INT >= 33) {
                this.activity.registerReceiver(this.powerStatusReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 2);
            } else {
                this.activity.registerReceiver(this.powerStatusReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            }
            this.registered = true;
        }
        onActivity();
    }

    public void shutdown() {
        cancel();
    }
}
