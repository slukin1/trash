package com.tencent.wxop.stat.b;

import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.jmrtd.lds.CVCAFile;

final class k extends i {

    /* renamed from: ad  reason: collision with root package name */
    public static final /* synthetic */ boolean f51015ad = true;
    private static final byte[] cM = {65, CVCAFile.CAR_TAG, 67, ISO7816.INS_REHABILITATE_CHV, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, ISOFileInfo.FCP_BYTE, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, ISOFileInfo.FCI_BYTE, ISO7816.INS_MANAGE_CHANNEL, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] cN = {65, CVCAFile.CAR_TAG, 67, ISO7816.INS_REHABILITATE_CHV, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, ISOFileInfo.FCP_BYTE, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, ISOFileInfo.FCI_BYTE, ISO7816.INS_MANAGE_CHANNEL, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, Framer.STDIN_FRAME_PREFIX, 95};

    /* renamed from: ba  reason: collision with root package name */
    public final boolean f51016ba = true;

    /* renamed from: bb  reason: collision with root package name */
    public final boolean f51017bb = true;
    private final byte[] cO = new byte[2];
    public final boolean cP = false;
    private final byte[] cQ = cM;

    /* renamed from: cc  reason: collision with root package name */
    private int f51018cc = 19;

    /* renamed from: cp  reason: collision with root package name */
    public int f51019cp = 0;

