package com.google.firebase.crashlytics.internal;

import android.util.Log;

public class Logger {
    public static final Logger DEFAULT_LOGGER = new Logger(TAG);
    public static final String TAG = "FirebaseCrashlytics";
    private int logLevel = 4;
    private final String tag;

    public Logger(String str) {
        this.tag = str;
    }

    private boolean canLog(int i11) {
        return this.logLevel <= i11 || Log.isLoggable(this.tag, i11);
    }

    public static Logger getLogger() {
        return DEFAULT_LOGGER;
    }

    public void d(String str, Throwable th2) {
        if (canLog(3)) {
            Log.d(this.tag, str, th2);
        }
    }

    public void e(String str, Throwable th2) {
        if (canLog(6)) {
            Log.e(this.tag, str, th2);
        }
    }

    public void i(String str, Throwable th2) {
        if (canLog(4)) {
            Log.i(this.tag, str, th2);
        }
    }

    public void log(int i11, String str) {
        log(i11, str, false);
    }

    public void v(String str, Throwable th2) {
        if (canLog(2)) {
            Log.v(this.tag, str, th2);
        }
    }

    public void w(String str, Throwable th2) {
        if (canLog(5)) {
            Log.w(this.tag, str, th2);
        }
    }

    public void log(int i11, String str, boolean z11) {
        if (z11 || canLog(i11)) {
            Log.println(i11, this.tag, str);
        }
    }

    public void d(String str) {
        d(str, (Throwable) null);
    }

    public void e(String str) {
        e(str, (Throwable) null);
    }

    public void i(String str) {
        i(str, (Throwable) null);
    }

    public void v(String str) {
        v(str, (Throwable) null);
    }

    public void w(String str) {
        w(str, (Throwable) null);
    }
}
