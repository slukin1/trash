package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;

public class eo implements fe {

    /* renamed from: a  reason: collision with root package name */
    private int f51737a;

    /* renamed from: a  reason: collision with other field name */
    private long f2795a = 0;

    /* renamed from: a  reason: collision with other field name */
    public fb f2796a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f2797a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f2798a;

    /* renamed from: a  reason: collision with other field name */
    private String f2799a;

    /* renamed from: b  reason: collision with root package name */
    private long f51738b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f51739c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f51740d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f51741e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f51742f = 0;

    public eo(XMPushService xMPushService) {
        this.f2797a = xMPushService;
        this.f2799a = "";
        b();
        int myUid = Process.myUid();
        try {
            this.f51742f = TrafficStats.getUidRxBytes(myUid);
            this.f51741e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e11) {
            b.a("Failed to obtain traffic data during initialization: " + e11);
            this.f51742f = -1;
            this.f51741e = -1;
        }
    }

    private void b() {
        this.f51738b = 0;
        this.f51740d = 0;
        this.f2795a = 0;
        this.f51739c = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (av.a((Context) this.f2797a)) {
            this.f2795a = elapsedRealtime;
        }
        if (this.f2797a.c()) {
            this.f51739c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        b.c("stat connpt = " + this.f2799a + " netDuration = " + this.f51738b + " ChannelDuration = " + this.f51740d + " channelConnectedTime = " + this.f51739c);
        ek ekVar = new ek();
        ekVar.f2774a = 0;
        ekVar.a(ej.CHANNEL_ONLINE_RATE.a());
        ekVar.a(this.f2799a);
        ekVar.d((int) (System.currentTimeMillis() / 1000));
        ekVar.b((int) (this.f51738b / 1000));
        ekVar.c((int) (this.f51740d / 1000));
        ep.a().a(ekVar);
        b();
    }

    public Exception a() {
        return this.f2798a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
        return;
     */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m2642a() {
        /*
            r10 = this;
            monitor-enter(r10)
            com.xiaomi.push.service.XMPushService r0 = r10.f2797a     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r10)
            return
        L_0x0007:
            java.lang.String r0 = com.xiaomi.push.av.a((android.content.Context) r0)     // Catch:{ all -> 0x0069 }
            com.xiaomi.push.service.XMPushService r1 = r10.f2797a     // Catch:{ all -> 0x0069 }
            boolean r1 = com.xiaomi.push.av.b(r1)     // Catch:{ all -> 0x0069 }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0069 }
            long r4 = r10.f2795a     // Catch:{ all -> 0x0069 }
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0026
            long r8 = r10.f51738b     // Catch:{ all -> 0x0069 }
            long r4 = r2 - r4
            long r8 = r8 + r4
            r10.f51738b = r8     // Catch:{ all -> 0x0069 }
            r10.f2795a = r6     // Catch:{ all -> 0x0069 }
        L_0x0026:
            long r4 = r10.f51739c     // Catch:{ all -> 0x0069 }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0035
            long r8 = r10.f51740d     // Catch:{ all -> 0x0069 }
            long r4 = r2 - r4
            long r8 = r8 + r4
            r10.f51740d = r8     // Catch:{ all -> 0x0069 }
            r10.f51739c = r6     // Catch:{ all -> 0x0069 }
        L_0x0035:
            if (r1 == 0) goto L_0x0067
            java.lang.String r1 = r10.f2799a     // Catch:{ all -> 0x0069 }
            boolean r1 = android.text.TextUtils.equals(r1, r0)     // Catch:{ all -> 0x0069 }
            if (r1 != 0) goto L_0x0047
            long r4 = r10.f51738b     // Catch:{ all -> 0x0069 }
            r8 = 30000(0x7530, double:1.4822E-319)
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 > 0) goto L_0x0050
        L_0x0047:
            long r4 = r10.f51738b     // Catch:{ all -> 0x0069 }
            r8 = 5400000(0x5265c0, double:2.6679545E-317)
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x0053
        L_0x0050:
            r10.c()     // Catch:{ all -> 0x0069 }
        L_0x0053:
            r10.f2799a = r0     // Catch:{ all -> 0x0069 }
            long r0 = r10.f2795a     // Catch:{ all -> 0x0069 }
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x005d
            r10.f2795a = r2     // Catch:{ all -> 0x0069 }
        L_0x005d:
            com.xiaomi.push.service.XMPushService r0 = r10.f2797a     // Catch:{ all -> 0x0069 }
            boolean r0 = r0.c()     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x0067
            r10.f51739c = r2     // Catch:{ all -> 0x0069 }
        L_0x0067:
            monitor-exit(r10)
            return
        L_0x0069:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.eo.m2642a():void");
    }

    public void b(fb fbVar) {
        a();
        this.f51739c = SystemClock.elapsedRealtime();
        eq.a(0, ej.CONN_SUCCESS.a(), fbVar.a(), fbVar.a());
    }

    public void a(fb fbVar) {
        this.f51737a = 0;
        this.f2798a = null;
        this.f2796a = fbVar;
        this.f2799a = av.a((Context) this.f2797a);
        eq.a(0, ej.CONN_SUCCESS.a());
    }

    public void a(fb fbVar, int i11, Exception exc) {
        long j11;
        if (this.f51737a == 0 && this.f2798a == null) {
            this.f51737a = i11;
            this.f2798a = exc;
            eq.b(fbVar.a(), exc);
        }
        if (i11 == 22 && this.f51739c != 0) {
            long a11 = fbVar.a() - this.f51739c;
            if (a11 < 0) {
                a11 = 0;
            }
            this.f51740d += a11 + ((long) (fh.b() / 2));
            this.f51739c = 0;
        }
        a();
        int myUid = Process.myUid();
        long j12 = -1;
        try {
            j12 = TrafficStats.getUidRxBytes(myUid);
            j11 = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e11) {
            b.a("Failed to obtain traffic data: " + e11);
            j11 = -1;
        }
        b.c("Stats rx=" + (j12 - this.f51742f) + ", tx=" + (j11 - this.f51741e));
        this.f51742f = j12;
        this.f51741e = j11;
    }

    public void a(fb fbVar, Exception exc) {
        eq.a(0, ej.CHANNEL_CON_FAIL.a(), 1, fbVar.a(), av.b(this.f2797a) ? 1 : 0);
        a();
    }
}
