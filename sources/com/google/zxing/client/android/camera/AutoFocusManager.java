package com.google.zxing.client.android.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.zxing.client.android.PreferencesActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

final class AutoFocusManager implements Camera.AutoFocusCallback {
    private static final long AUTO_FOCUS_INTERVAL_MS = 1000;
    private static final Collection<String> FOCUS_MODES_CALLING_AF;
    private static final String TAG = AutoFocusManager.class.getSimpleName();
    private final Camera camera;
    private boolean focusing;
    private AsyncTask<?, ?, ?> outstandingTask;
    private boolean stopped;
    private final boolean useAutoFocus;

    public final class AutoFocusTask extends AsyncTask<Object, Object, Object> {
        private AutoFocusTask() {
        }

        public Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException unused) {
            }
            AutoFocusManager.this.start();
            return null;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        FOCUS_MODES_CALLING_AF = arrayList;
        arrayList.add(TtmlNode.TEXT_EMPHASIS_AUTO);
        arrayList.add("macro");
    }

    public AutoFocusManager(Context context, Camera camera2) {
        this.camera = camera2;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String focusMode = camera2.getParameters().getFocusMode();
        boolean z11 = true;
        z11 = (!defaultSharedPreferences.getBoolean(PreferencesActivity.KEY_AUTO_FOCUS, true) || !FOCUS_MODES_CALLING_AF.contains(focusMode)) ? false : z11;
        this.useAutoFocus = z11;
        String str = TAG;
        Log.i(str, "Current focus mode '" + focusMode + "'; use auto focus? " + z11);
        start();
    }

    private synchronized void autoFocusAgainLater() {
        if (!this.stopped && this.outstandingTask == null) {
            AutoFocusTask autoFocusTask = new AutoFocusTask();
            try {
                autoFocusTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.outstandingTask = autoFocusTask;
            } catch (RejectedExecutionException e11) {
                Log.w(TAG, "Could not request auto focus", e11);
            }
        }
        return;
    }

    private synchronized void cancelOutstandingTask() {
        AsyncTask<?, ?, ?> asyncTask = this.outstandingTask;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                this.outstandingTask.cancel(true);
            }
            this.outstandingTask = null;
        }
    }

    public synchronized void onAutoFocus(boolean z11, Camera camera2) {
        this.focusing = false;
        autoFocusAgainLater();
    }

    public synchronized void start() {
        if (this.useAutoFocus) {
            this.outstandingTask = null;
            if (!this.stopped && !this.focusing) {
                try {
                    this.camera.autoFocus(this);
                    this.focusing = true;
                } catch (RuntimeException e11) {
                    Log.w(TAG, "Unexpected exception while focusing", e11);
                    autoFocusAgainLater();
                }
            }
        }
        return;
    }

    public synchronized void stop() {
        this.stopped = true;
        if (this.useAutoFocus) {
            cancelOutstandingTask();
            try {
                this.camera.cancelAutoFocus();
            } catch (RuntimeException e11) {
                Log.w(TAG, "Unexpected exception while cancelling focusing", e11);
            }
        }
        return;
    }
}
