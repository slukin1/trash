package com.tencent.liteav.base;

import com.tencent.liteav.base.annotations.JNINamespace;
import java.lang.Thread;

@JNINamespace("base::android")
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean mCrashAfterReport;
    private boolean mHandlingException;
    private final Thread.UncaughtExceptionHandler mParent;

    static {
        Class<JavaExceptionReporter> cls = JavaExceptionReporter.class;
    }

    private JavaExceptionReporter(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z11) {
        this.mParent = uncaughtExceptionHandler;
        this.mCrashAfterReport = z11;
    }

    private static void installHandler(boolean z11) {
        Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), z11));
    }

    public static void reportStackTrace(String str) {
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        if (!this.mHandlingException) {
            this.mHandlingException = true;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mParent;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        }
    }
}
