package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.engines.Salsa20Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

public class SCrypt {
    private SCrypt() {
    }

    private static void BlockMix(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i11) {
        System.arraycopy(iArr, iArr.length - 16, iArr2, 0, 16);
        int length = iArr.length >>> 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = i11 * 2; i14 > 0; i14--) {
            Xor(iArr2, iArr, i12, iArr3);
            Salsa20Engine.salsaCore(8, iArr3, iArr2);
            System.arraycopy(iArr2, 0, iArr4, i13, 16);
            i13 = (length + i12) - i13;
            i12 += 16;
        }
    }

    private static void Clear(byte[] bArr) {
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
    }

    private static void Clear(int[] iArr) {
        if (iArr != null) {
            Arrays.fill(iArr, 0);
        }
    }

    private static void ClearAll(int[][] iArr) {
        for (int[] Clear : iArr) {
            Clear(Clear);
        }
    }

    private static byte[] MFcrypt(byte[] bArr, byte[] bArr2, int i11, int i12, int i13, int i14) {
        int i15 = i12 * 128;
        byte[] SingleIterationPBKDF2 = SingleIterationPBKDF2(bArr, bArr2, i13 * i15);
        int[] iArr = null;
        try {
            int length = SingleIterationPBKDF2.length >>> 2;
            iArr = new int[length];
            Pack.littleEndianToInt(SingleIterationPBKDF2, 0, iArr);
            int i16 = i11 * i12;
            int i17 = 0;
            while (i11 - i17 > 2 && i16 > 1024) {
                i17++;
                i16 >>>= 1;
            }
            int i18 = i15 >>> 2;
            for (int i19 = 0; i19 < length; i19 += i18) {
                SMix(iArr, i19, i11, i17, i12);
            }
            Pack.intToLittleEndian(iArr, SingleIterationPBKDF2, 0);
            return SingleIterationPBKDF2(bArr, SingleIterationPBKDF2, i14);
        } finally {
            Clear(SingleIterationPBKDF2);
            Clear(iArr);
        }
    }

    private static void SMix(int[] iArr, int i11, int i12, int i13, int i14) {
        int[] iArr2 = iArr;
        int i15 = i11;
        int i16 = i12;
        int i17 = i14;
        int i18 = i16 >>> i13;
        int i19 = 1 << i13;
        int i21 = i18 - 1;
        int numberOfTrailingZeros = Integers.numberOfTrailingZeros(i12) - i13;
        int i22 = i17 * 32;
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[i22];
        int[] iArr6 = new int[i22];
        int[][] iArr7 = new int[i19][];
        try {
            System.arraycopy(iArr2, i15, iArr6, 0, i22);
            int i23 = 0;
            while (i23 < i19) {
                int[] iArr8 = new int[(i18 * i22)];
                iArr7[i23] = iArr8;
                int i24 = i19;
                int i25 = 0;
                int i26 = 0;
                while (i26 < i18) {
                    System.arraycopy(iArr6, 0, iArr8, i25, i22);
                    int i27 = i25 + i22;
                    BlockMix(iArr6, iArr3, iArr4, iArr5, i17);
                    System.arraycopy(iArr5, 0, iArr8, i27, i22);
                    i25 = i27 + i22;
                    BlockMix(iArr5, iArr3, iArr4, iArr6, i17);
                    i26 += 2;
                    i18 = i18;
                }
                int i28 = i18;
                i23++;
                int[] iArr9 = iArr;
                i19 = i24;
            }
            int i29 = i16 - 1;
            for (int i30 = 0; i30 < i16; i30++) {
                int i31 = iArr6[i22 - 16] & i29;
                System.arraycopy(iArr7[i31 >>> numberOfTrailingZeros], (i31 & i21) * i22, iArr5, 0, i22);
                Xor(iArr5, iArr6, 0, iArr5);
                BlockMix(iArr5, iArr3, iArr4, iArr6, i17);
            }
            System.arraycopy(iArr6, 0, iArr, i15, i22);
            ClearAll(iArr7);
            ClearAll(new int[][]{iArr6, iArr3, iArr4, iArr5});
        } catch (Throwable th2) {
            ClearAll(iArr7);
            ClearAll(new int[][]{iArr6, iArr3, iArr4, iArr5});
            throw th2;
        }
    }

    private static byte[] SingleIterationPBKDF2(byte[] bArr, byte[] bArr2, int i11) {
        PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(new SHA256Digest());
        pKCS5S2ParametersGenerator.init(bArr, bArr2, 1);
        return ((KeyParameter) pKCS5S2ParametersGenerator.generateDerivedMacParameters(i11 * 8)).getKey();
    }

    private static void Xor(int[] iArr, int[] iArr2, int i11, int[] iArr3) {
        for (int length = iArr3.length - 1; length >= 0; length--) {
            iArr3[length] = iArr[length] ^ iArr2[i11 + length];
        }
    }

    public static byte[] generate(byte[] bArr, byte[] bArr2, int i11, int i12, int i13, int i14) {
        if (bArr == null) {
            throw new IllegalArgumentException("Passphrase P must be provided.");
        } else if (bArr2 == null) {
            throw new IllegalArgumentException("Salt S must be provided.");
        } else if (i11 <= 1 || !isPowerOf2(i11)) {
            throw new IllegalArgumentException("Cost parameter N must be > 1 and a power of 2");
        } else if (i12 == 1 && i11 >= 65536) {
            throw new IllegalArgumentException("Cost parameter N must be > 1 and < 65536.");
        } else if (i12 >= 1) {
            int i15 = Integer.MAX_VALUE / ((i12 * 128) * 8);
            if (i13 < 1 || i13 > i15) {
                throw new IllegalArgumentException("Parallelisation parameter p must be >= 1 and <= " + i15 + " (based on block size r of " + i12 + ")");
            } else if (i14 >= 1) {
                return MFcrypt(bArr, bArr2, i11, i12, i13, i14);
            } else {
                throw new IllegalArgumentException("Generated key length dkLen must be >= 1.");
            }
        } else {
            throw new IllegalArgumentException("Block size r must be >= 1.");
        }
    }

    private static boolean isPowerOf2(int i11) {
        return (i11 & (i11 + -1)) == 0;
    }
}
