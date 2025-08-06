package com.tencent.liteav.base.util;

import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.util.Locale;

@JNINamespace("liteav")
public class LiteavLog {
    private static final int LEVEL_DEBUG = 1;
    private static final int LEVEL_ERROR = 4;
    private static final int LEVEL_FATAL = 5;
    private static final int LEVEL_INFO = 2;
    private static final int LEVEL_NULL = 6;
    private static final int LEVEL_VERBOSE = 0;
    private static final int LEVEL_WARN = 3;
    private static a sCallback = null;
    private static final boolean useChromiumBaseLog = true;

    public interface a {
        void a(int i11, String str, String str2);
    }

    public enum b {
        kAll(0),
        kInfo(1),
        kWarning(2),
        kError(3),
        kFatal(4),
        kNone(5);
        
        public int mNativeValue;

        private b(int i11) {
            this.mNativeValue = i11;
        }

        public static int a(int i11) {
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 1) {
                return 2;
            }
            if (i11 == 2) {
                return 3;
            }
            if (i11 != 3) {
                return i11 != 4 ? 6 : 5;
            }
            return 4;
        }
    }

    static {
        r.a();
    }

    public static void d(com.tencent.liteav.base.b.a aVar, String str, String str2, Object... objArr) {
        if (aVar != null && aVar.a()) {
            d(str, str2, objArr);
        }
    }

    public static void e(com.tencent.liteav.base.b.a aVar, String str, String str2, Object... objArr) {
        if (aVar != null && aVar.a()) {
            e(str, str2, objArr);
        }
    }

    public static int getLogLevel() {
        return nativeGetLogLevel();
    }

    public static void i(com.tencent.liteav.base.b.a aVar, String str, String str2, Object... objArr) {
        if (aVar != null && aVar.a()) {
            i(str, str2, objArr);
        }
    }

    public static native int nativeGetLogLevel();

    public static native void nativeSetConsoleLogEnabled(boolean z11);

    public static native void nativeSetLogCallbackEnabled(boolean z11);

    public static native void nativeSetLogCompressEnabled(boolean z11);

    public static native void nativeSetLogFilePath(String str);

    public static native void nativeSetLogLevel(int i11);

    public static native void nativeSetLogToFileEnabled(boolean z11);

    public static void onLog(int i11, String str) {
        a aVar = sCallback;
        if (aVar != null) {
            aVar.a(b.a(i11), "TXLiteAVSDK", str);
        }
    }

    public static void setCallback(a aVar) {
        sCallback = aVar;
    }

    public static void v(com.tencent.liteav.base.b.a aVar, String str, String str2, Object... objArr) {
        if (aVar != null && aVar.a()) {
            v(str, str2, objArr);
        }
    }

    public static void w(com.tencent.liteav.base.b.a aVar, String str, String str2, Object... objArr) {
        if (aVar != null && aVar.a()) {
            w(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        d(str, String.format(Locale.ENGLISH, str2, objArr));
    }

    public static void e(String str, String str2, Object... objArr) {
        e(str, String.format(Locale.ENGLISH, str2, objArr));
    }

    public static void i(String str, String str2, Object... objArr) {
        i(str, String.format(Locale.ENGLISH, str2, objArr));
    }

    public static void v(String str, String str2, Object... objArr) {
        v(str, String.format(Locale.ENGLISH, str2, objArr));
    }

    public static void w(String str, String str2, Object... objArr) {
        w(str, String.format(Locale.ENGLISH, str2, objArr));
    }

    public static void d(String str, String str2) {
        Log.d(str, str2, new Object[0]);
    }

    public static void e(String str, String str2) {
        Log.e(str, str2, new Object[0]);
    }

    public static void i(String str, String str2) {
        Log.i(str, str2, new Object[0]);
    }

    public static void v(String str, String str2) {
        Log.v(str, str2, new Object[0]);
    }

    public static void w(String str, String str2) {
        Log.w(str, str2, new Object[0]);
    }

    public static void e(com.tencent.liteav.base.b.a aVar, String str, String str2, Throwable th2) {
        if (aVar != null && aVar.a()) {
            e(str, str2, th2);
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        e(str, str2 + "\n" + android.util.Log.getStackTraceString(th2));
    }
}
