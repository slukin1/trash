package androidx.camera.core.impl.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.h;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class Threads {
    private static final long TIMEOUT_RUN_ON_MAIN_MS = 30000;

    private Threads() {
    }

    public static void checkBackgroundThread() {
        h.j(isBackgroundThread(), "In application's main thread");
    }

    public static void checkMainThread() {
        h.j(isMainThread(), "Not in application's main thread");
    }

    private static Handler getMainHandler() {
        return new Handler(Looper.getMainLooper());
    }

    public static boolean isBackgroundThread() {
        return !isMainThread();
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$runOnMainSync$0(Runnable runnable, CountDownLatch countDownLatch) {
        try {
            runnable.run();
        } finally {
            countDownLatch.countDown();
        }
    }

    public static void runOnMain(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            h.j(getMainHandler().post(runnable), "Unable to post to main thread");
        }
    }

    public static void runOnMainSync(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        h.j(getMainHandler().post(new a(runnable, countDownLatch)), "Unable to post to main thread");
        try {
            if (!countDownLatch.await(30000, TimeUnit.MILLISECONDS)) {
                throw new IllegalStateException("Timeout to wait main thread execution");
            }
        } catch (InterruptedException e11) {
            throw new InterruptedRuntimeException((Throwable) e11);
        }
    }
}
