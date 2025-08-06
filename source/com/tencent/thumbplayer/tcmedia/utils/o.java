package com.tencent.thumbplayer.tcmedia.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private static volatile HandlerThread f49723a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Handler f49724b;

    /* renamed from: c  reason: collision with root package name */
    private static int f49725c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile ExecutorService f49726d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile ExecutorService f49727e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile ScheduledExecutorService f49728f;

    /* renamed from: g  reason: collision with root package name */
    private static volatile o f49729g;

    private o() {
    }

    public static o a() {
        if (f49729g == null) {
            synchronized (o.class) {
                if (f49729g == null) {
                    f49729g = new o();
                }
            }
        }
        return f49729g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void f() {
        /*
            java.lang.Class<com.tencent.thumbplayer.tcmedia.utils.o> r0 = com.tencent.thumbplayer.tcmedia.utils.o.class
            monitor-enter(r0)
            android.os.HandlerThread r1 = f49723a     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0014
            android.os.HandlerThread r1 = new android.os.HandlerThread     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "TP-ShareThreadPool"
            r1.<init>(r2)     // Catch:{ all -> 0x003a }
            f49723a = r1     // Catch:{ all -> 0x003a }
        L_0x0010:
            r1.start()     // Catch:{ all -> 0x003a }
            goto L_0x001f
        L_0x0014:
            android.os.HandlerThread r1 = f49723a     // Catch:{ all -> 0x003a }
            boolean r1 = r1.isAlive()     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x001f
            android.os.HandlerThread r1 = f49723a     // Catch:{ all -> 0x003a }
            goto L_0x0010
        L_0x001f:
            android.os.HandlerThread r1 = f49723a     // Catch:{ all -> 0x003a }
            android.os.Looper r1 = r1.getLooper()     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0038
            android.os.HandlerThread r1 = f49723a     // Catch:{ all -> 0x003a }
            r1.quit()     // Catch:{ all -> 0x003a }
            android.os.HandlerThread r1 = new android.os.HandlerThread     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "TP-ShareThreadPool"
            r1.<init>(r2)     // Catch:{ all -> 0x003a }
            f49723a = r1     // Catch:{ all -> 0x003a }
            r1.start()     // Catch:{ all -> 0x003a }
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x003a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.utils.o.f():void");
    }

    public HandlerThread a(String str) {
        return a(str, 0);
    }

    public HandlerThread a(String str, int i11) {
        if (i11 >= 19 || i11 <= -19) {
            i11 = 0;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TP-HandlerThread";
        }
        HandlerThread handlerThread = new HandlerThread(str, i11);
        handlerThread.start();
        return handlerThread;
    }

    public void a(HandlerThread handlerThread, Handler handler) {
        if (handlerThread != null) {
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            if (handlerThread.equals(f49723a)) {
                synchronized (o.class) {
                    f49725c--;
                    TPLogUtil.i("TPPlayer[TPThreadPool]", "handlerThread recycle mShareThreadCount:" + f49725c);
                }
                return;
            }
            handlerThread.quit();
        }
    }

    public HandlerThread b() {
        HandlerThread handlerThread;
        f();
        synchronized (o.class) {
            f49725c++;
            TPLogUtil.i("TPPlayer[TPThreadPool]", "handlerThread obtainShareThread mShareThreadCount:" + f49725c);
            handlerThread = f49723a;
        }
        return handlerThread;
    }

    public ExecutorService c() {
        if (f49726d == null) {
            synchronized (o.class) {
                if (f49726d == null) {
                    f49726d = Executors.newSingleThreadExecutor();
                }
            }
        }
        return f49726d;
    }

    public ExecutorService d() {
        if (f49727e == null) {
            synchronized (o.class) {
                if (f49727e == null) {
                    f49727e = p.a(4, 20);
                }
            }
        }
        return f49727e;
    }

    public ScheduledExecutorService e() {
        if (f49728f == null) {
            synchronized (o.class) {
                if (f49728f == null) {
                    f49728f = Executors.newScheduledThreadPool(4);
                }
            }
        }
        return f49728f;
    }
}
