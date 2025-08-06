package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import org.json.JSONException;

public class Logger {
    private static final boolean DEBUG = false;
    private static final int MAX_STACK_DEEP_LENGTH = 20;
    private static final int MAX_STACK_DEEP_LENGTH_NORMAL = 8;
    private static final String SPLIT = "|";
    private static final String TAG = "NetworkKit_Logger";
    private static final String TAG_NETWORKKIT_PRE = "NetworkKit_";
    private static final String TAG_NETWORK_SDK_PRE = "NetworkSdk_";
    private static ExtLogger extLogger = null;
    private static boolean kitPrint = true;

    public static class ThrowableWrapper extends Throwable {
        private static final long serialVersionUID = 7129050843360571879L;
        private String message;
        private Throwable ownerThrowable;
        private Throwable thisCause;

        /* access modifiers changed from: private */
        public synchronized void setCause(Throwable th2) {
            this.thisCause = th2;
        }

        public synchronized Throwable getCause() {
            Throwable th2;
            th2 = this.thisCause;
            if (th2 == this) {
                th2 = null;
            }
            return th2;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public String toString() {
            Throwable th2 = this.ownerThrowable;
            if (th2 == null) {
                return "";
            }
            String name = th2.getClass().getName();
            if (this.message == null) {
                return name;
            }
            String str = name + l.f34627b;
            if (this.message.startsWith(str)) {
                return this.message;
            }
            return str + this.message;
        }

        private ThrowableWrapper(Throwable th2) {
            this.ownerThrowable = th2;
            StackTraceElement[] stackTrace = th2.getStackTrace();
            int i11 = ((th2 instanceof IOException) || (th2 instanceof JSONException)) ? 8 : 20;
            if (stackTrace.length > i11) {
                setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i11));
            } else {
                setStackTrace(stackTrace);
            }
            setMessage(StringUtils.anonymizeMessage(th2.getMessage()));
        }
    }

    private static String complexAppTag(String str) {
        return TAG_NETWORK_SDK_PRE + str;
    }

    private static String complexMsg(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return getCallMethodInfo(i11);
        }
        return getCallMethodInfo(i11) + "|" + str;
    }

    private static String complexTag(String str) {
        return TAG_NETWORKKIT_PRE + str;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, Object obj) {
        println(3, str, obj);
    }

    public static void e(String str, Object obj) {
        println(6, str, obj);
    }

    private static void extLogPrintln(int i11, String str, String str2) {
        if (i11 == 2) {
            extLogger.v(str, str2);
        } else if (i11 == 3) {
            extLogger.d(str, str2);
        } else if (i11 == 4) {
            extLogger.i(str, str2);
        } else if (i11 == 5) {
            extLogger.w(str, str2);
        } else if (i11 == 6) {
            extLogger.e(str, str2);
        }
    }

    private static String getCallMethodInfo(int i11) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i11) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i11];
        return Thread.currentThread().getName() + "|" + stackTraceElement.getFileName() + "|" + stackTraceElement.getClassName() + "|" + stackTraceElement.getMethodName() + "|" + stackTraceElement.getLineNumber();
    }

    private static Throwable getNewThrowable(Throwable th2) {
        if (isLoggable(3)) {
            return th2;
        }
        if (th2 == null) {
            return null;
        }
        ThrowableWrapper throwableWrapper = new ThrowableWrapper(th2);
        Throwable cause = th2.getCause();
        ThrowableWrapper throwableWrapper2 = throwableWrapper;
        while (cause != null) {
            ThrowableWrapper throwableWrapper3 = new ThrowableWrapper(cause);
            throwableWrapper2.setCause(throwableWrapper3);
            cause = cause.getCause();
            throwableWrapper2 = throwableWrapper3;
        }
        return throwableWrapper;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, Object obj) {
        println(4, str, obj);
    }

    private static boolean isAPPLoggable(int i11) {
        return extLogger != null && i11 >= 3;
    }

    private static boolean isKitLoggable(int i11) {
        return kitPrint && isLoggable(i11);
    }

    public static boolean isLoggable(int i11) {
        return Log.isLoggable(TAG_NETWORKKIT_PRE, i11);
    }

    private static int logPrintln(int i11, String str, String str2) {
        if (isAPPLoggable(i11)) {
            extLogPrintln(i11, complexAppTag(str), complexMsg(str2, 7));
        }
        if (isKitLoggable(i11)) {
            return Log.println(i11, complexTag(str), complexMsg(str2, 7));
        }
        return 1;
    }

    public static void println(int i11, String str, Object obj) {
        if (i11 >= 3) {
            logPrintln(i11, str, obj == null ? OptionsBridge.NULL_VALUE : obj.toString());
        }
    }

    public static void setExtLogger(ExtLogger extLogger2, boolean z11) {
        extLogger = extLogger2;
        kitPrint = z11;
        i(TAG, "logger = " + extLogger2 + z11);
    }

    public static void v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    public static void w(String str, Object obj) {
        println(5, str, obj);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static void println(int i11, String str, String str2, Object... objArr) {
        if (i11 >= 3) {
            if (str2 == null) {
                Log.w(TAG, "format is null, not log");
                return;
            }
            try {
                logPrintln(i11, str, StringUtils.format(str2, objArr));
            } catch (IllegalFormatException e11) {
                w(TAG, "log format error" + str2, (Throwable) e11);
            }
        }
    }

    public static void v(String str, Object obj) {
        println(2, str, obj);
    }

    public static void w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }

    public static void e(String str, String str2, Throwable th2) {
        if (isAPPLoggable(6)) {
            extLogger.e(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th2));
        }
        if (kitPrint) {
            Log.e(complexTag(str), complexMsg(str2, 5), getNewThrowable(th2));
        }
    }

    public static void w(String str, String str2, Throwable th2) {
        if (isAPPLoggable(5)) {
            extLogger.w(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th2));
        }
        if (kitPrint) {
            Log.w(complexTag(str), complexMsg(str2, 5), getNewThrowable(th2));
        }
    }
}
