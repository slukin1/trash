package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dd;
import com.xiaomi.push.de;
import java.io.File;

public class Logger {
    private static boolean sDisablePushLog = false;
    private static LoggerInterface sUserLogger;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    @Deprecated
    public static File getLogFile(String str) {
        return null;
    }

    public static LoggerInterface getUserLogger() {
        return sUserLogger;
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    public static void setPushLog(Context context) {
        LoggerInterface loggerInterface = sUserLogger;
        boolean z11 = false;
        boolean z12 = loggerInterface != null;
        boolean z13 = sDisablePushLog;
        if (!z13) {
            z11 = z12;
        }
        boolean z14 = true ^ z13;
        de deVar = null;
        if (!z11) {
            loggerInterface = null;
        }
        if (z14) {
            deVar = de.a(context);
        }
        b.a((LoggerInterface) new dd(loggerInterface, deVar));
    }

    @Deprecated
    public static void uploadLogFile(Context context, boolean z11) {
    }
}
