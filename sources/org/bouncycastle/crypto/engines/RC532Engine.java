package org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.RC5Parameters;

public class RC532Engine implements BlockCipher {
    private static final int P32 = -1209970333;
    private static final int Q32 = -1640531527;
    private int[] _S = null;
    private int _noRounds = 12;
    private boolean forEncryption;

    private int bytesToWord(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
    }

    private int decryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int bytesToWord = bytesToWord(bArr, i11);
        int bytesToWord2 = bytesToWord(bArr, i11 + 4);
        for (int i13 = this._noRounds; i13 >= 1; i13--) {
            int i14 = i13 * 2;
            bytesToWord2 = rotateRight(bytesToWord2 - this._S[i14 + 1], bytesToWord) ^ bytesToWord;
            bytesToWord = rotateRight(bytesToWord - this._S[i14], bytesToWord2) ^ bytesToWord2;
        }
        wordToBytes(bytesToWord - this._S[0], bArr2, i12);
        wordToBytes(bytesToWord2 - this._S[1], bArr2, i12 + 4);
        return 8;
    }

    private int encryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int bytesToWord = bytesToWord(bArr, i11) + this._S[0];
        int bytesToWord2 = bytesToWord(bArr, i11 + 4) + this._S[1];
        for (int i13 = 1; i13 <= this._noRounds; i13++) {
            int i14 = i13 * 2;
            bytesToWord = rotateLeft(bytesToWord ^ bytesToWord2, bytesToWord2) + this._S[i14];
            bytesToWord2 = rotateLeft(bytesToWord2 ^ bytesToWord, bytesToWord) + this._S[i14 + 1];
        }
        wordToBytes(bytesToWord, bArr2, i12);
        wordToBytes(bytesToWord2, bArr2, i12 + 4);
        return 8;
    }

    private int rotateLeft(int i11, int i12) {
        int i13 = i12 & 31;
        return (i11 >>> (32 - i13)) | (i11 << i13);
    }

    private int rotateRight(int i11, int i12) {
        int i13 = i12 & 31;
        return (i11 << (32 - i13)) | (i11 >>> i13);
    }

    private void setKey(byte[] bArr) {
        int[] iArr;
        int length = (bArr.length + 3) / 4;
        int[] iArr2 = new int[length];
        for (int i11 = 0; i11 != bArr.length; i11++) {
            int i12 = i11 / 4;
            iArr2[i12] = iArr2[i12] + ((bArr[i11] & 255) << ((i11 % 4) * 8));
        }
        int[] iArr3 = new int[((this._noRounds + 1) * 2)];
        this._S = iArr3;
        iArr3[0] = P32;
        int i13 = 1;
        while (true) {
            iArr = this._S;
            if (i13 >= iArr.length) {
                break;
            }
            iArr[i13] = iArr[i13 - 1] - 1640531527;
            i13++;
        }
        int length2 = length > iArr.length ? length * 3 : iArr.length * 3;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < length2; i18++) {
            int[] iArr4 = this._S;
            i15 = rotateLeft(iArr4[i14] + i15 + i16, 3);
            iArr4[i14] = i15;
            i16 = rotateLeft(iArr2[i17] + i15 + i16, i16 + i15);
            iArr2[i17] = i16;
            i14 = (i14 + 1) % this._S.length;
            i17 = (i17 + 1) % length;
        }
    }

    private void wordToBytes(int i11, byte[] bArr, int i12) {
        bArr[i12] = (byte) i11;
        bArr[i12 + 1] = (byte) (i11 >> 8);
        bArr[i12 + 2] = (byte) (i11 >> 16);
        bArr[i12 + 3] = (byte) (i11 >> 24);
    }

    public String getAlgorithmName() {
        return "RC5-32";
    }

    public int getBlockSize() {
        return 8;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof RC5Parameters) {
            RC5Parameters rC5Parameters = (RC5Parameters) cipherParameters;
            this._noRounds = rC5Parameters.getRounds();
            setKey(rC5Parameters.getKey());
        } else if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey());
        } else {
            throw new IllegalArgumentException("invalid parameter passed to RC532 init - " + cipherParameters.getClass().getName());
        }
        this.forEncryption = z11;
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        return this.forEncryption ? encryptBlock(bArr, i11, bArr2, i12) : decryptBlock(bArr, i11, bArr2, i12);
    }

    public void reset() {
    }
}
