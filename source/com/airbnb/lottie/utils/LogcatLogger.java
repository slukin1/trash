package com.airbnb.lottie.utils;

import android.util.Log;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

public class LogcatLogger implements LottieLogger {
    private static final Set<String> loggedMessages = new HashSet();

    public void debug(String str) {
        debug(str, (Throwable) null);
    }

    public void error(String str, Throwable th2) {
        if (L.DBG) {
            Log.d(L.TAG, str, th2);
        }
    }

    public void warning(String str) {
        warning(str, (Throwable) null);
    }

    public void debug(String str, Throwable th2) {
        if (L.DBG) {
            Log.d(L.TAG, str, th2);
        }
    }

    public void warning(String str, Throwable th2) {
        Set<String> set = loggedMessages;
        if (!set.contains(str)) {
            Log.w(L.TAG, str, th2);
            set.add(str);
        }
    }
}
