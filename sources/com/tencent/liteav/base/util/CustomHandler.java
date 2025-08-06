package com.tencent.liteav.base.util;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@JNINamespace("liteav")
public class CustomHandler extends Handler {
    private static final long TIMEOUT_QUIT_LOOPER = TimeUnit.SECONDS.toMillis(30);
    private Runnable mQuitLooperTimeoutRunnable;
    /* access modifiers changed from: private */
    public final String mTAG;
    private final Handler mUIHandler;

    public CustomHandler(Looper looper) {
        this(looper, (Handler.Callback) null);
    }

    public static /* synthetic */ boolean lambda$quitLooper$2(CustomHandler customHandler) {
        LiteavLog.i(customHandler.mTAG, "queue idle handle.");
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
            customHandler.getLooper().quitSafely();
        } else {
            customHandler.getLooper().quit();
        }
        customHandler.mUIHandler.removeCallbacks(customHandler.mQuitLooperTimeoutRunnable);
        return false;
    }

    public static /* synthetic */ void lambda$quitLooper$3(CustomHandler customHandler, MessageQueue.IdleHandler idleHandler) {
        if (customHandler.getLooper() == Looper.getMainLooper()) {
            LiteavLog.e(customHandler.mTAG, "try to quitLooper main looper!");
            return;
        }
        LiteavLog.i(customHandler.mTAG, "add idle handle.");
        Looper.myQueue().addIdleHandler(idleHandler);
    }

    public static /* synthetic */ void lambda$runAndWaitDone$0(Runnable runnable, CountDownLatch countDownLatch) {
        runnable.run();
        countDownLatch.countDown();
    }

    public static /* synthetic */ void lambda$runAndWaitDone$1(Runnable runnable, CountDownLatch countDownLatch) {
        runnable.run();
        countDownLatch.countDown();
    }

    public boolean isCurrentThread() {
        return Looper.myLooper() != null && Looper.myLooper() == getLooper();
    }

    public boolean postDelayedTask(Runnable runnable, long j11) {
        return postDelayed(runnable, j11);
    }

    public boolean postTask(Runnable runnable) {
        return post(runnable);
    }

    public void quitLooper() {
        post(e.a(this, d.a(this)));
        this.mUIHandler.postDelayed(this.mQuitLooperTimeoutRunnable, TIMEOUT_QUIT_LOOPER);
    }

    public void quitLooperAndWaitDone() {
        quitLooper();
        try {
            getLooper().getThread().join();
        } catch (InterruptedException unused) {
        }
    }

    public boolean runAndWaitDone(Runnable runnable) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean post = post(b.a(runnable, countDownLatch));
        if (post) {
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        return post;
    }

    public boolean runOrPost(Runnable runnable) {
        return runOrPost(runnable, 0);
    }

    public CustomHandler(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mQuitLooperTimeoutRunnable = new Runnable() {
            public final void run() {
                LiteavLog.e(CustomHandler.this.mTAG, "quit looper failed.");
            }
        };
        String str = "TXCHandler_" + hashCode();
        this.mTAG = str;
        LiteavLog.i(str, "[" + Thread.currentThread().getName() + "]");
    }

    public boolean runOrPost(Runnable runnable, int i11) {
        if (!getLooper().getThread().isAlive()) {
            return false;
        }
        if (Looper.myLooper() == getLooper() && i11 == 0) {
            runnable.run();
            return true;
        } else if (i11 == 0) {
            return post(runnable);
        } else {
            return postDelayed(runnable, (long) i11);
        }
    }

    public boolean runAndWaitDone(Runnable runnable, long j11) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean post = post(c.a(runnable, countDownLatch));
        if (post) {
            try {
                countDownLatch.await(j11, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        return post;
    }
}
