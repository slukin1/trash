package com.google.firebase.crashlytics;

import android.annotation.SuppressLint;
import com.google.firebase.crashlytics.internal.Logger;

public final class FlutterFirebaseCrashlyticsInternal {
    private static final String FLUTTER_BUILD_ID_KEY = "com.crashlytics.flutter.build-id.0";

    private FlutterFirebaseCrashlyticsInternal() {
    }

    @SuppressLint({"VisibleForTests"})
    public static void recordFatalException(Throwable th2) {
        if (th2 == null) {
            Logger.getLogger().w("A null value was passed to recordFatalException. Ignoring.");
        } else {
            FirebaseCrashlytics.getInstance().core.logFatalException(th2);
        }
    }

    @SuppressLint({"VisibleForTests"})
    public static void setFlutterBuildId(String str) {
        FirebaseCrashlytics.getInstance().core.setInternalKey(FLUTTER_BUILD_ID_KEY, str);
    }
}
