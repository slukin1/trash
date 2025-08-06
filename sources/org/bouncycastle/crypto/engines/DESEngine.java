package org.bouncycastle.crypto.engines;

import com.facebook.internal.NativeProtocol;
import com.google.common.base.Ascii;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaCodecProfileLevel;
import net.sf.scuba.smartcards.ISO7816;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class DESEngine implements BlockCipher {
    public static final int BLOCK_SIZE = 8;
    private static final int[] SP1 = {16843776, 0, 65536, 16843780, 16842756, 66564, 4, 65536, 1024, 16843776, 16843780, 1024, 16778244, 16842756, 16777216, 4, 1028, 16778240, 16778240, 66560, 66560, 16842752, 16842752, 16778244, NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST, 16777220, 16777220, NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST, 0, 1028, 66564, 16777216, 65536, 16843780, 4, 16842752, 16843776, 16777216, 16777216, 1024, 16842756, 65536, 66560, 16777220, 1024, 4, 16778244, 66564, 16843780, NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST, 16842752, 16778244, 16777220, 1028, 66564, 16843776, 1028, 16778240, 16778240, 0, NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST, 66560, 0, 16842756};
    private static final int[] SP2 = {-2146402272, -2147450880, 32768, 1081376, 1048576, 32, -2146435040, -2147450848, -2147483616, -2146402272, -2146402304, Integer.MIN_VALUE, -2147450880, 1048576, 32, -2146435040, 1081344, 1048608, -2147450848, 0, Integer.MIN_VALUE, 32768, 1081376, -2146435072, 1048608, -2147483616, 0, 1081344, 32800, -2146402304, -2146435072, 32800, 0, 1081376, -2146435040, 1048576, -2147450848, -2146435072, -2146402304, 32768, -2146435072, -2147450880, 32, -2146402272, 1081376, 32, 32768, Integer.MIN_VALUE, 32800, -2146402304, 1048576, -2147483616, 1048608, -2147450848, -2147483616, 1048608, 1081344, 0, -2147450880, 32800, Integer.MIN_VALUE, -2146435040, -2146402272, 1081344};
    private static final int[] SP3 = {520, 134349312, 0, 134348808, 134218240, 0, 131592, 134218240, 131080, 134217736, 134217736, 131072, 134349320, 131080, 134348800, 520, 134217728, 8, 134349312, 512, 131584, 134348800, 134348808, 131592, 134218248, 131584, 131072, 134218248, 8, 134349320, 512, 134217728, 134349312, 134217728, 131080, 520, 131072, 134349312, 134218240, 0, 512, 131080, 134349320, 134218240, 134217736, 512, 0, 134348808, 134218248, 131072, 134217728, 134349320, 8, 131592, 131584, 134217736, 134348800, 134218248, 520, 134348800, 131592, 8, 134348808, 131584};
    private static final int[] SP4 = {8396801, 8321, 8321, 128, 8396928, 8388737, 8388609, 8193, 0, 8396800, 8396800, 8396929, 129, 0, 8388736, 8388609, 1, 8192, 8388608, 8396801, 128, 8388608, 8193, 8320, 8388737, 1, 8320, 8388736, 8192, 8396928, 8396929, 129, 8388736, 8388609, 8396800, 8396929, 129, 0, 0, 8396800, 8320, 8388736, 8388737, 1, 8396801, 8321, 8321, 128, 8396929, 129, 1, 8192, 8388609, 8193, 8396928, 8388737, 8193, 8320, 8388608, 8396801, 128, 8388608, 8192, 8396928};
    private static final int[] SP5 = {256, 34078976, 34078720, 1107296512, 524288, 256, 1073741824, 34078720, 1074266368, 524288, 33554688, 1074266368, 1107296512, 1107820544, 524544, 1073741824, TPMediaCodecProfileLevel.HEVCHighTierLevel62, 1074266112, 1074266112, 0, 1073742080, 1107820800, 1107820800, 33554688, 1107820544, 1073742080, 0, 1107296256, 34078976, TPMediaCodecProfileLevel.HEVCHighTierLevel62, 1107296256, 524544, 524288, 1107296512, 256, TPMediaCodecProfileLevel.HEVCHighTierLevel62, 1073741824, 34078720, 1107296512, 1074266368, 33554688, 1073741824, 1107820544, 34078976, 1074266368, 256, TPMediaCodecProfileLevel.HEVCHighTierLevel62, 1107820544, 1107820800, 524544, 1107296256, 1107820800, 34078720, 0, 1074266112, 1107296256, 524544, 33554688, 1073742080, 524288, 0, 1074266112, 34078976, 1073742080};
    private static final int[] SP6 = {536870928, 541065216, 16384, 541081616, 541065216, 16, 541081616, 4194304, 536887296, 4210704, 4194304, 536870928, 4194320, 536887296, 536870912, 16400, 0, 4194320, 536887312, 16384, 4210688, 536887312, 16, 541065232, 541065232, 0, 4210704, 541081600, 16400, 4210688, 541081600, 536870912, 536887296, 16, 541065232, 4210688, 541081616, 4194304, 16400, 536870928, 4194304, 536887296, 536870912, 16400, 536870928, 541081616, 4210688, 541065216, 4210704, 541081600, 0, 541065232, 16, 16384, 541065216, 4210704, 16384, 4194320, 536887312, 0, 541081600, 536870912, 4194320, 536887312};
    private static final int[] SP7 = {2097152, 69206018, 67110914, 0, 2048, 67110914, 2099202, 69208064, 69208066, 2097152, 0, 67108866, 2, 67108864, 69206018, 2050, 67110912, 2099202, 2097154, 67110912, 67108866, 69206016, 69208064, 2097154, 69206016, 2048, 2050, 69208066, 2099200, 2, 67108864, 2099200, 67108864, 2099200, 2097152, 67110914, 67110914, 69206018, 69206018, 2, 2097154, 67108864, 67110912, 2097152, 69208064, 2050, 2099202, 69208064, 2050, 67108866, 69208066, 69206016, 2099200, 0, 2, 69208066, 0, 2099202, 69206016, 2048, 67108866, 67110912, 2048, 2097154};
    private static final int[] SP8 = {268439616, 4096, 262144, 268701760, 268435456, 268439616, 64, 268435456, 262208, 268697600, 268701760, 266240, 268701696, 266304, 4096, 64, 268697600, 268435520, 268439552, 4160, 266240, 262208, 268697664, 268701696, 4160, 0, 0, 268697664, 268435520, 268439552, 266304, 262144, 266304, 262144, 268701696, 4096, 64, 268697664, 4096, 266304, 268439552, 64, 268435520, 268697600, 268697664, 268435456, 262144, 268439616, 0, 268701760, 262208, 268435520, 268697600, 268439552, 268439616, 0, 268701760, 266240, 266240, 4160, 4160, 262208, 268435456, 268701696};
    private static final int[] bigbyte = {8388608, 4194304, 2097152, 1048576, 524288, 262144, 131072, 65536, 32768, 16384, 8192, 4096, 2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
    private static final short[] bytebit = {MqttException.REASON_CODE_SUBSCRIBE_FAILED, 64, 32, 16, 8, 4, 2, 1};
    private static final byte[] pc1 = {56, ISO7816.INS_DECREASE, 40, 32, Ascii.CAN, 16, 8, 0, 57, Framer.STDOUT_FRAME_PREFIX, 41, Framer.ENTER_FRAME_PREFIX, Ascii.EM, 17, 9, 1, 58, 50, ISO7816.INS_PSO, ISO7816.INS_MSE, Ascii.SUB, 18, 10, 2, 59, 51, 43, 35, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, Framer.STDIN_FRAME_PREFIX, 37, 29, 21, 13, 5, 60, ISO7816.INS_DECREASE_STAMPED, ISO7816.INS_UNBLOCK_CHV, ISO7816.INS_CHANGE_CHV, 28, 20, 12, 4, Ascii.ESC, 19, 11, 3};
    private static final byte[] pc2 = {13, 16, 10, 23, 0, 4, 2, Ascii.ESC, 14, 5, 20, 9, 22, 18, 11, 3, Ascii.EM, 7, 15, 6, Ascii.SUB, 19, 12, 1, 40, 51, 30, ISO7816.INS_CHANGE_CHV, 46, 54, 29, 39, 50, ISO7816.INS_UNBLOCK_CHV, 32, 47, 43, ISO7816.INS_DECREASE, 38, 55, Framer.ENTER_FRAME_PREFIX, ISO7816.INS_DECREASE_STAMPED, Framer.STDIN_FRAME_PREFIX, 41, Framer.STDOUT_FRAME_PREFIX, 35, 28, Ascii.US};
    private static final byte[] totrot = {1, 2, 4, 6, 8, 10, 12, 14, 15, 17, 19, 21, 23, Ascii.EM, Ascii.ESC, 28};
    private int[] workingKey = null;

    public void desFunc(int[] iArr, byte[] bArr, int i11, byte[] bArr2, int i12) {
        byte[] bArr3 = bArr2;
        int i13 = i12;
        int bigEndianToInt = Pack.bigEndianToInt(bArr, i11);
        int bigEndianToInt2 = Pack.bigEndianToInt(bArr, i11 + 4);
        int i14 = ((bigEndianToInt >>> 4) ^ bigEndianToInt2) & 252645135;
        int i15 = bigEndianToInt2 ^ i14;
        int i16 = bigEndianToInt ^ (i14 << 4);
        int i17 = ((i16 >>> 16) ^ i15) & 65535;
        int i18 = i15 ^ i17;
        int i19 = i16 ^ (i17 << 16);
        int i21 = ((i18 >>> 2) ^ i19) & 858993459;
        int i22 = i19 ^ i21;
        int i23 = i18 ^ (i21 << 2);
        int i24 = ((i23 >>> 8) ^ i22) & 16711935;
        int i25 = i22 ^ i24;
        int i26 = i23 ^ (i24 << 8);
        int i27 = (i26 >>> 31) | (i26 << 1);
        int i28 = (i25 ^ i27) & -1431655766;
        int i29 = i25 ^ i28;
        int i30 = i27 ^ i28;
        int i31 = (i29 >>> 31) | (i29 << 1);
        for (int i32 = 0; i32 < 8; i32++) {
            int i33 = i32 * 4;
            int i34 = ((i30 << 28) | (i30 >>> 4)) ^ iArr[i33 + 0];
            int[] iArr2 = SP7;
            int i35 = iArr2[i34 & 63];
            int[] iArr3 = SP5;
            int i36 = i35 | iArr3[(i34 >>> 8) & 63];
            int[] iArr4 = SP3;
            int i37 = i36 | iArr4[(i34 >>> 16) & 63];
            int[] iArr5 = SP1;
            int i38 = iArr5[(i34 >>> 24) & 63] | i37;
            int i39 = iArr[i33 + 1] ^ i30;
            int[] iArr6 = SP8;
            int i40 = i38 | iArr6[i39 & 63];
            int[] iArr7 = SP6;
            int i41 = i40 | iArr7[(i39 >>> 8) & 63];
            int[] iArr8 = SP4;
            int i42 = i41 | iArr8[(i39 >>> 16) & 63];
            int[] iArr9 = SP2;
            i31 ^= i42 | iArr9[(i39 >>> 24) & 63];
            int i43 = ((i31 << 28) | (i31 >>> 4)) ^ iArr[i33 + 2];
            int i44 = iArr5[(i43 >>> 24) & 63];
            int i45 = iArr[i33 + 3] ^ i31;
            i30 ^= ((((i44 | ((iArr2[i43 & 63] | iArr3[(i43 >>> 8) & 63]) | iArr4[(i43 >>> 16) & 63])) | iArr6[i45 & 63]) | iArr7[(i45 >>> 8) & 63]) | iArr8[(i45 >>> 16) & 63]) | iArr9[(i45 >>> 24) & 63];
        }
        int i46 = (i30 >>> 1) | (i30 << 31);
        int i47 = (i31 ^ i46) & -1431655766;
        int i48 = i31 ^ i47;
        int i49 = i46 ^ i47;
        int i50 = (i48 >>> 1) | (i48 << 31);
        int i51 = ((i50 >>> 8) ^ i49) & 16711935;
        int i52 = i49 ^ i51;
        int i53 = i50 ^ (i51 << 8);
        int i54 = ((i53 >>> 2) ^ i52) & 858993459;
        int i55 = i52 ^ i54;
        int i56 = i53 ^ (i54 << 2);
        int i57 = ((i55 >>> 16) ^ i56) & 65535;
        int i58 = i56 ^ i57;
        int i59 = i55 ^ (i57 << 16);
        int i60 = ((i59 >>> 4) ^ i58) & 252645135;
        Pack.intToBigEndian(i59 ^ (i60 << 4), bArr3, i13);
        Pack.intToBigEndian(i58 ^ i60, bArr3, i13 + 4);
    }

    public int[] generateWorkingKey(boolean z11, byte[] bArr) {
        int i11;
        int[] iArr = new int[32];
        boolean[] zArr = new boolean[56];
        boolean[] zArr2 = new boolean[56];
        int i12 = 0;
        while (true) {
            boolean z12 = true;
            if (i12 >= 56) {
                break;
            }
            byte b11 = pc1[i12];
            if ((bytebit[b11 & 7] & bArr[b11 >>> 3]) == 0) {
                z12 = false;
            }
            zArr[i12] = z12;
            i12++;
        }
        for (int i13 = 0; i13 < 16; i13++) {
            int i14 = z11 ? i13 << 1 : (15 - i13) << 1;
            int i15 = i14 + 1;
            iArr[i15] = 0;
            iArr[i14] = 0;
            int i16 = 0;
            while (true) {
                if (i16 >= 28) {
                    break;
                }
                int i17 = totrot[i13] + i16;
                if (i17 < 28) {
                    zArr2[i16] = zArr[i17];
                } else {
                    zArr2[i16] = zArr[i17 - 28];
                }
                i16++;
            }
            for (i11 = 28; i11 < 56; i11++) {
                int i18 = totrot[i13] + i11;
                if (i18 < 56) {
                    zArr2[i11] = zArr[i18];
                } else {
                    zArr2[i11] = zArr[i18 - 28];
                }
            }
            for (int i19 = 0; i19 < 24; i19++) {
                byte[] bArr2 = pc2;
                if (zArr2[bArr2[i19]]) {
                    iArr[i14] = iArr[i14] | bigbyte[i19];
                }
                if (zArr2[bArr2[i19 + 24]]) {
                    iArr[i15] = iArr[i15] | bigbyte[i19];
                }
            }
        }
        for (int i21 = 0; i21 != 32; i21 += 2) {
            int i22 = iArr[i21];
            int i23 = i21 + 1;
            int i24 = iArr[i23];
            iArr[i21] = ((16515072 & i24) >>> 10) | ((i22 & 16515072) << 6) | ((i22 & 4032) << 10) | ((i24 & 4032) >>> 6);
            iArr[i23] = ((i22 & 63) << 16) | ((i22 & 258048) << 12) | ((258048 & i24) >>> 4) | (i24 & 63);
        }
        return iArr;
    }

    public String getAlgorithmName() {
        return "DES";
    }

    public int getBlockSize() {
        return 8;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            KeyParameter keyParameter = (KeyParameter) cipherParameters;
            if (keyParameter.getKey().length <= 8) {
                this.workingKey = generateWorkingKey(z11, keyParameter.getKey());
                return;
            }
            throw new IllegalArgumentException("DES key too long - should be 8 bytes");
        }
        throw new IllegalArgumentException("invalid parameter passed to DES init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int[] iArr = this.workingKey;
        if (iArr == null) {
            throw new IllegalStateException("DES engine not initialised");
        } else if (i11 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + 8 <= bArr2.length) {
            desFunc(iArr, bArr, i11, bArr2, i12);
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
