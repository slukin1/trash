package com.mob.commons;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.utils.ActivityTracker;
import java.util.HashSet;
import java.util.Iterator;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static l f27269a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final HashSet<k> f27270b = new HashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile Handler f27271c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f27272d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public volatile long f27273e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public volatile long f27274f;

    private l() {
        String str = null;
        this.f27272d = null;
        this.f27273e = -1;
        this.f27274f = 0;
        this.f27274f = SystemClock.elapsedRealtime();
        if (!TextUtils.isEmpty("M-")) {
            str = z.f27382a + a("004+iehljmjh");
        }
        this.f27271c = MobHandlerThread.newHandler(str, (Handler.Callback) new Handler.Callback() {
            public boolean handleMessage(Message message) {
                int i11 = message.what;
                if (i11 == 0) {
                    long unused = l.this.f27273e = SystemClock.elapsedRealtime();
                    l.this.a(false);
                    l.this.d();
                } else if (i11 == 1) {
                    l.this.a(true);
                } else if (i11 == 2) {
                    l.this.a(((Long) message.obj).longValue(), true);
                } else if (i11 == 3) {
                    try {
                        k kVar = (k) message.obj;
                        if (kVar != null) {
                            l.this.f27270b.add(kVar);
                            kVar.a(l.this.f27273e > 0, true, 0);
                        }
                    } catch (Throwable th2) {
                        MobLog.getInstance().d(th2);
                    }
                }
                return false;
            }
        });
    }

    /* access modifiers changed from: private */
    public void d() {
        ActivityTracker.getInstance(MobSDK.getContext()).addTracker(new FBManager$2(this));
    }

    public long c() {
        return this.f27274f;
    }

    public boolean b() {
        return this.f27273e == 0;
    }

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (f27269a == null) {
                l lVar2 = new l();
                f27269a = lVar2;
                if (lVar2.f27271c != null) {
                    f27269a.f27271c.sendEmptyMessage(0);
                }
            }
            lVar = f27269a;
        }
        return lVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.mob.commons.k r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.HashSet<com.mob.commons.k> r0 = r3.f27270b
            monitor-enter(r0)
            java.util.HashSet<com.mob.commons.k> r1 = r3.f27270b     // Catch:{ all -> 0x0025 }
            boolean r1 = r1.contains(r4)     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0010
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0010:
            android.os.Handler r1 = r3.f27271c     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0023
            android.os.Message r1 = new android.os.Message     // Catch:{ all -> 0x0025 }
            r1.<init>()     // Catch:{ all -> 0x0025 }
            r2 = 3
            r1.what = r2     // Catch:{ all -> 0x0025 }
            r1.obj = r4     // Catch:{ all -> 0x0025 }
            android.os.Handler r4 = r3.f27271c     // Catch:{ all -> 0x0025 }
            r4.sendMessage(r1)     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.l.a(com.mob.commons.k):void");
    }

    /* access modifiers changed from: private */
    public void a(boolean z11) {
        if (z11) {
            a(true, false, 0);
        }
    }

    /* access modifiers changed from: private */
    public void a(long j11, boolean z11) {
        if (z11) {
            a(false, false, j11);
        }
    }

    private void a(boolean z11, boolean z12, long j11) {
        synchronized (this.f27270b) {
            Iterator<k> it2 = this.f27270b.iterator();
            while (it2.hasNext()) {
                it2.next().a(z11, z12, j11);
            }
        }
    }

    public static String a(String str) {
        return v.a(str, 101);
    }
}
