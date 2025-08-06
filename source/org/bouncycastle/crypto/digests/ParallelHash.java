package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class ParallelHash implements Xof, Digest {
    private static final byte[] N_PARALLEL_HASH = Strings.toByteArray("ParallelHash");
    private final int B;
    private final int bitLength;
    private int bufOff;
    private final byte[] buffer;
    private final CSHAKEDigest compressor;
    private final byte[] compressorBuffer;
    private final CSHAKEDigest cshake;
    private boolean firstOutput;
    private int nCount;
    private final int outputLength;

    public ParallelHash(int i11, byte[] bArr, int i12) {
        this(i11, bArr, i12, i11 * 2);
    }

    public ParallelHash(int i11, byte[] bArr, int i12, int i13) {
        this.cshake = new CSHAKEDigest(i11, N_PARALLEL_HASH, bArr);
        this.compressor = new CSHAKEDigest(i11, new byte[0], new byte[0]);
        this.bitLength = i11;
        this.B = i12;
        this.outputLength = (i13 + 7) / 8;
        this.buffer = new byte[i12];
        this.compressorBuffer = new byte[((i11 * 2) / 8)];
        reset();
    }

    public ParallelHash(ParallelHash parallelHash) {
        this.cshake = new CSHAKEDigest(parallelHash.cshake);
        this.compressor = new CSHAKEDigest(parallelHash.compressor);
        this.bitLength = parallelHash.bitLength;
        this.B = parallelHash.B;
        this.outputLength = parallelHash.outputLength;
        this.buffer = Arrays.clone(parallelHash.buffer);
        this.compressorBuffer = Arrays.clone(parallelHash.compressorBuffer);
    }

    private void compress() {
        compress(this.buffer, 0, this.bufOff);
        this.bufOff = 0;
    }

    private void compress(byte[] bArr, int i11, int i12) {
        this.compressor.update(bArr, i11, i12);
        CSHAKEDigest cSHAKEDigest = this.compressor;
        byte[] bArr2 = this.compressorBuffer;
        cSHAKEDigest.doFinal(bArr2, 0, bArr2.length);
        CSHAKEDigest cSHAKEDigest2 = this.cshake;
        byte[] bArr3 = this.compressorBuffer;
        cSHAKEDigest2.update(bArr3, 0, bArr3.length);
        this.nCount++;
    }

    private void wrapUp(int i11) {
        if (this.bufOff != 0) {
            compress();
        }
        byte[] rightEncode = XofUtils.rightEncode((long) this.nCount);
        byte[] rightEncode2 = XofUtils.rightEncode((long) (i11 * 8));
        this.cshake.update(rightEncode, 0, rightEncode.length);
        this.cshake.update(rightEncode2, 0, rightEncode2.length);
        this.firstOutput = false;
    }

    public int doFinal(byte[] bArr, int i11) throws DataLengthException, IllegalStateException {
        if (this.firstOutput) {
            wrapUp(this.outputLength);
        }
        int doFinal = this.cshake.doFinal(bArr, i11, getDigestSize());
        reset();
        return doFinal;
    }

    public int doFinal(byte[] bArr, int i11, int i12) {
        if (this.firstOutput) {
            wrapUp(this.outputLength);
        }
        int doFinal = this.cshake.doFinal(bArr, i11, i12);
        reset();
        return doFinal;
    }

    public int doOutput(byte[] bArr, int i11, int i12) {
        if (this.firstOutput) {
            wrapUp(0);
        }
        return this.cshake.doOutput(bArr, i11, i12);
    }

    public String getAlgorithmName() {
        return "ParallelHash" + this.cshake.getAlgorithmName().substring(6);
    }

    public int getByteLength() {
        return this.cshake.getByteLength();
    }

    public int getDigestSize() {
        return this.outputLength;
    }

    public void reset() {
        this.cshake.reset();
        Arrays.clear(this.buffer);
        byte[] leftEncode = XofUtils.leftEncode((long) this.B);
        this.cshake.update(leftEncode, 0, leftEncode.length);
        this.nCount = 0;
        this.bufOff = 0;
        this.firstOutput = true;
    }

    public void update(byte b11) throws IllegalStateException {
        byte[] bArr = this.buffer;
        int i11 = this.bufOff;
        int i12 = i11 + 1;
        this.bufOff = i12;
        bArr[i11] = b11;
        if (i12 == bArr.length) {
            compress();
        }
    }

    public void update(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalStateException {
        int i13 = 0;
        int max = Math.max(0, i12);
        if (this.bufOff != 0) {
            while (i13 < max) {
                int i14 = this.bufOff;
                byte[] bArr2 = this.buffer;
                if (i14 == bArr2.length) {
                    break;
                }
                this.bufOff = i14 + 1;
                bArr2[i14] = bArr[i13 + i11];
                i13++;
            }
            if (this.bufOff == this.buffer.length) {
                compress();
            }
        }
        if (i13 < max) {
            while (true) {
                int i15 = max - i13;
                int i16 = this.B;
                if (i15 <= i16) {
                    break;
                }
                compress(bArr, i11 + i13, i16);
                i13 += this.B;
            }
        }
        while (i13 < max) {
            update(bArr[i13 + i11]);
            i13++;
        }
    }
}
