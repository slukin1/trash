package org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class TEAEngine implements BlockCipher {
    private static final int block_size = 8;
    private static final int d_sum = -957401312;
    private static final int delta = -1640531527;
    private static final int rounds = 32;
    private int _a;
    private int _b;
    private int _c;
    private int _d;
    private boolean _forEncryption;
    private boolean _initialised = false;

    private int bytesToInt(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        byte b11 = (bArr[i11] << Ascii.CAN) | ((bArr[i12] & 255) << 16);
        return (bArr[i13 + 1] & 255) | b11 | ((bArr[i13] & 255) << 8);
    }

    private int decryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int bytesToInt = bytesToInt(bArr, i11);
        int bytesToInt2 = bytesToInt(bArr, i11 + 4);
        int i13 = d_sum;
        for (int i14 = 0; i14 != 32; i14++) {
            bytesToInt2 -= (((bytesToInt << 4) + this._c) ^ (bytesToInt + i13)) ^ ((bytesToInt >>> 5) + this._d);
            bytesToInt -= (((bytesToInt2 << 4) + this._a) ^ (bytesToInt2 + i13)) ^ ((bytesToInt2 >>> 5) + this._b);
            i13 += 1640531527;
        }
        unpackInt(bytesToInt, bArr2, i12);
        unpackInt(bytesToInt2, bArr2, i12 + 4);
        return 8;
    }

    private int encryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int bytesToInt = bytesToInt(bArr, i11);
        int bytesToInt2 = bytesToInt(bArr, i11 + 4);
        int i13 = bytesToInt;
        int i14 = 0;
        for (int i15 = 0; i15 != 32; i15++) {
            i14 -= 1640531527;
            i13 += (((bytesToInt2 << 4) + this._a) ^ (bytesToInt2 + i14)) ^ ((bytesToInt2 >>> 5) + this._b);
            bytesToInt2 += (((i13 << 4) + this._c) ^ (i13 + i14)) ^ ((i13 >>> 5) + this._d);
        }
        unpackInt(i13, bArr2, i12);
        unpackInt(bytesToInt2, bArr2, i12 + 4);
        return 8;
    }

    private void setKey(byte[] bArr) {
        if (bArr.length == 16) {
            this._a = bytesToInt(bArr, 0);
            this._b = bytesToInt(bArr, 4);
            this._c = bytesToInt(bArr, 8);
            this._d = bytesToInt(bArr, 12);
            return;
        }
        throw new IllegalArgumentException("Key size must be 128 bits.");
    }

    private void unpackInt(int i11, byte[] bArr, int i12) {
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i11 >>> 24);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (i11 >>> 16);
        bArr[i14] = (byte) (i11 >>> 8);
        bArr[i14 + 1] = (byte) i11;
    }

    public String getAlgorithmName() {
        return "TEA";
    }

    public int getBlockSize() {
        return 8;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this._forEncryption = z11;
            this._initialised = true;
            setKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to TEA init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        if (!this._initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i11 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + 8 <= bArr2.length) {
            return this._forEncryption ? encryptBlock(bArr, i11, bArr2, i12) : decryptBlock(bArr, i11, bArr2, i12);
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
