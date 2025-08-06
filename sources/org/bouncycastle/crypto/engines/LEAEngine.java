package org.bouncycastle.crypto.engines;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class LEAEngine implements BlockCipher {
    private static final int BASEROUNDS = 16;
    private static final int BLOCKSIZE = 16;
    private static final int[] DELTA = {-1007687205, 1147300610, 2044886154, 2027892972, 1902027934, -947529206, -531697110, -440137385};
    private static final int KEY0 = 0;
    private static final int KEY1 = 1;
    private static final int KEY2 = 2;
    private static final int KEY3 = 3;
    private static final int KEY4 = 4;
    private static final int KEY5 = 5;
    private static final int MASK128 = 3;
    private static final int MASK256 = 7;
    private static final int NUMWORDS = 4;
    private static final int NUMWORDS128 = 4;
    private static final int NUMWORDS192 = 6;
    private static final int NUMWORDS256 = 8;
    private static final int ROT1 = 1;
    private static final int ROT11 = 11;
    private static final int ROT13 = 13;
    private static final int ROT17 = 17;
    private static final int ROT3 = 3;
    private static final int ROT5 = 5;
    private static final int ROT6 = 6;
    private static final int ROT9 = 9;
    private boolean forEncryption;
    private final int[] theBlock = new int[4];
    private int[][] theRoundKeys;
    private int theRounds;

    private static int bufLength(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    private static void checkBuffer(byte[] bArr, int i11, boolean z11) {
        int bufLength = bufLength(bArr);
        int i12 = i11 + 16;
        if ((i11 < 0 || i12 < 0) || i12 > bufLength) {
            throw (z11 ? new OutputLengthException("Output buffer too short.") : new DataLengthException("Input buffer too short."));
        }
    }

    private int decryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        Pack.littleEndianToInt(bArr, i11, this.theBlock, 0, 4);
        for (int i13 = this.theRounds - 1; i13 >= 0; i13--) {
            decryptRound(i13);
        }
        Pack.intToLittleEndian(this.theBlock, bArr2, i12);
        return 16;
    }

    private void decryptRound(int i11) {
        int[] iArr = this.theRoundKeys[i11];
        int i12 = i11 % 4;
        int rightIndex = rightIndex(i12);
        int[] iArr2 = this.theBlock;
        iArr2[rightIndex] = iArr[1] ^ (ror32(iArr2[rightIndex], 9) - (this.theBlock[i12] ^ iArr[0]));
        int rightIndex2 = rightIndex(rightIndex);
        int[] iArr3 = this.theBlock;
        iArr3[rightIndex2] = (rol32(iArr3[rightIndex2], 5) - (this.theBlock[rightIndex] ^ iArr[2])) ^ iArr[3];
        int rightIndex3 = rightIndex(rightIndex2);
        int[] iArr4 = this.theBlock;
        iArr4[rightIndex3] = iArr[5] ^ (rol32(iArr4[rightIndex3], 3) - (this.theBlock[rightIndex2] ^ iArr[4]));
    }

    private int encryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        Pack.littleEndianToInt(bArr, i11, this.theBlock, 0, 4);
        for (int i13 = 0; i13 < this.theRounds; i13++) {
            encryptRound(i13);
        }
        Pack.intToLittleEndian(this.theBlock, bArr2, i12);
        return 16;
    }

    private void encryptRound(int i11) {
        int[] iArr = this.theRoundKeys[i11];
        int i12 = (i11 + 3) % 4;
        int leftIndex = leftIndex(i12);
        int[] iArr2 = this.theBlock;
        iArr2[i12] = ror32((iArr[4] ^ iArr2[leftIndex]) + (iArr2[i12] ^ iArr[5]), 3);
        int leftIndex2 = leftIndex(leftIndex);
        int[] iArr3 = this.theBlock;
        iArr3[leftIndex] = ror32((iArr3[leftIndex2] ^ iArr[2]) + (iArr[3] ^ iArr3[leftIndex]), 5);
        int leftIndex3 = leftIndex(leftIndex2);
        int[] iArr4 = this.theBlock;
        iArr4[leftIndex2] = rol32((iArr4[leftIndex3] ^ iArr[0]) + (iArr[1] ^ iArr4[leftIndex2]), 9);
    }

    private void generate128RoundKeys(int[] iArr) {
        for (int i11 = 0; i11 < this.theRounds; i11++) {
            int rol32 = rol32(DELTA[i11 & 3], i11);
            iArr[0] = rol32(iArr[0] + rol32, 1);
            iArr[1] = rol32(iArr[1] + rol32(rol32, 1), 3);
            iArr[2] = rol32(iArr[2] + rol32(rol32, 2), 6);
            iArr[3] = rol32(iArr[3] + rol32(rol32, 3), 11);
            int[] iArr2 = this.theRoundKeys[i11];
            iArr2[0] = iArr[0];
            iArr2[1] = iArr[1];
            iArr2[2] = iArr[2];
            iArr2[3] = iArr[1];
            iArr2[4] = iArr[3];
            iArr2[5] = iArr[1];
        }
    }

    private void generate192RoundKeys(int[] iArr) {
        for (int i11 = 0; i11 < this.theRounds; i11++) {
            int rol32 = rol32(DELTA[i11 % 6], i11);
            iArr[0] = rol32(iArr[0] + rol32(rol32, 0), 1);
            iArr[1] = rol32(iArr[1] + rol32(rol32, 1), 3);
            iArr[2] = rol32(iArr[2] + rol32(rol32, 2), 6);
            iArr[3] = rol32(iArr[3] + rol32(rol32, 3), 11);
            iArr[4] = rol32(iArr[4] + rol32(rol32, 4), 13);
            iArr[5] = rol32(iArr[5] + rol32(rol32, 5), 17);
            System.arraycopy(iArr, 0, this.theRoundKeys[i11], 0, 6);
        }
    }

    private void generate256RoundKeys(int[] iArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < this.theRounds; i12++) {
            int rol32 = rol32(DELTA[i12 & 7], i12);
            int[] iArr2 = this.theRoundKeys[i12];
            int i13 = i11 & 7;
            iArr2[0] = rol32(iArr[i13] + rol32, 1);
            int i14 = i11 + 1;
            iArr[i13] = iArr2[0];
            int i15 = i14 & 7;
            iArr2[1] = rol32(iArr[i15] + rol32(rol32, 1), 3);
            int i16 = i14 + 1;
            iArr[i15] = iArr2[1];
            int i17 = i16 & 7;
            iArr2[2] = rol32(iArr[i17] + rol32(rol32, 2), 6);
            int i18 = i16 + 1;
            iArr[i17] = iArr2[2];
            int i19 = i18 & 7;
            iArr2[3] = rol32(iArr[i19] + rol32(rol32, 3), 11);
            int i21 = i18 + 1;
            iArr[i19] = iArr2[3];
            int i22 = i21 & 7;
            iArr2[4] = rol32(iArr[i22] + rol32(rol32, 4), 13);
            int i23 = i21 + 1;
            iArr[i22] = iArr2[4];
            int i24 = i23 & 7;
            iArr2[5] = rol32(iArr[i24] + rol32(rol32, 5), 17);
            i11 = i23 + 1;
            iArr[i24] = iArr2[5];
        }
    }

    private void generateRoundKeys(byte[] bArr) {
        int length = (bArr.length >> 1) + 16;
        this.theRounds = length;
        int[] iArr = new int[2];
        iArr[1] = 6;
        iArr[0] = length;
        this.theRoundKeys = (int[][]) Array.newInstance(int.class, iArr);
        int length2 = bArr.length / 4;
        int[] iArr2 = new int[length2];
        Pack.littleEndianToInt(bArr, 0, iArr2, 0, length2);
        if (length2 == 4) {
            generate128RoundKeys(iArr2);
        } else if (length2 != 6) {
            generate256RoundKeys(iArr2);
        } else {
            generate192RoundKeys(iArr2);
        }
    }

    private static int leftIndex(int i11) {
        if (i11 == 0) {
            return 3;
        }
        return i11 - 1;
    }

    private static int rightIndex(int i11) {
        if (i11 == 3) {
            return 0;
        }
        return i11 + 1;
    }

    private static int rol32(int i11, int i12) {
        return (i11 >>> (32 - i12)) | (i11 << i12);
    }

    private static int ror32(int i11, int i12) {
        return (i11 << (32 - i12)) | (i11 >>> i12);
    }

    public String getAlgorithmName() {
        return "LEA";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            int length = key.length;
            if ((length << 1) % 16 != 0 || length < 16 || length > 32) {
                throw new IllegalArgumentException("KeyBitSize must be 128, 192 or 256");
            }
            this.forEncryption = z11;
            generateRoundKeys(key);
            return;
        }
        throw new IllegalArgumentException("Invalid parameter passed to LEA init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        checkBuffer(bArr, i11, false);
        checkBuffer(bArr2, i12, true);
        return this.forEncryption ? encryptBlock(bArr, i11, bArr2, i12) : decryptBlock(bArr, i11, bArr2, i12);
    }

    public void reset() {
    }
}
