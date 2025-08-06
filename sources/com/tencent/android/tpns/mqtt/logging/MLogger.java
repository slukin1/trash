package com.tencent.android.tpns.mqtt.logging;

import java.util.ResourceBundle;

public class MLogger implements Logger {
    private static final String TAG = "MLogger";

    private void log(String str) {
    }

    public void config(String str, String str2, String str3) {
        log("config - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void dumpTrace() {
    }

    public void fine(String str, String str2, String str3) {
        log("fine - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void finer(String str, String str2, String str3) {
        log("finer - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void finest(String str, String str2, String str3) {
        log("finest - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public String formatMessage(String str, Object[] objArr) {
        return "";
    }

    public void info(String str, String str2, String str3) {
        log("info - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void initialise(ResourceBundle resourceBundle, String str, String str2) {
    }

    public boolean isLoggable(int i11) {
        return false;
    }

    public void log(int i11, String str, String str2, String str3, Object[] objArr, Throwable th2) {
        log("log - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void setResourceName(String str) {
    }

    public void severe(String str, String str2, String str3) {
        log("server - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void trace(int i11, String str, String str2, String str3, Object[] objArr, Throwable th2) {
        log("trace - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void warning(String str, String str2, String str3) {
        log("warning - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void config(String str, String str2, String str3, Object[] objArr) {
        log("config - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void fine(String str, String str2, String str3, Object[] objArr) {
        log("fine - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void finer(String str, String str2, String str3, Object[] objArr) {
        log("finer - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void finest(String str, String str2, String str3, Object[] objArr) {
        log("finest - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void info(String str, String str2, String str3, Object[] objArr) {
        log("info - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void severe(String str, String str2, String str3, Object[] objArr) {
        log("server - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void warning(String str, String str2, String str3, Object[] objArr) {
        log("warning - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void config(String str, String str2, String str3, Object[] objArr, Throwable th2) {
        log("config - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void fine(String str, String str2, String str3, Object[] objArr, Throwable th2) {
        log("fine - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void finer(String str, String str2, String str3, Object[] objArr, Throwable th2) {
        log("finer - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void finest(String str, String str2, String str3, Object[] objArr, Throwable th2) {
        log("finest - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void info(String str, String str2, String str3, Object[] objArr, Throwable th2) {
        log("info - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void severe(String str, String str2, String str3, Object[] objArr, Throwable th2) {
        log("server - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    public void warning(String str, String str2, String str3, Object[] objArr, Throwable th2) {
        log("warning - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }
}
