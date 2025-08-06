package org.bouncycastle.math.ec.custom.sec;

import com.sumsub.sns.internal.ml.autocapture.b;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat384;
import org.bouncycastle.util.Pack;

public class SecP384R1Field {
    private static final long M = 4294967295L;
    public static final int[] P = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};
    private static final int P11 = -1;
    private static final int[] PExt = {1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};
    private static final int PExt23 = -1;
    private static final int[] PExtInv = {-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && Nat.gte(12, iArr3, P))) {
            addPInvTo(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(24, iArr, iArr2, iArr3) != 0 || (iArr3[23] == -1 && Nat.gte(24, iArr3, PExt))) {
            int[] iArr4 = PExtInv;
            if (Nat.addTo(iArr4.length, iArr4, iArr3) != 0) {
                Nat.incAt(24, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (Nat.inc(12, iArr, iArr2) != 0 || (iArr2[11] == -1 && Nat.gte(12, iArr2, P))) {
            addPInvTo(iArr2);
        }
    }

    private static void addPInvTo(int[] iArr) {
        long j11 = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr[1]) & 4294967295L) - 1);
        iArr[1] = (int) j12;
        long j13 = j12 >> 32;
        if (j13 != 0) {
            long j14 = j13 + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j14;
            j13 = j14 >> 32;
        }
        long j15 = j13 + (((long) iArr[3]) & 4294967295L) + 1;
        iArr[3] = (int) j15;
        long j16 = (j15 >> 32) + (4294967295L & ((long) iArr[4])) + 1;
        iArr[4] = (int) j16;
        if ((j16 >> 32) != 0) {
            Nat.incAt(12, iArr, 5);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat.fromBigInteger(b.f34945b, bigInteger);
        if (fromBigInteger[11] == -1) {
            int[] iArr = P;
            if (Nat.gte(12, fromBigInteger, iArr)) {
                Nat.subFrom(12, iArr, fromBigInteger);
            }
        }
        return fromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            Nat.shiftDownBit(12, iArr, 0, iArr2);
        } else {
            Nat.shiftDownBit(12, iArr2, Nat.add(12, iArr, P, iArr2));
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        Mod.checkedModOddInverse(P, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < 12; i12++) {
            i11 |= iArr[i12];
        }
        return (((i11 >>> 1) | (i11 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = Nat.create(24);
        Nat384.mul(iArr, iArr2, create);
        reduce(create, iArr3);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        Nat384.mul(iArr, iArr2, iArr4);
        reduce(iArr4, iArr3);
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) != 0) {
            int[] iArr3 = P;
            Nat.sub(12, iArr3, iArr3, iArr2);
            return;
        }
        Nat.sub(12, P, iArr, iArr2);
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[48];
        do {
            secureRandom.nextBytes(bArr);
            Pack.littleEndianToInt(bArr, 0, iArr, 0, 12);
        } while (Nat.lessThan(12, iArr, P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j11 = ((long) iArr[17]) & 4294967295L;
        long j12 = ((long) iArr[20]) & 4294967295L;
        long j13 = ((long) iArr[21]) & 4294967295L;
        long j14 = ((long) iArr[19]) & 4294967295L;
        long j15 = ((long) iArr[22]) & 4294967295L;
        long j16 = ((long) iArr[18]) & 4294967295L;
        long j17 = ((long) iArr[23]) & 4294967295L;
        long j18 = ((long) iArr[16]) & 4294967295L;
        long j19 = ((((long) iArr[12]) & 4294967295L) + j12) - 1;
        long j21 = j12;
        long j22 = (((long) iArr[13]) & 4294967295L) + j15;
        long j23 = (((long) iArr[14]) & 4294967295L) + j15 + j17;
        long j24 = (((long) iArr[15]) & 4294967295L) + j17;
        long j25 = j11 + j13;
        long j26 = j13 - j17;
        long j27 = j19 + j26;
        long j28 = j15 - j17;
        long j29 = (((long) iArr[0]) & 4294967295L) + j27 + 0;
        iArr3[0] = (int) j29;
        long j30 = (j29 >> 32) + (((((long) iArr[1]) & 4294967295L) + j17) - j19) + j22;
        iArr3[1] = (int) j30;
        long j31 = (j30 >> 32) + (((((long) iArr[2]) & 4294967295L) - j13) - j22) + j23;
        iArr3[2] = (int) j31;
        long j32 = (j31 >> 32) + ((((long) iArr[3]) & 4294967295L) - j23) + j24 + j27;
        iArr3[3] = (int) j32;
        long j33 = (j32 >> 32) + (((((((long) iArr[4]) & 4294967295L) + j18) + j13) + j22) - j24) + j27;
        iArr3[4] = (int) j33;
        long j34 = (j33 >> 32) + ((((long) iArr[5]) & 4294967295L) - j18) + j22 + j23 + j25;
        iArr3[5] = (int) j34;
        long j35 = (j34 >> 32) + (((((long) iArr[6]) & 4294967295L) + j16) - j11) + j23 + j24;
        iArr3[6] = (int) j35;
        long j36 = (j35 >> 32) + ((((((long) iArr[7]) & 4294967295L) + j18) + j14) - j16) + j24;
        iArr3[7] = (int) j36;
        long j37 = (j36 >> 32) + (((((((long) iArr[8]) & 4294967295L) + j18) + j11) + j21) - j14);
        iArr3[8] = (int) j37;
        long j38 = (j37 >> 32) + (((((long) iArr[9]) & 4294967295L) + j16) - j21) + j25;
        iArr3[9] = (int) j38;
        long j39 = (j38 >> 32) + ((((((long) iArr[10]) & 4294967295L) + j16) + j14) - j26) + j28;
        iArr3[10] = (int) j39;
        long j40 = (j39 >> 32) + ((((((long) iArr[11]) & 4294967295L) + j14) + j21) - j28);
        iArr3[11] = (int) j40;
        reduce32((int) ((j40 >> 32) + 1), iArr3);
    }

    public static void reduce32(int i11, int[] iArr) {
        long j11;
        if (i11 != 0) {
            long j12 = ((long) i11) & 4294967295L;
            long j13 = (((long) iArr[0]) & 4294967295L) + j12 + 0;
            iArr[0] = (int) j13;
            long j14 = (j13 >> 32) + ((((long) iArr[1]) & 4294967295L) - j12);
            iArr[1] = (int) j14;
            long j15 = j14 >> 32;
            if (j15 != 0) {
                long j16 = j15 + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j16;
                j15 = j16 >> 32;
            }
            long j17 = j15 + (((long) iArr[3]) & 4294967295L) + j12;
            iArr[3] = (int) j17;
            long j18 = (j17 >> 32) + (4294967295L & ((long) iArr[4])) + j12;
            iArr[4] = (int) j18;
            j11 = j18 >> 32;
        } else {
            j11 = 0;
        }
        if ((j11 != 0 && Nat.incAt(12, iArr, 5) != 0) || (iArr[11] == -1 && Nat.gte(12, iArr, P))) {
            addPInvTo(iArr);
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] create = Nat.create(24);
        Nat384.square(iArr, create);
        reduce(create, iArr2);
    }

    public static void square(int[] iArr, int[] iArr2, int[] iArr3) {
        Nat384.square(iArr, iArr3);
        reduce(iArr3, iArr2);
    }

    public static void squareN(int[] iArr, int i11, int[] iArr2) {
        int[] create = Nat.create(24);
        Nat384.square(iArr, create);
        while (true) {
            reduce(create, iArr2);
            i11--;
            if (i11 > 0) {
                Nat384.square(iArr2, create);
            } else {
                return;
            }
        }
    }

    public static void squareN(int[] iArr, int i11, int[] iArr2, int[] iArr3) {
        Nat384.square(iArr, iArr3);
        while (true) {
            reduce(iArr3, iArr2);
            i11--;
            if (i11 > 0) {
                Nat384.square(iArr2, iArr3);
            } else {
                return;
            }
        }
    }

    private static void subPInvFrom(int[] iArr) {
        long j11 = (((long) iArr[0]) & 4294967295L) - 1;
        iArr[0] = (int) j11;
        long j12 = (j11 >> 32) + (((long) iArr[1]) & 4294967295L) + 1;
        iArr[1] = (int) j12;
        long j13 = j12 >> 32;
        if (j13 != 0) {
            long j14 = j13 + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j14;
            j13 = j14 >> 32;
        }
        long j15 = j13 + ((((long) iArr[3]) & 4294967295L) - 1);
        iArr[3] = (int) j15;
        long j16 = (j15 >> 32) + ((4294967295L & ((long) iArr[4])) - 1);
        iArr[4] = (int) j16;
        if ((j16 >> 32) != 0) {
            Nat.decAt(12, iArr, 5);
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(12, iArr, iArr2, iArr3) != 0) {
            subPInvFrom(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(24, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = PExtInv;
            if (Nat.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                Nat.decAt(24, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (Nat.shiftUpBit(12, iArr, 0, iArr2) != 0 || (iArr2[11] == -1 && Nat.gte(12, iArr2, P))) {
            addPInvTo(iArr2);
        }
    }
}
