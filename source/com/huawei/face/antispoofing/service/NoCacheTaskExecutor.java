package com.huawei.face.antispoofing.service;

import a.a;
import com.huawei.face.antispoofing.exception.ValidateException;
import com.huawei.face.antispoofing.http.ValidateCodeEnum;
import com.huawei.face.antispoofing.utils.LogFace;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

public class NoCacheTaskExecutor implements Runnable, Thread.UncaughtExceptionHandler {

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicInteger f37596g = new AtomicInteger(0);

    /* renamed from: a  reason: collision with root package name */
    private String f37597a = "NoCacheTaskExecutor-";

    /* renamed from: b  reason: collision with root package name */
    private boolean f37598b = false;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f37599c;

    /* renamed from: d  reason: collision with root package name */
    private Runnable f37600d;

    /* renamed from: e  reason: collision with root package name */
    private Object f37601e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private boolean f37602f = false;

    public NoCacheTaskExecutor() {
        this.f37597a += f37596g.addAndGet(1);
    }

    public boolean isRunning() {
        return this.f37598b;
    }

    public void post(Runnable runnable) {
        synchronized (this.f37601e) {
            this.f37600d = runnable;
        }
    }

    public void run() {
        Runnable runnable;
        Thread.currentThread().setUncaughtExceptionHandler(this);
        while (this.f37598b) {
            Runnable runnable2 = this.f37600d;
            if (runnable2 == null || this.f37599c == runnable2) {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e11) {
                    LogFace.w(this.f37597a, "Thread sleep exception", e11);
                }
            } else {
                synchronized (this.f37601e) {
                    runnable = this.f37600d;
                }
                this.f37602f = true;
                runnable.run();
                this.f37602f = false;
                this.f37599c = runnable;
            }
        }
    }

    public void start() {
        if (!this.f37598b) {
            this.f37598b = true;
            new Thread(this).start();
            LogFace.i(this.f37597a, "NoCacheTaskExecutor is started");
            return;
        }
        LogFace.i(this.f37597a, "NoCacheTaskExecutor is running,can not start again");
        throw new ValidateException(ValidateCodeEnum.NO_CACHE_TASK_EXECUTOR_RUNNING);
    }

    public void stop() {
        this.f37598b = false;
        for (int i11 = 0; i11 < 10 && !this.f37602f; i11++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e11) {
                LogFace.w(this.f37597a, "Thread sleep exception", e11);
            }
        }
        this.f37600d = null;
        this.f37599c = null;
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        String str = this.f37597a;
        StringBuilder c11 = a.c("UncaughtException at ");
        c11.append(thread.getName());
        LogFace.w(str, c11.toString(), th2);
    }
}
