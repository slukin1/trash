package org.bouncycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.bouncycastle.util.Pack;

public class Tables4kGCMMultiplier implements GCMMultiplier {
    private byte[] H;
    private long[][] T;

    public void init(byte[] bArr) {
        if (this.T == null) {
            this.T = (long[][]) Array.newInstance(long.class, new int[]{256, 2});
        } else if (GCMUtil.areEqual(this.H, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.H = bArr2;
        GCMUtil.copy(bArr, bArr2);
        GCMUtil.asLongs(this.H, this.T[1]);
        long[][] jArr = this.T;
        GCMUtil.multiplyP7(jArr[1], jArr[1]);
        for (int i11 = 2; i11 < 256; i11 += 2) {
            long[][] jArr2 = this.T;
            GCMUtil.divideP(jArr2[i11 >> 1], jArr2[i11]);
            long[][] jArr3 = this.T;
            GCMUtil.xor(jArr3[i11], jArr3[1], jArr3[i11 + 1]);
        }
    }

    public void multiplyH(byte[] bArr) {
        byte[] bArr2 = bArr;
        long[] jArr = this.T[bArr2[15] & 255];
        long j11 = jArr[0];
        long j12 = jArr[1];
        for (int i11 = 14; i11 >= 0; i11--) {
            long[] jArr2 = this.T[bArr2[i11] & 255];
            long j13 = j12 << 56;
            j12 = ((j12 >>> 8) | (j11 << 56)) ^ jArr2[1];
            j11 = (((((j11 >>> 8) ^ jArr2[0]) ^ j13) ^ (j13 >>> 1)) ^ (j13 >>> 2)) ^ (j13 >>> 7);
        }
        Pack.longToBigEndian(j11, bArr2, 0);
        Pack.longToBigEndian(j12, bArr2, 8);
    }
}
