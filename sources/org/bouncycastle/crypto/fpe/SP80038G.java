package org.bouncycastle.crypto.fpe;

import com.tencent.android.tpush.common.Constants;
import java.math.BigInteger;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Pack;

class SP80038G {
    public static final int BLOCK_SIZE = 16;
    public static final String FF1_DISABLED = "org.bouncycastle.fpe.disable_ff1";
    public static final String FPE_DISABLED = "org.bouncycastle.fpe.disable";
    public static final double LOG2 = Math.log(2.0d);
    public static final double TWO_TO_96 = Math.pow(2.0d, 96.0d);

    public static BigInteger[] calculateModUV(BigInteger bigInteger, int i11, int i12) {
        BigInteger[] bigIntegerArr = new BigInteger[2];
        bigIntegerArr[0] = bigInteger.pow(i11);
        bigIntegerArr[1] = bigIntegerArr[0];
        if (i12 != i11) {
            bigIntegerArr[1] = bigIntegerArr[1].multiply(bigInteger);
        }
        return bigIntegerArr;
    }

    public static byte[] calculateP_FF1(int i11, byte b11, int i12, int i13) {
        byte[] bArr = new byte[16];
        bArr[0] = 1;
        bArr[1] = 2;
        bArr[2] = 1;
        bArr[3] = 0;
        bArr[4] = (byte) (i11 >> 8);
        bArr[5] = (byte) i11;
        bArr[6] = 10;
        bArr[7] = b11;
        Pack.intToBigEndian(i12, bArr, 8);
        Pack.intToBigEndian(i13, bArr, 12);
        return bArr;
    }

    public static byte[] calculateTweak64_FF3_1(byte[] bArr) {
        return new byte[]{bArr[0], bArr[1], bArr[2], (byte) (bArr[3] & 240), bArr[4], bArr[5], bArr[6], (byte) (bArr[3] << 4)};
    }

    public static BigInteger calculateY_FF1(BlockCipher blockCipher, BigInteger bigInteger, byte[] bArr, int i11, int i12, int i13, byte[] bArr2, short[] sArr) {
        int length = bArr.length;
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(num(bigInteger, sArr));
        int i14 = ((-(length + i11 + 1)) & 15) + length;
        int i15 = i14 + 1 + i11;
        byte[] bArr3 = new byte[i15];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        bArr3[i14] = (byte) i13;
        System.arraycopy(asUnsignedByteArray, 0, bArr3, i15 - asUnsignedByteArray.length, asUnsignedByteArray.length);
        byte[] prf = prf(blockCipher, Arrays.concatenate(bArr2, bArr3));
        if (i12 > 16) {
            int i16 = ((i12 + 16) - 1) / 16;
            byte[] bArr4 = new byte[(i16 * 16)];
            System.arraycopy(prf, 0, bArr4, 0, 16);
            byte[] bArr5 = new byte[4];
            for (int i17 = 1; i17 < i16; i17++) {
                int i18 = i17 * 16;
                System.arraycopy(prf, 0, bArr4, i18, 16);
                Pack.intToBigEndian(i17, bArr5, 0);
                xor(bArr5, 0, bArr4, (i18 + 16) - 4, 4);
                blockCipher.processBlock(bArr4, i18, bArr4, i18);
            }
            prf = bArr4;
        }
        return num(prf, 0, i12);
    }

    public static BigInteger calculateY_FF3(BlockCipher blockCipher, BigInteger bigInteger, byte[] bArr, int i11, int i12, short[] sArr) {
        byte[] bArr2 = new byte[16];
        Pack.intToBigEndian(i12, bArr2, 0);
        xor(bArr, i11, bArr2, 0, 4);
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(num(bigInteger, sArr));
        if (16 - asUnsignedByteArray.length >= 4) {
            System.arraycopy(asUnsignedByteArray, 0, bArr2, 16 - asUnsignedByteArray.length, asUnsignedByteArray.length);
            rev(bArr2);
            blockCipher.processBlock(bArr2, 0, bArr2, 0);
            rev(bArr2);
            return num(bArr2, 0, 16);
        }
        throw new IllegalStateException("input out of range");
    }

