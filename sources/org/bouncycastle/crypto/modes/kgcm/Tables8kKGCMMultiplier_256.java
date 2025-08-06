package org.bouncycastle.crypto.modes.kgcm;

import java.lang.reflect.Array;

public class Tables8kKGCMMultiplier_256 implements KGCMMultiplier {
    private long[][] T;

    public void init(long[] jArr) {
        long[][] jArr2 = this.T;
        if (jArr2 == null) {
            this.T = (long[][]) Array.newInstance(long.class, new int[]{256, 4});
        } else if (KGCMUtil_256.equal(jArr, jArr2[1])) {
            return;
        }
        KGCMUtil_256.copy(jArr, this.T[1]);
        for (int i11 = 2; i11 < 256; i11 += 2) {
            long[][] jArr3 = this.T;
            KGCMUtil_256.multiplyX(jArr3[i11 >> 1], jArr3[i11]);
            long[][] jArr4 = this.T;
            KGCMUtil_256.add(jArr4[i11], jArr4[1], jArr4[i11 + 1]);
        }
    }

    public void multiplyH(long[] jArr) {
        long[] jArr2 = new long[4];
        KGCMUtil_256.copy(this.T[((int) (jArr[3] >>> 56)) & 255], jArr2);
        for (int i11 = 30; i11 >= 0; i11--) {
            KGCMUtil_256.multiplyX8(jArr2, jArr2);
            KGCMUtil_256.add(this.T[((int) (jArr[i11 >>> 3] >>> ((i11 & 7) << 3))) & 255], jArr2, jArr2);
        }
        KGCMUtil_256.copy(jArr2, jArr);
    }
}
