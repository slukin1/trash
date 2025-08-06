package com.twitter.sdk.android.core;

import android.util.Log;

public class DefaultLogger implements Logger {
    private int logLevel;

    public DefaultLogger(int i11) {
        this.logLevel = i11;
    }

    public void d(String str, String str2, Throwable th2) {
        if (isLoggable(str, 3)) {
            Log.d(str, str2, th2);
        }
    }

    public void e(String str, String str2, Throwable th2) {
        if (isLoggable(str, 6)) {
            Log.e(str, str2, th2);
        }
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public void i(String str, String str2, Throwable th2) {
        if (isLoggable(str, 4)) {
            Log.i(str, str2, th2);
        }
    }

    public boolean isLoggable(String str, int i11) {
        return this.logLevel <= i11;
    }

    public void log(int i11, String str, String str2) {
        log(i11, str, str2, false);
    }

    public void setLogLevel(int i11) {
        this.logLevel = i11;
    }

    public void v(String str, String str2, Throwable th2) {
        if (isLoggable(str, 2)) {
            Log.v(str, str2, th2);
        }
    }

    public void w(String str, String str2, Throwable th2) {
        if (isLoggable(str, 5)) {
            Log.w(str, str2, th2);
        }
    }

    public void log(int i11, String str, String str2, boolean z11) {
        if (z11 || isLoggable(str, i11)) {
            Log.println(i11, str, str2);
        }
    }

    public DefaultLogger() {
        this.logLevel = 4;
    }

    public void d(String str, String str2) {
        d(str, str2, (Throwable) null);
    }

    public void e(String str, String str2) {
        e(str, str2, (Throwable) null);
    }

    public void i(String str, String str2) {
        i(str, str2, (Throwable) null);
    }

    public void v(String str, String str2) {
        v(str, str2, (Throwable) null);
    }

    public void w(String str, String str2) {
        w(str, str2, (Throwable) null);
    }
}
