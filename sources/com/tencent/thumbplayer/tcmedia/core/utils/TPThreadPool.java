package com.tencent.thumbplayer.tcmedia.core.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TPThreadPool {
    private static final int CORE_POOL_SIZE = 1;
    private static final int MAX_POOL_SIZE = 20;
    private static final String PRE_THREAD_NAME = "TPCoreHdr";
    private static final String SHARE_THREAD_NAME = "TPCore-ShareThread";
    private static final String TAG = "TPCore[TPThreadPool]";
    private static volatile ExecutorService sCustomExecutor;
    private static volatile HandlerThread sHandlerThread;
    private static volatile TPThreadPool sInstance;
    private static volatile Handler sMainThreadHandler;
    private static volatile ScheduledExecutorService sScheduler;
    private static volatile ExecutorService sShareSingleExecutor;
    private static int sShareThreadCount;

    private TPThreadPool() {
    }

    public static TPThreadPool getInstance() {
        if (sInstance == null) {
            synchronized (TPThreadPool.class) {
                if (sInstance == null) {
                    sInstance = new TPThreadPool();
                }
            }
        }
        return sInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void initHandlerThread() {
        /*
            java.lang.Class<com.tencent.thumbplayer.tcmedia.core.utils.TPThreadPool> r0 = com.tencent.thumbplayer.tcmedia.core.utils.TPThreadPool.class
            monitor-enter(r0)
            android.os.HandlerThread r1 = sHandlerThread     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0014
            android.os.HandlerThread r1 = new android.os.HandlerThread     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "TPCore-ShareThread"
            r1.<init>(r2)     // Catch:{ all -> 0x003a }
            sHandlerThread = r1     // Catch:{ all -> 0x003a }
        L_0x0010:
            r1.start()     // Catch:{ all -> 0x003a }
            goto L_0x001f
        L_0x0014:
            android.os.HandlerThread r1 = sHandlerThread     // Catch:{ all -> 0x003a }
            boolean r1 = r1.isAlive()     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x001f
            android.os.HandlerThread r1 = sHandlerThread     // Catch:{ all -> 0x003a }
            goto L_0x0010
        L_0x001f:
            android.os.HandlerThread r1 = sHandlerThread     // Catch:{ all -> 0x003a }
            android.os.Looper r1 = r1.getLooper()     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0038
            android.os.HandlerThread r1 = sHandlerThread     // Catch:{ all -> 0x003a }
            r1.quit()     // Catch:{ all -> 0x003a }
            android.os.HandlerThread r1 = new android.os.HandlerThread     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "TPCore-ShareThread"
            r1.<init>(r2)     // Catch:{ all -> 0x003a }
            sHandlerThread = r1     // Catch:{ all -> 0x003a }
            r1.start()     // Catch:{ all -> 0x003a }
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x003a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.utils.TPThreadPool.initHandlerThread():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void initMainThreadHandler() {
        /*
            android.os.Handler r0 = sMainThreadHandler
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.Class<com.tencent.thumbplayer.tcmedia.core.utils.TPThreadPool> r0 = com.tencent.thumbplayer.tcmedia.core.utils.TPThreadPool.class
            monitor-enter(r0)
            android.os.Handler r1 = sMainThreadHandler     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            return
        L_0x000e:
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x001c
            android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x0029 }
            r2.<init>(r1)     // Catch:{ all -> 0x0029 }
            sMainThreadHandler = r2     // Catch:{ all -> 0x0029 }
            goto L_0x0027
        L_0x001c:
            r1 = 0
            sMainThreadHandler = r1     // Catch:{ all -> 0x0029 }
            r1 = 4
            java.lang.String r2 = "TPCore[TPThreadPool]"
            java.lang.String r3 = "cannot get thread looper"
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r1, r2, r3)     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            return
        L_0x0029:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.utils.TPThreadPool.initMainThreadHandler():void");
    }

    public HandlerThread obtainHandleThread(String str) {
        return obtainHandleThread(str, 0);
    }

    public HandlerThread obtainHandleThread(String str, int i11) {
        if (i11 >= 19 || i11 <= -19) {
            i11 = 0;
        }
        if (TextUtils.isEmpty(str)) {
            str = PRE_THREAD_NAME;
        }
        HandlerThread handlerThread = new HandlerThread(str, i11);
        handlerThread.start();
        return handlerThread;
    }

    public ScheduledExecutorService obtainScheduledExecutorService() {
        if (sScheduler == null) {
            synchronized (TPThreadPool.class) {
                if (sScheduler == null) {
                    sScheduler = Executors.newScheduledThreadPool(1);
                }
            }
        }
        return sScheduler;
    }

    public HandlerThread obtainShareThread() {
        HandlerThread handlerThread;
        initHandlerThread();
        synchronized (TPThreadPool.class) {
            sShareThreadCount++;
            TPNativeLog.printLog(2, TAG, "handlerThread obtainShareThread mShareThreadCount:" + sShareThreadCount);
            handlerThread = sHandlerThread;
        }
        return handlerThread;
    }

    public ExecutorService obtainSingleThreadExecutor() {
        if (sShareSingleExecutor == null) {
            synchronized (TPThreadPool.class) {
                if (sShareSingleExecutor == null) {
                    sShareSingleExecutor = Executors.newSingleThreadExecutor();
                }
            }
        }
        return sShareSingleExecutor;
    }

    public ExecutorService obtainThreadExecutor() {
        if (sCustomExecutor == null) {
            synchronized (TPThreadPool.class) {
                if (sCustomExecutor == null) {
                    sCustomExecutor = TPThreadPoolExecutor.newCustomThreadExecutor(1, 20);
                }
            }
        }
        return sCustomExecutor;
    }

    public void postDelayRunnableOnMainThread(Runnable runnable, long j11) {
        initMainThreadHandler();
        if (sMainThreadHandler != null) {
            sMainThreadHandler.postDelayed(runnable, j11);
        }
    }

    public void postRunnableOnMainThread(Runnable runnable) {
        initMainThreadHandler();
        if (sMainThreadHandler != null) {
            sMainThreadHandler.post(runnable);
        }
    }

    public void postRunnableOnMainThreadFront(Runnable runnable) {
        initMainThreadHandler();
        if (sMainThreadHandler != null) {
            sMainThreadHandler.postAtFrontOfQueue(runnable);
        }
    }

    public void recycle(HandlerThread handlerThread, Handler handler) {
        if (handlerThread != null) {
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            if (handlerThread.equals(sHandlerThread)) {
                synchronized (TPThreadPool.class) {
                    sShareThreadCount--;
                    TPNativeLog.printLog(2, TAG, "handlerThread recycle mShareThreadCount:" + sShareThreadCount);
                }
                return;
            }
            handlerThread.quit();
        }
    }
}
