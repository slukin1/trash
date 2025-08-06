package org.bouncycastle.pqc.math.linearalgebra;

import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.common.base.Ascii;
import com.google.common.primitives.Shorts;
import com.huobi.view.roundimg.RoundedDrawable;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaCodecProfileLevel;
import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.util.Arrays;
import org.jmrtd.PassportService;

public class GF2Polynomial {
    private static final int[] bitMask = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, TPMediaCodecProfileLevel.HEVCHighTierLevel62, 67108864, 134217728, 268435456, 536870912, 1073741824, Integer.MIN_VALUE, 0};
    private static final boolean[] parity = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    private static Random rand = new Random();
    private static final int[] reverseRightMask = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, Reduce.RMask, 524287, 1048575, 2097151, 4194303, 8388607, FlexItem.MAX_SIZE, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
    private static final short[] squaringTable = {0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, PassportService.EF_DG1, PassportService.EF_DG4, PassportService.EF_DG5, PassportService.EF_DG16, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, SilenceSkippingAudioProcessor.DEFAULT_SILENCE_THRESHOLD_LEVEL, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, Shorts.MAX_POWER_OF_TWO, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};
    private int blocks;
    private int len;
    private int[] value;

    public GF2Polynomial(int i11) {
        i11 = i11 < 1 ? 1 : i11;
        int i12 = ((i11 - 1) >> 5) + 1;
        this.blocks = i12;
        this.value = new int[i12];
        this.len = i11;
    }

    public GF2Polynomial(int i11, String str) {
        i11 = i11 < 1 ? 1 : i11;
        int i12 = ((i11 - 1) >> 5) + 1;
        this.blocks = i12;
        this.value = new int[i12];
        this.len = i11;
        if (str.equalsIgnoreCase("ZERO")) {
            assignZero();
        } else if (str.equalsIgnoreCase("ONE")) {
            assignOne();
        } else if (str.equalsIgnoreCase("RANDOM")) {
            randomize();
        } else if (str.equalsIgnoreCase("X")) {
            assignX();
        } else if (str.equalsIgnoreCase("ALL")) {
            assignAll();
        } else {
            throw new IllegalArgumentException("Error: GF2Polynomial was called using " + str + " as value!");
        }
    }

    public GF2Polynomial(int i11, BigInteger bigInteger) {
        i11 = i11 < 1 ? 1 : i11;
        int i12 = ((i11 - 1) >> 5) + 1;
        this.blocks = i12;
        this.value = new int[i12];
        this.len = i11;
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] == 0) {
            int length = byteArray.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(byteArray, 1, bArr, 0, length);
            byteArray = bArr;
        }
        int length2 = byteArray.length & 3;
        int length3 = ((byteArray.length - 1) >> 2) + 1;
        for (int i13 = 0; i13 < length2; i13++) {
            int[] iArr = this.value;
            int i14 = length3 - 1;
            iArr[i14] = iArr[i14] | ((byteArray[i13] & 255) << (((length2 - 1) - i13) << 3));
        }
        for (int i15 = 0; i15 <= ((byteArray.length - 4) >> 2); i15++) {
            int length4 = (byteArray.length - 1) - (i15 << 2);
            int[] iArr2 = this.value;
            iArr2[i15] = byteArray[length4] & 255;
            iArr2[i15] = iArr2[i15] | ((byteArray[length4 - 1] << 8) & 65280);
            iArr2[i15] = iArr2[i15] | ((byteArray[length4 - 2] << 16) & 16711680);
            iArr2[i15] = ((byteArray[length4 - 3] << Ascii.CAN) & RoundedDrawable.DEFAULT_BORDER_COLOR) | iArr2[i15];
        }
        int i16 = this.len;
        if ((i16 & 31) != 0) {
            int[] iArr3 = this.value;
            int i17 = this.blocks - 1;
            iArr3[i17] = reverseRightMask[i16 & 31] & iArr3[i17];
        }
        reduceN();
    }

    public GF2Polynomial(int i11, Random random) {
        i11 = i11 < 1 ? 1 : i11;
        int i12 = ((i11 - 1) >> 5) + 1;
        this.blocks = i12;
        this.value = new int[i12];
        this.len = i11;
        randomize(random);
    }

    public GF2Polynomial(int i11, byte[] bArr) {
        int i12;
        i11 = i11 < 1 ? 1 : i11;
        int i13 = ((i11 - 1) >> 5) + 1;
        this.blocks = i13;
        this.value = new int[i13];
        this.len = i11;
        int min = Math.min(((bArr.length - 1) >> 2) + 1, i13);
        int i14 = 0;
        while (true) {
            i12 = min - 1;
            if (i14 >= i12) {
                break;
            }
            int length = (bArr.length - (i14 << 2)) - 1;
            int[] iArr = this.value;
            iArr[i14] = bArr[length] & 255;
            iArr[i14] = (65280 & (bArr[length - 1] << 8)) | iArr[i14];
            iArr[i14] = (16711680 & (bArr[length - 2] << 16)) | iArr[i14];
            iArr[i14] = ((bArr[length - 3] << Ascii.CAN) & RoundedDrawable.DEFAULT_BORDER_COLOR) | iArr[i14];
            i14++;
        }
        int length2 = (bArr.length - (i12 << 2)) - 1;
        int[] iArr2 = this.value;
        iArr2[i12] = bArr[length2] & 255;
        if (length2 > 0) {
            iArr2[i12] = (65280 & (bArr[length2 - 1] << 8)) | iArr2[i12];
        }
        if (length2 > 1) {
            iArr2[i12] = iArr2[i12] | (16711680 & (bArr[length2 - 2] << 16));
        }
        if (length2 > 2) {
            iArr2[i12] = ((bArr[length2 - 3] << Ascii.CAN) & RoundedDrawable.DEFAULT_BORDER_COLOR) | iArr2[i12];
        }
        zeroUnusedBits();
        reduceN();
    }

    public GF2Polynomial(int i11, int[] iArr) {
        i11 = i11 < 1 ? 1 : i11;
        int i12 = ((i11 - 1) >> 5) + 1;
        this.blocks = i12;
        this.value = new int[i12];
        this.len = i11;
        System.arraycopy(iArr, 0, this.value, 0, Math.min(i12, iArr.length));
        zeroUnusedBits();
    }

    public GF2Polynomial(GF2Polynomial gF2Polynomial) {
        this.len = gF2Polynomial.len;
        this.blocks = gF2Polynomial.blocks;
        this.value = IntUtils.clone(gF2Polynomial.value);
    }

    private void doShiftBlocksLeft(int i11) {
        int i12 = this.blocks;
        int[] iArr = this.value;
        if (i12 <= iArr.length) {
            for (int i13 = i12 - 1; i13 >= i11; i13--) {
                int[] iArr2 = this.value;
                iArr2[i13] = iArr2[i13 - i11];
            }
            for (int i14 = 0; i14 < i11; i14++) {
                this.value[i14] = 0;
            }
            return;
        }
        int[] iArr3 = new int[i12];
        System.arraycopy(iArr, 0, iArr3, i11, i12 - i11);
        this.value = null;
        this.value = iArr3;
    }

    private GF2Polynomial karaMult(GF2Polynomial gF2Polynomial) {
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.len << 1);
        int i11 = this.len;
        if (i11 <= 32) {
            gF2Polynomial2.value = mult32(this.value[0], gF2Polynomial.value[0]);
            return gF2Polynomial2;
        } else if (i11 <= 64) {
            gF2Polynomial2.value = mult64(this.value, gF2Polynomial.value);
            return gF2Polynomial2;
        } else if (i11 <= 128) {
            gF2Polynomial2.value = mult128(this.value, gF2Polynomial.value);
            return gF2Polynomial2;
        } else if (i11 <= 256) {
            gF2Polynomial2.value = mult256(this.value, gF2Polynomial.value);
            return gF2Polynomial2;
        } else if (i11 <= 512) {
            gF2Polynomial2.value = mult512(this.value, gF2Polynomial.value);
            return gF2Polynomial2;
        } else {
            int i12 = bitMask[IntegerFunctions.floorLog(i11 - 1)];
            int i13 = ((i12 - 1) >> 5) + 1;
            GF2Polynomial lower = lower(i13);
            GF2Polynomial upper = upper(i13);
            GF2Polynomial lower2 = gF2Polynomial.lower(i13);
            GF2Polynomial upper2 = gF2Polynomial.upper(i13);
            GF2Polynomial karaMult = upper.karaMult(upper2);
            GF2Polynomial karaMult2 = lower.karaMult(lower2);
            lower.addToThis(upper);
            lower2.addToThis(upper2);
            GF2Polynomial karaMult3 = lower.karaMult(lower2);
            gF2Polynomial2.shiftLeftAddThis(karaMult, i12 << 1);
            gF2Polynomial2.shiftLeftAddThis(karaMult, i12);
            gF2Polynomial2.shiftLeftAddThis(karaMult3, i12);
            gF2Polynomial2.shiftLeftAddThis(karaMult2, i12);
            gF2Polynomial2.addToThis(karaMult2);
            return gF2Polynomial2;
        }
    }

    private GF2Polynomial lower(int i11) {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(i11 << 5);
        System.arraycopy(this.value, 0, gF2Polynomial.value, 0, Math.min(i11, this.blocks));
        return gF2Polynomial;
    }

    private static int[] mult128(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[8];
        int[] iArr4 = new int[2];
        System.arraycopy(iArr, 0, iArr4, 0, Math.min(2, iArr.length));
        int[] iArr5 = new int[2];
        if (iArr.length > 2) {
            System.arraycopy(iArr, 2, iArr5, 0, Math.min(2, iArr.length - 2));
        }
        int[] iArr6 = new int[2];
        System.arraycopy(iArr2, 0, iArr6, 0, Math.min(2, iArr2.length));
        int[] iArr7 = new int[2];
        if (iArr2.length > 2) {
            System.arraycopy(iArr2, 2, iArr7, 0, Math.min(2, iArr2.length - 2));
        }
        if (iArr5[1] != 0 || iArr7[1] != 0) {
            int[] mult64 = mult64(iArr5, iArr7);
            iArr3[7] = iArr3[7] ^ mult64[3];
            iArr3[6] = iArr3[6] ^ mult64[2];
            iArr3[5] = iArr3[5] ^ (mult64[1] ^ mult64[3]);
            iArr3[4] = iArr3[4] ^ (mult64[0] ^ mult64[2]);
            iArr3[3] = iArr3[3] ^ mult64[1];
            iArr3[2] = mult64[0] ^ iArr3[2];
        } else if (!(iArr5[0] == 0 && iArr7[0] == 0)) {
            int[] mult32 = mult32(iArr5[0], iArr7[0]);
            iArr3[5] = iArr3[5] ^ mult32[1];
            iArr3[4] = iArr3[4] ^ mult32[0];
            iArr3[3] = iArr3[3] ^ mult32[1];
            iArr3[2] = mult32[0] ^ iArr3[2];
        }
        iArr5[0] = iArr5[0] ^ iArr4[0];
        iArr5[1] = iArr5[1] ^ iArr4[1];
        iArr7[0] = iArr7[0] ^ iArr6[0];
        iArr7[1] = iArr7[1] ^ iArr6[1];
        if (iArr5[1] == 0 && iArr7[1] == 0) {
            int[] mult322 = mult32(iArr5[0], iArr7[0]);
            iArr3[3] = iArr3[3] ^ mult322[1];
            iArr3[2] = mult322[0] ^ iArr3[2];
        } else {
            int[] mult642 = mult64(iArr5, iArr7);
            iArr3[5] = iArr3[5] ^ mult642[3];
            iArr3[4] = iArr3[4] ^ mult642[2];
            iArr3[3] = iArr3[3] ^ mult642[1];
            iArr3[2] = mult642[0] ^ iArr3[2];
        }
        if (iArr4[1] == 0 && iArr6[1] == 0) {
            int[] mult323 = mult32(iArr4[0], iArr6[0]);
            iArr3[3] = iArr3[3] ^ mult323[1];
            iArr3[2] = iArr3[2] ^ mult323[0];
            iArr3[1] = iArr3[1] ^ mult323[1];
            iArr3[0] = mult323[0] ^ iArr3[0];
        } else {
            int[] mult643 = mult64(iArr4, iArr6);
            iArr3[5] = iArr3[5] ^ mult643[3];
            iArr3[4] = iArr3[4] ^ mult643[2];
            iArr3[3] = iArr3[3] ^ (mult643[1] ^ mult643[3]);
            iArr3[2] = iArr3[2] ^ (mult643[0] ^ mult643[2]);
            iArr3[1] = iArr3[1] ^ mult643[1];
            iArr3[0] = mult643[0] ^ iArr3[0];
        }
        return iArr3;
    }

    private static int[] mult256(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int[] iArr5 = new int[16];
        int[] iArr6 = new int[4];
        System.arraycopy(iArr3, 0, iArr6, 0, Math.min(4, iArr3.length));
        int[] iArr7 = new int[4];
        if (iArr3.length > 4) {
            System.arraycopy(iArr3, 4, iArr7, 0, Math.min(4, iArr3.length - 4));
        }
        int[] iArr8 = new int[4];
        System.arraycopy(iArr4, 0, iArr8, 0, Math.min(4, iArr4.length));
        int[] iArr9 = new int[4];
        if (iArr4.length > 4) {
            System.arraycopy(iArr4, 4, iArr9, 0, Math.min(4, iArr4.length - 4));
        }
        if (iArr7[3] != 0 || iArr7[2] != 0 || iArr9[3] != 0 || iArr9[2] != 0) {
            int[] mult128 = mult128(iArr7, iArr9);
            iArr5[15] = iArr5[15] ^ mult128[7];
            iArr5[14] = iArr5[14] ^ mult128[6];
            iArr5[13] = iArr5[13] ^ mult128[5];
            iArr5[12] = iArr5[12] ^ mult128[4];
            iArr5[11] = iArr5[11] ^ (mult128[3] ^ mult128[7]);
            iArr5[10] = iArr5[10] ^ (mult128[2] ^ mult128[6]);
            iArr5[9] = iArr5[9] ^ (mult128[1] ^ mult128[5]);
            iArr5[8] = iArr5[8] ^ (mult128[0] ^ mult128[4]);
            iArr5[7] = iArr5[7] ^ mult128[3];
            iArr5[6] = iArr5[6] ^ mult128[2];
            iArr5[5] = iArr5[5] ^ mult128[1];
            iArr5[4] = mult128[0] ^ iArr5[4];
        } else if (iArr7[1] != 0 || iArr9[1] != 0) {
            int[] mult64 = mult64(iArr7, iArr9);
            iArr5[11] = iArr5[11] ^ mult64[3];
            iArr5[10] = iArr5[10] ^ mult64[2];
            iArr5[9] = iArr5[9] ^ mult64[1];
            iArr5[8] = iArr5[8] ^ mult64[0];
            iArr5[7] = iArr5[7] ^ mult64[3];
            iArr5[6] = iArr5[6] ^ mult64[2];
            iArr5[5] = iArr5[5] ^ mult64[1];
            iArr5[4] = mult64[0] ^ iArr5[4];
        } else if (!(iArr7[0] == 0 && iArr9[0] == 0)) {
            int[] mult32 = mult32(iArr7[0], iArr9[0]);
            iArr5[9] = iArr5[9] ^ mult32[1];
            iArr5[8] = iArr5[8] ^ mult32[0];
            iArr5[5] = iArr5[5] ^ mult32[1];
            iArr5[4] = mult32[0] ^ iArr5[4];
        }
        iArr7[0] = iArr7[0] ^ iArr6[0];
        iArr7[1] = iArr7[1] ^ iArr6[1];
        iArr7[2] = iArr7[2] ^ iArr6[2];
        iArr7[3] = iArr7[3] ^ iArr6[3];
        iArr9[0] = iArr9[0] ^ iArr8[0];
        iArr9[1] = iArr9[1] ^ iArr8[1];
        iArr9[2] = iArr9[2] ^ iArr8[2];
        iArr9[3] = iArr9[3] ^ iArr8[3];
        int[] mult1282 = mult128(iArr7, iArr9);
        iArr5[11] = iArr5[11] ^ mult1282[7];
        iArr5[10] = iArr5[10] ^ mult1282[6];
        iArr5[9] = iArr5[9] ^ mult1282[5];
        iArr5[8] = iArr5[8] ^ mult1282[4];
        iArr5[7] = iArr5[7] ^ mult1282[3];
        iArr5[6] = iArr5[6] ^ mult1282[2];
        iArr5[5] = iArr5[5] ^ mult1282[1];
        iArr5[4] = mult1282[0] ^ iArr5[4];
        int[] mult1283 = mult128(iArr6, iArr8);
        iArr5[11] = iArr5[11] ^ mult1283[7];
        iArr5[10] = iArr5[10] ^ mult1283[6];
        iArr5[9] = iArr5[9] ^ mult1283[5];
        iArr5[8] = iArr5[8] ^ mult1283[4];
        iArr5[7] = iArr5[7] ^ (mult1283[3] ^ mult1283[7]);
        iArr5[6] = iArr5[6] ^ (mult1283[2] ^ mult1283[6]);
        iArr5[5] = iArr5[5] ^ (mult1283[1] ^ mult1283[5]);
        iArr5[4] = iArr5[4] ^ (mult1283[0] ^ mult1283[4]);
        iArr5[3] = iArr5[3] ^ mult1283[3];
        iArr5[2] = iArr5[2] ^ mult1283[2];
        iArr5[1] = iArr5[1] ^ mult1283[1];
        iArr5[0] = mult1283[0] ^ iArr5[0];
        return iArr5;
    }

    private static int[] mult32(int i11, int i12) {
        int[] iArr = new int[2];
        if (!(i11 == 0 || i12 == 0)) {
            long j11 = ((long) i12) & 4294967295L;
            long j12 = 0;
            for (int i13 = 1; i13 <= 32; i13++) {
                if ((bitMask[i13 - 1] & i11) != 0) {
                    j12 ^= j11;
                }
                j11 <<= 1;
            }
            iArr[1] = (int) (j12 >>> 32);
            iArr[0] = (int) (j12 & 4294967295L);
        }
        return iArr;
    }

    private static int[] mult512(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int[] iArr5 = new int[32];
        int[] iArr6 = new int[8];
        System.arraycopy(iArr3, 0, iArr6, 0, Math.min(8, iArr3.length));
        int[] iArr7 = new int[8];
        if (iArr3.length > 8) {
            System.arraycopy(iArr3, 8, iArr7, 0, Math.min(8, iArr3.length - 8));
        }
        int[] iArr8 = new int[8];
        System.arraycopy(iArr4, 0, iArr8, 0, Math.min(8, iArr4.length));
        int[] iArr9 = new int[8];
        if (iArr4.length > 8) {
            System.arraycopy(iArr4, 8, iArr9, 0, Math.min(8, iArr4.length - 8));
        }
        int[] mult256 = mult256(iArr7, iArr9);
        iArr5[31] = iArr5[31] ^ mult256[15];
        iArr5[30] = iArr5[30] ^ mult256[14];
        iArr5[29] = iArr5[29] ^ mult256[13];
        iArr5[28] = iArr5[28] ^ mult256[12];
        iArr5[27] = iArr5[27] ^ mult256[11];
        iArr5[26] = iArr5[26] ^ mult256[10];
        iArr5[25] = iArr5[25] ^ mult256[9];
        iArr5[24] = iArr5[24] ^ mult256[8];
        iArr5[23] = iArr5[23] ^ (mult256[7] ^ mult256[15]);
        iArr5[22] = iArr5[22] ^ (mult256[6] ^ mult256[14]);
        iArr5[21] = iArr5[21] ^ (mult256[5] ^ mult256[13]);
        iArr5[20] = iArr5[20] ^ (mult256[4] ^ mult256[12]);
        iArr5[19] = iArr5[19] ^ (mult256[3] ^ mult256[11]);
        iArr5[18] = iArr5[18] ^ (mult256[2] ^ mult256[10]);
        iArr5[17] = iArr5[17] ^ (mult256[1] ^ mult256[9]);
        iArr5[16] = iArr5[16] ^ (mult256[0] ^ mult256[8]);
        iArr5[15] = iArr5[15] ^ mult256[7];
        iArr5[14] = iArr5[14] ^ mult256[6];
        iArr5[13] = iArr5[13] ^ mult256[5];
        iArr5[12] = iArr5[12] ^ mult256[4];
        iArr5[11] = iArr5[11] ^ mult256[3];
        iArr5[10] = iArr5[10] ^ mult256[2];
        iArr5[9] = iArr5[9] ^ mult256[1];
        iArr5[8] = iArr5[8] ^ mult256[0];
        iArr7[0] = iArr7[0] ^ iArr6[0];
        iArr7[1] = iArr7[1] ^ iArr6[1];
        iArr7[2] = iArr7[2] ^ iArr6[2];
        iArr7[3] = iArr7[3] ^ iArr6[3];
        iArr7[4] = iArr7[4] ^ iArr6[4];
        iArr7[5] = iArr7[5] ^ iArr6[5];
        iArr7[6] = iArr7[6] ^ iArr6[6];
        iArr7[7] = iArr7[7] ^ iArr6[7];
        iArr9[0] = iArr9[0] ^ iArr8[0];
        iArr9[1] = iArr9[1] ^ iArr8[1];
        iArr9[2] = iArr9[2] ^ iArr8[2];
        iArr9[3] = iArr9[3] ^ iArr8[3];
        iArr9[4] = iArr9[4] ^ iArr8[4];
        iArr9[5] = iArr9[5] ^ iArr8[5];
        iArr9[6] = iArr9[6] ^ iArr8[6];
        iArr9[7] = iArr9[7] ^ iArr8[7];
        int[] mult2562 = mult256(iArr7, iArr9);
        iArr5[23] = iArr5[23] ^ mult2562[15];
        iArr5[22] = iArr5[22] ^ mult2562[14];
        iArr5[21] = iArr5[21] ^ mult2562[13];
        iArr5[20] = iArr5[20] ^ mult2562[12];
        iArr5[19] = iArr5[19] ^ mult2562[11];
        iArr5[18] = iArr5[18] ^ mult2562[10];
        iArr5[17] = iArr5[17] ^ mult2562[9];
        iArr5[16] = iArr5[16] ^ mult2562[8];
        iArr5[15] = iArr5[15] ^ mult2562[7];
        iArr5[14] = iArr5[14] ^ mult2562[6];
        iArr5[13] = iArr5[13] ^ mult2562[5];
        iArr5[12] = iArr5[12] ^ mult2562[4];
        iArr5[11] = iArr5[11] ^ mult2562[3];
        iArr5[10] = iArr5[10] ^ mult2562[2];
        iArr5[9] = iArr5[9] ^ mult2562[1];
        iArr5[8] = mult2562[0] ^ iArr5[8];
        int[] mult2563 = mult256(iArr6, iArr8);
        iArr5[23] = iArr5[23] ^ mult2563[15];
        iArr5[22] = iArr5[22] ^ mult2563[14];
        iArr5[21] = iArr5[21] ^ mult2563[13];
        iArr5[20] = iArr5[20] ^ mult2563[12];
        iArr5[19] = iArr5[19] ^ mult2563[11];
        iArr5[18] = iArr5[18] ^ mult2563[10];
        iArr5[17] = iArr5[17] ^ mult2563[9];
        iArr5[16] = iArr5[16] ^ mult2563[8];
        iArr5[15] = iArr5[15] ^ (mult2563[7] ^ mult2563[15]);
        iArr5[14] = iArr5[14] ^ (mult2563[6] ^ mult2563[14]);
        iArr5[13] = iArr5[13] ^ (mult2563[5] ^ mult2563[13]);
        iArr5[12] = iArr5[12] ^ (mult2563[4] ^ mult2563[12]);
        iArr5[11] = iArr5[11] ^ (mult2563[3] ^ mult2563[11]);
        iArr5[10] = iArr5[10] ^ (mult2563[2] ^ mult2563[10]);
        iArr5[9] = iArr5[9] ^ (mult2563[1] ^ mult2563[9]);
        iArr5[8] = iArr5[8] ^ (mult2563[0] ^ mult2563[8]);
        iArr5[7] = iArr5[7] ^ mult2563[7];
        iArr5[6] = iArr5[6] ^ mult2563[6];
        iArr5[5] = iArr5[5] ^ mult2563[5];
        iArr5[4] = iArr5[4] ^ mult2563[4];
        iArr5[3] = iArr5[3] ^ mult2563[3];
        iArr5[2] = iArr5[2] ^ mult2563[2];
        iArr5[1] = iArr5[1] ^ mult2563[1];
        iArr5[0] = mult2563[0] ^ iArr5[0];
        return iArr5;
    }

    private static int[] mult64(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[4];
        int i11 = iArr[0];
        int i12 = iArr.length > 1 ? iArr[1] : 0;
        int i13 = iArr2[0];
        int i14 = iArr2.length > 1 ? iArr2[1] : 0;
        if (!(i12 == 0 && i14 == 0)) {
            int[] mult32 = mult32(i12, i14);
            iArr3[3] = iArr3[3] ^ mult32[1];
            iArr3[2] = iArr3[2] ^ (mult32[0] ^ mult32[1]);
            iArr3[1] = mult32[0] ^ iArr3[1];
        }
        int[] mult322 = mult32(i12 ^ i11, i14 ^ i13);
        iArr3[2] = iArr3[2] ^ mult322[1];
        iArr3[1] = mult322[0] ^ iArr3[1];
        int[] mult323 = mult32(i11, i13);
        iArr3[2] = iArr3[2] ^ mult323[1];
        iArr3[1] = iArr3[1] ^ (mult323[0] ^ mult323[1]);
        iArr3[0] = mult323[0] ^ iArr3[0];
        return iArr3;
    }

    private GF2Polynomial upper(int i11) {
        int min = Math.min(i11, this.blocks - i11);
        GF2Polynomial gF2Polynomial = new GF2Polynomial(min << 5);
        if (this.blocks >= i11) {
            System.arraycopy(this.value, i11, gF2Polynomial.value, 0, min);
        }
        return gF2Polynomial;
    }

    private void zeroUnusedBits() {
        int i11 = this.len;
        if ((i11 & 31) != 0) {
            int[] iArr = this.value;
            int i12 = this.blocks - 1;
            iArr[i12] = reverseRightMask[i11 & 31] & iArr[i12];
        }
    }

    public GF2Polynomial add(GF2Polynomial gF2Polynomial) {
        return xor(gF2Polynomial);
    }

    public void addToThis(GF2Polynomial gF2Polynomial) {
        expandN(gF2Polynomial.len);
        xorThisBy(gF2Polynomial);
    }

    public void assignAll() {
        for (int i11 = 0; i11 < this.blocks; i11++) {
            this.value[i11] = -1;
        }
        zeroUnusedBits();
    }

    public void assignOne() {
        for (int i11 = 1; i11 < this.blocks; i11++) {
            this.value[i11] = 0;
        }
        this.value[0] = 1;
    }

    public void assignX() {
        for (int i11 = 1; i11 < this.blocks; i11++) {
            this.value[i11] = 0;
        }
        this.value[0] = 2;
    }

    public void assignZero() {
        for (int i11 = 0; i11 < this.blocks; i11++) {
            this.value[i11] = 0;
        }
    }

    public Object clone() {
        return new GF2Polynomial(this);
    }

    public GF2Polynomial[] divide(GF2Polynomial gF2Polynomial) throws RuntimeException {
        GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[2];
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.len);
        GF2Polynomial gF2Polynomial3 = new GF2Polynomial(this);
        GF2Polynomial gF2Polynomial4 = new GF2Polynomial(gF2Polynomial);
        if (!gF2Polynomial4.isZero()) {
            gF2Polynomial3.reduceN();
            gF2Polynomial4.reduceN();
            int i11 = gF2Polynomial3.len;
            int i12 = gF2Polynomial4.len;
            if (i11 < i12) {
                gF2PolynomialArr[0] = new GF2Polynomial(0);
                gF2PolynomialArr[1] = gF2Polynomial3;
                return gF2PolynomialArr;
            }
            int i13 = i11 - i12;
            gF2Polynomial2.expandN(i13 + 1);
            while (i13 >= 0) {
                gF2Polynomial3.subtractFromThis(gF2Polynomial4.shiftLeft(i13));
                gF2Polynomial3.reduceN();
                gF2Polynomial2.xorBit(i13);
                i13 = gF2Polynomial3.len - gF2Polynomial4.len;
            }
            gF2PolynomialArr[0] = gF2Polynomial2;
            gF2PolynomialArr[1] = gF2Polynomial3;
            return gF2PolynomialArr;
        }
        throw new RuntimeException();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2Polynomial)) {
            return false;
        }
        GF2Polynomial gF2Polynomial = (GF2Polynomial) obj;
        if (this.len != gF2Polynomial.len) {
            return false;
        }
        for (int i11 = 0; i11 < this.blocks; i11++) {
            if (this.value[i11] != gF2Polynomial.value[i11]) {
                return false;
            }
        }
        return true;
    }

    public void expandN(int i11) {
        if (this.len < i11) {
            this.len = i11;
            int i12 = ((i11 - 1) >>> 5) + 1;
            int i13 = this.blocks;
            if (i13 < i12) {
                int[] iArr = this.value;
                if (iArr.length >= i12) {
                    while (i13 < i12) {
                        this.value[i13] = 0;
                        i13++;
                    }
                    this.blocks = i12;
                    return;
                }
                int[] iArr2 = new int[i12];
                System.arraycopy(iArr, 0, iArr2, 0, i13);
                this.blocks = i12;
                this.value = null;
                this.value = iArr2;
            }
        }
    }

    public GF2Polynomial gcd(GF2Polynomial gF2Polynomial) throws RuntimeException {
        if (isZero() && gF2Polynomial.isZero()) {
            throw new ArithmeticException("Both operands of gcd equal zero.");
        } else if (isZero()) {
            return new GF2Polynomial(gF2Polynomial);
        } else {
            if (gF2Polynomial.isZero()) {
                return new GF2Polynomial(this);
            }
            GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this);
            GF2Polynomial gF2Polynomial3 = new GF2Polynomial(gF2Polynomial);
            GF2Polynomial gF2Polynomial4 = gF2Polynomial2;
            GF2Polynomial gF2Polynomial5 = gF2Polynomial3;
            while (!gF2Polynomial5.isZero()) {
                GF2Polynomial gF2Polynomial6 = gF2Polynomial5;
                gF2Polynomial5 = gF2Polynomial4.remainder(gF2Polynomial5);
                gF2Polynomial4 = gF2Polynomial6;
            }
            return gF2Polynomial4;
        }
    }

    public int getBit(int i11) {
        if (i11 < 0) {
            throw new RuntimeException();
        } else if (i11 > this.len - 1) {
            return 0;
        } else {
            return (bitMask[i11 & 31] & this.value[i11 >>> 5]) != 0 ? 1 : 0;
        }
    }

    public int getLength() {
        return this.len;
    }

    public int hashCode() {
        return this.len + Arrays.hashCode(this.value);
    }

    public GF2Polynomial increase() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this);
        gF2Polynomial.increaseThis();
        return gF2Polynomial;
    }

    public void increaseThis() {
        xorBit(0);
    }

    public boolean isIrreducible() {
        if (isZero()) {
            return false;
        }
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this);
        gF2Polynomial.reduceN();
        int i11 = gF2Polynomial.len;
        int i12 = i11 - 1;
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(i11, "X");
        for (int i13 = 1; i13 <= (i12 >> 1); i13++) {
            gF2Polynomial2.squareThisPreCalc();
            gF2Polynomial2 = gF2Polynomial2.remainder(gF2Polynomial);
            GF2Polynomial add = gF2Polynomial2.add(new GF2Polynomial(32, "X"));
            if (add.isZero() || !gF2Polynomial.gcd(add).isOne()) {
                return false;
            }
        }
        return true;
    }

    public boolean isOne() {
        for (int i11 = 1; i11 < this.blocks; i11++) {
            if (this.value[i11] != 0) {
                return false;
            }
        }
        return this.value[0] == 1;
    }

    public boolean isZero() {
        if (this.len == 0) {
            return true;
        }
        for (int i11 = 0; i11 < this.blocks; i11++) {
            if (this.value[i11] != 0) {
                return false;
            }
        }
        return true;
    }

    public GF2Polynomial multiply(GF2Polynomial gF2Polynomial) {
        int max = Math.max(this.len, gF2Polynomial.len);
        expandN(max);
        gF2Polynomial.expandN(max);
        return karaMult(gF2Polynomial);
    }

    public GF2Polynomial multiplyClassic(GF2Polynomial gF2Polynomial) {
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(Math.max(this.len, gF2Polynomial.len) << 1);
        GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[32];
        gF2PolynomialArr[0] = new GF2Polynomial(this);
        for (int i11 = 1; i11 <= 31; i11++) {
            gF2PolynomialArr[i11] = gF2PolynomialArr[i11 - 1].shiftLeft();
        }
        for (int i12 = 0; i12 < gF2Polynomial.blocks; i12++) {
            for (int i13 = 0; i13 <= 31; i13++) {
                if ((gF2Polynomial.value[i12] & bitMask[i13]) != 0) {
                    gF2Polynomial2.xorThisBy(gF2PolynomialArr[i13]);
                }
            }
            for (int i14 = 0; i14 <= 31; i14++) {
                gF2PolynomialArr[i14].shiftBlocksLeft();
            }
        }
        return gF2Polynomial2;
    }

    public GF2Polynomial quotient(GF2Polynomial gF2Polynomial) throws RuntimeException {
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.len);
        GF2Polynomial gF2Polynomial3 = new GF2Polynomial(this);
        GF2Polynomial gF2Polynomial4 = new GF2Polynomial(gF2Polynomial);
        if (!gF2Polynomial4.isZero()) {
            gF2Polynomial3.reduceN();
            gF2Polynomial4.reduceN();
            int i11 = gF2Polynomial3.len;
            int i12 = gF2Polynomial4.len;
            if (i11 < i12) {
                return new GF2Polynomial(0);
            }
            int i13 = i11 - i12;
            gF2Polynomial2.expandN(i13 + 1);
            while (i13 >= 0) {
                gF2Polynomial3.subtractFromThis(gF2Polynomial4.shiftLeft(i13));
                gF2Polynomial3.reduceN();
                gF2Polynomial2.xorBit(i13);
                i13 = gF2Polynomial3.len - gF2Polynomial4.len;
            }
            return gF2Polynomial2;
        }
        throw new RuntimeException();
    }

    public void randomize() {
        for (int i11 = 0; i11 < this.blocks; i11++) {
            this.value[i11] = rand.nextInt();
        }
        zeroUnusedBits();
    }

    public void randomize(Random random) {
        for (int i11 = 0; i11 < this.blocks; i11++) {
            this.value[i11] = random.nextInt();
        }
        zeroUnusedBits();
    }

    public void reduceN() {
        int[] iArr;
        int i11 = this.blocks;
        while (true) {
            i11--;
            iArr = this.value;
            if (iArr[i11] != 0 || i11 <= 0) {
                int i12 = iArr[i11];
                int i13 = 0;
            }
        }
        int i122 = iArr[i11];
        int i132 = 0;
        while (i122 != 0) {
            i122 >>>= 1;
            i132++;
        }
        this.len = (i11 << 5) + i132;
        this.blocks = i11 + 1;
    }

    public void reducePentanomial(int i11, int[] iArr) {
        GF2Polynomial gF2Polynomial = this;
        int i12 = i11;
        int i13 = i12 >>> 5;
        int i14 = i12 & 31;
        int i15 = 32 - i14;
        boolean z11 = false;
        int i16 = (i12 - iArr[0]) >>> 5;
        int i17 = 32 - ((i12 - iArr[0]) & 31);
        int i18 = (i12 - iArr[1]) >>> 5;
        int i19 = 32 - ((i12 - iArr[1]) & 31);
        int i21 = (i12 - iArr[2]) >>> 5;
        int i22 = 32 - ((i12 - iArr[2]) & 31);
        int i23 = ((i12 << 1) - 2) >>> 5;
        while (i23 > i13) {
            int[] iArr2 = gF2Polynomial.value;
            long j11 = ((long) iArr2[i23]) & 4294967295L;
            int i24 = i23 - i13;
            int i25 = i24 - 1;
            int i26 = i13;
            int i27 = i14;
            iArr2[i25] = ((int) (j11 << i15)) ^ iArr2[i25];
            iArr2[i24] = (int) (((long) iArr2[i24]) ^ (j11 >>> (32 - i15)));
            int i28 = i23 - i16;
            int i29 = i28 - 1;
            iArr2[i29] = iArr2[i29] ^ ((int) (j11 << i17));
            iArr2[i28] = (int) (((long) iArr2[i28]) ^ (j11 >>> (32 - i17)));
            int i30 = i23 - i18;
            int i31 = i30 - 1;
            iArr2[i31] = iArr2[i31] ^ ((int) (j11 << i19));
            iArr2[i30] = (int) (((long) iArr2[i30]) ^ (j11 >>> (32 - i19)));
            int i32 = i23 - i21;
            int i33 = i32 - 1;
            iArr2[i33] = iArr2[i33] ^ ((int) (j11 << i22));
            iArr2[i32] = (int) ((j11 >>> (32 - i22)) ^ ((long) iArr2[i32]));
            iArr2[i23] = 0;
            i23--;
            int i34 = i11;
            z11 = false;
            i13 = i26;
            i14 = i27;
            gF2Polynomial = this;
        }
        GF2Polynomial gF2Polynomial2 = gF2Polynomial;
        int i35 = i13;
        int i36 = i14;
        boolean z12 = z11;
        int[] iArr3 = gF2Polynomial2.value;
        long j12 = ((long) iArr3[i35]) & 4294967295L & (4294967295 << i36);
        iArr3[0] = (int) ((j12 >>> (32 - i15)) ^ ((long) iArr3[0]));
        int i37 = i35 - i16;
        int i38 = i37 - 1;
        if (i38 >= 0) {
            iArr3[i38] = iArr3[i38] ^ ((int) (j12 << i17));
        }
        iArr3[i37] = (int) (((long) iArr3[i37]) ^ (j12 >>> (32 - i17)));
        int i39 = i35 - i18;
        int i40 = i39 - 1;
        if (i40 >= 0) {
            iArr3[i40] = iArr3[i40] ^ ((int) (j12 << i19));
        }
        iArr3[i39] = (int) (((long) iArr3[i39]) ^ (j12 >>> (32 - i19)));
        int i41 = i35 - i21;
        int i42 = i41 - 1;
        if (i42 >= 0) {
            iArr3[i42] = iArr3[i42] ^ ((int) (j12 << i22));
        }
        iArr3[i41] = (int) ((j12 >>> (32 - i22)) ^ ((long) iArr3[i41]));
        iArr3[i35] = iArr3[i35] & reverseRightMask[i36];
        int i43 = i11;
        this.blocks = ((i43 - 1) >>> 5) + 1;
        this.len = i43;
    }

    public void reduceTrinomial(int i11, int i12) {
        int i13 = i11;
        int i14 = i13 >>> 5;
        int i15 = i13 & 31;
        int i16 = 32 - i15;
        int i17 = i13 - i12;
        int i18 = i17 >>> 5;
        int i19 = 32 - (i17 & 31);
        int i21 = ((i13 << 1) - 2) >>> 5;
        while (i21 > i14) {
            int[] iArr = this.value;
            long j11 = 4294967295L & ((long) iArr[i21]);
            int i22 = i21 - i14;
            int i23 = i22 - 1;
            int i24 = i14;
            iArr[i23] = ((int) (j11 << i16)) ^ iArr[i23];
            iArr[i22] = (int) (((long) iArr[i22]) ^ (j11 >>> (32 - i16)));
            int i25 = i21 - i18;
            int i26 = i25 - 1;
            iArr[i26] = iArr[i26] ^ ((int) (j11 << i19));
            iArr[i25] = (int) ((j11 >>> (32 - i19)) ^ ((long) iArr[i25]));
            iArr[i21] = 0;
            i21--;
            int i27 = i11;
            i14 = i24;
        }
        int i28 = i14;
        int[] iArr2 = this.value;
        long j12 = (4294967295 << i15) & ((long) iArr2[i28]) & 4294967295L;
        iArr2[0] = (int) (((long) iArr2[0]) ^ (j12 >>> (32 - i16)));
        int i29 = i28 - i18;
        int i30 = i29 - 1;
        if (i30 >= 0) {
            iArr2[i30] = iArr2[i30] ^ ((int) (j12 << i19));
        }
        iArr2[i29] = (int) ((j12 >>> (32 - i19)) ^ ((long) iArr2[i29]));
        iArr2[i28] = iArr2[i28] & reverseRightMask[i15];
        int i31 = i11;
        this.blocks = ((i31 - 1) >>> 5) + 1;
        this.len = i31;
    }

    public GF2Polynomial remainder(GF2Polynomial gF2Polynomial) throws RuntimeException {
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this);
        GF2Polynomial gF2Polynomial3 = new GF2Polynomial(gF2Polynomial);
        if (!gF2Polynomial3.isZero()) {
            gF2Polynomial2.reduceN();
            gF2Polynomial3.reduceN();
            int i11 = gF2Polynomial2.len;
            int i12 = gF2Polynomial3.len;
            if (i11 < i12) {
                return gF2Polynomial2;
            }
            while (true) {
                int i13 = i11 - i12;
                if (i13 < 0) {
                    return gF2Polynomial2;
                }
                gF2Polynomial2.subtractFromThis(gF2Polynomial3.shiftLeft(i13));
                gF2Polynomial2.reduceN();
                i11 = gF2Polynomial2.len;
                i12 = gF2Polynomial3.len;
            }
        } else {
            throw new RuntimeException();
        }
    }

    public void resetBit(int i11) throws RuntimeException {
        if (i11 < 0) {
            throw new RuntimeException();
        } else if (i11 <= this.len - 1) {
            int[] iArr = this.value;
            int i12 = i11 >>> 5;
            iArr[i12] = (~bitMask[i11 & 31]) & iArr[i12];
        }
    }

    public void setBit(int i11) throws RuntimeException {
        if (i11 < 0 || i11 > this.len - 1) {
            throw new RuntimeException();
        }
        int[] iArr = this.value;
        int i12 = i11 >>> 5;
        iArr[i12] = bitMask[i11 & 31] | iArr[i12];
    }

    public void shiftBlocksLeft() {
        int i11 = this.blocks + 1;
        this.blocks = i11;
        this.len += 32;
        int[] iArr = this.value;
        if (i11 <= iArr.length) {
            for (int i12 = i11 - 1; i12 >= 1; i12--) {
                int[] iArr2 = this.value;
                iArr2[i12] = iArr2[i12 - 1];
            }
            this.value[0] = 0;
            return;
        }
        int[] iArr3 = new int[i11];
        System.arraycopy(iArr, 0, iArr3, 1, i11 - 1);
        this.value = null;
        this.value = iArr3;
    }

    public GF2Polynomial shiftLeft() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.len + 1, this.value);
        for (int i11 = gF2Polynomial.blocks - 1; i11 >= 1; i11--) {
            int[] iArr = gF2Polynomial.value;
            iArr[i11] = iArr[i11] << 1;
            iArr[i11] = iArr[i11] | (iArr[i11 - 1] >>> 31);
        }
        int[] iArr2 = gF2Polynomial.value;
        iArr2[0] = iArr2[0] << 1;
        return gF2Polynomial;
    }

    public GF2Polynomial shiftLeft(int i11) {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.len + i11, this.value);
        if (i11 >= 32) {
            gF2Polynomial.doShiftBlocksLeft(i11 >>> 5);
        }
        int i12 = i11 & 31;
        if (i12 != 0) {
            for (int i13 = gF2Polynomial.blocks - 1; i13 >= 1; i13--) {
                int[] iArr = gF2Polynomial.value;
                iArr[i13] = iArr[i13] << i12;
                iArr[i13] = iArr[i13] | (iArr[i13 - 1] >>> (32 - i12));
            }
            int[] iArr2 = gF2Polynomial.value;
            iArr2[0] = iArr2[0] << i12;
        }
        return gF2Polynomial;
    }

    public void shiftLeftAddThis(GF2Polynomial gF2Polynomial, int i11) {
        int i12;
        if (i11 == 0) {
            addToThis(gF2Polynomial);
            return;
        }
        expandN(gF2Polynomial.len + i11);
        int i13 = i11 >>> 5;
        for (int i14 = gF2Polynomial.blocks - 1; i14 >= 0; i14--) {
            int i15 = i14 + i13;
            int i16 = i15 + 1;
            if (i16 < this.blocks && (i12 = i11 & 31) != 0) {
                int[] iArr = this.value;
                iArr[i16] = (gF2Polynomial.value[i14] >>> (32 - i12)) ^ iArr[i16];
            }
            int[] iArr2 = this.value;
            iArr2[i15] = iArr2[i15] ^ (gF2Polynomial.value[i14] << (i11 & 31));
        }
    }

    public void shiftLeftThis() {
        int i11 = this.len;
        int i12 = i11 & 31;
        this.len = i11 + 1;
        int i13 = this.blocks;
        if (i12 == 0) {
            int i14 = i13 + 1;
            this.blocks = i14;
            int[] iArr = this.value;
            if (i14 > iArr.length) {
                int[] iArr2 = new int[i14];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                this.value = null;
                this.value = iArr2;
            }
            for (int i15 = this.blocks - 1; i15 >= 1; i15--) {
                int[] iArr3 = this.value;
                int i16 = i15 - 1;
                iArr3[i15] = iArr3[i15] | (iArr3[i16] >>> 31);
                iArr3[i16] = iArr3[i16] << 1;
            }
            return;
        }
        for (int i17 = i13 - 1; i17 >= 1; i17--) {
            int[] iArr4 = this.value;
            iArr4[i17] = iArr4[i17] << 1;
            iArr4[i17] = iArr4[i17] | (iArr4[i17 - 1] >>> 31);
        }
        int[] iArr5 = this.value;
        iArr5[0] = iArr5[0] << 1;
    }

    public GF2Polynomial shiftRight() {
        int i11;
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.len - 1);
        int i12 = 0;
        System.arraycopy(this.value, 0, gF2Polynomial.value, 0, gF2Polynomial.blocks);
        while (true) {
            i11 = gF2Polynomial.blocks;
            if (i12 > i11 - 2) {
                break;
            }
            int[] iArr = gF2Polynomial.value;
            iArr[i12] = iArr[i12] >>> 1;
            int i13 = i12 + 1;
            iArr[i12] = iArr[i12] | (iArr[i13] << 31);
            i12 = i13;
        }
        int[] iArr2 = gF2Polynomial.value;
        int i14 = i11 - 1;
        iArr2[i14] = iArr2[i14] >>> 1;
        if (i11 < this.blocks) {
            int i15 = i11 - 1;
            iArr2[i15] = (this.value[i11] << 31) | iArr2[i15];
        }
        return gF2Polynomial;
    }

    public void shiftRightThis() {
        int i11;
        int i12 = this.len - 1;
        this.len = i12;
        this.blocks = ((i12 - 1) >>> 5) + 1;
        int i13 = 0;
        while (true) {
            i11 = this.blocks;
            if (i13 > i11 - 2) {
                break;
            }
            int[] iArr = this.value;
            iArr[i13] = iArr[i13] >>> 1;
            int i14 = i13 + 1;
            iArr[i13] = iArr[i13] | (iArr[i14] << 31);
            i13 = i14;
        }
        int[] iArr2 = this.value;
        int i15 = i11 - 1;
        iArr2[i15] = iArr2[i15] >>> 1;
        if ((this.len & 31) == 0) {
            int i16 = i11 - 1;
            iArr2[i16] = (iArr2[i11] << 31) | iArr2[i16];
        }
    }

    public void squareThisBitwise() {
        if (!isZero()) {
            int i11 = this.blocks;
            int i12 = i11 << 1;
            int[] iArr = new int[i12];
            for (int i13 = i11 - 1; i13 >= 0; i13--) {
                int i14 = this.value[i13];
                int i15 = 1;
                for (int i16 = 0; i16 < 16; i16++) {
                    if ((i14 & 1) != 0) {
                        int i17 = i13 << 1;
                        iArr[i17] = iArr[i17] | i15;
                    }
                    if ((65536 & i14) != 0) {
                        int i18 = (i13 << 1) + 1;
                        iArr[i18] = iArr[i18] | i15;
                    }
                    i15 <<= 2;
                    i14 >>>= 1;
                }
            }
            this.value = null;
            this.value = iArr;
            this.blocks = i12;
            this.len = (this.len << 1) - 1;
        }
    }

    public void squareThisPreCalc() {
        int i11;
        int i12;
        if (!isZero()) {
            int length = this.value.length;
            int i13 = this.blocks;
            if (length >= (i13 << 1)) {
                for (int i14 = i13 - 1; i14 >= 0; i14--) {
                    int[] iArr = this.value;
                    int i15 = i14 << 1;
                    short[] sArr = squaringTable;
                    iArr[i15 + 1] = sArr[(iArr[i14] & 16711680) >>> 16] | (sArr[(iArr[i14] & RoundedDrawable.DEFAULT_BORDER_COLOR) >>> 24] << 16);
                    iArr[i15] = sArr[iArr[i14] & 255] | (sArr[(iArr[i14] & 65280) >>> 8] << 16);
                }
                i11 = this.blocks << 1;
            } else {
                int[] iArr2 = new int[(i13 << 1)];
                int i16 = 0;
                while (true) {
                    i12 = this.blocks;
                    if (i16 >= i12) {
                        break;
                    }
                    int i17 = i16 << 1;
                    short[] sArr2 = squaringTable;
                    int[] iArr3 = this.value;
                    iArr2[i17] = sArr2[iArr3[i16] & 255] | (sArr2[(iArr3[i16] & 65280) >>> 8] << 16);
                    iArr2[i17 + 1] = (sArr2[(iArr3[i16] & RoundedDrawable.DEFAULT_BORDER_COLOR) >>> 24] << 16) | sArr2[(iArr3[i16] & 16711680) >>> 16];
                    i16++;
                }
                this.value = null;
                this.value = iArr2;
                i11 = i12 << 1;
            }
            this.blocks = i11;
            this.len = (this.len << 1) - 1;
        }
    }

    public GF2Polynomial subtract(GF2Polynomial gF2Polynomial) {
        return xor(gF2Polynomial);
    }

    public void subtractFromThis(GF2Polynomial gF2Polynomial) {
        expandN(gF2Polynomial.len);
        xorThisBy(gF2Polynomial);
    }

    public boolean testBit(int i11) {
        if (i11 < 0) {
            throw new RuntimeException();
        } else if (i11 > this.len - 1) {
            return false;
        } else {
            return (bitMask[i11 & 31] & this.value[i11 >>> 5]) != 0;
        }
    }

    public byte[] toByteArray() {
        int i11 = ((this.len - 1) >> 3) + 1;
        int i12 = i11 & 3;
        byte[] bArr = new byte[i11];
        for (int i13 = 0; i13 < (i11 >> 2); i13++) {
            int i14 = (i11 - (i13 << 2)) - 1;
            int[] iArr = this.value;
            bArr[i14] = (byte) (255 & iArr[i13]);
            bArr[i14 - 1] = (byte) ((iArr[i13] & 65280) >>> 8);
            bArr[i14 - 2] = (byte) ((iArr[i13] & 16711680) >>> 16);
            bArr[i14 - 3] = (byte) ((iArr[i13] & RoundedDrawable.DEFAULT_BORDER_COLOR) >>> 24);
        }
        for (int i15 = 0; i15 < i12; i15++) {
            int i16 = ((i12 - i15) - 1) << 3;
            bArr[i15] = (byte) ((this.value[this.blocks - 1] & (255 << i16)) >>> i16);
        }
        return bArr;
    }

    public BigInteger toFlexiBigInt() {
        return (this.len == 0 || isZero()) ? new BigInteger(0, new byte[0]) : new BigInteger(1, toByteArray());
    }

    public int[] toIntegerArray() {
        int i11 = this.blocks;
        int[] iArr = new int[i11];
        System.arraycopy(this.value, 0, iArr, 0, i11);
        return iArr;
    }

    public String toString(int i11) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String[] strArr = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        String str = new String();
        if (i11 == 16) {
            for (int i12 = this.blocks - 1; i12 >= 0; i12--) {
                str = ((((((((str + cArr[(this.value[i12] >>> 28) & 15]) + cArr[(this.value[i12] >>> 24) & 15]) + cArr[(this.value[i12] >>> 20) & 15]) + cArr[(this.value[i12] >>> 16) & 15]) + cArr[(this.value[i12] >>> 12) & 15]) + cArr[(this.value[i12] >>> 8) & 15]) + cArr[(this.value[i12] >>> 4) & 15]) + cArr[this.value[i12] & 15]) + " ";
            }
        } else {
            for (int i13 = this.blocks - 1; i13 >= 0; i13--) {
                str = ((((((((str + strArr[(this.value[i13] >>> 28) & 15]) + strArr[(this.value[i13] >>> 24) & 15]) + strArr[(this.value[i13] >>> 20) & 15]) + strArr[(this.value[i13] >>> 16) & 15]) + strArr[(this.value[i13] >>> 12) & 15]) + strArr[(this.value[i13] >>> 8) & 15]) + strArr[(this.value[i13] >>> 4) & 15]) + strArr[this.value[i13] & 15]) + " ";
            }
        }
        return str;
    }

    public boolean vectorMult(GF2Polynomial gF2Polynomial) throws RuntimeException {
        if (this.len == gF2Polynomial.len) {
            boolean z11 = false;
            for (int i11 = 0; i11 < this.blocks; i11++) {
                int i12 = this.value[i11] & gF2Polynomial.value[i11];
                boolean[] zArr = parity;
                z11 = (((z11 ^ zArr[i12 & 255]) ^ zArr[(i12 >>> 8) & 255]) ^ zArr[(i12 >>> 16) & 255]) ^ zArr[(i12 >>> 24) & 255];
            }
            return z11;
        }
        throw new RuntimeException();
    }

    public GF2Polynomial xor(GF2Polynomial gF2Polynomial) {
        GF2Polynomial gF2Polynomial2;
        int min = Math.min(this.blocks, gF2Polynomial.blocks);
        int i11 = 0;
        if (this.len >= gF2Polynomial.len) {
            gF2Polynomial2 = new GF2Polynomial(this);
            while (i11 < min) {
                int[] iArr = gF2Polynomial2.value;
                iArr[i11] = iArr[i11] ^ gF2Polynomial.value[i11];
                i11++;
            }
        } else {
            gF2Polynomial2 = new GF2Polynomial(gF2Polynomial);
            while (i11 < min) {
                int[] iArr2 = gF2Polynomial2.value;
                iArr2[i11] = iArr2[i11] ^ this.value[i11];
                i11++;
            }
        }
        gF2Polynomial2.zeroUnusedBits();
        return gF2Polynomial2;
    }

    public void xorBit(int i11) throws RuntimeException {
        if (i11 < 0 || i11 > this.len - 1) {
            throw new RuntimeException();
        }
        int[] iArr = this.value;
        int i12 = i11 >>> 5;
        iArr[i12] = bitMask[i11 & 31] ^ iArr[i12];
    }

    public void xorThisBy(GF2Polynomial gF2Polynomial) {
        for (int i11 = 0; i11 < Math.min(this.blocks, gF2Polynomial.blocks); i11++) {
            int[] iArr = this.value;
            iArr[i11] = iArr[i11] ^ gF2Polynomial.value[i11];
        }
        zeroUnusedBits();
    }
}
