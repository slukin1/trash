package com.tencent.wxop.stat;

import android.content.Context;

final class as implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f50984a;
    public final /* synthetic */ f bM;

    /* renamed from: co  reason: collision with root package name */
    public final /* synthetic */ Context f50985co;

    public as(String str, Context context, f fVar) {
        this.f50984a = str;
        this.f50985co = context;
        this.bM = fVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
        com.tencent.wxop.stat.e.aV.b(r0);
        com.tencent.wxop.stat.e.a(r5.f50985co, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0092, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            java.util.Map r0 = com.tencent.wxop.stat.e.aT     // Catch:{ all -> 0x0085 }
            monitor-enter(r0)     // Catch:{ all -> 0x0085 }
            java.util.Map r1 = com.tencent.wxop.stat.e.aT     // Catch:{ all -> 0x0082 }
            int r1 = r1.size()     // Catch:{ all -> 0x0082 }
            int r2 = com.tencent.wxop.stat.c.v()     // Catch:{ all -> 0x0082 }
            if (r1 < r2) goto L_0x0032
            com.tencent.wxop.stat.b.b r1 = com.tencent.wxop.stat.e.aV     // Catch:{ all -> 0x0082 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = "The number of page events exceeds the maximum value "
            r2.<init>(r3)     // Catch:{ all -> 0x0082 }
            int r3 = com.tencent.wxop.stat.c.v()     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ all -> 0x0082 }
            r2.append(r3)     // Catch:{ all -> 0x0082 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0082 }
            r1.error(r2)     // Catch:{ all -> 0x0082 }
            monitor-exit(r0)     // Catch:{ all -> 0x0082 }
            return
        L_0x0032:
            java.lang.String r1 = r5.f50984a     // Catch:{ all -> 0x0082 }
            java.lang.String unused = com.tencent.wxop.stat.e.aR = r1     // Catch:{ all -> 0x0082 }
            java.util.Map r1 = com.tencent.wxop.stat.e.aT     // Catch:{ all -> 0x0082 }
            java.lang.String r2 = com.tencent.wxop.stat.e.aR     // Catch:{ all -> 0x0082 }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x0082 }
            if (r1 == 0) goto L_0x0065
            com.tencent.wxop.stat.b.b r1 = com.tencent.wxop.stat.e.aV     // Catch:{ all -> 0x0082 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = "Duplicate PageID : "
            r2.<init>(r3)     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = com.tencent.wxop.stat.e.aR     // Catch:{ all -> 0x0082 }
            r2.append(r3)     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = ", onResume() repeated?"
            r2.append(r3)     // Catch:{ all -> 0x0082 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0082 }
            r1.d(r2)     // Catch:{ all -> 0x0082 }
            monitor-exit(r0)     // Catch:{ all -> 0x0082 }
            return
        L_0x0065:
            java.util.Map r1 = com.tencent.wxop.stat.e.aT     // Catch:{ all -> 0x0082 }
            java.lang.String r2 = com.tencent.wxop.stat.e.aR     // Catch:{ all -> 0x0082 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0082 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0082 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0082 }
            monitor-exit(r0)     // Catch:{ all -> 0x0082 }
            android.content.Context r0 = r5.f50985co     // Catch:{ all -> 0x0085 }
            r1 = 1
            com.tencent.wxop.stat.f r2 = r5.bM     // Catch:{ all -> 0x0085 }
            com.tencent.wxop.stat.e.a((android.content.Context) r0, (boolean) r1, (com.tencent.wxop.stat.f) r2)     // Catch:{ all -> 0x0085 }
            return
        L_0x0082:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0085 }
            throw r1     // Catch:{ all -> 0x0085 }
        L_0x0085:
            r0 = move-exception
            com.tencent.wxop.stat.b.b r1 = com.tencent.wxop.stat.e.aV
            r1.b((java.lang.Throwable) r0)
            android.content.Context r1 = r5.f50985co
            com.tencent.wxop.stat.e.a((android.content.Context) r1, (java.lang.Throwable) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.as.run():void");
    }
}
