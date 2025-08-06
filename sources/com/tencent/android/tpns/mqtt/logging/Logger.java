package com.tencent.android.tpns.mqtt.logging;

import java.util.ResourceBundle;

public interface Logger {
    public static final int CONFIG = 4;
    public static final int FINE = 5;
    public static final int FINER = 6;
    public static final int FINEST = 7;
    public static final int INFO = 3;
    public static final int SEVERE = 1;
    public static final int WARNING = 2;

    void config(String str, String str2, String str3);

    void config(String str, String str2, String str3, Object[] objArr);

    void config(String str, String str2, String str3, Object[] objArr, Throwable th2);

    void dumpTrace();

    void fine(String str, String str2, String str3);

    void fine(String str, String str2, String str3, Object[] objArr);

    void fine(String str, String str2, String str3, Object[] objArr, Throwable th2);

    void finer(String str, String str2, String str3);

    void finer(String str, String str2, String str3, Object[] objArr);

    void finer(String str, String str2, String str3, Object[] objArr, Throwable th2);

    void finest(String str, String str2, String str3);

    void finest(String str, String str2, String str3, Object[] objArr);

    void finest(String str, String str2, String str3, Object[] objArr, Throwable th2);

    String formatMessage(String str, Object[] objArr);

    void info(String str, String str2, String str3);

    void info(String str, String str2, String str3, Object[] objArr);

    void info(String str, String str2, String str3, Object[] objArr, Throwable th2);

    void initialise(ResourceBundle resourceBundle, String str, String str2);

    boolean isLoggable(int i11);

    void log(int i11, String str, String str2, String str3, Object[] objArr, Throwable th2);

    void setResourceName(String str);

    void severe(String str, String str2, String str3);

    void severe(String str, String str2, String str3, Object[] objArr);

    void severe(String str, String str2, String str3, Object[] objArr, Throwable th2);

    void trace(int i11, String str, String str2, String str3, Object[] objArr, Throwable th2);

    void warning(String str, String str2, String str3);

    void warning(String str, String str2, String str3, Object[] objArr);

    void warning(String str, String str2, String str3, Object[] objArr, Throwable th2);
}
