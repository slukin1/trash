package com.tencent.wxop.stat;

import android.content.Context;

final class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f51081b;
    public final /* synthetic */ f bM;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f51082e;

    public k(Context context, String str, f fVar) {
        this.f51082e = context;
        this.f51081b = str;
        this.bM = fVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a3, code lost:
        com.tencent.wxop.stat.e.aV.b(r0);
        com.tencent.wxop.stat.e.a(r8.f51082e, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00af, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            android.content.Context r0 = r8.f51082e     // Catch:{ all -> 0x00a2 }
            com.tencent.wxop.stat.e.p((android.content.Context) r0)     // Catch:{ all -> 0x00a2 }
            java.util.Map r0 = com.tencent.wxop.stat.e.aT     // Catch:{ all -> 0x00a2 }
            monitor-enter(r0)     // Catch:{ all -> 0x00a2 }
            java.util.Map r1 = com.tencent.wxop.stat.e.aT     // Catch:{ all -> 0x009f }
            java.lang.String r2 = r8.f51081b     // Catch:{ all -> 0x009f }
            java.lang.Object r1 = r1.remove(r2)     // Catch:{ all -> 0x009f }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x009f }
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            if (r1 == 0) goto L_0x0082
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a2 }
            long r0 = r1.longValue()     // Catch:{ all -> 0x00a2 }
            long r2 = r2 - r0
            r0 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r0
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00a2 }
            long r1 = r0.longValue()     // Catch:{ all -> 0x00a2 }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0039
            r0 = 1
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x00a2 }
        L_0x0039:
            r6 = r0
            java.lang.String r0 = com.tencent.wxop.stat.e.aS     // Catch:{ all -> 0x00a2 }
            if (r0 == 0) goto L_0x004b
            java.lang.String r1 = r8.f51081b     // Catch:{ all -> 0x00a2 }
            boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x00a2 }
            r2 = 1
            if (r1 != r2) goto L_0x004b
            java.lang.String r0 = "-"
        L_0x004b:
            r3 = r0
            com.tencent.wxop.stat.a.h r0 = new com.tencent.wxop.stat.a.h     // Catch:{ all -> 0x00a2 }
            android.content.Context r2 = r8.f51082e     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = r8.f51081b     // Catch:{ all -> 0x00a2 }
            r1 = 0
            com.tencent.wxop.stat.f r5 = r8.bM     // Catch:{ all -> 0x00a2 }
            int r5 = com.tencent.wxop.stat.e.a((android.content.Context) r2, (boolean) r1, (com.tencent.wxop.stat.f) r5)     // Catch:{ all -> 0x00a2 }
            com.tencent.wxop.stat.f r7 = r8.bM     // Catch:{ all -> 0x00a2 }
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = r8.f51081b     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = com.tencent.wxop.stat.e.aR     // Catch:{ all -> 0x00a2 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x00a2 }
            if (r1 != 0) goto L_0x0074
            com.tencent.wxop.stat.b.b r1 = com.tencent.wxop.stat.e.aV     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = "Invalid invocation since previous onResume on diff page."
            r1.warn(r2)     // Catch:{ all -> 0x00a2 }
        L_0x0074:
            com.tencent.wxop.stat.p r1 = new com.tencent.wxop.stat.p     // Catch:{ all -> 0x00a2 }
            r1.<init>(r0)     // Catch:{ all -> 0x00a2 }
            r1.ah()     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = r8.f51081b     // Catch:{ all -> 0x00a2 }
            java.lang.String unused = com.tencent.wxop.stat.e.aS = r0     // Catch:{ all -> 0x00a2 }
            return
        L_0x0082:
            com.tencent.wxop.stat.b.b r0 = com.tencent.wxop.stat.e.aV     // Catch:{ all -> 0x00a2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = "Starttime for PageID:"
            r1.<init>(r2)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = r8.f51081b     // Catch:{ all -> 0x00a2 }
            r1.append(r2)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = " not found, lost onResume()?"
            r1.append(r2)     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a2 }
            r0.d(r1)     // Catch:{ all -> 0x00a2 }
            return
        L_0x009f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a2 }
            throw r1     // Catch:{ all -> 0x00a2 }
        L_0x00a2:
            r0 = move-exception
            com.tencent.wxop.stat.b.b r1 = com.tencent.wxop.stat.e.aV
            r1.b((java.lang.Throwable) r0)
            android.content.Context r1 = r8.f51082e
            com.tencent.wxop.stat.e.a((android.content.Context) r1, (java.lang.Throwable) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.k.run():void");
    }
}
