package org.bouncycastle.util.encoders;

import com.google.common.base.Ascii;
import okio.Utf8;

public class UTF8 {
    private static final byte C_CR1 = 1;
    private static final byte C_CR2 = 2;
    private static final byte C_CR3 = 3;
    private static final byte C_ILL = 0;
    private static final byte C_L2A = 4;
    private static final byte C_L3A = 5;
    private static final byte C_L3B = 6;
    private static final byte C_L3C = 7;
    private static final byte C_L4A = 8;
    private static final byte C_L4B = 9;
    private static final byte C_L4C = 10;
    private static final byte S_CS1 = 0;
    private static final byte S_CS2 = 16;
    private static final byte S_CS3 = 32;
    private static final byte S_END = -1;
    private static final byte S_ERR = -2;
    private static final byte S_P3A = 48;
    private static final byte S_P3B = 64;
    private static final byte S_P4A = 80;
    private static final byte S_P4B = 96;
    private static final short[] firstUnitTable = new short[128];
    private static final byte[] transitionTable;

    static {
        byte[] bArr = new byte[112];
        transitionTable = bArr;
        byte[] bArr2 = new byte[128];
        fill(bArr2, 0, 15, (byte) 1);
        fill(bArr2, 16, 31, (byte) 2);
        fill(bArr2, 32, 63, (byte) 3);
        fill(bArr2, 64, 65, (byte) 0);
        fill(bArr2, 66, 95, (byte) 4);
        fill(bArr2, 96, 96, (byte) 5);
        fill(bArr2, 97, 108, (byte) 6);
        fill(bArr2, 109, 109, (byte) 7);
        fill(bArr2, 110, 111, (byte) 6);
        fill(bArr2, 112, 112, (byte) 8);
        fill(bArr2, 113, 115, (byte) 9);
        fill(bArr2, 116, 116, (byte) 10);
        fill(bArr2, 117, 127, (byte) 0);
        fill(bArr, 0, bArr.length - 1, S_ERR);
        fill(bArr, 8, 11, (byte) -1);
        fill(bArr, 24, 27, (byte) 0);
        fill(bArr, 40, 43, (byte) 16);
        fill(bArr, 58, 59, (byte) 0);
        fill(bArr, 72, 73, (byte) 0);
        fill(bArr, 89, 91, (byte) 16);
        fill(bArr, 104, 104, (byte) 16);
        byte[] bArr3 = {0, 0, 0, 0, Ascii.US, 15, 15, 15, 7, 7, 7};
        byte[] bArr4 = {S_ERR, S_ERR, S_ERR, S_ERR, 0, 48, 16, 64, S_P4A, 32, S_P4B};
        for (int i11 = 0; i11 < 128; i11++) {
            byte b11 = bArr2[i11];
            firstUnitTable[i11] = (short) (bArr4[b11] | ((bArr3[b11] & i11) << 8));
        }
    }

    private static void fill(byte[] bArr, int i11, int i12, byte b11) {
        while (i11 <= i12) {
            bArr[i11] = b11;
            i11++;
        }
    }

    public static int transcodeToUTF16(byte[] bArr, int i11, int i12, char[] cArr) {
        int i13 = i12 + i11;
        int i14 = 0;
        while (i11 < i13) {
            int i15 = i11 + 1;
            byte b11 = bArr[i11];
            if (b11 < 0) {
                short s11 = firstUnitTable[b11 & Ascii.DEL];
                int i16 = s11 >>> 8;
                byte b12 = (byte) s11;
                while (b12 >= 0) {
                    if (i15 >= bArr.length) {
                        return -1;
                    }
                    int i17 = i15 + 1;
                    byte b13 = bArr[i15];
                    i16 = (i16 << 6) | (b13 & Utf8.REPLACEMENT_BYTE);
                    b12 = transitionTable[b12 + ((b13 & 255) >>> 4)];
                    i15 = i17;
                }
                if (b12 == -2) {
                    return -1;
                }
                if (i16 <= 65535) {
                    if (i14 >= cArr.length) {
                        return -1;
                    }
                    cArr[i14] = (char) i16;
                    i14++;
                } else if (i14 >= cArr.length - 1) {
                    return -1;
                } else {
                    int i18 = i14 + 1;
                    cArr[i14] = (char) ((i16 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                    i14 = i18 + 1;
                    cArr[i18] = (char) (56320 | (i16 & 1023));
                }
                i11 = i15;
            } else if (i14 >= cArr.length) {
                return -1;
            } else {
                cArr[i14] = (char) b11;
                i11 = i15;
                i14++;
            }
        }
        return i14;
    }

    public static int transcodeToUTF16(byte[] bArr, char[] cArr) {
        return transcodeToUTF16(bArr, 0, bArr.length, cArr);
    }
}
