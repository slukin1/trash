package com.twitter.sdk.android.core;

public interface Logger {
    void d(String str, String str2);

    void d(String str, String str2, Throwable th2);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th2);

    int getLogLevel();

    void i(String str, String str2);

    void i(String str, String str2, Throwable th2);

    boolean isLoggable(String str, int i11);

    void log(int i11, String str, String str2);

    void log(int i11, String str, String str2, boolean z11);

    void setLogLevel(int i11);

    void v(String str, String str2);

    void v(String str, String str2, Throwable th2);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th2);
}
