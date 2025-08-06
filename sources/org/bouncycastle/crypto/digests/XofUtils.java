package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Arrays;

public class XofUtils {
    public static byte[] encode(byte b11) {
        return Arrays.concatenate(leftEncode(8), new byte[]{b11});
    }

    public static byte[] encode(byte[] bArr, int i11, int i12) {
        return bArr.length == i12 ? Arrays.concatenate(leftEncode((long) (i12 * 8)), bArr) : Arrays.concatenate(leftEncode((long) (i12 * 8)), Arrays.copyOfRange(bArr, i11, i12 + i11));
    }

    public static byte[] leftEncode(long j11) {
        long j12 = j11;
        byte b11 = 1;
        while (true) {
            j12 >>= 8;
            if (j12 == 0) {
                break;
            }
            b11 = (byte) (b11 + 1);
        }
        byte[] bArr = new byte[(b11 + 1)];
        bArr[0] = b11;
        for (int i11 = 1; i11 <= b11; i11++) {
            bArr[i11] = (byte) ((int) (j11 >> ((b11 - i11) * 8)));
        }
        return bArr;
    }

    public static byte[] rightEncode(long j11) {
        long j12 = j11;
        byte b11 = 1;
        while (true) {
            j12 >>= 8;
            if (j12 == 0) {
                break;
            }
            b11 = (byte) (b11 + 1);
        }
        byte[] bArr = new byte[(b11 + 1)];
        bArr[b11] = b11;
        for (int i11 = 0; i11 < b11; i11++) {
            bArr[i11] = (byte) ((int) (j11 >> (((b11 - i11) - 1) * 8)));
        }
        return bArr;
    }
}
