package com.tencent.wxop.stat.b;

final class j extends i {
    private static final int[] cJ = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final int[] cK = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: bf  reason: collision with root package name */
    private int f51013bf = 0;
    private final int[] cL = cJ;

    /* renamed from: cu  reason: collision with root package name */
    private int f51014cu = 0;

    public j(byte[] bArr) {
        this.cI = bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b8, code lost:
        r0.f51014cu = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f5, code lost:
        if (r1 == 1) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f7, code lost:
        if (r1 == 2) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f9, code lost:
        if (r1 == 3) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fb, code lost:
        if (r1 == 4) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00fe, code lost:
        r2 = r11 + 1;
        r6[r11] = (byte) (r5 >> 10);
        r11 = r2 + 1;
        r6[r2] = (byte) (r5 >> 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010d, code lost:
        r6[r11] = (byte) (r5 >> 4);
        r11 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0115, code lost:
        r0.f51014cu = r1;
        r0.f51012g = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0119, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(byte[] r18, int r19) {
        /*
            r17 = this;
            r0 = r17
            int r1 = r0.f51014cu
            r2 = 0
            r3 = 6
            if (r1 != r3) goto L_0x0009
            return r2
        L_0x0009:
            int r4 = r19 + 0
            int r5 = r0.f51013bf
            byte[] r6 = r0.cI
            int[] r7 = r0.cL
            r8 = 5
            r9 = 4
            r10 = r2
            r11 = r10
        L_0x0015:
            r12 = 3
            r13 = 2
            r14 = 1
            if (r10 >= r4) goto L_0x00f5
            if (r1 != 0) goto L_0x0060
        L_0x001c:
            int r15 = r10 + 4
            if (r15 > r4) goto L_0x005e
            byte r5 = r18[r10]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r7[r5]
            int r5 = r5 << 18
            int r16 = r10 + 1
            byte r2 = r18[r16]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r2 = r7[r2]
            int r2 = r2 << 12
            r2 = r2 | r5
            int r5 = r10 + 2
            byte r5 = r18[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r7[r5]
            int r5 = r5 << r3
            r2 = r2 | r5
            int r5 = r10 + 3
            byte r5 = r18[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r7[r5]
            r5 = r5 | r2
            if (r5 < 0) goto L_0x005e
            int r2 = r11 + 2
            byte r10 = (byte) r5
            r6[r2] = r10
            int r2 = r11 + 1
            int r10 = r5 >> 8
            byte r10 = (byte) r10
            r6[r2] = r10
            int r2 = r5 >> 16
            byte r2 = (byte) r2
            r6[r11] = r2
            int r11 = r11 + 3
            r10 = r15
            r2 = 0
            goto L_0x001c
        L_0x005e:
            if (r10 >= r4) goto L_0x00f5
        L_0x0060:
            int r2 = r10 + 1
            byte r10 = r18[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r7[r10]
            r15 = -1
            if (r1 == 0) goto L_0x00e2
            if (r1 == r14) goto L_0x00d4
            r14 = -2
            if (r1 == r13) goto L_0x00bc
            if (r1 == r12) goto L_0x0087
            if (r1 == r9) goto L_0x007e
            if (r1 == r8) goto L_0x0078
            goto L_0x00f1
        L_0x0078:
            if (r10 == r15) goto L_0x00f1
        L_0x007a:
            r0.f51014cu = r3
            r12 = 0
            return r12
        L_0x007e:
            r12 = 0
            if (r10 != r14) goto L_0x0082
            goto L_0x00da
        L_0x0082:
            if (r10 == r15) goto L_0x00f1
            r0.f51014cu = r3
            return r12
        L_0x0087:
            if (r10 < 0) goto L_0x00a3
            int r1 = r5 << 6
            r5 = r1 | r10
            int r1 = r11 + 2
            byte r10 = (byte) r5
            r6[r1] = r10
            int r1 = r11 + 1
            int r10 = r5 >> 8
            byte r10 = (byte) r10
            r6[r1] = r10
            int r1 = r5 >> 16
            byte r1 = (byte) r1
            r6[r11] = r1
            int r11 = r11 + 3
            r10 = r2
            r1 = 0
            goto L_0x00f2
        L_0x00a3:
            if (r10 != r14) goto L_0x00b6
            int r1 = r11 + 1
            int r10 = r5 >> 2
            byte r10 = (byte) r10
            r6[r1] = r10
            int r1 = r5 >> 10
            byte r1 = (byte) r1
            r6[r11] = r1
            int r11 = r11 + 2
            r10 = r2
            r1 = r8
            goto L_0x00f2
        L_0x00b6:
            if (r10 == r15) goto L_0x00f1
        L_0x00b8:
            r0.f51014cu = r3
            r1 = 0
            return r1
        L_0x00bc:
            if (r10 < 0) goto L_0x00c4
            int r5 = r5 << 6
            r5 = r5 | r10
            int r1 = r1 + 1
            goto L_0x00f1
        L_0x00c4:
            if (r10 != r14) goto L_0x00d1
            int r1 = r11 + 1
            int r10 = r5 >> 4
            byte r10 = (byte) r10
            r6[r11] = r10
            r11 = r1
            r10 = r2
            r1 = r9
            goto L_0x00f2
        L_0x00d1:
            if (r10 == r15) goto L_0x00f1
            goto L_0x007a
        L_0x00d4:
            r12 = 0
            if (r10 < 0) goto L_0x00dd
            int r5 = r5 << 6
            r5 = r5 | r10
        L_0x00da:
            int r1 = r1 + 1
            goto L_0x00e8
        L_0x00dd:
            if (r10 == r15) goto L_0x00f1
            r0.f51014cu = r3
            return r12
        L_0x00e2:
            r12 = 0
            if (r10 < 0) goto L_0x00ec
            int r1 = r1 + 1
            r5 = r10
        L_0x00e8:
            r10 = r2
            r2 = r12
            goto L_0x0015
        L_0x00ec:
            if (r10 == r15) goto L_0x00f1
            r0.f51014cu = r3
            return r12
        L_0x00f1:
            r10 = r2
        L_0x00f2:
            r2 = 0
            goto L_0x0015
        L_0x00f5:
            if (r1 == r14) goto L_0x00b8
            if (r1 == r13) goto L_0x010d
            if (r1 == r12) goto L_0x00fe
            if (r1 == r9) goto L_0x00b8
            goto L_0x0115
        L_0x00fe:
            int r2 = r11 + 1
            int r3 = r5 >> 10
            byte r3 = (byte) r3
            r6[r11] = r3
            int r11 = r2 + 1
            int r3 = r5 >> 2
            byte r3 = (byte) r3
            r6[r2] = r3
            goto L_0x0115
        L_0x010d:
            int r2 = r11 + 1
            int r3 = r5 >> 4
            byte r3 = (byte) r3
            r6[r11] = r3
            r11 = r2
        L_0x0115:
            r0.f51014cu = r1
            r0.f51012g = r11
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.b.j.a(byte[], int):boolean");
    }
}
