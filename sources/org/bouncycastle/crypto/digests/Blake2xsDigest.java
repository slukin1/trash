package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.Xof;
import org.bouncycastle.util.Arrays;

public class Blake2xsDigest implements Xof {
    private static final int DIGEST_LENGTH = 32;
    private static final long MAX_NUMBER_BLOCKS = 4294967296L;
    public static final int UNKNOWN_DIGEST_LENGTH = 65535;
    private long blockPos;
    private byte[] buf;
    private int bufPos;
    private int digestLength;
    private int digestPos;

    /* renamed from: h0  reason: collision with root package name */
    private byte[] f59130h0;
    private Blake2sDigest hash;
    private long nodeOffset;

    public Blake2xsDigest() {
        this(65535);
    }

    public Blake2xsDigest(int i11) {
        this(i11, (byte[]) null, (byte[]) null, (byte[]) null);
    }

    public Blake2xsDigest(int i11, byte[] bArr) {
        this(i11, bArr, (byte[]) null, (byte[]) null);
    }

    public Blake2xsDigest(int i11, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f59130h0 = null;
        this.buf = new byte[32];
        this.bufPos = 32;
        this.digestPos = 0;
        this.blockPos = 0;
        if (i11 < 1 || i11 > 65535) {
            throw new IllegalArgumentException("BLAKE2xs digest length must be between 1 and 2^16-1");
        }
        this.digestLength = i11;
        this.nodeOffset = computeNodeOffset();
        this.hash = new Blake2sDigest(32, bArr, bArr2, bArr3, this.nodeOffset);
    }

    public Blake2xsDigest(Blake2xsDigest blake2xsDigest) {
        this.f59130h0 = null;
        this.buf = new byte[32];
        this.bufPos = 32;
        this.digestPos = 0;
        this.blockPos = 0;
        this.digestLength = blake2xsDigest.digestLength;
        this.hash = new Blake2sDigest(blake2xsDigest.hash);
        this.f59130h0 = Arrays.clone(blake2xsDigest.f59130h0);
        this.buf = Arrays.clone(blake2xsDigest.buf);
        this.bufPos = blake2xsDigest.bufPos;
        this.digestPos = blake2xsDigest.digestPos;
        this.blockPos = blake2xsDigest.blockPos;
        this.nodeOffset = blake2xsDigest.nodeOffset;
    }

    private long computeNodeOffset() {
        return ((long) this.digestLength) * MAX_NUMBER_BLOCKS;
    }

    private int computeStepLength() {
        int i11 = this.digestLength;
        if (i11 == 65535) {
            return 32;
        }
        return Math.min(32, i11 - this.digestPos);
    }

    public int doFinal(byte[] bArr, int i11) {
        return doFinal(bArr, i11, bArr.length);
    }

    public int doFinal(byte[] bArr, int i11, int i12) {
        int doOutput = doOutput(bArr, i11, i12);
        reset();
        return doOutput;
    }

    public int doOutput(byte[] bArr, int i11, int i12) {
        if (this.f59130h0 == null) {
            byte[] bArr2 = new byte[this.hash.getDigestSize()];
            this.f59130h0 = bArr2;
            this.hash.doFinal(bArr2, 0);
        }
        int i13 = this.digestLength;
        if (i13 != 65535) {
            if (this.digestPos + i12 > i13) {
                throw new IllegalArgumentException("Output length is above the digest length");
            }
        } else if ((this.blockPos << 5) >= getUnknownMaxLength()) {
            throw new IllegalArgumentException("Maximum length is 2^32 blocks of 32 bytes");
        }
        for (int i14 = 0; i14 < i12; i14++) {
            if (this.bufPos >= 32) {
                Blake2sDigest blake2sDigest = new Blake2sDigest(computeStepLength(), 32, this.nodeOffset);
                byte[] bArr3 = this.f59130h0;
                blake2sDigest.update(bArr3, 0, bArr3.length);
                Arrays.fill(this.buf, (byte) 0);
                blake2sDigest.doFinal(this.buf, 0);
                this.bufPos = 0;
                this.nodeOffset++;
                this.blockPos++;
            }
            byte[] bArr4 = this.buf;
            int i15 = this.bufPos;
            bArr[i14] = bArr4[i15];
            this.bufPos = i15 + 1;
            this.digestPos++;
        }
        return i12;
    }

    public String getAlgorithmName() {
        return "BLAKE2xs";
    }

    public int getByteLength() {
        return this.hash.getByteLength();
    }

    public int getDigestSize() {
        return this.digestLength;
    }

    public long getUnknownMaxLength() {
        return 137438953472L;
    }

    public void reset() {
        this.hash.reset();
        this.f59130h0 = null;
        this.bufPos = 32;
        this.digestPos = 0;
        this.blockPos = 0;
        this.nodeOffset = computeNodeOffset();
    }

    public void update(byte b11) {
        this.hash.update(b11);
    }

    public void update(byte[] bArr, int i11, int i12) {
        this.hash.update(bArr, i11, i12);
    }
}
