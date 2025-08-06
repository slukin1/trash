package org.bouncycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.bouncycastle.util.Pack;

public class Tables8kGCMMultiplier implements GCMMultiplier {
    private byte[] H;
    private long[][][] T;

    public void init(byte[] bArr) {
        if (this.T == null) {
            this.T = (long[][][]) Array.newInstance(long.class, new int[]{2, 256, 2});
        } else if (GCMUtil.areEqual(this.H, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.H = bArr2;
        GCMUtil.copy(bArr, bArr2);
        int i11 = 0;
        while (true) {
            if (i11 < 2) {
                long[][][] jArr = this.T;
                long[][] jArr2 = jArr[i11];
                if (i11 == 0) {
                    GCMUtil.asLongs(this.H, jArr2[1]);
                    GCMUtil.multiplyP7(jArr2[1], jArr2[1]);
                } else {
                    GCMUtil.multiplyP8(jArr[i11 - 1][1], jArr2[1]);
                }
                for (int i12 = 2; i12 < 256; i12 += 2) {
                    GCMUtil.divideP(jArr2[i12 >> 1], jArr2[i12]);
                    GCMUtil.xor(jArr2[i12], jArr2[1], jArr2[i12 + 1]);
                }
                i11++;
            } else {
                return;
            }
        }
    }

    public void multiplyH(byte[] bArr) {
        byte[] bArr2 = bArr;
        long[][][] jArr = this.T;
        long[][] jArr2 = jArr[0];
        long[][] jArr3 = jArr[1];
        long[] jArr4 = jArr2[bArr2[14] & 255];
        long[] jArr5 = jArr3[bArr2[15] & 255];
        long j11 = jArr4[0] ^ jArr5[0];
        long j12 = jArr5[1] ^ jArr4[1];
        for (int i11 = 12; i11 >= 0; i11 -= 2) {
            long[] jArr6 = jArr2[bArr2[i11] & 255];
            long[] jArr7 = jArr3[bArr2[i11 + 1] & 255];
            long j13 = j12 << 48;
            j12 = (jArr6[1] ^ jArr7[1]) ^ ((j12 >>> 16) | (j11 << 48));
            j11 = (((((j11 >>> 16) ^ (jArr6[0] ^ jArr7[0])) ^ j13) ^ (j13 >>> 1)) ^ (j13 >>> 2)) ^ (j13 >>> 7);
        }
        Pack.longToBigEndian(j11, bArr2, 0);
        Pack.longToBigEndian(j12, bArr2, 8);
    }
}
