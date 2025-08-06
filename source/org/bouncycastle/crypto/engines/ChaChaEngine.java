package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

public class ChaChaEngine extends Salsa20Engine {
    public ChaChaEngine() {
    }

    public ChaChaEngine(int i11) {
        super(i11);
    }

    public static void chachaCore(int i11, int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i12 = 16;
        if (iArr3.length != 16) {
            throw new IllegalArgumentException();
        } else if (iArr4.length != 16) {
            throw new IllegalArgumentException();
        } else if (i11 % 2 == 0) {
            char c11 = 0;
            int i13 = iArr3[0];
            int i14 = iArr3[1];
            int i15 = iArr3[2];
            int i16 = iArr3[3];
            int i17 = iArr3[4];
            int i18 = iArr3[5];
            int i19 = iArr3[6];
            int i21 = 7;
            int i22 = iArr3[7];
            int i23 = 8;
            int i24 = iArr3[8];
            int i25 = iArr3[9];
            int i26 = iArr3[10];
            int i27 = iArr3[11];
            int i28 = 12;
            int i29 = iArr3[12];
            int i30 = iArr3[13];
            int i31 = iArr3[14];
            int i32 = iArr3[15];
            int i33 = i31;
            int i34 = i30;
            int i35 = i29;
            int i36 = i27;
            int i37 = i26;
            int i38 = i25;
            int i39 = i24;
            int i40 = i22;
            int i41 = i19;
            int i42 = i18;
            int i43 = i17;
            int i44 = i16;
            int i45 = i15;
            int i46 = i14;
            int i47 = i13;
            int i48 = i11;
            while (i48 > 0) {
                int i49 = i47 + i43;
                int rotateLeft = Integers.rotateLeft(i35 ^ i49, i12);
                int i50 = i39 + rotateLeft;
                int rotateLeft2 = Integers.rotateLeft(i43 ^ i50, i28);
                int i51 = i49 + rotateLeft2;
                int rotateLeft3 = Integers.rotateLeft(rotateLeft ^ i51, i23);
                int i52 = i50 + rotateLeft3;
                int rotateLeft4 = Integers.rotateLeft(rotateLeft2 ^ i52, i21);
                int i53 = i46 + i42;
                int rotateLeft5 = Integers.rotateLeft(i34 ^ i53, i12);
                int i54 = i38 + rotateLeft5;
                int rotateLeft6 = Integers.rotateLeft(i42 ^ i54, i28);
                int i55 = i53 + rotateLeft6;
                int rotateLeft7 = Integers.rotateLeft(rotateLeft5 ^ i55, i23);
                int i56 = i54 + rotateLeft7;
                int rotateLeft8 = Integers.rotateLeft(rotateLeft6 ^ i56, i21);
                int i57 = i45 + i41;
                int rotateLeft9 = Integers.rotateLeft(i33 ^ i57, i12);
                int i58 = i37 + rotateLeft9;
                int rotateLeft10 = Integers.rotateLeft(i41 ^ i58, i28);
                int i59 = i57 + rotateLeft10;
                int rotateLeft11 = Integers.rotateLeft(rotateLeft9 ^ i59, i23);
                int i60 = i58 + rotateLeft11;
                int rotateLeft12 = Integers.rotateLeft(rotateLeft10 ^ i60, i21);
                int i61 = i44 + i40;
                int rotateLeft13 = Integers.rotateLeft(i32 ^ i61, 16);
                int i62 = i36 + rotateLeft13;
                int rotateLeft14 = Integers.rotateLeft(i40 ^ i62, i28);
                int i63 = i61 + rotateLeft14;
                int rotateLeft15 = Integers.rotateLeft(rotateLeft13 ^ i63, 8);
                int i64 = i62 + rotateLeft15;
                int rotateLeft16 = Integers.rotateLeft(rotateLeft14 ^ i64, 7);
                int i65 = i51 + rotateLeft8;
                int rotateLeft17 = Integers.rotateLeft(rotateLeft15 ^ i65, 16);
                int i66 = i60 + rotateLeft17;
                int rotateLeft18 = Integers.rotateLeft(rotateLeft8 ^ i66, 12);
                i47 = i65 + rotateLeft18;
                i32 = Integers.rotateLeft(rotateLeft17 ^ i47, 8);
                i37 = i66 + i32;
                i42 = Integers.rotateLeft(rotateLeft18 ^ i37, 7);
                int i67 = i55 + rotateLeft12;
                int rotateLeft19 = Integers.rotateLeft(rotateLeft3 ^ i67, 16);
                int i68 = i64 + rotateLeft19;
                int rotateLeft20 = Integers.rotateLeft(rotateLeft12 ^ i68, 12);
                i46 = i67 + rotateLeft20;
                i35 = Integers.rotateLeft(rotateLeft19 ^ i46, 8);
                i36 = i68 + i35;
                i41 = Integers.rotateLeft(rotateLeft20 ^ i36, 7);
                int i69 = i59 + rotateLeft16;
                int rotateLeft21 = Integers.rotateLeft(rotateLeft7 ^ i69, 16);
                int i70 = i52 + rotateLeft21;
                int rotateLeft22 = Integers.rotateLeft(rotateLeft16 ^ i70, 12);
                i45 = i69 + rotateLeft22;
                i34 = Integers.rotateLeft(rotateLeft21 ^ i45, 8);
                i39 = i70 + i34;
                i40 = Integers.rotateLeft(rotateLeft22 ^ i39, 7);
                int i71 = i63 + rotateLeft4;
                i12 = 16;
                int rotateLeft23 = Integers.rotateLeft(rotateLeft11 ^ i71, 16);
                int i72 = i56 + rotateLeft23;
                int rotateLeft24 = Integers.rotateLeft(rotateLeft4 ^ i72, 12);
                i44 = i71 + rotateLeft24;
                i33 = Integers.rotateLeft(rotateLeft23 ^ i44, 8);
                i38 = i72 + i33;
                i43 = Integers.rotateLeft(rotateLeft24 ^ i38, 7);
                i48 -= 2;
                c11 = 0;
                i28 = 12;
                i23 = 8;
                i21 = 7;
            }
            iArr4[c11] = i47 + iArr3[c11];
            iArr4[1] = i46 + iArr3[1];
            iArr4[2] = i45 + iArr3[2];
            iArr4[3] = i44 + iArr3[3];
            iArr4[4] = i43 + iArr3[4];
            iArr4[5] = i42 + iArr3[5];
            iArr4[6] = i41 + iArr3[6];
            iArr4[7] = i40 + iArr3[7];
            iArr4[8] = i39 + iArr3[8];
            iArr4[9] = i38 + iArr3[9];
            iArr4[10] = i37 + iArr3[10];
            iArr4[11] = i36 + iArr3[11];
            iArr4[12] = i35 + iArr3[12];
            iArr4[13] = i34 + iArr3[13];
            iArr4[14] = i33 + iArr3[14];
            iArr4[15] = i32 + iArr3[15];
        } else {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
    }

    public void advanceCounter() {
        int[] iArr = this.engineState;
        int i11 = iArr[12] + 1;
        iArr[12] = i11;
        if (i11 == 0) {
            iArr[13] = iArr[13] + 1;
        }
    }

    public void advanceCounter(long j11) {
        int i11 = (int) (j11 >>> 32);
        int i12 = (int) j11;
        if (i11 > 0) {
            int[] iArr = this.engineState;
            iArr[13] = iArr[13] + i11;
        }
        int[] iArr2 = this.engineState;
        int i13 = iArr2[12];
        iArr2[12] = iArr2[12] + i12;
        if (i13 != 0 && iArr2[12] < i13) {
            iArr2[13] = iArr2[13] + 1;
        }
    }

    public void generateKeyStream(byte[] bArr) {
        chachaCore(this.rounds, this.engineState, this.f59185x);
        Pack.intToLittleEndian(this.f59185x, bArr, 0);
    }

    public String getAlgorithmName() {
        return "ChaCha" + this.rounds;
    }

    public long getCounter() {
        int[] iArr = this.engineState;
        return (((long) iArr[13]) << 32) | (((long) iArr[12]) & 4294967295L);
    }

    public void resetCounter() {
        int[] iArr = this.engineState;
        iArr[13] = 0;
        iArr[12] = 0;
    }

    public void retreatCounter() {
        int[] iArr = this.engineState;
        if (iArr[12] == 0 && iArr[13] == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int i11 = iArr[12] - 1;
        iArr[12] = i11;
        if (i11 == -1) {
            iArr[13] = iArr[13] - 1;
        }
    }

    public void retreatCounter(long j11) {
        int i11 = (int) (j11 >>> 32);
        int i12 = (int) j11;
        if (i11 != 0) {
            int[] iArr = this.engineState;
            if ((((long) iArr[13]) & 4294967295L) >= (((long) i11) & 4294967295L)) {
                iArr[13] = iArr[13] - i11;
            } else {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        int[] iArr2 = this.engineState;
        if ((((long) iArr2[12]) & 4294967295L) >= (4294967295L & ((long) i12))) {
            iArr2[12] = iArr2[12] - i12;
        } else if (iArr2[13] != 0) {
            iArr2[13] = iArr2[13] - 1;
            iArr2[12] = iArr2[12] - i12;
        } else {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
    }

    public void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length == 16 || bArr.length == 32) {
                packTauOrSigma(bArr.length, this.engineState, 0);
                Pack.littleEndianToInt(bArr, 0, this.engineState, 4, 4);
                Pack.littleEndianToInt(bArr, bArr.length - 16, this.engineState, 8, 4);
            } else {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 128 bit or 256 bit key");
            }
        }
        Pack.littleEndianToInt(bArr2, 0, this.engineState, 14, 2);
    }
}
