package com.huawei.hms.support.log.common;

import com.google.common.base.Ascii;
import net.sf.scuba.smartcards.ISO7816;
import okio.Utf8;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public final class Base64 {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f38534a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', '='};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f38535b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, 28, 29, 30, Ascii.US, 32, Framer.ENTER_FRAME_PREFIX, ISO7816.INS_MSE, 35, ISO7816.INS_CHANGE_CHV, 37, 38, 39, 40, 41, ISO7816.INS_PSO, 43, ISO7816.INS_UNBLOCK_CHV, Framer.STDIN_FRAME_PREFIX, 46, 47, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    private Base64() {
    }

    private static int a(String str) {
        int length = str.length();
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt > 255 || f38535b[charAt] < 0) {
                length--;
            }
        }
        return length;
    }

    public static byte[] decode(String str) {
        byte b11;
        if (str == null) {
            return new byte[0];
        }
        int a11 = a(str);
        int i11 = (a11 / 4) * 3;
        int i12 = a11 % 4;
        if (i12 == 3) {
            i11 += 2;
        }
        if (i12 == 2) {
            i11++;
        }
        byte[] bArr = new byte[i11];
        int i13 = 0;
        byte b12 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < str.length(); i15++) {
            char charAt = str.charAt(i15);
            if (charAt > 255) {
                b11 = -1;
            } else {
                b11 = f38535b[charAt];
            }
            if (b11 >= 0) {
                i14 += 6;
                b12 = (b12 << 6) | b11;
                if (i14 >= 8) {
                    i14 -= 8;
                    bArr[i13] = (byte) (255 & (b12 >> i14));
                    i13++;
                }
            }
        }
        return i13 != i11 ? new byte[0] : bArr;
    }

    public static String encode(byte[] bArr) {
        return bArr == null ? "" : encode(bArr, bArr.length);
    }

    public static String encode(byte[] bArr, int i11) {
        boolean z11;
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[(((i11 + 2) / 3) * 4)];
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = (bArr[i12] & 255) << 8;
            int i15 = i12 + 1;
            boolean z12 = true;
            if (i15 < i11) {
                i14 |= bArr[i15] & 255;
                z11 = true;
            } else {
                z11 = false;
            }
            int i16 = i14 << 8;
            int i17 = i12 + 2;
            if (i17 < i11) {
                i16 |= bArr[i17] & 255;
            } else {
                z12 = false;
            }
            int i18 = i13 + 3;
            char[] cArr2 = f38534a;
            int i19 = 64;
            cArr[i18] = cArr2[z12 ? i16 & 63 : 64];
            int i21 = i16 >> 6;
            int i22 = i13 + 2;
            if (z11) {
                i19 = i21 & 63;
            }
            cArr[i22] = cArr2[i19];
            int i23 = i21 >> 6;
            cArr[i13 + 1] = cArr2[i23 & 63];
            cArr[i13 + 0] = cArr2[(i23 >> 6) & 63];
            i12 += 3;
            i13 += 4;
        }
        return new String(cArr);
    }
}
