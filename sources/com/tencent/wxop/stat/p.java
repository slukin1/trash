package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.d;

final class p {
    private static volatile long bU;
    /* access modifiers changed from: private */
    public d bP;
    private d bQ = null;
    /* access modifiers changed from: private */
    public boolean bR = false;
    /* access modifiers changed from: private */
    public Context bS = null;
    private long bT = System.currentTimeMillis();

    public p(d dVar) {
        this.bP = dVar;
        this.bQ = c.j();
        this.bR = dVar.X();
        this.bS = dVar.J();
    }

    private void H() {
        if (t.ai().aI <= 0 || !c.f51054ax) {
            a((aj) new s(this));
            return;
        }
        t.ai().b(this.bP, (aj) null, this.bR, true);
        t.ai().b(-1);
    }

    private void a(aj ajVar) {
        ak.Z(e.aY).a(this.bP, ajVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ah() {
        /*
            r9 = this;
            int r0 = com.tencent.wxop.stat.c.f51035ae
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x00bf
            long r3 = r9.bT
            long r5 = com.tencent.wxop.stat.e.aO
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x003e
            java.util.Map r0 = com.tencent.wxop.stat.e.aN
            r0.clear()
            long r3 = r9.bT
            long r5 = com.tencent.wxop.stat.c.f51036af
            long r3 = r3 + r5
            long unused = com.tencent.wxop.stat.e.aO = r3
            boolean r0 = com.tencent.wxop.stat.c.k()
            if (r0 == 0) goto L_0x003e
            com.tencent.wxop.stat.b.b r0 = com.tencent.wxop.stat.e.aV
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "clear methodsCalledLimitMap, nextLimitCallClearTime="
            r3.<init>(r4)
            long r4 = com.tencent.wxop.stat.e.aO
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.b((java.lang.Object) r3)
        L_0x003e:
            com.tencent.wxop.stat.a.d r0 = r9.bP
            com.tencent.wxop.stat.a.e r0 = r0.ac()
            int r0 = r0.r()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.util.Map r3 = com.tencent.wxop.stat.e.aN
            java.lang.Object r3 = r3.get(r0)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x00b4
            java.util.Map r4 = com.tencent.wxop.stat.e.aN
            int r5 = r3.intValue()
            int r5 = r5 + r1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.put(r0, r5)
            int r0 = r3.intValue()
            int r4 = com.tencent.wxop.stat.c.f51035ae
            if (r0 <= r4) goto L_0x00bf
            boolean r0 = com.tencent.wxop.stat.c.k()
            if (r0 == 0) goto L_0x00b2
            com.tencent.wxop.stat.b.b r0 = com.tencent.wxop.stat.e.aV
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "event "
            r4.<init>(r5)
            com.tencent.wxop.stat.a.d r5 = r9.bP
            java.lang.String r5 = r5.af()
            r4.append(r5)
            java.lang.String r5 = " was discard, cause of called limit, current:"
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = ", limit:"
            r4.append(r3)
            int r3 = com.tencent.wxop.stat.c.f51035ae
            r4.append(r3)
            java.lang.String r3 = ", period:"
            r4.append(r3)
            long r5 = com.tencent.wxop.stat.c.f51036af
            r4.append(r5)
            java.lang.String r3 = " ms"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r0.d(r3)
        L_0x00b2:
            r0 = r1
            goto L_0x00c0
        L_0x00b4:
            java.util.Map r3 = com.tencent.wxop.stat.e.aN
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            r3.put(r0, r4)
        L_0x00bf:
            r0 = r2
        L_0x00c0:
            if (r0 == 0) goto L_0x00c3
            return
        L_0x00c3:
            int r0 = com.tencent.wxop.stat.c.f51055ay
            if (r0 <= 0) goto L_0x00f8
            long r3 = r9.bT
            long r5 = bU
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00f8
            android.content.Context r0 = r9.bS
            com.tencent.wxop.stat.e.p((android.content.Context) r0)
            long r3 = r9.bT
            long r5 = com.tencent.wxop.stat.c.f51056az
            long r3 = r3 + r5
            bU = r3
            boolean r0 = com.tencent.wxop.stat.c.k()
            if (r0 == 0) goto L_0x00f8
            com.tencent.wxop.stat.b.b r0 = com.tencent.wxop.stat.e.aV
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "nextFlushTime="
            r3.<init>(r4)
            long r4 = bU
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.b((java.lang.Object) r3)
        L_0x00f8:
            android.content.Context r0 = r9.bS
            com.tencent.wxop.stat.g r0 = com.tencent.wxop.stat.g.r(r0)
            boolean r0 = r0.X()
            r3 = 0
            if (r0 == 0) goto L_0x02cd
            boolean r0 = com.tencent.wxop.stat.c.k()
            if (r0 == 0) goto L_0x0122
            com.tencent.wxop.stat.b.b r0 = com.tencent.wxop.stat.e.aV
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "sendFailedCount="
            r4.<init>(r5)
            int r5 = com.tencent.wxop.stat.e.aI
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.b((java.lang.Object) r4)
        L_0x0122:
            boolean r0 = com.tencent.wxop.stat.e.a()
            if (r0 != 0) goto L_0x02ae
            com.tencent.wxop.stat.a.d r0 = r9.bP
            com.tencent.wxop.stat.f r0 = r0.ae()
            if (r0 == 0) goto L_0x0140
            com.tencent.wxop.stat.a.d r0 = r9.bP
            com.tencent.wxop.stat.f r0 = r0.ae()
            boolean r0 = r0.R()
            if (r0 == 0) goto L_0x0140
            com.tencent.wxop.stat.d r0 = com.tencent.wxop.stat.d.INSTANT
            r9.bQ = r0
        L_0x0140:
            boolean r0 = com.tencent.wxop.stat.c.f51038ah
            if (r0 == 0) goto L_0x0156
            android.content.Context r0 = com.tencent.wxop.stat.e.aY
            com.tencent.wxop.stat.g r0 = com.tencent.wxop.stat.g.r(r0)
            boolean r0 = r0.W()
            if (r0 == 0) goto L_0x0156
            com.tencent.wxop.stat.d r0 = com.tencent.wxop.stat.d.INSTANT
            r9.bQ = r0
        L_0x0156:
            boolean r0 = com.tencent.wxop.stat.c.k()
            if (r0 == 0) goto L_0x0177
            com.tencent.wxop.stat.b.b r0 = com.tencent.wxop.stat.e.aV
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "strategy="
            r4.<init>(r5)
            com.tencent.wxop.stat.d r5 = r9.bQ
            java.lang.String r5 = r5.name()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.b((java.lang.Object) r4)
        L_0x0177:
            int[] r0 = com.tencent.wxop.stat.j.bL
            com.tencent.wxop.stat.d r4 = r9.bQ
            int r4 = r4.ordinal()
            r0 = r0[r4]
            switch(r0) {
                case 1: goto L_0x02aa;
                case 2: goto L_0x01f1;
                case 3: goto L_0x01e3;
                case 4: goto L_0x01e3;
                case 5: goto L_0x01d0;
                case 6: goto L_0x01b0;
                case 7: goto L_0x019f;
                default: goto L_0x0184;
            }
        L_0x0184:
            com.tencent.wxop.stat.b.b r0 = com.tencent.wxop.stat.e.aV
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid stat strategy:"
            r1.<init>(r2)
            com.tencent.wxop.stat.d r2 = com.tencent.wxop.stat.c.j()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.error(r1)
            goto L_0x02ad
        L_0x019f:
            android.content.Context r0 = r9.bS
            boolean r0 = com.tencent.wxop.stat.b.l.y(r0)
            if (r0 == 0) goto L_0x02ad
            com.tencent.wxop.stat.r r0 = new com.tencent.wxop.stat.r
            r0.<init>(r9)
            r9.a((com.tencent.wxop.stat.aj) r0)
            return
        L_0x01b0:
            android.content.Context r0 = com.tencent.wxop.stat.e.aY
            com.tencent.wxop.stat.g r0 = com.tencent.wxop.stat.g.r(r0)
            int r0 = r0.D()
            if (r0 != r1) goto L_0x01c2
            r9.H()
            return
        L_0x01c2:
            android.content.Context r0 = r9.bS
            com.tencent.wxop.stat.t r0 = com.tencent.wxop.stat.t.s(r0)
            com.tencent.wxop.stat.a.d r1 = r9.bP
            boolean r4 = r9.bR
            r0.b(r1, r3, r4, r2)
            return
        L_0x01d0:
            android.content.Context r0 = r9.bS
            com.tencent.wxop.stat.t r0 = com.tencent.wxop.stat.t.s(r0)
            com.tencent.wxop.stat.a.d r2 = r9.bP
            com.tencent.wxop.stat.q r3 = new com.tencent.wxop.stat.q
            r3.<init>(r9)
            boolean r4 = r9.bR
            r0.b(r2, r3, r4, r1)
            return
        L_0x01e3:
            android.content.Context r0 = r9.bS
            com.tencent.wxop.stat.t r0 = com.tencent.wxop.stat.t.s(r0)
            com.tencent.wxop.stat.a.d r1 = r9.bP
            boolean r4 = r9.bR
            r0.b(r1, r3, r4, r2)
            return
        L_0x01f1:
            android.content.Context r0 = r9.bS
            com.tencent.wxop.stat.t r0 = com.tencent.wxop.stat.t.s(r0)
            com.tencent.wxop.stat.a.d r1 = r9.bP
            boolean r4 = r9.bR
            r0.b(r1, r3, r4, r2)
            boolean r0 = com.tencent.wxop.stat.c.k()
            java.lang.String r1 = ",difftime="
            java.lang.String r2 = ",nextPeriodSendTs="
            java.lang.String r3 = "PERIOD currTime="
            if (r0 == 0) goto L_0x0232
            com.tencent.wxop.stat.b.b r0 = com.tencent.wxop.stat.e.aV
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            long r5 = r9.bT
            r4.append(r5)
            r4.append(r2)
            long r5 = com.tencent.wxop.stat.e.aZ
            r4.append(r5)
            r4.append(r1)
            long r5 = com.tencent.wxop.stat.e.aZ
            long r7 = r9.bT
            long r5 = r5 - r7
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.b((java.lang.Object) r4)
        L_0x0232:
            long r4 = com.tencent.wxop.stat.e.aZ
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x026e
            android.content.Context r0 = r9.bS
            java.lang.String r4 = "last_period_ts"
            long r4 = com.tencent.wxop.stat.b.q.f(r0, r4)
            com.tencent.wxop.stat.e.aZ = r4
            long r4 = r9.bT
            long r6 = com.tencent.wxop.stat.e.aZ
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0251
            android.content.Context r0 = r9.bS
            com.tencent.wxop.stat.e.q((android.content.Context) r0)
        L_0x0251:
            long r4 = r9.bT
            int r0 = com.tencent.wxop.stat.c.u()
            int r0 = r0 * 60
            int r0 = r0 * 1000
            long r6 = (long) r0
            long r4 = r4 + r6
            long r6 = com.tencent.wxop.stat.e.aZ
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0265
            com.tencent.wxop.stat.e.aZ = r4
        L_0x0265:
            android.content.Context r0 = r9.bS
            com.tencent.wxop.stat.af r0 = com.tencent.wxop.stat.af.Y(r0)
            r0.ah()
        L_0x026e:
            boolean r0 = com.tencent.wxop.stat.c.k()
            if (r0 == 0) goto L_0x029c
            com.tencent.wxop.stat.b.b r0 = com.tencent.wxop.stat.e.aV
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            long r5 = r9.bT
            r4.append(r5)
            r4.append(r2)
            long r2 = com.tencent.wxop.stat.e.aZ
            r4.append(r2)
            r4.append(r1)
            long r1 = com.tencent.wxop.stat.e.aZ
            long r5 = r9.bT
            long r1 = r1 - r5
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r0.b((java.lang.Object) r1)
        L_0x029c:
            long r0 = r9.bT
            long r2 = com.tencent.wxop.stat.e.aZ
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x02ad
            android.content.Context r0 = r9.bS
            com.tencent.wxop.stat.e.q((android.content.Context) r0)
            return
        L_0x02aa:
            r9.H()
        L_0x02ad:
            return
        L_0x02ae:
            android.content.Context r0 = r9.bS
            com.tencent.wxop.stat.t r0 = com.tencent.wxop.stat.t.s(r0)
            com.tencent.wxop.stat.a.d r1 = r9.bP
            boolean r4 = r9.bR
            r0.b(r1, r3, r4, r2)
            long r0 = r9.bT
            long r2 = com.tencent.wxop.stat.e.aX
            long r0 = r0 - r2
            r2 = 1800000(0x1b7740, double:8.89318E-318)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x02cc
            android.content.Context r0 = r9.bS
            com.tencent.wxop.stat.e.n(r0)
        L_0x02cc:
            return
        L_0x02cd:
            android.content.Context r0 = r9.bS
            com.tencent.wxop.stat.t r0 = com.tencent.wxop.stat.t.s(r0)
            com.tencent.wxop.stat.a.d r1 = r9.bP
            boolean r4 = r9.bR
            r0.b(r1, r3, r4, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.p.ah():void");
    }
}
