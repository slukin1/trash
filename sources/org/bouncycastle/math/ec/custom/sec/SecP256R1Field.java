package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Pack;

public class SecP256R1Field {
    private static final long M = 4294967295L;
    public static final int[] P = {-1, -1, -1, 0, 0, 0, 1, -1};
    private static final int P7 = -1;
    private static final int[] PExt = {1, 0, 0, -2, -1, -1, -2, 1, -2, 1, -2, 1, 1, -2, 2, -2};
    private static final int PExt15s1 = Integer.MAX_VALUE;

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.add(iArr, iArr2, iArr3) != 0 || (iArr3[7] == -1 && Nat256.gte(iArr3, P))) {
            addPInvTo(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(16, iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && Nat.gte(16, iArr3, PExt))) {
            Nat.subFrom(16, PExt, iArr3);
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (Nat.inc(8, iArr, iArr2) != 0 || (iArr2[7] == -1 && Nat256.gte(iArr2, P))) {
            addPInvTo(iArr2);
        }
    }

    private static void addPInvTo(int[] iArr) {
        long j11 = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j11;
        long j12 = j11 >> 32;
        if (j12 != 0) {
            long j13 = j12 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j13;
            long j14 = (j13 >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j14;
            j12 = j14 >> 32;
        }
        long j15 = j12 + ((((long) iArr[3]) & 4294967295L) - 1);
        iArr[3] = (int) j15;
        long j16 = j15 >> 32;
        if (j16 != 0) {
            long j17 = j16 + (((long) iArr[4]) & 4294967295L);
            iArr[4] = (int) j17;
            long j18 = (j17 >> 32) + (((long) iArr[5]) & 4294967295L);
            iArr[5] = (int) j18;
            j16 = j18 >> 32;
        }
        long j19 = j16 + ((((long) iArr[6]) & 4294967295L) - 1);
        iArr[6] = (int) j19;
        iArr[7] = (int) ((j19 >> 32) + (4294967295L & ((long) iArr[7])) + 1);
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat256.fromBigInteger(bigInteger);
        if (fromBigInteger[7] == -1) {
            int[] iArr = P;
            if (Nat256.gte(fromBigInteger, iArr)) {
                Nat256.subFrom(iArr, fromBigInteger);
            }
        }
        return fromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            Nat.shiftDownBit(8, iArr, 0, iArr2);
        } else {
            Nat.shiftDownBit(8, iArr2, Nat256.add(iArr, P, iArr2));
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        Mod.checkedModOddInverse(P, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < 8; i12++) {
            i11 |= iArr[i12];
        }
        return (((i11 >>> 1) | (i11 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] createExt = Nat256.createExt();
        Nat256.mul(iArr, iArr2, createExt);
        reduce(createExt, iArr3);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        Nat256.mul(iArr, iArr2, iArr4);
        reduce(iArr4, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.mulAddTo(iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && Nat.gte(16, iArr3, PExt))) {
            Nat.subFrom(16, PExt, iArr3);
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) != 0) {
            int[] iArr3 = P;
            Nat256.sub(iArr3, iArr3, iArr2);
            return;
        }
        Nat256.sub(P, iArr, iArr2);
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[32];
        do {
            secureRandom.nextBytes(bArr);
            Pack.littleEndianToInt(bArr, 0, iArr, 0, 8);
        } while (Nat.lessThan(8, iArr, P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j11 = ((long) iArr[9]) & 4294967295L;
        long j12 = ((long) iArr[10]) & 4294967295L;
        long j13 = ((long) iArr[11]) & 4294967295L;
        long j14 = ((long) iArr[12]) & 4294967295L;
        long j15 = ((long) iArr[13]) & 4294967295L;
        long j16 = ((long) iArr[14]) & 4294967295L;
        long j17 = ((long) iArr[15]) & 4294967295L;
        long j18 = (((long) iArr[8]) & 4294967295L) - 6;
        long j19 = j18 + j11;
        long j21 = j11 + j12;
        long j22 = (j12 + j13) - j17;
        long j23 = j13 + j14;
        long j24 = j14 + j15;
        long j25 = j15 + j16;
        long j26 = j16 + j17;
        long j27 = j25 - j19;
        long j28 = j18;
        long j29 = (((((long) iArr[0]) & 4294967295L) - j23) - j27) + 0;
        iArr3[0] = (int) j29;
        long j30 = (j29 >> 32) + ((((((long) iArr[1]) & 4294967295L) + j21) - j24) - j26);
        iArr3[1] = (int) j30;
        long j31 = (j30 >> 32) + (((((long) iArr[2]) & 4294967295L) + j22) - j25);
        iArr3[2] = (int) j31;
        long j32 = (j31 >> 32) + ((((((long) iArr[3]) & 4294967295L) + (j23 << 1)) + j27) - j26);
        iArr3[3] = (int) j32;
        long j33 = (j32 >> 32) + ((((((long) iArr[4]) & 4294967295L) + (j24 << 1)) + j16) - j21);
        iArr3[4] = (int) j33;
        long j34 = (j33 >> 32) + (((((long) iArr[5]) & 4294967295L) + (j25 << 1)) - j22);
        iArr3[5] = (int) j34;
        long j35 = (j34 >> 32) + (((long) iArr[6]) & 4294967295L) + (j26 << 1) + j27;
        iArr3[6] = (int) j35;
        long j36 = (j35 >> 32) + (((((((long) iArr[7]) & 4294967295L) + (j17 << 1)) + j28) - j22) - j24);
        iArr3[7] = (int) j36;
        reduce32((int) ((j36 >> 32) + 6), iArr3);
    }

    public static void reduce32(int i11, int[] iArr) {
        long j11;
        if (i11 != 0) {
            long j12 = ((long) i11) & 4294967295L;
            long j13 = (((long) iArr[0]) & 4294967295L) + j12 + 0;
            iArr[0] = (int) j13;
            long j14 = j13 >> 32;
            if (j14 != 0) {
                long j15 = j14 + (((long) iArr[1]) & 4294967295L);
                iArr[1] = (int) j15;
                long j16 = (j15 >> 32) + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j16;
                j14 = j16 >> 32;
            }
            long j17 = j14 + ((((long) iArr[3]) & 4294967295L) - j12);
            iArr[3] = (int) j17;
            long j18 = j17 >> 32;
            if (j18 != 0) {
                long j19 = j18 + (((long) iArr[4]) & 4294967295L);
                iArr[4] = (int) j19;
                long j21 = (j19 >> 32) + (((long) iArr[5]) & 4294967295L);
                iArr[5] = (int) j21;
                j18 = j21 >> 32;
            }
            long j22 = j18 + ((((long) iArr[6]) & 4294967295L) - j12);
            iArr[6] = (int) j22;
            long j23 = (j22 >> 32) + (4294967295L & ((long) iArr[7])) + j12;
            iArr[7] = (int) j23;
            j11 = j23 >> 32;
        } else {
            j11 = 0;
        }
        if (j11 != 0 || (iArr[7] == -1 && Nat256.gte(iArr, P))) {
            addPInvTo(iArr);
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] createExt = Nat256.createExt();
        Nat256.square(iArr, createExt);
        reduce(createExt, iArr2);
    }

    public static void square(int[] iArr, int[] iArr2, int[] iArr3) {
        Nat256.square(iArr, iArr3);
        reduce(iArr3, iArr2);
    }

    public static void squareN(int[] iArr, int i11, int[] iArr2) {
        int[] createExt = Nat256.createExt();
        Nat256.square(iArr, createExt);
        while (true) {
            reduce(createExt, iArr2);
            i11--;
            if (i11 > 0) {
                Nat256.square(iArr2, createExt);
            } else {
                return;
            }
        }
    }

    public static void squareN(int[] iArr, int i11, int[] iArr2, int[] iArr3) {
        Nat256.square(iArr, iArr3);
        while (true) {
            reduce(iArr3, iArr2);
            i11--;
            if (i11 > 0) {
                Nat256.square(iArr2, iArr3);
            } else {
                return;
            }
        }
    }

    private static void subPInvFrom(int[] iArr) {
        long j11 = (((long) iArr[0]) & 4294967295L) - 1;
        iArr[0] = (int) j11;
        long j12 = j11 >> 32;
        if (j12 != 0) {
            long j13 = j12 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j13;
            long j14 = (j13 >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j14;
            j12 = j14 >> 32;
        }
        long j15 = j12 + (((long) iArr[3]) & 4294967295L) + 1;
        iArr[3] = (int) j15;
        long j16 = j15 >> 32;
        if (j16 != 0) {
            long j17 = j16 + (((long) iArr[4]) & 4294967295L);
            iArr[4] = (int) j17;
            long j18 = (j17 >> 32) + (((long) iArr[5]) & 4294967295L);
            iArr[5] = (int) j18;
            j16 = j18 >> 32;
        }
        long j19 = j16 + (((long) iArr[6]) & 4294967295L) + 1;
        iArr[6] = (int) j19;
        iArr[7] = (int) ((j19 >> 32) + ((4294967295L & ((long) iArr[7])) - 1));
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.sub(iArr, iArr2, iArr3) != 0) {
            subPInvFrom(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(16, iArr, iArr2, iArr3) != 0) {
            Nat.addTo(16, PExt, iArr3);
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (Nat.shiftUpBit(8, iArr, 0, iArr2) != 0 || (iArr2[7] == -1 && Nat256.gte(iArr2, P))) {
            addPInvTo(iArr2);
        }
    }
}
