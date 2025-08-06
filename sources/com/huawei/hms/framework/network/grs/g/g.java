package com.huawei.hms.framework.network.grs.g;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.g.j.c;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public class g {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final ExecutorService f38065b = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, com.huawei.hms.framework.network.grs.g.j.b> f38066c = new ConcurrentHashMap(16);

    /* renamed from: d  reason: collision with root package name */
    private static final Object f38067d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public com.huawei.hms.framework.network.grs.e.a f38068a;

    public class a implements Callable<d> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f38069a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f38070b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f38071c;

        public a(c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
            this.f38069a = cVar;
            this.f38070b = str;
            this.f38071c = cVar2;
        }

        public d call() {
            return new c(this.f38069a, g.this.f38068a).a(g.f38065b, this.f38070b, this.f38071c);
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f38073a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f38074b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f38075c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f38076d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ com.huawei.hms.framework.network.grs.b f38077e;

        public b(c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2, int i11, com.huawei.hms.framework.network.grs.b bVar) {
            this.f38073a = cVar;
            this.f38074b = str;
            this.f38075c = cVar2;
            this.f38076d = i11;
            this.f38077e = bVar;
        }

        public void run() {
            g gVar = g.this;
            gVar.a(gVar.a(this.f38073a, this.f38074b, this.f38075c, this.f38076d), this.f38077e);
        }
    }

    /* access modifiers changed from: private */
    public void a(d dVar, com.huawei.hms.framework.network.grs.b bVar) {
        if (bVar == null) {
            return;
        }
        if (dVar == null) {
            Logger.v("RequestController", "GrsResponse is null");
            bVar.a();
            return;
        }
        Logger.v("RequestController", "GrsResponse is not null");
        bVar.a(dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008a, code lost:
        if (r12 == -1) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008d, code lost:
        r9 = com.huawei.hms.framework.network.grs.g.i.a.a(r9.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        if (r9 == null) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0097, code lost:
        r12 = r9.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009c, code lost:
        r12 = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009e, code lost:
        com.huawei.hms.framework.common.Logger.i("RequestController", "use grsQueryTimeout %d", java.lang.Integer.valueOf(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b7, code lost:
        return r10.get((long) r12, java.util.concurrent.TimeUnit.SECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b8, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b9, code lost:
        r10 = "RequestController";
        r11 = "when check result, find Other Exception, check others";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00be, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bf, code lost:
        r10 = "RequestController";
        r11 = "when check result, find TimeoutException, check others";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c4, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c5, code lost:
        r10 = "RequestController";
        r11 = "when check result, find InterruptedException, check others";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ca, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cb, code lost:
        r10 = "RequestController";
        r11 = "when check result, find ExecutionException, check others";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d0, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d1, code lost:
        r10 = "RequestController";
        r11 = "when check result, find CancellationException, check others";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d5, code lost:
        com.huawei.hms.framework.common.Logger.w(r10, r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d8, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.framework.network.grs.g.d a(com.huawei.hms.framework.network.grs.g.j.c r9, java.lang.String r10, com.huawei.hms.framework.network.grs.e.c r11, int r12) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "request to server with service name is: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RequestController"
            com.huawei.hms.framework.common.Logger.d(r1, r0)
            com.huawei.hms.framework.network.grs.GrsBaseInfo r0 = r9.b()
            android.content.Context r1 = r9.a()
            r2 = 1
            java.lang.String r0 = r0.getGrsParasKey(r2, r2, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "request spUrlKey: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "RequestController"
            com.huawei.hms.framework.common.Logger.v(r3, r1)
            java.lang.Object r1 = f38067d
            monitor-enter(r1)
            android.content.Context r3 = r9.a()     // Catch:{ all -> 0x00d9 }
            boolean r3 = com.huawei.hms.framework.common.NetworkUtil.isNetworkAvailable(r3)     // Catch:{ all -> 0x00d9 }
            r4 = 0
            if (r3 != 0) goto L_0x0049
            monitor-exit(r1)     // Catch:{ all -> 0x00d9 }
            return r4
        L_0x0049:
            com.huawei.hms.framework.network.grs.h.d$a r3 = com.huawei.hms.framework.network.grs.h.d.a(r0)     // Catch:{ all -> 0x00d9 }
            java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.g.j.b> r5 = f38066c     // Catch:{ all -> 0x00d9 }
            java.lang.Object r6 = r5.get(r0)     // Catch:{ all -> 0x00d9 }
            com.huawei.hms.framework.network.grs.g.j.b r6 = (com.huawei.hms.framework.network.grs.g.j.b) r6     // Catch:{ all -> 0x00d9 }
            if (r6 == 0) goto L_0x0063
            boolean r7 = r6.b()     // Catch:{ all -> 0x00d9 }
            if (r7 != 0) goto L_0x005e
            goto L_0x0063
        L_0x005e:
            java.util.concurrent.Future r10 = r6.a()     // Catch:{ all -> 0x00d9 }
            goto L_0x0088
        L_0x0063:
            if (r3 == 0) goto L_0x006e
            boolean r3 = r3.a()     // Catch:{ all -> 0x00d9 }
            if (r3 != 0) goto L_0x006c
            goto L_0x006e
        L_0x006c:
            monitor-exit(r1)     // Catch:{ all -> 0x00d9 }
            return r4
        L_0x006e:
            java.lang.String r3 = "RequestController"
            java.lang.String r6 = "hitGrsRequestBean == null or request block is released."
            com.huawei.hms.framework.common.Logger.d(r3, r6)     // Catch:{ all -> 0x00d9 }
            java.util.concurrent.ExecutorService r3 = f38065b     // Catch:{ all -> 0x00d9 }
            com.huawei.hms.framework.network.grs.g.g$a r6 = new com.huawei.hms.framework.network.grs.g.g$a     // Catch:{ all -> 0x00d9 }
            r6.<init>(r9, r10, r11)     // Catch:{ all -> 0x00d9 }
            java.util.concurrent.Future r10 = r3.submit(r6)     // Catch:{ all -> 0x00d9 }
            com.huawei.hms.framework.network.grs.g.j.b r11 = new com.huawei.hms.framework.network.grs.g.j.b     // Catch:{ all -> 0x00d9 }
            r11.<init>(r10)     // Catch:{ all -> 0x00d9 }
            r5.put(r0, r11)     // Catch:{ all -> 0x00d9 }
        L_0x0088:
            monitor-exit(r1)     // Catch:{ all -> 0x00d9 }
            r11 = -1
            if (r12 == r11) goto L_0x008d
            goto L_0x009e
        L_0x008d:
            android.content.Context r9 = r9.a()
            com.huawei.hms.framework.network.grs.g.j.d r9 = com.huawei.hms.framework.network.grs.g.i.a.a(r9)
            if (r9 == 0) goto L_0x009c
            int r12 = r9.c()
            goto L_0x009e
        L_0x009c:
            r12 = 10
        L_0x009e:
            java.lang.Object[] r9 = new java.lang.Object[r2]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r12)
            r0 = 0
            r9[r0] = r11
            java.lang.String r11 = "RequestController"
            java.lang.String r0 = "use grsQueryTimeout %d"
            com.huawei.hms.framework.common.Logger.i(r11, r0, r9)
            long r11 = (long) r12
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ CancellationException -> 0x00d0, ExecutionException -> 0x00ca, InterruptedException -> 0x00c4, TimeoutException -> 0x00be, Exception -> 0x00b8 }
            java.lang.Object r9 = r10.get(r11, r9)     // Catch:{ CancellationException -> 0x00d0, ExecutionException -> 0x00ca, InterruptedException -> 0x00c4, TimeoutException -> 0x00be, Exception -> 0x00b8 }
            com.huawei.hms.framework.network.grs.g.d r9 = (com.huawei.hms.framework.network.grs.g.d) r9     // Catch:{ CancellationException -> 0x00d0, ExecutionException -> 0x00ca, InterruptedException -> 0x00c4, TimeoutException -> 0x00be, Exception -> 0x00b8 }
            return r9
        L_0x00b8:
            r9 = move-exception
            java.lang.String r10 = "RequestController"
            java.lang.String r11 = "when check result, find Other Exception, check others"
            goto L_0x00d5
        L_0x00be:
            r9 = move-exception
            java.lang.String r10 = "RequestController"
            java.lang.String r11 = "when check result, find TimeoutException, check others"
            goto L_0x00d5
        L_0x00c4:
            r9 = move-exception
            java.lang.String r10 = "RequestController"
            java.lang.String r11 = "when check result, find InterruptedException, check others"
            goto L_0x00d5
        L_0x00ca:
            r9 = move-exception
            java.lang.String r10 = "RequestController"
            java.lang.String r11 = "when check result, find ExecutionException, check others"
            goto L_0x00d5
        L_0x00d0:
            r9 = move-exception
            java.lang.String r10 = "RequestController"
            java.lang.String r11 = "when check result, find CancellationException, check others"
        L_0x00d5:
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r10, (java.lang.String) r11, (java.lang.Throwable) r9)
            return r4
        L_0x00d9:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00d9 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.g.a(com.huawei.hms.framework.network.grs.g.j.c, java.lang.String, com.huawei.hms.framework.network.grs.e.c, int):com.huawei.hms.framework.network.grs.g.d");
    }

    public void a(com.huawei.hms.framework.network.grs.e.a aVar) {
        this.f38068a = aVar;
    }

    public void a(c cVar, com.huawei.hms.framework.network.grs.b bVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2, int i11) {
        f38065b.execute(new b(cVar, str, cVar2, i11, bVar));
    }

    public void a(String str) {
        synchronized (f38067d) {
            f38066c.remove(str);
        }
    }
}
