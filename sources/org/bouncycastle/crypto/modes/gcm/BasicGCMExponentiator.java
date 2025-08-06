package org.bouncycastle.crypto.modes.gcm;

public class BasicGCMExponentiator implements GCMExponentiator {

    /* renamed from: x  reason: collision with root package name */
    private long[] f59247x;

    public void exponentiateX(long j11, byte[] bArr) {
        long[] oneAsLongs = GCMUtil.oneAsLongs();
        if (j11 > 0) {
            long[] jArr = new long[2];
            GCMUtil.copy(this.f59247x, jArr);
            do {
                if ((1 & j11) != 0) {
                    GCMUtil.multiply(oneAsLongs, jArr);
                }
                GCMUtil.square(jArr, jArr);
                j11 >>>= 1;
            } while (j11 > 0);
        }
        GCMUtil.asBytes(oneAsLongs, bArr);
    }

    public void init(byte[] bArr) {
        this.f59247x = GCMUtil.asLongs(bArr);
    }
}
