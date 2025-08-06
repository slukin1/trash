package com.mob.commons.a;

import android.os.Build;
import com.mob.MobSDK;
import com.mob.commons.C0891r;
import com.mob.tools.utils.DH;

public class b extends c {
    public b() {
        super(C0891r.b("0022eeeh"), 0, C0891r.b("005=eeehdi2ci"), 86400, c.a(C0891r.b("0022eeeh"), (Long) 0L));
    }

    private void m() {
        DH.RequestBuilder requestBuilder;
        DH.RequestBuilder mnbclfo = DH.requester(MobSDK.getContext()).getCarrier().getCarrierName().getMnbclfo();
        final int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 17) {
            requestBuilder = mnbclfo.getACIfo();
        } else {
            requestBuilder = mnbclfo.getCLoc();
        }
        requestBuilder.request(new DH.DHResponder() {
            /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x022e: MOVE  (r4v9 int) = (r18v0 int)
                	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
                	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
                	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
                	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
                	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
                	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
                */
            public void onResponse(com.mob.tools.utils.DH.DHResponse r21) {
                /*
                    r20 = this;
                    r0 = r20
                    r1 = -1
                    java.lang.String r2 = r21.getCarrier()     // Catch:{ all -> 0x000c }
                    int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x000c }
                    goto L_0x000d
                L_0x000c:
                    r2 = r1
                L_0x000d:
                    int r3 = r1
                    r4 = 17
                    java.lang.String r5 = "003%eechcb"
                    r6 = 0
                    r7 = 1
                    java.lang.String r8 = "003fch"
                    java.lang.String r9 = "003fcb"
                    java.lang.String r10 = "004beff"
                    if (r3 < r4) goto L_0x00f8
                    java.util.ArrayList r3 = r21.getACIfo()
                    if (r3 == 0) goto L_0x00f8
                    java.util.ArrayList r3 = r21.getACIfo()
                    boolean r3 = r3.isEmpty()
                    if (r3 != 0) goto L_0x00f8
                    java.util.ArrayList r3 = r21.getACIfo()
                    java.util.HashMap r6 = new java.util.HashMap
                    r6.<init>()
                    java.lang.String r4 = "bsd"
                    r6.put(r4, r3)
                    r4 = 0
                    java.lang.Object r3 = r3.get(r4)
                    java.util.HashMap r3 = (java.util.HashMap) r3
                    java.util.HashMap r4 = new java.util.HashMap
                    r4.<init>()
                    java.lang.String r11 = "004hBdb;ie"
                    java.lang.String r11 = com.mob.commons.C0891r.b(r11)
                    java.lang.Object r11 = r3.get(r11)
                    java.lang.Integer r11 = (java.lang.Integer) r11
                    int r11 = r11.intValue()
                    r12 = 2
                    if (r11 != r12) goto L_0x00b9
                    java.lang.String r11 = "0167dccbce]cYdcReff+edcj7bchAchcj'd"
                    java.lang.String r11 = com.mob.commons.C0891r.b(r11)
                    java.lang.Integer r12 = java.lang.Integer.valueOf(r7)
                    r4.put(r11, r12)
                    java.lang.String r11 = com.mob.commons.C0891r.b(r5)
                    java.lang.String r12 = com.mob.commons.C0891r.b(r10)
                    java.lang.Object r12 = r3.get(r12)
                    r4.put(r11, r12)
                    java.lang.String r11 = "003 ehchcb"
                    java.lang.String r12 = com.mob.commons.C0891r.b(r11)
                    java.lang.String r11 = com.mob.commons.C0891r.b(r11)
                    java.lang.Object r11 = r3.get(r11)
                    r4.put(r12, r11)
                    java.lang.String r11 = "003dTchcb"
                    java.lang.String r12 = com.mob.commons.C0891r.b(r11)
                    java.lang.String r11 = com.mob.commons.C0891r.b(r11)
                    java.lang.Object r11 = r3.get(r11)
                    r4.put(r12, r11)
                    java.lang.String r11 = com.mob.commons.C0891r.b(r8)
                    java.lang.String r12 = com.mob.commons.C0891r.b(r8)
                    java.lang.Object r12 = r3.get(r12)
                    r4.put(r11, r12)
                    java.lang.String r11 = "003f2cjBd"
                    java.lang.String r12 = com.mob.commons.C0891r.b(r11)
                    java.lang.String r11 = com.mob.commons.C0891r.b(r11)
                    java.lang.Object r3 = r3.get(r11)
                    r4.put(r12, r3)
                    goto L_0x00f5
                L_0x00b9:
                    java.lang.String r11 = "016NdccbceFc5dc0eff0edcjFbch<chcjUd"
                    java.lang.String r11 = com.mob.commons.C0891r.b(r11)
                    java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
                    r4.put(r11, r12)
                    java.lang.String r11 = "003i[ehHb"
                    java.lang.String r12 = com.mob.commons.C0891r.b(r11)
                    java.lang.String r11 = com.mob.commons.C0891r.b(r11)
                    java.lang.Object r11 = r3.get(r11)
                    r4.put(r12, r11)
                    java.lang.String r11 = com.mob.commons.C0891r.b(r9)
                    java.lang.String r12 = com.mob.commons.C0891r.b(r9)
                    java.lang.Object r12 = r3.get(r12)
                    r4.put(r11, r12)
                    java.lang.String r11 = com.mob.commons.C0891r.b(r10)
                    java.lang.String r12 = com.mob.commons.C0891r.b(r10)
                    java.lang.Object r3 = r3.get(r12)
                    r4.put(r11, r3)
                L_0x00f5:
                    r3 = r6
                    r6 = r4
                    goto L_0x010b
                L_0x00f8:
                    java.lang.Object r3 = r21.getCLoc()
                    if (r3 == 0) goto L_0x010a
                    java.lang.Object r3 = r21.getCLoc()
                    java.util.HashMap r3 = (java.util.HashMap) r3
                    r19 = r6
                    r6 = r3
                    r3 = r19
                    goto L_0x010b
                L_0x010a:
                    r3 = r6
                L_0x010b:
                    if (r6 == 0) goto L_0x02b7
                    java.lang.String r4 = "016%dccbceYc.dcOeff[edcj=bchQchcj<d"
                    java.lang.String r4 = com.mob.commons.C0891r.b(r4)
                    java.lang.Object r4 = r6.get(r4)
                    java.lang.Integer r11 = java.lang.Integer.valueOf(r1)
                    java.lang.Object r4 = com.mob.tools.utils.ResHelper.forceCast(r4, r11)
                    java.lang.Integer r4 = (java.lang.Integer) r4
                    int r4 = r4.intValue()
                    r11 = -1
                    if (r4 != r7) goto L_0x01aa
                    java.lang.String r4 = com.mob.commons.C0891r.b(r8)
                    java.lang.Object r4 = r6.get(r4)
                    java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
                    java.lang.Object r4 = com.mob.tools.utils.ResHelper.forceCast(r4, r13)
                    java.lang.Integer r4 = (java.lang.Integer) r4
                    int r4 = r4.intValue()
                    java.lang.String r13 = "003fNcj.d"
                    java.lang.String r13 = com.mob.commons.C0891r.b(r13)
                    java.lang.Object r13 = r6.get(r13)
                    java.lang.Integer r14 = java.lang.Integer.valueOf(r1)
                    java.lang.Object r13 = com.mob.tools.utils.ResHelper.forceCast(r13, r14)
                    java.lang.Integer r13 = (java.lang.Integer) r13
                    int r13 = r13.intValue()
                    java.lang.String r14 = "003*eechcb"
                    java.lang.String r14 = com.mob.commons.C0891r.b(r14)
                    java.lang.Object r14 = r6.get(r14)
                    java.lang.Integer r15 = java.lang.Integer.valueOf(r1)
                    java.lang.Object r14 = com.mob.tools.utils.ResHelper.forceCast(r14, r15)
                    java.lang.Integer r14 = (java.lang.Integer) r14
                    int r14 = r14.intValue()
                    java.lang.String r15 = "003.ehchcb"
                    java.lang.String r15 = com.mob.commons.C0891r.b(r15)
                    java.lang.Object r15 = r6.get(r15)
                    java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                    java.lang.Object r7 = com.mob.tools.utils.ResHelper.forceCast(r15, r7)
                    java.lang.Integer r7 = (java.lang.Integer) r7
                    int r7 = r7.intValue()
                    java.lang.String r15 = "003dBchcb"
                    java.lang.String r15 = com.mob.commons.C0891r.b(r15)
                    java.lang.Object r6 = r6.get(r15)
                    java.lang.Integer r15 = java.lang.Integer.valueOf(r1)
                    java.lang.Object r6 = com.mob.tools.utils.ResHelper.forceCast(r6, r15)
                    java.lang.Integer r6 = (java.lang.Integer) r6
                    int r6 = r6.intValue()
                    r16 = r11
                    r15 = r13
                    r18 = r14
                    r13 = r1
                    r14 = r7
                    r7 = r6
                    r6 = r4
                    r4 = r13
                    goto L_0x01f8
                L_0x01aa:
                    java.lang.String r4 = "003iJeh@b"
                    java.lang.String r4 = com.mob.commons.C0891r.b(r4)
                    java.lang.Object r4 = r6.get(r4)
                    java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                    java.lang.Object r4 = com.mob.tools.utils.ResHelper.forceCast(r4, r7)
                    java.lang.Integer r4 = (java.lang.Integer) r4
                    int r4 = r4.intValue()
                    java.lang.String r7 = com.mob.commons.C0891r.b(r9)
                    java.lang.Object r7 = r6.get(r7)
                    java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
                    java.lang.Object r7 = com.mob.tools.utils.ResHelper.forceCast(r7, r13)
                    java.lang.Integer r7 = (java.lang.Integer) r7
                    int r7 = r7.intValue()
                    java.lang.String r13 = com.mob.commons.C0891r.b(r10)
                    java.lang.Object r6 = r6.get(r13)
                    java.lang.Long r13 = java.lang.Long.valueOf(r11)
                    java.lang.Object r6 = com.mob.tools.utils.ResHelper.forceCast(r6, r13)
                    java.lang.Long r6 = (java.lang.Long) r6
                    long r13 = r6.longValue()
                    r6 = r1
                    r15 = r6
                    r18 = r15
                    r16 = r13
                    r14 = r18
                    r13 = r7
                    r7 = r14
                L_0x01f8:
                    if (r2 == r1) goto L_0x022c
                    if (r13 == r1) goto L_0x022c
                    int r11 = (r16 > r11 ? 1 : (r16 == r11 ? 0 : -1))
                    if (r11 == 0) goto L_0x022c
                    if (r3 != 0) goto L_0x0207
                    java.util.HashMap r3 = new java.util.HashMap
                    r3.<init>()
                L_0x0207:
                    java.lang.String r9 = com.mob.commons.C0891r.b(r9)
                    java.lang.Integer r11 = java.lang.Integer.valueOf(r13)
                    r3.put(r9, r11)
                    java.lang.String r9 = com.mob.commons.C0891r.b(r10)
                    java.lang.Long r10 = java.lang.Long.valueOf(r16)
                    r3.put(r9, r10)
                    if (r4 == r1) goto L_0x022c
                    java.lang.String r9 = "003i9eh.b"
                    java.lang.String r9 = com.mob.commons.C0891r.b(r9)
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                    r3.put(r9, r4)
                L_0x022c:
                    if (r2 == r1) goto L_0x027e
                    r4 = r18
                    if (r4 == r1) goto L_0x027e
                    if (r14 == r1) goto L_0x027e
                    if (r7 == r1) goto L_0x027e
                    if (r3 != 0) goto L_0x023d
                    java.util.HashMap r3 = new java.util.HashMap
                    r3.<init>()
                L_0x023d:
                    java.lang.String r5 = com.mob.commons.C0891r.b(r5)
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                    r3.put(r5, r4)
                    java.lang.String r4 = "003%ehchcb"
                    java.lang.String r4 = com.mob.commons.C0891r.b(r4)
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r14)
                    r3.put(r4, r5)
                    java.lang.String r4 = "003d5chcb"
                    java.lang.String r4 = com.mob.commons.C0891r.b(r4)
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
                    r3.put(r4, r5)
                    if (r6 == r1) goto L_0x026f
                    java.lang.String r4 = com.mob.commons.C0891r.b(r8)
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
                    r3.put(r4, r5)
                L_0x026f:
                    if (r15 == r1) goto L_0x027e
                    java.lang.String r1 = "003fNcjOd"
                    java.lang.String r1 = com.mob.commons.C0891r.b(r1)
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
                    r3.put(r1, r4)
                L_0x027e:
                    if (r3 == 0) goto L_0x02b7
                    java.lang.String r1 = "007bc:cicich2e<ci"
                    java.lang.String r1 = com.mob.commons.C0891r.b(r1)
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                    r3.put(r1, r2)
                    java.lang.String r1 = "0092ehchcecj]idcLcePe"
                    java.lang.String r1 = com.mob.commons.C0891r.b(r1)
                    java.lang.String r2 = r21.getCarrierName()
                    r3.put(r1, r2)
                    java.util.ArrayList r1 = r21.getMnbclfo()
                    if (r1 == 0) goto L_0x02af
                    int r2 = r1.size()
                    if (r2 <= 0) goto L_0x02af
                    java.lang.String r2 = "006decPcieedb"
                    java.lang.String r2 = com.mob.commons.C0891r.b(r2)
                    r3.put(r2, r1)
                L_0x02af:
                    com.mob.commons.a.b r1 = com.mob.commons.a.b.this
                    java.lang.String r2 = "BSIOMT"
                    r4 = 1
                    r1.a((java.lang.String) r2, (java.util.HashMap<java.lang.String, java.lang.Object>) r3, (boolean) r4)
                L_0x02b7:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.a.b.AnonymousClass1.onResponse(com.mob.tools.utils.DH$DHResponse):void");
            }
        });
    }

    public void a() {
        m();
    }
}
