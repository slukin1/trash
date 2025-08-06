package com.jumio.commons.log;

import android.graphics.Bitmap;
import d10.a;
import java.io.File;
import kotlin.Unit;

public final class Log {
    public static final Log INSTANCE = new Log();

    /* renamed from: a  reason: collision with root package name */
    public static LogLevel f38979a = LogLevel.OFF;

    public static final void allowFileLogging(boolean z11) {
    }

    public static final void d(String str) {
    }

    public static final void d(String str, File file, String str2) {
    }

    public static final void d(String str, String str2) {
    }

    public static final void d(String str, String str2, Throwable th2) {
    }

    public static final void d(String str, Throwable th2) {
    }

    public static final void e(String str) {
    }

    public static final void e(String str, File file, String str2) {
    }

    public static final void e(String str, String str2) {
    }

    public static final void e(String str, String str2, Throwable th2) {
    }

    public static final void e(String str, Throwable th2) {
    }

    public static final LogLevel getLogLevel() {
        return f38979a;
    }

    public static /* synthetic */ void getLogLevel$annotations() {
    }

    public static final void i(String str) {
    }

    public static final void i(String str, File file, String str2) {
    }

    public static final void i(String str, String str2) {
    }

    public static final void i(String str, String str2, Throwable th2) {
    }

    public static final void i(String str, Throwable th2) {
    }

    public static /* synthetic */ void image$default(Log log, Bitmap bitmap, File file, String str, Bitmap.CompressFormat compressFormat, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        Bitmap.CompressFormat compressFormat2 = compressFormat;
        if ((i12 & 16) != 0) {
            i11 = 80;
        }
        log.image(bitmap, file, str, compressFormat2, i11);
    }

    public static final boolean isFileLoggingActivated() {
        return false;
    }

    public static /* synthetic */ void isFileLoggingActivated$annotations() {
    }

    public static final void printStackTrace(Throwable th2) {
    }

    public static final void setLogLevel(LogLevel logLevel) {
        f38979a = logLevel;
    }

    public static final void v(String str) {
    }

    public static final void v(String str, File file, String str2) {
    }

    public static final void v(String str, String str2) {
    }

    public static final void v(String str, String str2, Throwable th2) {
    }

    public static final void v(String str, Throwable th2) {
    }

    public static final void w(String str) {
    }

    public static final void w(String str, File file, String str2) {
    }

    public static final void w(String str, String str2) {
    }

    public static final void w(String str, String str2, Throwable th2) {
    }

    public static final void w(String str, Throwable th2) {
    }

    public final void data(byte[] bArr, File file, String str) {
    }

    public final void image(Bitmap bitmap, File file, String str, Bitmap.CompressFormat compressFormat, int i11) {
    }

    public final void logThreadInfoWithMessage(String str) {
    }

    public final void runIfLogLevelIs(LogLevel logLevel, a<Unit> aVar) {
    }
}
