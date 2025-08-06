package org.bouncycastle.math.raw;

public abstract class Mont256 {
    private static final long M = 4294967295L;

    public static int inverse32(int i11) {
        int i12 = (2 - (i11 * i11)) * i11;
        int i13 = i12 * (2 - (i11 * i12));
        int i14 = i13 * (2 - (i11 * i13));
        return i14 * (2 - (i11 * i14));
    }

    public static void multAdd(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i11) {
        int[] iArr5 = iArr3;
        int[] iArr6 = iArr4;
        char c11 = 0;
        long j11 = ((long) iArr2[0]) & 4294967295L;
        int i12 = 0;
        int i13 = 0;
        while (i12 < 8) {
            long j12 = ((long) iArr[i12]) & 4294967295L;
            long j13 = j12 * j11;
            long j14 = (j13 & 4294967295L) + (((long) iArr5[c11]) & 4294967295L);
            long j15 = j11;
            long j16 = ((long) (((int) j14) * i11)) & 4294967295L;
            int i14 = i12;
            int i15 = i13;
            long j17 = (((long) iArr6[c11]) & 4294967295L) * j16;
            char c12 = ' ';
            long j18 = ((j14 + (j17 & 4294967295L)) >>> 32) + (j13 >>> 32) + (j17 >>> 32);
            int i16 = 1;
            while (i16 < 8) {
                long j19 = (((long) iArr2[i16]) & 4294967295L) * j12;
                long j21 = (((long) iArr6[i16]) & 4294967295L) * j16;
                long j22 = j18 + (j19 & 4294967295L) + (j21 & 4294967295L) + (((long) iArr5[i16]) & 4294967295L);
                iArr5[i16 - 1] = (int) j22;
                j18 = (j22 >>> 32) + (j19 >>> 32) + (j21 >>> 32);
                i16++;
                c12 = ' ';
                j16 = j16;
            }
            long j23 = j18 + (((long) i15) & 4294967295L);
            iArr5[7] = (int) j23;
            i13 = (int) (j23 >>> c12);
            i12 = i14 + 1;
            j11 = j15;
            c11 = 0;
        }
        if (i13 != 0 || Nat256.gte(iArr3, iArr4)) {
            Nat256.sub(iArr5, iArr6, iArr5);
        }
    }

    public static void multAddXF(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int[] iArr5 = iArr3;
        int[] iArr6 = iArr4;
        char c11 = 0;
        long j11 = ((long) iArr2[0]) & 4294967295L;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= 8) {
                break;
            }
            long j12 = ((long) iArr[i11]) & 4294967295L;
            long j13 = (j12 * j11) + (((long) iArr5[c11]) & 4294967295L);
            long j14 = j13 & 4294967295L;
            long j15 = (j13 >>> 32) + j14;
            int i13 = 1;
            for (int i14 = 8; i13 < i14; i14 = 8) {
                long j16 = j11;
                long j17 = (((long) iArr2[i13]) & 4294967295L) * j12;
                long j18 = (((long) iArr6[i13]) & 4294967295L) * j14;
                long j19 = j15 + (j17 & 4294967295L) + (j18 & 4294967295L) + (((long) iArr5[i13]) & 4294967295L);
                iArr5[i13 - 1] = (int) j19;
                j15 = (j19 >>> 32) + (j17 >>> 32) + (j18 >>> 32);
                i13++;
                j11 = j16;
                j12 = j12;
                j14 = j14;
            }
            long j21 = j15 + (((long) i12) & 4294967295L);
            iArr5[7] = (int) j21;
            i12 = (int) (j21 >>> 32);
            i11++;
            j11 = j11;
            c11 = 0;
        }
        if (i12 != 0 || Nat256.gte(iArr3, iArr4)) {
            Nat256.sub(iArr5, iArr6, iArr5);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2, int i11) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        char c11 = 0;
        int i12 = 0;
        while (i12 < 8) {
            int i13 = iArr3[c11];
            long j11 = ((long) (i13 * i11)) & 4294967295L;
            long j12 = (((((long) iArr4[c11]) & 4294967295L) * j11) + (((long) i13) & 4294967295L)) >>> 32;
            int i14 = 1;
            while (i14 < 8) {
                long j13 = j12 + ((((long) iArr4[i14]) & 4294967295L) * j11) + (((long) iArr3[i14]) & 4294967295L);
                iArr3[i14 - 1] = (int) j13;
                j12 = j13 >>> 32;
                i14++;
                i12 = i12;
            }
            iArr3[7] = (int) j12;
            i12++;
            c11 = 0;
        }
        if (Nat256.gte(iArr, iArr2)) {
            Nat256.sub(iArr3, iArr4, iArr3);
        }
    }

    public static void reduceXF(int[] iArr, int[] iArr2) {
        for (int i11 = 0; i11 < 8; i11++) {
            long j11 = ((long) iArr[0]) & 4294967295L;
            long j12 = j11;
            for (int i12 = 1; i12 < 8; i12++) {
                long j13 = j12 + ((((long) iArr2[i12]) & 4294967295L) * j11) + (((long) iArr[i12]) & 4294967295L);
                iArr[i12 - 1] = (int) j13;
                j12 = j13 >>> 32;
            }
            iArr[7] = (int) j12;
        }
        if (Nat256.gte(iArr, iArr2)) {
            Nat256.sub(iArr, iArr2, iArr);
        }
    }
}
