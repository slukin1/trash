package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class RC6Engine implements BlockCipher {
    private static final int LGW = 5;
    private static final int P32 = -1209970333;
    private static final int Q32 = -1640531527;
    private static final int _noRounds = 20;
    private static final int bytesPerWord = 4;
    private static final int wordSize = 32;
    private int[] _S = null;
    private boolean forEncryption;

    private int bytesToWord(byte[] bArr, int i11) {
        int i12 = 0;
        for (int i13 = 3; i13 >= 0; i13--) {
            i12 = (i12 << 8) + (bArr[i13 + i11] & 255);
        }
        return i12;
    }

    private int decryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int bytesToWord = bytesToWord(bArr, i11);
        int bytesToWord2 = bytesToWord(bArr, i11 + 4);
        int bytesToWord3 = bytesToWord(bArr, i11 + 8);
        int bytesToWord4 = bytesToWord(bArr, i11 + 12);
        int[] iArr = this._S;
        int i13 = bytesToWord3 - iArr[43];
        int i14 = bytesToWord - iArr[42];
        int i15 = 20;
        while (i15 >= 1) {
            int rotateLeft = rotateLeft(((i14 * 2) + 1) * i14, 5);
            int rotateLeft2 = rotateLeft(((i13 * 2) + 1) * i13, 5);
            int i16 = i15 * 2;
            i15--;
            int i17 = i14;
            i14 = rotateRight(bytesToWord4 - this._S[i16], rotateLeft2) ^ rotateLeft;
            bytesToWord4 = i13;
            i13 = rotateRight(bytesToWord2 - this._S[i16 + 1], rotateLeft) ^ rotateLeft2;
            bytesToWord2 = i17;
        }
        int[] iArr2 = this._S;
        wordToBytes(i14, bArr2, i12);
        wordToBytes(bytesToWord2 - iArr2[0], bArr2, i12 + 4);
        wordToBytes(i13, bArr2, i12 + 8);
        wordToBytes(bytesToWord4 - iArr2[1], bArr2, i12 + 12);
        return 16;
    }

    private int encryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int bytesToWord = bytesToWord(bArr, i11);
        int bytesToWord2 = bytesToWord(bArr, i11 + 4);
        int bytesToWord3 = bytesToWord(bArr, i11 + 8);
        int bytesToWord4 = bytesToWord(bArr, i11 + 12);
        int[] iArr = this._S;
        int i13 = bytesToWord2 + iArr[0];
        int i14 = bytesToWord4 + iArr[1];
        int i15 = 1;
        while (i15 <= 20) {
            int rotateLeft = rotateLeft(((i13 * 2) + 1) * i13, 5);
            int rotateLeft2 = rotateLeft(((i14 * 2) + 1) * i14, 5);
            int i16 = i15 * 2;
            i15++;
            int rotateLeft3 = rotateLeft(bytesToWord3 ^ rotateLeft2, rotateLeft) + this._S[i16 + 1];
            bytesToWord3 = i14;
            i14 = rotateLeft(bytesToWord ^ rotateLeft, rotateLeft2) + this._S[i16];
            bytesToWord = i13;
            i13 = rotateLeft3;
        }
        int[] iArr2 = this._S;
        int i17 = bytesToWord3 + iArr2[43];
        wordToBytes(bytesToWord + iArr2[42], bArr2, i12);
        wordToBytes(i13, bArr2, i12 + 4);
        wordToBytes(i17, bArr2, i12 + 8);
        wordToBytes(i14, bArr2, i12 + 12);
        return 16;
    }

    private int rotateLeft(int i11, int i12) {
        return (i11 >>> (-i12)) | (i11 << i12);
    }

    private int rotateRight(int i11, int i12) {
        return (i11 << (-i12)) | (i11 >>> i12);
    }

    private void setKey(byte[] bArr) {
        int[] iArr;
        int length = (bArr.length + 3) / 4;
        int length2 = ((bArr.length + 4) - 1) / 4;
        int[] iArr2 = new int[length2];
        for (int length3 = bArr.length - 1; length3 >= 0; length3--) {
            int i11 = length3 / 4;
            iArr2[i11] = (iArr2[i11] << 8) + (bArr[length3] & 255);
        }
        int[] iArr3 = new int[44];
        this._S = iArr3;
        iArr3[0] = P32;
        int i12 = 1;
        while (true) {
            iArr = this._S;
            if (i12 >= iArr.length) {
                break;
            }
            iArr[i12] = iArr[i12 - 1] - 1640531527;
            i12++;
        }
        int length4 = length2 > iArr.length ? length2 * 3 : iArr.length * 3;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < length4; i17++) {
            int[] iArr4 = this._S;
            i14 = rotateLeft(iArr4[i13] + i14 + i15, 3);
            iArr4[i13] = i14;
            i15 = rotateLeft(iArr2[i16] + i14 + i15, i15 + i14);
            iArr2[i16] = i15;
            i13 = (i13 + 1) % this._S.length;
            i16 = (i16 + 1) % length2;
        }
    }

    private void wordToBytes(int i11, byte[] bArr, int i12) {
        for (int i13 = 0; i13 < 4; i13++) {
            bArr[i13 + i12] = (byte) i11;
            i11 >>>= 8;
        }
    }

    public String getAlgorithmName() {
        return "RC6";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.forEncryption = z11;
            setKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to RC6 init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int blockSize = getBlockSize();
        if (this._S == null) {
            throw new IllegalStateException("RC6 engine not initialised");
        } else if (i11 + blockSize > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (blockSize + i12 <= bArr2.length) {
            return this.forEncryption ? encryptBlock(bArr, i11, bArr2, i12) : decryptBlock(bArr, i11, bArr2, i12);
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
