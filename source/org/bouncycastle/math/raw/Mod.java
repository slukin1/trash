package org.bouncycastle.math.raw;

import java.util.Random;
import org.bouncycastle.util.Integers;

public abstract class Mod {
    private static final int M30 = 1073741823;
    private static final long M32L = 4294967295L;

    private static int add30(int i11, int[] iArr, int[] iArr2) {
        int i12 = i11 - 1;
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            int i15 = i13 + iArr[i14] + iArr2[i14];
            iArr[i14] = M30 & i15;
            i13 = i15 >> 30;
        }
        int i16 = i13 + iArr[i12] + iArr2[i12];
        iArr[i12] = i16;
        return i16 >> 30;
    }

    public static void checkedModOddInverse(int[] iArr, int[] iArr2, int[] iArr3) {
        if (modOddInverse(iArr, iArr2, iArr3) == 0) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    public static void checkedModOddInverseVar(int[] iArr, int[] iArr2, int[] iArr3) {
        if (!modOddInverseVar(iArr, iArr2, iArr3)) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    private static void cnegate30(int i11, int i12, int[] iArr) {
        int i13 = i11 - 1;
        int i14 = 0;
        for (int i15 = 0; i15 < i13; i15++) {
            int i16 = i14 + ((iArr[i15] ^ i12) - i12);
            iArr[i15] = M30 & i16;
            i14 = i16 >> 30;
        }
        iArr[i13] = i14 + ((iArr[i13] ^ i12) - i12);
    }

    private static void cnormalize30(int i11, int i12, int[] iArr, int[] iArr2) {
        int i13 = i11 - 1;
        int i14 = iArr[i13] >> 31;
        int i15 = 0;
        for (int i16 = 0; i16 < i13; i16++) {
            int i17 = i15 + (((iArr[i16] + (iArr2[i16] & i14)) ^ i12) - i12);
            iArr[i16] = M30 & i17;
            i15 = i17 >> 30;
        }
        iArr[i13] = i15 + (((iArr[i13] + (i14 & iArr2[i13])) ^ i12) - i12);
        int i18 = iArr[i13] >> 31;
        int i19 = 0;
        for (int i21 = 0; i21 < i13; i21++) {
            int i22 = i19 + iArr[i21] + (iArr2[i21] & i18);
            iArr[i21] = i22 & M30;
            i19 = i22 >> 30;
        }
        iArr[i13] = i19 + iArr[i13] + (i18 & iArr2[i13]);
    }

    private static void decode30(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        int i14 = 0;
        long j11 = 0;
        while (i11 > 0) {
            while (i14 < Math.min(32, i11)) {
                j11 |= ((long) iArr[i12]) << i14;
                i14 += 30;
                i12++;
            }
            iArr2[i13] = (int) j11;
            j11 >>>= 32;
            i14 -= 32;
            i11 -= 32;
            i13++;
        }
    }

    private static int divsteps30(int i11, int i12, int i13, int[] iArr) {
        int i14 = 1073741824;
        int i15 = 1073741824;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < 30; i18++) {
            int i19 = i11 >> 31;
            int i21 = -(i13 & 1);
            int i22 = i13 - ((i12 ^ i19) & i21);
            int i23 = i17 - ((i14 ^ i19) & i21);
            int i24 = i15 - ((i16 ^ i19) & i21);
            int i25 = (~i19) & i21;
            i11 = (i11 ^ i25) - (i25 - 1);
            i12 += i22 & i25;
            i14 += i23 & i25;
            i16 += i25 & i24;
            i13 = i22 >> 1;
            i17 = i23 >> 1;
            i15 = i24 >> 1;
        }
        iArr[0] = i14;
        iArr[1] = i16;
        iArr[2] = i17;
        iArr[3] = i15;
        return i11;
    }

    private static int divsteps30Var(int i11, int i12, int i13, int[] iArr) {
        int i14;
        int i15 = i12;
        int i16 = i13;
        int i17 = 0;
        int i18 = 0;
        int i19 = 1;
        int i21 = 1;
        int i22 = 30;
        int i23 = i11;
        while (true) {
            int numberOfTrailingZeros = Integers.numberOfTrailingZeros((-1 << i22) | i16);
            int i24 = i16 >> numberOfTrailingZeros;
            i19 <<= numberOfTrailingZeros;
            i17 <<= numberOfTrailingZeros;
            i23 -= numberOfTrailingZeros;
            i22 -= numberOfTrailingZeros;
            if (i22 <= 0) {
                iArr[0] = i19;
                iArr[1] = i17;
                iArr[2] = i18;
                iArr[3] = i21;
                return i23;
            }
            if (i23 < 0) {
                i23 = -i23;
                int i25 = -i15;
                int i26 = -i19;
                int i27 = -i17;
                int i28 = i23 + 1;
                if (i28 > i22) {
                    i28 = i22;
                }
                i14 = (-1 >>> (32 - i28)) & 63 & (i24 * i25 * ((i24 * i24) - 2));
                int i29 = i24;
                i24 = i25;
                i15 = i29;
                int i30 = i18;
                i18 = i26;
                i19 = i30;
                int i31 = i21;
                i21 = i27;
                i17 = i31;
            } else {
                int i32 = i23 + 1;
                if (i32 > i22) {
                    i32 = i22;
                }
                i14 = (-1 >>> (32 - i32)) & 15 & ((-((((i15 + 1) & 4) << 1) + i15)) * i24);
            }
            i16 = i24 + (i15 * i14);
            i18 += i19 * i14;
            i21 += i14 * i17;
        }
    }

    private static void encode30(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        int i14 = 0;
        long j11 = 0;
        while (i11 > 0) {
            if (i14 < Math.min(30, i11)) {
                j11 |= (((long) iArr[i12]) & 4294967295L) << i14;
                i14 += 32;
                i12++;
            }
            iArr2[i13] = ((int) j11) & M30;
            j11 >>>= 30;
            i14 -= 30;
            i11 -= 30;
            i13++;
        }
    }

    private static int getMaximumDivsteps(int i11) {
        return ((i11 * 49) + (i11 < 46 ? 80 : 47)) / 17;
    }

    public static int inverse32(int i11) {
        int i12 = (2 - (i11 * i11)) * i11;
        int i13 = i12 * (2 - (i11 * i12));
        int i14 = i13 * (2 - (i11 * i13));
        return i14 * (2 - (i11 * i14));
    }

    public static int modOddInverse(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = iArr;
        int length = iArr4.length;
        int numberOfLeadingZeros = (length << 5) - Integers.numberOfLeadingZeros(iArr4[length - 1]);
        int i11 = (numberOfLeadingZeros + 29) / 30;
        int[] iArr5 = new int[4];
        int[] iArr6 = new int[i11];
        int[] iArr7 = new int[i11];
        int[] iArr8 = new int[i11];
        int[] iArr9 = new int[i11];
        int[] iArr10 = new int[i11];
        int i12 = 0;
        iArr7[0] = 1;
        encode30(numberOfLeadingZeros, iArr2, 0, iArr9, 0);
        encode30(numberOfLeadingZeros, iArr4, 0, iArr10, 0);
        System.arraycopy(iArr10, 0, iArr8, 0, i11);
        int inverse32 = inverse32(iArr10[0]);
        int i13 = 0;
        int i14 = 0;
        for (int maximumDivsteps = getMaximumDivsteps(numberOfLeadingZeros); i14 < maximumDivsteps; maximumDivsteps = maximumDivsteps) {
            int divsteps30 = divsteps30(i13, iArr8[i12], iArr9[i12], iArr5);
            updateDE30(i11, iArr6, iArr7, iArr5, inverse32, iArr10);
            updateFG30(i11, iArr8, iArr9, iArr5);
            i14 += 30;
            i12 = i12;
            i13 = divsteps30;
        }
        int i15 = i12;
        int i16 = iArr8[i11 - 1] >> 31;
        cnegate30(i11, i16, iArr8);
        cnormalize30(i11, i16, iArr6, iArr10);
        decode30(numberOfLeadingZeros, iArr6, i15, iArr3, i15);
        return Nat.equalTo(i11, iArr8, 1) & Nat.equalToZero(i11, iArr9);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r9v3 */
    public static boolean modOddInverseVar(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = iArr;
        int length = iArr4.length;
        int numberOfLeadingZeros = (length << 5) - Integers.numberOfLeadingZeros(iArr4[length - 1]);
        int i11 = (numberOfLeadingZeros + 29) / 30;
        int[] iArr5 = new int[4];
        int[] iArr6 = new int[i11];
        int[] iArr7 = new int[i11];
        int[] iArr8 = new int[i11];
        int[] iArr9 = new int[i11];
        int[] iArr10 = new int[i11];
        ? r92 = 0;
        iArr7[0] = 1;
        encode30(numberOfLeadingZeros, iArr2, 0, iArr9, 0);
        encode30(numberOfLeadingZeros, iArr4, 0, iArr10, 0);
        System.arraycopy(iArr10, 0, iArr8, 0, i11);
        int i12 = i11 - 1;
        int numberOfLeadingZeros2 = -1 - (Integers.numberOfLeadingZeros(iArr9[i12] | 1) - (((i11 * 30) + 2) - numberOfLeadingZeros));
        int inverse32 = inverse32(iArr10[0]);
        int maximumDivsteps = getMaximumDivsteps(numberOfLeadingZeros);
        int i13 = i11;
        int i14 = 0;
        while (!Nat.isZero(i13, iArr9)) {
            if (i14 >= maximumDivsteps) {
                return r92;
            }
            int i15 = i14 + 30;
            int divsteps30Var = divsteps30Var(numberOfLeadingZeros2, iArr8[r92], iArr9[r92], iArr5);
            int i16 = i13;
            int i17 = maximumDivsteps;
            int[] iArr11 = iArr7;
            boolean z11 = r92;
            updateDE30(i11, iArr6, iArr7, iArr5, inverse32, iArr10);
            updateFG30(i16, iArr8, iArr9, iArr5);
            int i18 = i16 - 1;
            int i19 = iArr8[i18];
            int i21 = iArr9[i18];
            int i22 = i16 - 2;
            if (((i22 >> 31) | ((i19 >> 31) ^ i19) | ((i21 >> 31) ^ i21)) == 0) {
                iArr8[i22] = (i19 << 30) | iArr8[i22];
                iArr9[i22] = iArr9[i22] | (i21 << 30);
                i13 = i16 - 1;
            } else {
                i13 = i16;
            }
            r92 = z11;
            i14 = i15;
            numberOfLeadingZeros2 = divsteps30Var;
            maximumDivsteps = i17;
            iArr7 = iArr11;
        }
        int i23 = i13;
        boolean z12 = r92;
        int i24 = iArr8[i23 - 1] >> 31;
        int i25 = iArr6[i12] >> 31;
        if (i25 < 0) {
            i25 = add30(i11, iArr6, iArr10);
        }
        if (i24 < 0) {
            i25 = negate30(i11, iArr6);
            negate30(i23, iArr8);
        }
        if (!Nat.isOne(i23, iArr8)) {
            return z12;
        }
        if (i25 < 0) {
            add30(i11, iArr6, iArr10);
        }
        decode30(numberOfLeadingZeros, iArr6, z12 ? 1 : 0, iArr3, z12);
        return true;
    }

    private static int negate30(int i11, int[] iArr) {
        int i12 = i11 - 1;
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            int i15 = i13 - iArr[i14];
            iArr[i14] = M30 & i15;
            i13 = i15 >> 30;
        }
        int i16 = i13 - iArr[i12];
        iArr[i12] = i16;
        return i16 >> 30;
    }

    public static int[] random(int[] iArr) {
        int length = iArr.length;
        Random random = new Random();
        int[] create = Nat.create(length);
        int i11 = length - 1;
        int i12 = iArr[i11];
        int i13 = i12 | (i12 >>> 1);
        int i14 = i13 | (i13 >>> 2);
        int i15 = i14 | (i14 >>> 4);
        int i16 = i15 | (i15 >>> 8);
        int i17 = i16 | (i16 >>> 16);
        do {
            for (int i18 = 0; i18 != length; i18++) {
                create[i18] = random.nextInt();
            }
            create[i11] = create[i11] & i17;
        } while (Nat.gte(length, create, iArr));
        return create;
    }

    private static void updateDE30(int i11, int[] iArr, int[] iArr2, int[] iArr3, int i12, int[] iArr4) {
        int i13 = i11;
        int i14 = iArr3[0];
        int i15 = iArr3[1];
        int i16 = iArr3[2];
        int i17 = iArr3[3];
        int i18 = i13 - 1;
        int i19 = iArr[i18] >> 31;
        int i21 = iArr2[i18] >> 31;
        int i22 = (i14 & i19) + (i15 & i21);
        int i23 = (i19 & i16) + (i21 & i17);
        int i24 = iArr4[0];
        long j11 = (long) i14;
        long j12 = (long) iArr[0];
        long j13 = (long) i15;
        long j14 = (long) iArr2[0];
        long j15 = j13;
        long j16 = (j11 * j12) + (j13 * j14);
        long j17 = j11;
        long j18 = (long) i16;
        long j19 = (long) i17;
        long j21 = (j12 * j18) + (j14 * j19);
        long j22 = (long) i24;
        long j23 = (long) (i22 - (((((int) j16) * i12) + i22) & M30));
        int i25 = i18;
        long j24 = (long) (i23 - (((((int) j21) * i12) + i23) & M30));
        long j25 = (j21 + (j22 * j24)) >> 30;
        long j26 = (j16 + (j22 * j23)) >> 30;
        int i26 = 1;
        while (i26 < i13) {
            int i27 = iArr4[i26];
            long j27 = j25;
            long j28 = (long) iArr[i26];
            int i28 = i26;
            long j29 = (long) iArr2[i26];
            long j30 = j24;
            long j31 = (long) i27;
            long j32 = j26 + (j17 * j28) + (j15 * j29) + (j31 * j23);
            long j33 = j27 + (j28 * j18) + (j29 * j19) + (j31 * j30);
            int i29 = i28 - 1;
            iArr[i29] = ((int) j32) & M30;
            j26 = j32 >> 30;
            iArr2[i29] = ((int) j33) & M30;
            j25 = j33 >> 30;
            i26 = i28 + 1;
            i13 = i11;
            i25 = i25;
            j24 = j30;
        }
        int i30 = i25;
        long j34 = j25;
        iArr[i30] = (int) j26;
        iArr2[i30] = (int) j25;
    }

    private static void updateFG30(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
        int i12 = i11;
        int i13 = iArr3[0];
        int i14 = 1;
        int i15 = iArr3[1];
        int i16 = iArr3[2];
        int i17 = iArr3[3];
        long j11 = (long) i13;
        long j12 = (long) iArr[0];
        long j13 = (long) i15;
        long j14 = (long) iArr2[0];
        long j15 = (long) i16;
        long j16 = (long) i17;
        long j17 = ((j11 * j12) + (j13 * j14)) >> 30;
        long j18 = ((j12 * j15) + (j14 * j16)) >> 30;
        int i18 = 1;
        while (i18 < i12) {
            int i19 = iArr[i18];
            int i21 = iArr2[i18];
            int i22 = i18;
            long j19 = (long) i19;
            long j21 = j11 * j19;
            long j22 = j11;
            long j23 = (long) i21;
            long j24 = j17 + j21 + (j13 * j23);
            long j25 = j18 + (j19 * j15) + (j23 * j16);
            int i23 = i22 - 1;
            iArr[i23] = ((int) j24) & M30;
            j17 = j24 >> 30;
            iArr2[i23] = M30 & ((int) j25);
            j18 = j25 >> 30;
            i18 = i22 + 1;
            j11 = j22;
            i14 = 1;
        }
        int i24 = i12 - i14;
        iArr[i24] = (int) j17;
        iArr2[i24] = (int) j18;
    }
}
