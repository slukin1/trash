package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final CrashListener crashListener;
    private final Thread.UncaughtExceptionHandler defaultHandler;
    private final AtomicBoolean isHandlingException = new AtomicBoolean(false);
    private final CrashlyticsNativeComponent nativeComponent;
    private final SettingsProvider settingsProvider;

    public interface CrashListener {
        void onUncaughtException(SettingsProvider settingsProvider, Thread thread, Throwable th2);
    }

    public CrashlyticsUncaughtExceptionHandler(CrashListener crashListener2, SettingsProvider settingsProvider2, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, CrashlyticsNativeComponent crashlyticsNativeComponent) {
        this.crashListener = crashListener2;
        this.settingsProvider = settingsProvider2;
        this.defaultHandler = uncaughtExceptionHandler;
        this.nativeComponent = crashlyticsNativeComponent;
    }

    private boolean shouldRecordUncaughtException(Thread thread, Throwable th2) {
        if (thread == null) {
            Logger.getLogger().e("Crashlytics will not record uncaught exception; null thread");
            return false;
        } else if (th2 == null) {
            Logger.getLogger().e("Crashlytics will not record uncaught exception; null throwable");
            return false;
        } else if (!this.nativeComponent.hasCrashDataForCurrentSession()) {
            return true;
        } else {
            Logger.getLogger().d("Crashlytics will not record uncaught exception; native crash exists for session.");
            return false;
        }
    }

    public boolean isHandlingException() {
        return this.isHandlingException.get();
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        this.isHandlingException.set(true);
        try {
            if (shouldRecordUncaughtException(thread, th2)) {
                this.crashListener.onUncaughtException(this.settingsProvider, thread, th2);
            } else {
                Logger.getLogger().d("Uncaught exception will not be recorded by Crashlytics.");
            }
        } catch (Exception e11) {
            Logger.getLogger().e("An error occurred in the uncaught exception handler", e11);
        } catch (Throwable th3) {
            Logger.getLogger().d("Completed exception processing. Invoking default exception handler.");
            this.defaultHandler.uncaughtException(thread, th2);
            this.isHandlingException.set(false);
            throw th3;
        }
        Logger.getLogger().d("Completed exception processing. Invoking default exception handler.");
        this.defaultHandler.uncaughtException(thread, th2);
        this.isHandlingException.set(false);
    }
}
