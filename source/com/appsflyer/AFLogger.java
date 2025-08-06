package com.appsflyer;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.appsflyer.internal.ae;
import com.appsflyer.internal.aj;
import com.appsflyer.internal.at;
import com.iproov.sdk.bridge.OptionsBridge;
import io.flutter.plugins.firebase.crashlytics.Constants;

public final class AFLogger {
    private static final long values = System.currentTimeMillis();

    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        
        private int AFInAppEventParameterName;

        private LogLevel(int i11) {
            this.AFInAppEventParameterName = i11;
        }

        public final int getLevel() {
            return this.AFInAppEventParameterName;
        }
    }

    private static String AFInAppEventParameterName(String str, boolean z11) {
        if (str == null) {
            str = OptionsBridge.NULL_VALUE;
        }
        if (!z11 && LogLevel.VERBOSE.getLevel() > AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder("(");
        sb2.append(System.currentTimeMillis() - values);
        sb2.append(") [");
        sb2.append(Thread.currentThread().getName());
        sb2.append("] ");
        sb2.append(str);
        return sb2.toString();
    }

    public static void AFInAppEventType(String str, boolean z11) {
        if (AFInAppEventType(LogLevel.INFO)) {
            Log.i("AppsFlyer_6.3.2", AFInAppEventParameterName(str, false));
        }
        if (z11) {
            aj.valueOf().AFInAppEventType((String) null, "I", AFInAppEventParameterName(str, true));
        }
    }

    private static void AFKeystoreWrapper(String str, Throwable th2, boolean z11, boolean z12) {
        long j11;
        if (AFInAppEventType(LogLevel.ERROR)) {
            if (str == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(th2.getClass().getSimpleName());
                sb2.append(" at ");
                sb2.append(th2.getStackTrace()[0].toString());
                str = sb2.toString();
            }
            String AFInAppEventParameterName = AFInAppEventParameterName(str, false);
            if (z12) {
                Log.e("AppsFlyer_6.3.2", AFInAppEventParameterName, th2);
            } else if (z11) {
                Log.d("AppsFlyer_6.3.2", AFInAppEventParameterName);
            }
        }
        aj valueOf = aj.valueOf();
        Throwable cause = th2.getCause();
        valueOf.AFInAppEventType(Constants.EXCEPTION, th2.getClass().getSimpleName(), aj.AFInAppEventType(cause == null ? th2.getMessage() : cause.getMessage(), cause == null ? th2.getStackTrace() : cause.getStackTrace()));
        Application application = at.AFInAppEventParameterName;
        if (application != null) {
            SharedPreferences.Editor edit = ae.values((Context) application).edit();
            Application application2 = at.AFInAppEventParameterName;
            if (application2 == null) {
                j11 = -1;
            } else {
                j11 = ae.values((Context) application2).getLong("exception_number", 0);
            }
            edit.putLong("exception_number", j11 + 1).apply();
        }
    }

    public static void init(String str) {
        valueOf(str);
    }

    public static void valueOf(String str) {
        if (AFInAppEventType(LogLevel.WARNING)) {
            Log.w("AppsFlyer_6.3.2", AFInAppEventParameterName(str, false));
        }
        aj.valueOf().AFInAppEventType((String) null, "W", AFInAppEventParameterName(str, true));
    }

    public static void values(Throwable th2) {
        AFKeystoreWrapper((String) null, th2, false, false);
    }

    public static void values(String str) {
        if (AFInAppEventType(LogLevel.DEBUG)) {
            Log.d("AppsFlyer_6.3.2", AFInAppEventParameterName(str, false));
        }
        aj.valueOf().AFInAppEventType((String) null, "D", AFInAppEventParameterName(str, true));
    }

    public static void AFInAppEventParameterName(String str) {
        if (AFInAppEventType(LogLevel.VERBOSE)) {
            Log.v("AppsFlyer_6.3.2", AFInAppEventParameterName(str, false));
        }
        aj.valueOf().AFInAppEventType((String) null, "V", AFInAppEventParameterName(str, true));
    }

    private static boolean AFInAppEventType(LogLevel logLevel) {
        return logLevel.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel());
    }

    private static boolean valueOf() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    public static void AFInAppEventType(String str) {
        if (!valueOf()) {
            Log.d("AppsFlyer_6.3.2", AFInAppEventParameterName(str, false));
        }
        aj.valueOf().AFInAppEventType((String) null, "F", str);
    }

    public static void AFInAppEventParameterName(String str, Throwable th2) {
        AFKeystoreWrapper(str, th2, true, true);
    }

    public static void AFInAppEventType(String str, Throwable th2) {
        AFKeystoreWrapper(str, th2, true, false);
    }

    public static void AFKeystoreWrapper(String str) {
        AFInAppEventType(str, true);
    }
}
