package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.RC5Parameters;

public class RC564Engine implements BlockCipher {
    private static final long P64 = -5196783011329398165L;
    private static final long Q64 = -7046029254386353131L;
    private static final int bytesPerWord = 8;
    private static final int wordSize = 64;
    private long[] _S = null;
    private int _noRounds = 12;
    private boolean forEncryption;

    private long bytesToWord(byte[] bArr, int i11) {
        long j11 = 0;
        for (int i12 = 7; i12 >= 0; i12--) {
            j11 = (j11 << 8) + ((long) (bArr[i12 + i11] & 255));
        }
        return j11;
    }

    private int decryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        long bytesToWord = bytesToWord(bArr, i11);
        long bytesToWord2 = bytesToWord(bArr, i11 + 8);
        for (int i13 = this._noRounds; i13 >= 1; i13--) {
            int i14 = i13 * 2;
            bytesToWord2 = rotateRight(bytesToWord2 - this._S[i14 + 1], bytesToWord) ^ bytesToWord;
            bytesToWord = rotateRight(bytesToWord - this._S[i14], bytesToWord2) ^ bytesToWord2;
        }
        wordToBytes(bytesToWord - this._S[0], bArr2, i12);
        wordToBytes(bytesToWord2 - this._S[1], bArr2, i12 + 8);
        return 16;
    }

    private int encryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        long bytesToWord = bytesToWord(bArr, i11) + this._S[0];
        long bytesToWord2 = bytesToWord(bArr, i11 + 8) + this._S[1];
        for (int i13 = 1; i13 <= this._noRounds; i13++) {
            int i14 = i13 * 2;
            bytesToWord = rotateLeft(bytesToWord ^ bytesToWord2, bytesToWord2) + this._S[i14];
            bytesToWord2 = rotateLeft(bytesToWord2 ^ bytesToWord, bytesToWord) + this._S[i14 + 1];
        }
        wordToBytes(bytesToWord, bArr2, i12);
        wordToBytes(bytesToWord2, bArr2, i12 + 8);
        return 16;
    }

    private long rotateLeft(long j11, long j12) {
        long j13 = j12 & 63;
        return (j11 >>> ((int) (64 - j13))) | (j11 << ((int) j13));
    }

    private long rotateRight(long j11, long j12) {
        long j13 = j12 & 63;
        return (j11 << ((int) (64 - j13))) | (j11 >>> ((int) j13));
    }

    private void setKey(byte[] bArr) {
        long[] jArr;
        int length = (bArr.length + 7) / 8;
        long[] jArr2 = new long[length];
        for (int i11 = 0; i11 != bArr.length; i11++) {
            int i12 = i11 / 8;
            jArr2[i12] = jArr2[i12] + (((long) (bArr[i11] & 255)) << ((i11 % 8) * 8));
        }
        long[] jArr3 = new long[((this._noRounds + 1) * 2)];
        this._S = jArr3;
        jArr3[0] = -5196783011329398165L;
        int i13 = 1;
        while (true) {
            jArr = this._S;
            if (i13 >= jArr.length) {
                break;
            }
            jArr[i13] = jArr[i13 - 1] + Q64;
            i13++;
        }
        int length2 = length > jArr.length ? length * 3 : jArr.length * 3;
        long j11 = 0;
        long j12 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < length2; i16++) {
            long[] jArr4 = this._S;
            j11 = rotateLeft(jArr4[i14] + j11 + j12, 3);
            jArr4[i14] = j11;
            j12 = rotateLeft(jArr2[i15] + j11 + j12, j12 + j11);
            jArr2[i15] = j12;
            i14 = (i14 + 1) % this._S.length;
            i15 = (i15 + 1) % length;
        }
    }

    private void wordToBytes(long j11, byte[] bArr, int i11) {
        for (int i12 = 0; i12 < 8; i12++) {
            bArr[i12 + i11] = (byte) ((int) j11);
            j11 >>>= 8;
        }
    }

    public String getAlgorithmName() {
        return "RC5-64";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof RC5Parameters) {
            RC5Parameters rC5Parameters = (RC5Parameters) cipherParameters;
            this.forEncryption = z11;
            this._noRounds = rC5Parameters.getRounds();
            setKey(rC5Parameters.getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to RC564 init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        return this.forEncryption ? encryptBlock(bArr, i11, bArr2, i12) : decryptBlock(bArr, i11, bArr2, i12);
    }

    public void reset() {
    }
}
