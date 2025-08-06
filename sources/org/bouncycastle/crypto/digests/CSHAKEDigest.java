package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Arrays;

public class CSHAKEDigest extends SHAKEDigest {
    private static final byte[] padding = new byte[100];
    private final byte[] diff;

    public CSHAKEDigest(int i11, byte[] bArr, byte[] bArr2) {
        super(i11);
        if ((bArr == null || bArr.length == 0) && (bArr2 == null || bArr2.length == 0)) {
            this.diff = null;
            return;
        }
        this.diff = Arrays.concatenate(XofUtils.leftEncode((long) (this.rate / 8)), encodeString(bArr), encodeString(bArr2));
        diffPadAndAbsorb();
    }

    public CSHAKEDigest(CSHAKEDigest cSHAKEDigest) {
        super((SHAKEDigest) cSHAKEDigest);
        this.diff = Arrays.clone(cSHAKEDigest.diff);
    }

    private void diffPadAndAbsorb() {
        int i11 = this.rate / 8;
        byte[] bArr = this.diff;
        absorb(bArr, 0, bArr.length);
        int length = this.diff.length % i11;
        if (length != 0) {
            while (true) {
                i11 -= length;
                byte[] bArr2 = padding;
                if (i11 > bArr2.length) {
                    absorb(bArr2, 0, bArr2.length);
                    length = bArr2.length;
                } else {
                    absorb(bArr2, 0, i11);
                    return;
                }
            }
        }
    }

    private byte[] encodeString(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? XofUtils.leftEncode(0) : Arrays.concatenate(XofUtils.leftEncode(((long) bArr.length) * 8), bArr);
    }

    public int doOutput(byte[] bArr, int i11, int i12) {
        if (this.diff == null) {
            return super.doOutput(bArr, i11, i12);
        }
        if (!this.squeezing) {
            absorbBits(0, 2);
        }
        squeeze(bArr, i11, ((long) i12) * 8);
        return i12;
    }

    public String getAlgorithmName() {
        return "CSHAKE" + this.fixedOutputLength;
    }

    public void reset() {
        super.reset();
        if (this.diff != null) {
            diffPadAndAbsorb();
        }
    }
}
