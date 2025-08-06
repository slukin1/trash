package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.Xof;

public class SHAKEDigest extends KeccakDigest implements Xof {
    public SHAKEDigest() {
        this(128);
    }

    public SHAKEDigest(int i11) {
        super(checkBitLength(i11));
    }

    public SHAKEDigest(SHAKEDigest sHAKEDigest) {
        super((KeccakDigest) sHAKEDigest);
    }

    private static int checkBitLength(int i11) {
        if (i11 == 128 || i11 == 256) {
            return i11;
        }
        throw new IllegalArgumentException("'bitLength' " + i11 + " not supported for SHAKE");
    }

    public int doFinal(byte[] bArr, int i11) {
        return doFinal(bArr, i11, getDigestSize());
    }

    public int doFinal(byte[] bArr, int i11, byte b11, int i12) {
        return doFinal(bArr, i11, getDigestSize(), b11, i12);
    }

    public int doFinal(byte[] bArr, int i11, int i12) {
        int doOutput = doOutput(bArr, i11, i12);
        reset();
        return doOutput;
    }

    public int doFinal(byte[] bArr, int i11, int i12, byte b11, int i13) {
        if (i13 < 0 || i13 > 7) {
            throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
        }
        int i14 = (b11 & ((1 << i13) - 1)) | (15 << i13);
        int i15 = i13 + 4;
        if (i15 >= 8) {
            absorb((byte) i14);
            i15 -= 8;
            i14 >>>= 8;
        }
        if (i15 > 0) {
            absorbBits(i14, i15);
        }
        squeeze(bArr, i11, ((long) i12) * 8);
        reset();
        return i12;
    }

    public int doOutput(byte[] bArr, int i11, int i12) {
        if (!this.squeezing) {
            absorbBits(15, 4);
        }
        squeeze(bArr, i11, ((long) i12) * 8);
        return i12;
    }

    public String getAlgorithmName() {
        return "SHAKE" + this.fixedOutputLength;
    }

    public int getDigestSize() {
        return this.fixedOutputLength / 4;
    }
}
