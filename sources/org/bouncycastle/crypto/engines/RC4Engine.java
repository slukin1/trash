package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;

public class RC4Engine implements StreamCipher {
    private static final int STATE_LENGTH = 256;
    private byte[] engineState = null;
    private byte[] workingKey = null;

    /* renamed from: x  reason: collision with root package name */
    private int f59181x = 0;

    /* renamed from: y  reason: collision with root package name */
    private int f59182y = 0;

    private void setKey(byte[] bArr) {
        this.workingKey = bArr;
        this.f59181x = 0;
        this.f59182y = 0;
        if (this.engineState == null) {
            this.engineState = new byte[256];
        }
        for (int i11 = 0; i11 < 256; i11++) {
            this.engineState[i11] = (byte) i11;
        }
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < 256; i14++) {
            byte[] bArr2 = this.engineState;
            i13 = ((bArr[i12] & 255) + bArr2[i14] + i13) & 255;
            byte b11 = bArr2[i14];
            bArr2[i14] = bArr2[i13];
            bArr2[i13] = b11;
            i12 = (i12 + 1) % bArr.length;
        }
    }

    public String getAlgorithmName() {
        return "RC4";
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.workingKey = key;
            setKey(key);
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to RC4 init - " + cipherParameters.getClass().getName());
    }

    public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) {
        if (i11 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i13 + i12 <= bArr2.length) {
            for (int i14 = 0; i14 < i12; i14++) {
                int i15 = (this.f59181x + 1) & 255;
                this.f59181x = i15;
                byte[] bArr3 = this.engineState;
                int i16 = (bArr3[i15] + this.f59182y) & 255;
                this.f59182y = i16;
                byte b11 = bArr3[i15];
                bArr3[i15] = bArr3[i16];
                bArr3[i16] = b11;
                bArr2[i14 + i13] = (byte) (bArr3[(bArr3[i15] + bArr3[i16]) & 255] ^ bArr[i14 + i11]);
            }
            return i12;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        setKey(this.workingKey);
    }

    public byte returnByte(byte b11) {
        int i11 = (this.f59181x + 1) & 255;
        this.f59181x = i11;
        byte[] bArr = this.engineState;
        int i12 = (bArr[i11] + this.f59182y) & 255;
        this.f59182y = i12;
        byte b12 = bArr[i11];
        bArr[i11] = bArr[i12];
        bArr[i12] = b12;
        return (byte) (b11 ^ bArr[(bArr[i11] + bArr[i12]) & 255]);
    }
}
