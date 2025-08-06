package com.sumsub.sns.internal.fingerprint.tools.hashers;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final long f34667a = -8663945395140668459L;

    /* renamed from: b  reason: collision with root package name */
    public final long f34668b = 5545529020109919103L;

    public final long a(long j11) {
        long j12 = (j11 ^ (j11 >>> 33)) * -49064778989728563L;
        long j13 = (j12 ^ (j12 >>> 33)) * -4265267296055464877L;
        return j13 ^ (j13 >>> 33);
    }

    public String a(String str) {
        long[] a11 = a(this, str.getBytes(kotlin.text.b.f56912f), str.length(), 0, 4, (Object) null);
        StringBuilder sb2 = new StringBuilder();
        for (long hexString : a11) {
            sb2.append(Long.toHexString(hexString));
        }
        return sb2.toString();
    }

    public final long b(long j11) {
        return Long.rotateLeft(j11 * this.f34667a, 31) * this.f34668b;
    }

    public final long c(long j11) {
        return Long.rotateLeft(j11 * this.f34668b, 33) * this.f34667a;
    }

    public static /* synthetic */ long[] a(b bVar, byte[] bArr, int i11, long j11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            j11 = 0;
        }
        return bVar.a(bArr, i11, j11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x01bd, code lost:
        r8 = r8 ^ 0;
        r14 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x02ac, code lost:
        r8 = (((long) r1) & 255) ^ r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x02e0, code lost:
        r8 = r6 ^ (((long) r1) & 255);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x02ee, code lost:
        r8 = r6 ^ 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x02f0, code lost:
        r4 = r4 ^ b(r8);
        r2 = r2 ^ c(r14);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long[] a(byte[] r22, int r23, long r24) {
        /*
            r21 = this;
            r0 = r21
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.wrap(r22)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN
            r1.order(r2)
            r2 = r24
            r4 = r2
        L_0x000e:
            int r6 = r1.remaining()
            r7 = 5
            r8 = 16
            if (r6 < r8) goto L_0x0045
            long r8 = r1.getLong()
            long r10 = r1.getLong()
            long r8 = r0.b(r8)
            long r4 = r4 ^ r8
            r6 = 27
            long r4 = java.lang.Long.rotateLeft(r4, r6)
            long r4 = r4 + r2
            long r6 = (long) r7
            long r4 = r4 * r6
            r8 = 1390208809(0x52dce729, float:4.74385514E11)
            long r8 = (long) r8
            long r4 = r4 + r8
            long r8 = r0.c(r10)
            long r2 = r2 ^ r8
            r8 = 31
            long r2 = java.lang.Long.rotateLeft(r2, r8)
            long r2 = r2 + r4
            long r2 = r2 * r6
            r6 = 944331445(0x38495ab5, float:4.8006612E-5)
            long r6 = (long) r6
            long r2 = r2 + r6
            goto L_0x000e
        L_0x0045:
            r1.compact()
            r1.flip()
            int r6 = r1.remaining()
            if (r6 <= 0) goto L_0x02fa
            int r6 = r1.remaining()
            r12 = 13
            r13 = 48
            r14 = 0
            r11 = 12
            r9 = 11
            r16 = 40
            r10 = 10
            r17 = 32
            r18 = 24
            r19 = 255(0xff, double:1.26E-321)
            switch(r6) {
                case 1: goto L_0x02e6;
                case 2: goto L_0x02cf;
                case 3: goto L_0x02b1;
                case 4: goto L_0x0284;
                case 5: goto L_0x0250;
                case 6: goto L_0x0211;
                case 7: goto L_0x01c7;
                case 8: goto L_0x01c1;
                case 9: goto L_0x01af;
                case 10: goto L_0x0195;
                case 11: goto L_0x0170;
                case 12: goto L_0x0141;
                case 13: goto L_0x0107;
                case 14: goto L_0x00c3;
                case 15: goto L_0x0074;
                default: goto L_0x006c;
            }
        L_0x006c:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            java.lang.String r2 = "Code should not reach here!"
            r1.<init>(r2)
            throw r1
        L_0x0074:
            r6 = 14
            byte r6 = r1.get(r6)
            long r7 = (long) r6
            long r6 = r7 & r19
            long r6 = r6 << r13
            long r6 = r6 ^ r14
            byte r8 = r1.get(r12)
            long r12 = (long) r8
            long r12 = r12 & r19
            long r12 = r12 << r16
            long r6 = r6 ^ r12
            byte r8 = r1.get(r11)
            long r11 = (long) r8
            long r11 = r11 & r19
            long r11 = r11 << r17
            long r6 = r6 ^ r11
            byte r8 = r1.get(r9)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r8 = r8 << r18
            long r6 = r6 ^ r8
            byte r8 = r1.get(r10)
            long r8 = (long) r8
            long r8 = r8 & r19
            r10 = 16
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            r8 = 9
            byte r8 = r1.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r19
            r10 = 8
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            byte r8 = r1.get(r10)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r6 = r6 ^ r8
            long r8 = r1.getLong()
            goto L_0x01bd
        L_0x00c3:
            byte r6 = r1.get(r12)
            long r6 = (long) r6
            long r6 = r6 & r19
            long r6 = r6 << r16
            long r6 = r6 ^ r14
            byte r8 = r1.get(r11)
            long r11 = (long) r8
            long r11 = r11 & r19
            long r11 = r11 << r17
            long r6 = r6 ^ r11
            byte r8 = r1.get(r9)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r8 = r8 << r18
            long r6 = r6 ^ r8
            byte r8 = r1.get(r10)
            long r8 = (long) r8
            long r8 = r8 & r19
            r10 = 16
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            r8 = 9
            byte r8 = r1.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r19
            r10 = 8
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            byte r8 = r1.get(r10)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r6 = r6 ^ r8
            long r8 = r1.getLong()
            goto L_0x01bd
        L_0x0107:
            byte r6 = r1.get(r11)
            long r6 = (long) r6
            long r6 = r6 & r19
            long r6 = r6 << r17
            long r6 = r6 ^ r14
            byte r8 = r1.get(r9)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r8 = r8 << r18
            long r6 = r6 ^ r8
            byte r8 = r1.get(r10)
            long r8 = (long) r8
            long r8 = r8 & r19
            r10 = 16
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            r8 = 9
            byte r8 = r1.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r19
            r10 = 8
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            byte r8 = r1.get(r10)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r6 = r6 ^ r8
            long r8 = r1.getLong()
            goto L_0x01bd
        L_0x0141:
            byte r6 = r1.get(r9)
            long r6 = (long) r6
            long r6 = r6 & r19
            long r6 = r6 << r18
            long r6 = r6 ^ r14
            byte r8 = r1.get(r10)
            long r8 = (long) r8
            long r8 = r8 & r19
            r10 = 16
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            r8 = 9
            byte r8 = r1.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r19
            r10 = 8
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            byte r8 = r1.get(r10)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r6 = r6 ^ r8
            long r8 = r1.getLong()
            goto L_0x01bd
        L_0x0170:
            byte r6 = r1.get(r10)
            long r6 = (long) r6
            long r6 = r6 & r19
            r8 = 16
            long r6 = r6 << r8
            long r6 = r6 ^ r14
            r8 = 9
            byte r8 = r1.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r19
            r10 = 8
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            byte r8 = r1.get(r10)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r6 = r6 ^ r8
            long r8 = r1.getLong()
            goto L_0x01bd
        L_0x0195:
            r6 = 9
            r10 = 8
            byte r6 = r1.get(r6)
            long r6 = (long) r6
            long r6 = r6 & r19
            long r6 = r6 << r10
            long r6 = r6 ^ r14
            byte r8 = r1.get(r10)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r6 = r6 ^ r8
            long r8 = r1.getLong()
            goto L_0x01bd
        L_0x01af:
            r10 = 8
            byte r6 = r1.get(r10)
            long r6 = (long) r6
            long r6 = r6 & r19
            long r6 = r6 ^ r14
            long r8 = r1.getLong()
        L_0x01bd:
            long r8 = r8 ^ r14
            r14 = r6
            goto L_0x02f0
        L_0x01c1:
            long r6 = r1.getLong()
            goto L_0x02ee
        L_0x01c7:
            r6 = 6
            byte r6 = r1.get(r6)
            long r6 = (long) r6
            long r6 = r6 & r19
            long r6 = r6 << r13
            long r6 = r6 ^ r14
            r8 = 5
            byte r8 = r1.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r8 = r8 << r16
            long r6 = r6 ^ r8
            r8 = 4
            byte r8 = r1.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r8 = r8 << r17
            long r6 = r6 ^ r8
            r8 = 3
            byte r8 = r1.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r8 = r8 << r18
            long r6 = r6 ^ r8
            r8 = 2
            byte r9 = r1.get(r8)
            long r8 = (long) r9
            long r8 = r8 & r19
            r10 = 16
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            r8 = 1
            byte r9 = r1.get(r8)
            long r8 = (long) r9
            long r8 = r8 & r19
            r10 = 8
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            r8 = 0
            byte r1 = r1.get(r8)
            goto L_0x02ac
        L_0x0211:
            r6 = 5
            byte r6 = r1.get(r6)
            long r6 = (long) r6
            long r6 = r6 & r19
            long r6 = r6 << r16
            long r6 = r6 ^ r14
            r8 = 4
            byte r8 = r1.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r8 = r8 << r17
            long r6 = r6 ^ r8
            r8 = 3
            byte r8 = r1.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r8 = r8 << r18
            long r6 = r6 ^ r8
            r8 = 2
            byte r9 = r1.get(r8)
            long r8 = (long) r9
            long r8 = r8 & r19
            r10 = 16
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            r8 = 1
            byte r9 = r1.get(r8)
            long r8 = (long) r9
            long r8 = r8 & r19
            r10 = 8
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            r8 = 0
            byte r1 = r1.get(r8)
            goto L_0x02ac
        L_0x0250:
            r6 = 4
            byte r6 = r1.get(r6)
            long r6 = (long) r6
            long r6 = r6 & r19
            long r6 = r6 << r17
            long r6 = r6 ^ r14
            r8 = 3
            byte r8 = r1.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r19
            long r8 = r8 << r18
            long r6 = r6 ^ r8
            r8 = 2
            byte r9 = r1.get(r8)
            long r8 = (long) r9
            long r8 = r8 & r19
            r10 = 16
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            r8 = 1
            byte r9 = r1.get(r8)
            long r8 = (long) r9
            long r8 = r8 & r19
            r10 = 8
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            r8 = 0
            byte r1 = r1.get(r8)
            goto L_0x02ac
        L_0x0284:
            r6 = 3
            byte r6 = r1.get(r6)
            long r6 = (long) r6
            long r6 = r6 & r19
            long r6 = r6 << r18
            long r6 = r6 ^ r14
            r8 = 2
            byte r9 = r1.get(r8)
            long r8 = (long) r9
            long r8 = r8 & r19
            r10 = 16
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            r8 = 1
            byte r9 = r1.get(r8)
            long r8 = (long) r9
            long r8 = r8 & r19
            r10 = 8
            long r8 = r8 << r10
            long r6 = r6 ^ r8
            r8 = 0
            byte r1 = r1.get(r8)
        L_0x02ac:
            long r8 = (long) r1
            long r8 = r8 & r19
            long r8 = r8 ^ r6
            goto L_0x02f0
        L_0x02b1:
            r6 = 2
            byte r7 = r1.get(r6)
            long r6 = (long) r7
            long r6 = r6 & r19
            r8 = 16
            long r6 = r6 << r8
            long r6 = r6 ^ r14
            r8 = 1
            byte r9 = r1.get(r8)
            long r9 = (long) r9
            long r9 = r9 & r19
            r11 = 8
            long r9 = r9 << r11
            long r6 = r6 ^ r9
            r9 = 0
            byte r1 = r1.get(r9)
            goto L_0x02e0
        L_0x02cf:
            r8 = 1
            r9 = 0
            r11 = 8
            byte r6 = r1.get(r8)
            long r6 = (long) r6
            long r6 = r6 & r19
            long r6 = r6 << r11
            long r6 = r6 ^ r14
            byte r1 = r1.get(r9)
        L_0x02e0:
            long r10 = (long) r1
            long r10 = r10 & r19
            long r6 = r6 ^ r10
            r8 = r6
            goto L_0x02f0
        L_0x02e6:
            r9 = 0
            byte r1 = r1.get(r9)
            long r6 = (long) r1
            long r6 = r6 & r19
        L_0x02ee:
            long r8 = r6 ^ r14
        L_0x02f0:
            long r6 = r0.b(r8)
            long r4 = r4 ^ r6
            long r6 = r0.c(r14)
            long r2 = r2 ^ r6
        L_0x02fa:
            r1 = r23
            long r6 = (long) r1
            long r4 = r4 ^ r6
            long r1 = r2 ^ r6
            long r4 = r4 + r1
            long r1 = r1 + r4
            long r3 = r0.a((long) r4)
            long r1 = r0.a((long) r1)
            long r3 = r3 + r1
            long r1 = r1 + r3
            r5 = 2
            long[] r5 = new long[r5]
            r6 = 0
            r5[r6] = r3
            r3 = 1
            r5[r3] = r1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.fingerprint.tools.hashers.b.a(byte[], int, long):long[]");
    }
}
