package com.tencent.android.tpns.mqtt.internal.security;

public class SimpleBase64Encoder {
    private static final char[] PWDCHARS_ARRAY = PWDCHARS_STRING.toCharArray();
    private static final String PWDCHARS_STRING = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static byte[] decode(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[((length * 3) / 4)];
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (length < 4) {
                break;
            }
            long from64 = from64(bytes, i11, 4);
            length -= 4;
            i11 += 4;
            for (int i13 = 2; i13 >= 0; i13--) {
                bArr[i12 + i13] = (byte) ((int) (from64 & 255));
                from64 >>= 8;
            }
            i12 += 3;
        }
        if (length == 3) {
            long from642 = from64(bytes, i11, 3);
            for (int i14 = 1; i14 >= 0; i14--) {
                bArr[i12 + i14] = (byte) ((int) (from642 & 255));
                from642 >>= 8;
            }
        }
        if (length == 2) {
            bArr[i12] = (byte) ((int) (from64(bytes, i11, 2) & 255));
        }
        return bArr;
    }

    public static String encode(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer(((length + 2) / 3) * 4);
        int i11 = 0;
        while (length >= 3) {
            stringBuffer.append(to64((long) (((bArr[i11] & 255) << 16) | ((bArr[i11 + 1] & 255) << 8) | (bArr[i11 + 2] & 255)), 4));
            i11 += 3;
            length -= 3;
        }
        if (length == 2) {
            stringBuffer.append(to64((long) (((bArr[i11] & 255) << 8) | (bArr[i11 + 1] & 255)), 3));
        }
        if (length == 1) {
            stringBuffer.append(to64((long) (bArr[i11] & 255), 2));
        }
        return stringBuffer.toString();
    }

    private static final long from64(byte[] bArr, int i11, int i12) {
        int i13 = 0;
        long j11 = 0;
        while (i12 > 0) {
            i12--;
            int i14 = i11 + 1;
            byte b11 = bArr[i11];
            long j12 = b11 == 47 ? 1 : 0;
            if (b11 >= 48 && b11 <= 57) {
                j12 = (long) ((b11 + 2) - 48);
            }
            if (b11 >= 65 && b11 <= 90) {
                j12 = (long) ((b11 + 12) - 65);
            }
            if (b11 >= 97 && b11 <= 122) {
                j12 = (long) ((b11 + 38) - 97);
            }
            j11 += j12 << i13;
            i13 += 6;
            i11 = i14;
        }
        return j11;
    }

    private static final String to64(long j11, int i11) {
        StringBuffer stringBuffer = new StringBuffer(i11);
        while (i11 > 0) {
            i11--;
            stringBuffer.append(PWDCHARS_ARRAY[(int) (63 & j11)]);
            j11 >>= 6;
        }
        return stringBuffer.toString();
    }
}
