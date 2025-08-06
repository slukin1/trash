package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

public abstract class Nat320 {
    public static void copy64(long[] jArr, int i11, long[] jArr2, int i12) {
        jArr2[i12 + 0] = jArr[i11 + 0];
        jArr2[i12 + 1] = jArr[i11 + 1];
        jArr2[i12 + 2] = jArr[i11 + 2];
        jArr2[i12 + 3] = jArr[i11 + 3];
        jArr2[i12 + 4] = jArr[i11 + 4];
    }

    public static void copy64(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
    }

    public static long[] create64() {
        return new long[5];
    }

    public static long[] createExt64() {
        return new long[10];
    }

    public static boolean eq64(long[] jArr, long[] jArr2) {
        for (int i11 = 4; i11 >= 0; i11--) {
            if (jArr[i11] != jArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    public static long[] fromBigInteger64(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 320) {
            throw new IllegalArgumentException();
        }
        long[] create64 = create64();
        for (int i11 = 0; i11 < 5; i11++) {
            create64[i11] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return create64;
    }

    public static boolean isOne64(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i11 = 1; i11 < 5; i11++) {
            if (jArr[i11] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero64(long[] jArr) {
        for (int i11 = 0; i11 < 5; i11++) {
            if (jArr[i11] != 0) {
                return false;
            }
        }
        return true;
    }

    public static BigInteger toBigInteger64(long[] jArr) {
        byte[] bArr = new byte[40];
        for (int i11 = 0; i11 < 5; i11++) {
            long j11 = jArr[i11];
            if (j11 != 0) {
                Pack.longToBigEndian(j11, bArr, (4 - i11) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }
}