    public k() {
        this.cI = null;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00de A[SYNTHETIC] */
    public final boolean a(byte[] r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            byte[] r1 = r0.cQ
            byte[] r2 = r0.cI
            int r3 = r0.f51018cc
            r4 = 0
            int r5 = r20 + 0
            int r6 = r0.f51019cp
            r7 = -1
            r8 = 2
            r9 = 1
            if (r6 == r9) goto L_0x002f
            if (r6 == r8) goto L_0x0015
            goto L_0x0049
        L_0x0015:
            if (r5 <= 0) goto L_0x0049
            byte[] r6 = r0.cO
            byte r10 = r6[r4]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 16
            byte r6 = r6[r9]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 8
            r6 = r6 | r10
            byte r10 = r19[r4]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r6 = r6 | r10
            r0.f51019cp = r4
            r10 = r9
            goto L_0x004b
        L_0x002f:
            if (r8 > r5) goto L_0x0049
            byte[] r6 = r0.cO
            byte r6 = r6[r4]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 16
            byte r10 = r19[r4]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 8
            r6 = r6 | r10
            byte r10 = r19[r9]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r6 = r6 | r10
            r0.f51019cp = r4
            r10 = r8
            goto L_0x004b
        L_0x0049:
            r10 = r4
            r6 = r7
        L_0x004b:
            r12 = 4
            r13 = 13
            r14 = 10
            if (r6 == r7) goto L_0x0087
            int r7 = r6 >> 18
            r7 = r7 & 63
            byte r7 = r1[r7]
            r2[r4] = r7
            int r7 = r6 >> 12
            r7 = r7 & 63
            byte r7 = r1[r7]
            r2[r9] = r7
            int r7 = r6 >> 6
            r7 = r7 & 63
            byte r7 = r1[r7]
            r2[r8] = r7
            r6 = r6 & 63
            byte r6 = r1[r6]
            r7 = 3
            r2[r7] = r6
            int r3 = r3 + -1
            if (r3 != 0) goto L_0x0085
            boolean r3 = r0.cP
            if (r3 == 0) goto L_0x007d
            r3 = 5
            r2[r12] = r13
            goto L_0x007e
        L_0x007d:
            r3 = r12
        L_0x007e:
            int r6 = r3 + 1
            r2[r3] = r14
        L_0x0082:
            r3 = 19
            goto L_0x0088
        L_0x0085:
            r6 = r12
            goto L_0x0088
        L_0x0087:
            r6 = r4
        L_0x0088:
            int r7 = r10 + 3
            if (r7 > r5) goto L_0x00de
            byte r15 = r19[r10]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << 16
            int r16 = r10 + 1
            byte r11 = r19[r16]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r11 = r11 | r15
            int r10 = r10 + 2
            byte r10 = r19[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r10 | r11
            int r11 = r10 >> 18
            r11 = r11 & 63
            byte r11 = r1[r11]
            r2[r6] = r11
            int r11 = r6 + 1
            int r15 = r10 >> 12
            r15 = r15 & 63
            byte r15 = r1[r15]
            r2[r11] = r15
            int r11 = r6 + 2
            int r15 = r10 >> 6
            r15 = r15 & 63
            byte r15 = r1[r15]
            r2[r11] = r15
            int r11 = r6 + 3
            r10 = r10 & 63
            byte r10 = r1[r10]
            r2[r11] = r10
            int r6 = r6 + 4
            int r3 = r3 + -1
            if (r3 != 0) goto L_0x00dc
            boolean r3 = r0.cP
            if (r3 == 0) goto L_0x00d5
            int r3 = r6 + 1
            r2[r6] = r13
            r6 = r3
        L_0x00d5:
            int r3 = r6 + 1
            r2[r6] = r14
            r6 = r3
            r10 = r7
            goto L_0x0082
        L_0x00dc:
            r10 = r7
            goto L_0x0088
        L_0x00de:
            int r7 = r0.f51019cp
            int r11 = r10 - r7
            int r15 = r5 + -1
            r16 = 61
            if (r11 != r15) goto L_0x0131
            if (r7 <= 0) goto L_0x00f0
            byte[] r8 = r0.cO
            byte r4 = r8[r4]
            r8 = r9
            goto L_0x00fa
        L_0x00f0:
            int r8 = r10 + 1
            byte r10 = r19[r10]
            r17 = r8
            r8 = r4
            r4 = r10
            r10 = r17
        L_0x00fa:
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r12
            int r7 = r7 - r8
            r0.f51019cp = r7
            int r7 = r6 + 1
            int r8 = r4 >> 6
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r6] = r8
            int r6 = r7 + 1
            r4 = r4 & 63
            byte r1 = r1[r4]
            r2[r7] = r1
            boolean r1 = r0.f51016ba
            if (r1 == 0) goto L_0x011e
            int r1 = r6 + 1
            r2[r6] = r16
            int r6 = r1 + 1
            r2[r1] = r16
        L_0x011e:
            boolean r1 = r0.f51017bb
            if (r1 == 0) goto L_0x01b7
            boolean r1 = r0.cP
            if (r1 == 0) goto L_0x012b
            int r1 = r6 + 1
            r2[r6] = r13
            r6 = r1
        L_0x012b:
            int r1 = r6 + 1
            r2[r6] = r14
            goto L_0x01b6
        L_0x0131:
            int r11 = r10 - r7
            int r12 = r5 + -2
            if (r11 != r12) goto L_0x019f
            if (r7 <= r9) goto L_0x0140
            byte[] r11 = r0.cO
            byte r4 = r11[r4]
            r11 = r10
            r10 = r9
            goto L_0x0149
        L_0x0140:
            int r11 = r10 + 1
            byte r10 = r19[r10]
            r17 = r10
            r10 = r4
            r4 = r17
        L_0x0149:
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r14
            if (r7 <= 0) goto L_0x0155
            byte[] r12 = r0.cO
            int r15 = r10 + 1
            byte r10 = r12[r10]
            goto L_0x015c
        L_0x0155:
            int r12 = r11 + 1
            byte r11 = r19[r11]
            r15 = r10
            r10 = r11
            r11 = r12
        L_0x015c:
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r8 = r10 << 2
            r4 = r4 | r8
            int r7 = r7 - r15
            r0.f51019cp = r7
            int r7 = r6 + 1
            int r8 = r4 >> 12
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r6] = r8
            int r6 = r7 + 1
            int r8 = r4 >> 6
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r7] = r8
            int r7 = r6 + 1
            r4 = r4 & 63
            byte r1 = r1[r4]
            r2[r6] = r1
            boolean r1 = r0.f51016ba
            if (r1 == 0) goto L_0x0189
            int r1 = r7 + 1
            r2[r7] = r16
            r7 = r1
        L_0x0189:
            boolean r1 = r0.f51017bb
            if (r1 == 0) goto L_0x019c
            boolean r1 = r0.cP
            if (r1 == 0) goto L_0x0196
            int r1 = r7 + 1
            r2[r7] = r13
            r7 = r1
        L_0x0196:
            int r1 = r7 + 1
            r2[r7] = r14
            r6 = r1
            goto L_0x019d
        L_0x019c:
            r6 = r7
        L_0x019d:
            r10 = r11
            goto L_0x01b7
        L_0x019f:
            boolean r1 = r0.f51017bb
            if (r1 == 0) goto L_0x01b7
            if (r6 <= 0) goto L_0x01b7
            r1 = 19
            if (r3 == r1) goto L_0x01b7
            boolean r1 = r0.cP
            if (r1 == 0) goto L_0x01b2
            int r1 = r6 + 1
            r2[r6] = r13
            r6 = r1
        L_0x01b2:
            int r1 = r6 + 1
            r2[r6] = r14
        L_0x01b6:
            r6 = r1
        L_0x01b7:
            boolean r1 = f51015ad
            if (r1 != 0) goto L_0x01c6
            int r2 = r0.f51019cp
            if (r2 != 0) goto L_0x01c0
            goto L_0x01c6
        L_0x01c0:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x01c6:
            if (r1 != 0) goto L_0x01d1
            if (r10 != r5) goto L_0x01cb
            goto L_0x01d1
        L_0x01cb:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x01d1:
            r0.f51012g = r6
            r0.f51018cc = r3
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.b.k.a(byte[], int):boolean");
    }
}
