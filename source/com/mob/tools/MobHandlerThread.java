package com.mob.tools;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.mob.tools.proguard.EverythingKeeper;

public class MobHandlerThread extends Thread implements EverythingKeeper {
    private Looper looper;
    private int priority;
    private int tid;

    public MobHandlerThread() {
        this.tid = -1;
        this.priority = 0;
    }

    public static Handler newHandler(Handler.Callback callback) {
        return newHandler((String) null, (Runnable) null, callback);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0009 A[LOOP:0: B:4:0x0009->B:19:0x0009, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Looper getLooper() {
        /*
            r1 = this;
            boolean r0 = r1.isAlive()
            if (r0 != 0) goto L_0x0008
            r0 = 0
            return r0
        L_0x0008:
            monitor-enter(r1)
        L_0x0009:
            boolean r0 = r1.isAlive()     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0017
            android.os.Looper r0 = r1.looper     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0017
            r1.wait()     // Catch:{ all -> 0x0009 }
            goto L_0x0009
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            android.os.Looper r0 = r1.looper
            return r0
        L_0x001b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.MobHandlerThread.getLooper():android.os.Looper");
    }

    public int getThreadId() {
        return this.tid;
    }

    public void onLooperPrepared() {
    }

    public void onLooperPrepared(Looper looper2) {
    }

    public boolean quit() {
        Looper looper2 = getLooper();
        if (looper2 == null) {
            return false;
        }
        looper2.quit();
        return true;
    }

    @Deprecated
    public void realRun() {
    }

    public void run() {
        try {
            realRun();
            this.tid = Process.myTid();
            Looper.prepare();
            synchronized (this) {
                this.looper = Looper.myLooper();
                notifyAll();
            }
            Process.setThreadPriority(this.priority);
            onLooperPrepared(this.looper);
            onLooperPrepared();
            Looper.loop();
            this.tid = -1;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
    }

    public static Handler newHandler(String str, Handler.Callback callback) {
        return newHandler(str, (Runnable) null, callback);
    }

    public static Handler newHandler(Runnable runnable, Handler.Callback callback) {
        return newHandler((String) null, runnable, callback);
    }

    public MobHandlerThread(int i11) {
        this.tid = -1;
        this.priority = i11;
    }

    public static Handler newHandler(String str, final Runnable runnable, final Handler.Callback callback) {
        final Handler[] handlerArr = new Handler[1];
        AnonymousClass1 r12 = new MobHandlerThread() {
            public void onLooperPrepared(Looper looper) {
                synchronized (handlerArr) {
                    handlerArr[0] = new Handler(looper, callback);
                    handlerArr.notifyAll();
                }
            }

            public void run() {
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
                MobHandlerThread.super.run();
            }
        };
        synchronized (handlerArr) {
            if (str != null) {
                try {
                    r12.setName(str);
                } catch (Throwable th2) {
                    MobLog.getInstance().w(th2);
                }
            }
            r12.start();
            handlerArr.wait();
        }
        return handlerArr[0];
    }
}
