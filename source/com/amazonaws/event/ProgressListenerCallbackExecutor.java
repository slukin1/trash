package com.amazonaws.event;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ProgressListenerCallbackExecutor {

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f14863b = b();

    /* renamed from: a  reason: collision with root package name */
    public final ProgressListener f14864a;

    public ProgressListenerCallbackExecutor(ProgressListener progressListener) {
        this.f14864a = progressListener;
    }

    public static ExecutorService b() {
        return Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("android-sdk-progress-listener-callback-thread");
                thread.setDaemon(true);
                return thread;
            }
        });
    }

    public static ProgressListenerCallbackExecutor d(ProgressListener progressListener) {
        if (progressListener == null) {
            return null;
        }
        return new ProgressListenerCallbackExecutor(progressListener);
    }

    public void c(final ProgressEvent progressEvent) {
        if (this.f14864a != null) {
            f14863b.submit(new Runnable() {
                public void run() {
                    ProgressListenerCallbackExecutor.this.f14864a.a(progressEvent);
                }
            });
        }
    }

    public ProgressListenerCallbackExecutor() {
        this.f14864a = null;
    }
}