    public static void checkArgs(BlockCipher blockCipher, boolean z11, int i11, byte[] bArr, int i12, int i13) {
        checkCipher(blockCipher);
        if (i11 < 2 || i11 > 256) {
            throw new IllegalArgumentException();
        }
        checkData(z11, i11, bArr, i12, i13);
    }

    public static void checkArgs(BlockCipher blockCipher, boolean z11, int i11, short[] sArr, int i12, int i13) {
        checkCipher(blockCipher);
        if (i11 < 2 || i11 > 65536) {
            throw new IllegalArgumentException();
        }
        checkData(z11, i11, sArr, i12, i13);
    }

    public static void checkCipher(BlockCipher blockCipher) {
        if (16 != blockCipher.getBlockSize()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkData(boolean z11, int i11, byte[] bArr, int i12, int i13) {
        checkLength(z11, i11, i13);
        int i14 = 0;
        while (i14 < i13) {
            if ((bArr[i12 + i14] & 255) < i11) {
                i14++;
            } else {
                throw new IllegalArgumentException("input data outside of radix");
            }
        }
    }

    public static void checkData(boolean z11, int i11, short[] sArr, int i12, int i13) {
        checkLength(z11, i11, i13);
        int i14 = 0;
        while (i14 < i13) {
            if ((sArr[i12 + i14] & Constants.PROTOCOL_NONE) < i11) {
                i14++;
            } else {
                throw new IllegalArgumentException("input data outside of radix");
            }
        }
    }

    private static void checkLength(boolean z11, int i11, int i12) {
        int floor;
        if (i12 >= 2) {
            double d11 = (double) i11;
            if (Math.pow(d11, (double) i12) >= 1000000.0d) {
                if (!z11 && i12 > (floor = ((int) Math.floor(Math.log(TWO_TO_96) / Math.log(d11))) * 2)) {
                    throw new IllegalArgumentException("maximum input length is " + floor);
                }
                return;
            }
        }
        throw new IllegalArgumentException("input too short");
    }

    public static short[] decFF1(BlockCipher blockCipher, int i11, byte[] bArr, int i12, int i13, int i14, short[] sArr, short[] sArr2) {
        int i15 = i11;
        int i16 = i12;
        int i17 = i13;
        int i18 = i14;
        int length = bArr.length;
        int ceil = (((int) Math.ceil((Math.log((double) i15) * ((double) i18)) / LOG2)) + 7) / 8;
        int i19 = (((ceil + 3) / 4) * 4) + 4;
        byte[] calculateP_FF1 = calculateP_FF1(i15, (byte) i17, i16, length);
        BigInteger valueOf = BigInteger.valueOf((long) i15);
        BigInteger[] calculateModUV = calculateModUV(valueOf, i17, i18);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i21 = i17;
        int i22 = 9;
        while (i22 >= 0) {
            short[] sArr5 = sArr4;
            i21 = i16 - i21;
            str(valueOf, num(valueOf, sArr5).subtract(calculateY_FF1(blockCipher, valueOf, bArr, ceil, i19, i22, calculateP_FF1, sArr3)).mod(calculateModUV[i22 & 1]), i21, sArr5, 0);
            i22--;
            sArr4 = sArr3;
            sArr3 = sArr5;
            byte[] bArr2 = bArr;
        }
        return Arrays.concatenate(sArr3, sArr4);
    }

    private static short[] decFF3_1(BlockCipher blockCipher, int i11, byte[] bArr, int i12, int i13, int i14, short[] sArr, short[] sArr2) {
        BigInteger valueOf = BigInteger.valueOf((long) i11);
        int i15 = i14;
        BigInteger[] calculateModUV = calculateModUV(valueOf, i13, i15);
        rev(sArr);
        rev(sArr2);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i16 = 7;
        while (i16 >= 0) {
            int i17 = i12 - i15;
            int i18 = i16 & 1;
            str(valueOf, num(valueOf, sArr4).subtract(calculateY_FF3(blockCipher, valueOf, bArr, 4 - (i18 * 4), i16, sArr3)).mod(calculateModUV[1 - i18]), i17, sArr4, 0);
            i16--;
            i15 = i17;
            short[] sArr5 = sArr4;
            sArr4 = sArr3;
            sArr3 = sArr5;
        }
        rev(sArr3);
        rev(sArr4);
        return Arrays.concatenate(sArr3, sArr4);
    }

    public static byte[] decryptFF1(BlockCipher blockCipher, int i11, byte[] bArr, byte[] bArr2, int i12, int i13) {
        int i14 = i13;
        checkArgs(blockCipher, true, i11, bArr2, i12, i14);
        int i15 = i13 / 2;
        int i16 = i13 - i15;
        return toByte(decFF1(blockCipher, i11, bArr, i14, i15, i16, toShort(bArr2, i12, i15), toShort(bArr2, i12 + i15, i16)));
    }

    public static short[] decryptFF1w(BlockCipher blockCipher, int i11, byte[] bArr, short[] sArr, int i12, int i13) {
        int i14 = i13;
        checkArgs(blockCipher, true, i11, sArr, i12, i14);
        int i15 = i13 / 2;
        int i16 = i13 - i15;
        short[] sArr2 = new short[i15];
        short[] sArr3 = new short[i16];
        System.arraycopy(sArr, i12, sArr2, 0, i15);
        System.arraycopy(sArr, i12 + i15, sArr3, 0, i16);
        return decFF1(blockCipher, i11, bArr, i14, i15, i16, sArr2, sArr3);
    }

    public static byte[] decryptFF3(BlockCipher blockCipher, int i11, byte[] bArr, byte[] bArr2, int i12, int i13) {
        checkArgs(blockCipher, false, i11, bArr2, i12, i13);
        if (bArr.length == 8) {
            return implDecryptFF3(blockCipher, i11, bArr, bArr2, i12, i13);
        }
        throw new IllegalArgumentException();
    }

    public static byte[] decryptFF3_1(BlockCipher blockCipher, int i11, byte[] bArr, byte[] bArr2, int i12, int i13) {
        checkArgs(blockCipher, false, i11, bArr2, i12, i13);
        if (bArr.length == 7) {
            return implDecryptFF3(blockCipher, i11, calculateTweak64_FF3_1(bArr), bArr2, i12, i13);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    public static short[] decryptFF3_1w(BlockCipher blockCipher, int i11, byte[] bArr, short[] sArr, int i12, int i13) {
        checkArgs(blockCipher, false, i11, sArr, i12, i13);
        if (bArr.length == 7) {
            return implDecryptFF3w(blockCipher, i11, calculateTweak64_FF3_1(bArr), sArr, i12, i13);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    private static short[] encFF1(BlockCipher blockCipher, int i11, byte[] bArr, int i12, int i13, int i14, short[] sArr, short[] sArr2) {
        int i15 = i11;
        int i16 = i12;
        int i17 = i13;
        int i18 = i14;
        int length = bArr.length;
        int ceil = (((int) Math.ceil((Math.log((double) i15) * ((double) i18)) / LOG2)) + 7) / 8;
        int i19 = (((ceil + 3) / 4) * 4) + 4;
        byte[] calculateP_FF1 = calculateP_FF1(i15, (byte) i17, i16, length);
        BigInteger valueOf = BigInteger.valueOf((long) i15);
        BigInteger[] calculateModUV = calculateModUV(valueOf, i17, i18);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i21 = i18;
        int i22 = 0;
        while (i22 < 10) {
            int i23 = i22;
            short[] sArr5 = sArr3;
            sArr3 = sArr4;
            BigInteger calculateY_FF1 = calculateY_FF1(blockCipher, valueOf, bArr, ceil, i19, i22, calculateP_FF1, sArr3);
            int i24 = i16 - i21;
            str(valueOf, num(valueOf, sArr5).add(calculateY_FF1).mod(calculateModUV[i23 & 1]), i24, sArr5, 0);
            i22 = i23 + 1;
            i21 = i24;
            sArr4 = sArr5;
        }
        return Arrays.concatenate(sArr3, sArr4);
    }

    private static short[] encFF3_1(BlockCipher blockCipher, int i11, byte[] bArr, int i12, int i13, int i14, short[] sArr, short[] sArr2) {
        BigInteger valueOf = BigInteger.valueOf((long) i11);
        int i15 = i13;
        BigInteger[] calculateModUV = calculateModUV(valueOf, i15, i14);
        rev(sArr);
        rev(sArr2);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i16 = 0;
        while (i16 < 8) {
            i15 = i12 - i15;
            int i17 = i16 & 1;
            str(valueOf, num(valueOf, sArr3).add(calculateY_FF3(blockCipher, valueOf, bArr, 4 - (i17 * 4), i16, sArr4)).mod(calculateModUV[1 - i17]), i15, sArr3, 0);
            i16++;
            short[] sArr5 = sArr4;
            sArr4 = sArr3;
            sArr3 = sArr5;
        }
        rev(sArr3);
        rev(sArr4);
        return Arrays.concatenate(sArr3, sArr4);
    }

    public static byte[] encryptFF1(BlockCipher blockCipher, int i11, byte[] bArr, byte[] bArr2, int i12, int i13) {
        int i14 = i13;
        checkArgs(blockCipher, true, i11, bArr2, i12, i14);
        int i15 = i13 / 2;
        int i16 = i13 - i15;
        return toByte(encFF1(blockCipher, i11, bArr, i14, i15, i16, toShort(bArr2, i12, i15), toShort(bArr2, i12 + i15, i16)));
    }

    public static short[] encryptFF1w(BlockCipher blockCipher, int i11, byte[] bArr, short[] sArr, int i12, int i13) {
        int i14 = i13;
        checkArgs(blockCipher, true, i11, sArr, i12, i14);
        int i15 = i13 / 2;
        int i16 = i13 - i15;
        short[] sArr2 = new short[i15];
        short[] sArr3 = new short[i16];
        System.arraycopy(sArr, i12, sArr2, 0, i15);
        System.arraycopy(sArr, i12 + i15, sArr3, 0, i16);
        return encFF1(blockCipher, i11, bArr, i14, i15, i16, sArr2, sArr3);
    }

    public static byte[] encryptFF3(BlockCipher blockCipher, int i11, byte[] bArr, byte[] bArr2, int i12, int i13) {
        checkArgs(blockCipher, false, i11, bArr2, i12, i13);
        if (bArr.length == 8) {
            return implEncryptFF3(blockCipher, i11, bArr, bArr2, i12, i13);
        }
        throw new IllegalArgumentException();
    }

    public static byte[] encryptFF3_1(BlockCipher blockCipher, int i11, byte[] bArr, byte[] bArr2, int i12, int i13) {
        checkArgs(blockCipher, false, i11, bArr2, i12, i13);
        if (bArr.length == 7) {
            return encryptFF3(blockCipher, i11, calculateTweak64_FF3_1(bArr), bArr2, i12, i13);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    public static short[] encryptFF3_1w(BlockCipher blockCipher, int i11, byte[] bArr, short[] sArr, int i12, int i13) {
        checkArgs(blockCipher, false, i11, sArr, i12, i13);
        if (bArr.length == 7) {
            return encryptFF3w(blockCipher, i11, calculateTweak64_FF3_1(bArr), sArr, i12, i13);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    public static short[] encryptFF3w(BlockCipher blockCipher, int i11, byte[] bArr, short[] sArr, int i12, int i13) {
        checkArgs(blockCipher, false, i11, sArr, i12, i13);
        if (bArr.length == 8) {
            return implEncryptFF3w(blockCipher, i11, bArr, sArr, i12, i13);
        }
        throw new IllegalArgumentException();
    }

    public static byte[] implDecryptFF3(BlockCipher blockCipher, int i11, byte[] bArr, byte[] bArr2, int i12, int i13) {
        int i14 = i13 / 2;
        int i15 = i13 - i14;
        return toByte(decFF3_1(blockCipher, i11, bArr, i13, i14, i15, toShort(bArr2, i12, i15), toShort(bArr2, i12 + i15, i14)));
    }

    public static short[] implDecryptFF3w(BlockCipher blockCipher, int i11, byte[] bArr, short[] sArr, int i12, int i13) {
        int i14 = i13 / 2;
        int i15 = i13 - i14;
        short[] sArr2 = new short[i15];
        short[] sArr3 = new short[i14];
        System.arraycopy(sArr, i12, sArr2, 0, i15);
        System.arraycopy(sArr, i12 + i15, sArr3, 0, i14);
        return decFF3_1(blockCipher, i11, bArr, i13, i14, i15, sArr2, sArr3);
    }

    public static byte[] implEncryptFF3(BlockCipher blockCipher, int i11, byte[] bArr, byte[] bArr2, int i12, int i13) {
        int i14 = i13 / 2;
        int i15 = i13 - i14;
        return toByte(encFF3_1(blockCipher, i11, bArr, i13, i14, i15, toShort(bArr2, i12, i15), toShort(bArr2, i12 + i15, i14)));
    }

    public static short[] implEncryptFF3w(BlockCipher blockCipher, int i11, byte[] bArr, short[] sArr, int i12, int i13) {
        int i14 = i13 / 2;
        int i15 = i13 - i14;
        short[] sArr2 = new short[i15];
        short[] sArr3 = new short[i14];
        System.arraycopy(sArr, i12, sArr2, 0, i15);
        System.arraycopy(sArr, i12 + i15, sArr3, 0, i14);
        return encFF3_1(blockCipher, i11, bArr, i13, i14, i15, sArr2, sArr3);
    }

    public static BigInteger num(BigInteger bigInteger, short[] sArr) {
        BigInteger bigInteger2 = BigIntegers.ZERO;
        for (short s11 : sArr) {
            bigInteger2 = bigInteger2.multiply(bigInteger).add(BigInteger.valueOf((long) (s11 & Constants.PROTOCOL_NONE)));
        }
        return bigInteger2;
    }

    public static BigInteger num(byte[] bArr, int i11, int i12) {
        return new BigInteger(1, Arrays.copyOfRange(bArr, i11, i12 + i11));
    }

    public static byte[] prf(BlockCipher blockCipher, byte[] bArr) {
        if (bArr.length % 16 == 0) {
            int length = bArr.length / 16;
            byte[] bArr2 = new byte[16];
            for (int i11 = 0; i11 < length; i11++) {
                xor(bArr, i11 * 16, bArr2, 0, 16);
                blockCipher.processBlock(bArr2, 0, bArr2, 0);
            }
            return bArr2;
        }
        throw new IllegalArgumentException();
    }

    public static void rev(byte[] bArr) {
        int length = bArr.length / 2;
        int length2 = bArr.length - 1;
        for (int i11 = 0; i11 < length; i11++) {
            byte b11 = bArr[i11];
            int i12 = length2 - i11;
            bArr[i11] = bArr[i12];
            bArr[i12] = b11;
        }
    }

    public static void rev(short[] sArr) {
        int length = sArr.length / 2;
        int length2 = sArr.length - 1;
        for (int i11 = 0; i11 < length; i11++) {
            short s11 = sArr[i11];
            int i12 = length2 - i11;
            sArr[i11] = sArr[i12];
            sArr[i12] = s11;
        }
    }

    public static void str(BigInteger bigInteger, BigInteger bigInteger2, int i11, short[] sArr, int i12) {
        if (bigInteger2.signum() >= 0) {
            for (int i13 = 1; i13 <= i11; i13++) {
                BigInteger[] divideAndRemainder = bigInteger2.divideAndRemainder(bigInteger);
                sArr[(i12 + i11) - i13] = (short) divideAndRemainder[1].intValue();
                bigInteger2 = divideAndRemainder[0];
            }
            if (bigInteger2.signum() != 0) {
                throw new IllegalArgumentException();
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    private static byte[] toByte(short[] sArr) {
        int length = sArr.length;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 != length; i11++) {
            bArr[i11] = (byte) sArr[i11];
        }
        return bArr;
    }

    private static short[] toShort(byte[] bArr, int i11, int i12) {
        short[] sArr = new short[i12];
        for (int i13 = 0; i13 != i12; i13++) {
            sArr[i13] = (short) (bArr[i11 + i13] & 255);
        }
        return sArr;
    }

    public static void xor(byte[] bArr, int i11, byte[] bArr2, int i12, int i13) {
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = i12 + i14;
            bArr2[i15] = (byte) (bArr2[i15] ^ bArr[i11 + i14]);
        }
    }
}
