package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class HC128Engine implements StreamCipher {
    private byte[] buf = new byte[4];
    private int cnt = 0;
    private int idx = 0;
    private boolean initialised;

    /* renamed from: iv  reason: collision with root package name */
    private byte[] f59169iv;
    private byte[] key;

    /* renamed from: p  reason: collision with root package name */
    private int[] f59170p = new int[512];

    /* renamed from: q  reason: collision with root package name */
    private int[] f59171q = new int[512];

    private static int dim(int i11, int i12) {
        return mod512(i11 - i12);
    }

    private static int f1(int i11) {
        return (i11 >>> 3) ^ (rotateRight(i11, 7) ^ rotateRight(i11, 18));
    }

    private static int f2(int i11) {
        return (i11 >>> 10) ^ (rotateRight(i11, 17) ^ rotateRight(i11, 19));
    }

    private int g1(int i11, int i12, int i13) {
        return (rotateRight(i11, 10) ^ rotateRight(i13, 23)) + rotateRight(i12, 8);
    }

    private int g2(int i11, int i12, int i13) {
        return (rotateLeft(i11, 10) ^ rotateLeft(i13, 23)) + rotateLeft(i12, 8);
    }

    private byte getByte() {
        if (this.idx == 0) {
            int step = step();
            byte[] bArr = this.buf;
            bArr[0] = (byte) (step & 255);
            int i11 = step >> 8;
            bArr[1] = (byte) (i11 & 255);
            int i12 = i11 >> 8;
            bArr[2] = (byte) (i12 & 255);
            bArr[3] = (byte) ((i12 >> 8) & 255);
        }
        byte[] bArr2 = this.buf;
        int i13 = this.idx;
        byte b11 = bArr2[i13];
        this.idx = 3 & (i13 + 1);
        return b11;
    }

    private int h1(int i11) {
        int[] iArr = this.f59171q;
        return iArr[i11 & 255] + iArr[((i11 >> 16) & 255) + 256];
    }

    private int h2(int i11) {
        int[] iArr = this.f59170p;
        return iArr[i11 & 255] + iArr[((i11 >> 16) & 255) + 256];
    }

    private void init() {
        if (this.key.length == 16) {
            this.idx = 0;
            this.cnt = 0;
            int[] iArr = new int[1280];
            for (int i11 = 0; i11 < 16; i11++) {
                int i12 = i11 >> 2;
                iArr[i12] = ((this.key[i11] & 255) << ((i11 & 3) * 8)) | iArr[i12];
            }
            System.arraycopy(iArr, 0, iArr, 4, 4);
            int i13 = 0;
            while (true) {
                byte[] bArr = this.f59169iv;
                if (i13 >= bArr.length || i13 >= 16) {
                    System.arraycopy(iArr, 8, iArr, 12, 4);
                } else {
                    int i14 = (i13 >> 2) + 8;
                    iArr[i14] = ((bArr[i13] & 255) << ((i13 & 3) * 8)) | iArr[i14];
                    i13++;
                }
            }
            System.arraycopy(iArr, 8, iArr, 12, 4);
            for (int i15 = 16; i15 < 1280; i15++) {
                iArr[i15] = f2(iArr[i15 - 2]) + iArr[i15 - 7] + f1(iArr[i15 - 15]) + iArr[i15 - 16] + i15;
            }
            System.arraycopy(iArr, 256, this.f59170p, 0, 512);
            System.arraycopy(iArr, 768, this.f59171q, 0, 512);
            for (int i16 = 0; i16 < 512; i16++) {
                this.f59170p[i16] = step();
            }
            for (int i17 = 0; i17 < 512; i17++) {
                this.f59171q[i17] = step();
            }
            this.cnt = 0;
            return;
        }
        throw new IllegalArgumentException("The key must be 128 bits long");
    }

    private static int mod1024(int i11) {
        return i11 & 1023;
    }

    private static int mod512(int i11) {
        return i11 & 511;
    }

    private static int rotateLeft(int i11, int i12) {
        return (i11 >>> (-i12)) | (i11 << i12);
    }

    private static int rotateRight(int i11, int i12) {
        return (i11 << (-i12)) | (i11 >>> i12);
    }

    private int step() {
        int i11;
        int i12;
        int mod512 = mod512(this.cnt);
        if (this.cnt < 512) {
            int[] iArr = this.f59170p;
            iArr[mod512] = iArr[mod512] + g1(iArr[dim(mod512, 3)], this.f59170p[dim(mod512, 10)], this.f59170p[dim(mod512, 511)]);
            i11 = h1(this.f59170p[dim(mod512, 12)]);
            i12 = this.f59170p[mod512];
        } else {
            int[] iArr2 = this.f59171q;
            iArr2[mod512] = iArr2[mod512] + g2(iArr2[dim(mod512, 3)], this.f59171q[dim(mod512, 10)], this.f59171q[dim(mod512, 511)]);
            i11 = h2(this.f59171q[dim(mod512, 12)]);
            i12 = this.f59171q[mod512];
        }
        int i13 = i12 ^ i11;
        this.cnt = mod1024(this.cnt + 1);
        return i13;
    }

    public String getAlgorithmName() {
        return "HC-128";
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f59169iv = parametersWithIV.getIV();
            cipherParameters2 = parametersWithIV.getParameters();
        } else {
            this.f59169iv = new byte[0];
            cipherParameters2 = cipherParameters;
        }
        if (cipherParameters2 instanceof KeyParameter) {
            this.key = ((KeyParameter) cipherParameters2).getKey();
            init();
            this.initialised = true;
            return;
        }
        throw new IllegalArgumentException("Invalid parameter passed to HC128 init - " + cipherParameters.getClass().getName());
    }

    public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws DataLengthException {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i11 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i13 + i12 <= bArr2.length) {
            for (int i14 = 0; i14 < i12; i14++) {
                bArr2[i13 + i14] = (byte) (bArr[i11 + i14] ^ getByte());
            }
            return i12;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        init();
    }

    public byte returnByte(byte b11) {
        return (byte) (b11 ^ getByte());
    }
}
