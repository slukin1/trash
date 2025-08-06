package com.tencent.liteav.base.util;

import android.os.Handler;
import android.os.Looper;

public final class w extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private int f21574a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21575b = false;

    /* renamed from: c  reason: collision with root package name */
    private final a f21576c;

    public interface a {
        void onTimeout();
    }

    public w(Looper looper, a aVar) {
        super(looper);
        this.f21576c = aVar;
    }

    public final synchronized void a(int i11) {
        a();
        this.f21574a = i11;
        this.f21575b = true;
        sendEmptyMessageDelayed(0, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r3.onTimeout();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r3 = r2.f21576c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r3 == null) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleMessage(android.os.Message r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r3 = r2.f21575b     // Catch:{ all -> 0x001a }
            if (r3 != 0) goto L_0x0007
            monitor-exit(r2)     // Catch:{ all -> 0x001a }
            return
        L_0x0007:
            r3 = 0
            r2.removeMessages(r3)     // Catch:{ all -> 0x001a }
            int r0 = r2.f21574a     // Catch:{ all -> 0x001a }
            long r0 = (long) r0     // Catch:{ all -> 0x001a }
            r2.sendEmptyMessageDelayed(r3, r0)     // Catch:{ all -> 0x001a }
            monitor-exit(r2)     // Catch:{ all -> 0x001a }
            com.tencent.liteav.base.util.w$a r3 = r2.f21576c
            if (r3 == 0) goto L_0x0019
            r3.onTimeout()
        L_0x0019:
            return
        L_0x001a:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.util.w.handleMessage(android.os.Message):void");
    }

    public final synchronized void a() {
        while (hasMessages(0)) {
            removeMessages(0);
        }
        this.f21575b = false;
    }
}
