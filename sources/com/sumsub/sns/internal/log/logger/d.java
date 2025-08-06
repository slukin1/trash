package com.sumsub.sns.internal.log.logger;

import android.util.Log;
import com.sumsub.log.logger.Logger;

public final class d implements Logger {

    /* renamed from: a  reason: collision with root package name */
    public static final d f34907a = new d();

    public void d(String str, String str2, Throwable th2) {
        if (th2 == null) {
            Log.d(str, str2);
        } else {
            Log.d(str, str2, th2);
        }
    }

    public void e(String str, String str2, Throwable th2) {
        if (th2 == null) {
            Log.e(str, str2);
        } else {
            Log.e(str, str2, th2);
        }
    }

    public void i(String str, String str2, Throwable th2) {
        if (th2 == null) {
            Log.i(str, str2);
        } else {
            Log.i(str, str2, th2);
        }
    }

    public void v(String str, String str2, Throwable th2) {
        if (th2 == null) {
            Log.v(str, str2);
        } else {
            Log.v(str, str2, th2);
        }
    }

    public void w(String str, String str2, Throwable th2) {
        if (th2 == null) {
            Log.w(str, str2);
        } else {
            Log.w(str, str2, th2);
        }
    }
}
