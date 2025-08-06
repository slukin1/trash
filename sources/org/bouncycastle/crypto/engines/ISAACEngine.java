package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class ISAACEngine implements StreamCipher {

    /* renamed from: a  reason: collision with root package name */
    private int f59175a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f59176b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f59177c = 0;
    private int[] engineState = null;
    private int index = 0;
    private boolean initialised = false;
    private byte[] keyStream = new byte[1024];
    private int[] results = null;
    private final int sizeL = 8;
    private final int stateArraySize = 256;
    private byte[] workingKey = null;

    private void isaac() {
        int i11;
        int i12;
        int i13 = this.f59176b;
        int i14 = this.f59177c + 1;
        this.f59177c = i14;
        this.f59176b = i13 + i14;
        for (int i15 = 0; i15 < 256; i15++) {
            int[] iArr = this.engineState;
            int i16 = iArr[i15];
            int i17 = i15 & 3;
            if (i17 == 0) {
                i12 = this.f59175a;
                i11 = i12 << 13;
            } else if (i17 == 1) {
                i12 = this.f59175a;
                i11 = i12 >>> 6;
            } else if (i17 == 2) {
                i12 = this.f59175a;
                i11 = i12 << 2;
            } else if (i17 != 3) {
                int i18 = this.f59175a + iArr[(i15 + 128) & 255];
                this.f59175a = i18;
                int i19 = iArr[(i16 >>> 2) & 255] + i18 + this.f59176b;
                iArr[i15] = i19;
                int[] iArr2 = this.results;
                int i21 = iArr[(i19 >>> 10) & 255] + i16;
                this.f59176b = i21;
                iArr2[i15] = i21;
            } else {
                i12 = this.f59175a;
                i11 = i12 >>> 16;
            }
            this.f59175a = i12 ^ i11;
            int i182 = this.f59175a + iArr[(i15 + 128) & 255];
            this.f59175a = i182;
            int i192 = iArr[(i16 >>> 2) & 255] + i182 + this.f59176b;
            iArr[i15] = i192;
            int[] iArr22 = this.results;
            int i212 = iArr[(i192 >>> 10) & 255] + i16;
            this.f59176b = i212;
            iArr22[i15] = i212;
        }
    }

    private void mix(int[] iArr) {
        iArr[0] = iArr[0] ^ (iArr[1] << 11);
        iArr[3] = iArr[3] + iArr[0];
        iArr[1] = iArr[1] + iArr[2];
        iArr[1] = iArr[1] ^ (iArr[2] >>> 2);
        iArr[4] = iArr[4] + iArr[1];
        iArr[2] = iArr[2] + iArr[3];
        iArr[2] = iArr[2] ^ (iArr[3] << 8);
        iArr[5] = iArr[5] + iArr[2];
        iArr[3] = iArr[3] + iArr[4];
        iArr[3] = iArr[3] ^ (iArr[4] >>> 16);
        iArr[6] = iArr[6] + iArr[3];
        iArr[4] = iArr[4] + iArr[5];
        iArr[4] = iArr[4] ^ (iArr[5] << 10);
        iArr[7] = iArr[7] + iArr[4];
        iArr[5] = iArr[5] + iArr[6];
        iArr[5] = (iArr[6] >>> 4) ^ iArr[5];
        iArr[0] = iArr[0] + iArr[5];
        iArr[6] = iArr[6] + iArr[7];
        iArr[6] = iArr[6] ^ (iArr[7] << 8);
        iArr[1] = iArr[1] + iArr[6];
        iArr[7] = iArr[7] + iArr[0];
        iArr[7] = iArr[7] ^ (iArr[0] >>> 9);
        iArr[2] = iArr[2] + iArr[7];
        iArr[0] = iArr[0] + iArr[1];
    }

    private void setKey(byte[] bArr) {
        this.workingKey = bArr;
        if (this.engineState == null) {
            this.engineState = new int[256];
        }
        if (this.results == null) {
            this.results = new int[256];
        }
        for (int i11 = 0; i11 < 256; i11++) {
            int[] iArr = this.engineState;
            this.results[i11] = 0;
            iArr[i11] = 0;
        }
        this.f59177c = 0;
        this.f59176b = 0;
        this.f59175a = 0;
        this.index = 0;
        int length = bArr.length + (bArr.length & 3);
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i12 = 0; i12 < length; i12 += 4) {
            this.results[i12 >>> 2] = Pack.littleEndianToInt(bArr2, i12);
        }
        int[] iArr2 = new int[8];
        for (int i13 = 0; i13 < 8; i13++) {
            iArr2[i13] = -1640531527;
        }
        for (int i14 = 0; i14 < 4; i14++) {
            mix(iArr2);
        }
        int i15 = 0;
        while (i15 < 2) {
            for (int i16 = 0; i16 < 256; i16 += 8) {
                for (int i17 = 0; i17 < 8; i17++) {
                    iArr2[i17] = iArr2[i17] + (i15 < 1 ? this.results[i16 + i17] : this.engineState[i16 + i17]);
                }
                mix(iArr2);
                for (int i18 = 0; i18 < 8; i18++) {
                    this.engineState[i16 + i18] = iArr2[i18];
                }
            }
            i15++;
        }
        isaac();
        this.initialised = true;
    }

    public String getAlgorithmName() {
        return "ISAAC";
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to ISAAC init - " + cipherParameters.getClass().getName());
    }

    public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i11 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i13 + i12 <= bArr2.length) {
            for (int i14 = 0; i14 < i12; i14++) {
                if (this.index == 0) {
                    isaac();
                    this.keyStream = Pack.intToBigEndian(this.results);
                }
                byte[] bArr3 = this.keyStream;
                int i15 = this.index;
                bArr2[i14 + i13] = (byte) (bArr3[i15] ^ bArr[i14 + i11]);
                this.index = (i15 + 1) & 1023;
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
        if (this.index == 0) {
            isaac();
            this.keyStream = Pack.intToBigEndian(this.results);
        }
        byte[] bArr = this.keyStream;
        int i11 = this.index;
        byte b12 = (byte) (b11 ^ bArr[i11]);
        this.index = (i11 + 1) & 1023;
        return b12;
    }
}
