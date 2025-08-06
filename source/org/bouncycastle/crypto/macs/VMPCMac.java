package org.bouncycastle.crypto.macs;

import com.google.common.base.Ascii;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class VMPCMac implements Mac {
    private byte[] P = null;
    private byte[] T;

    /* renamed from: g  reason: collision with root package name */
    private byte f59231g;

    /* renamed from: n  reason: collision with root package name */
    private byte f59232n = 0;

    /* renamed from: s  reason: collision with root package name */
    private byte f59233s = 0;
    private byte[] workingIV;
    private byte[] workingKey;

    /* renamed from: x1  reason: collision with root package name */
    private byte f59234x1;

    /* renamed from: x2  reason: collision with root package name */
    private byte f59235x2;

    /* renamed from: x3  reason: collision with root package name */
    private byte f59236x3;

    /* renamed from: x4  reason: collision with root package name */
    private byte f59237x4;

    private void initKey(byte[] bArr, byte[] bArr2) {
        this.f59233s = 0;
        this.P = new byte[256];
        for (int i11 = 0; i11 < 256; i11++) {
            this.P[i11] = (byte) i11;
        }
        for (int i12 = 0; i12 < 768; i12++) {
            byte[] bArr3 = this.P;
            int i13 = i12 & 255;
            byte b11 = bArr3[(this.f59233s + bArr3[i13] + bArr[i12 % bArr.length]) & 255];
            this.f59233s = b11;
            byte b12 = bArr3[i13];
            bArr3[i13] = bArr3[b11 & 255];
            bArr3[b11 & 255] = b12;
        }
        for (int i14 = 0; i14 < 768; i14++) {
            byte[] bArr4 = this.P;
            int i15 = i14 & 255;
            byte b13 = bArr4[(this.f59233s + bArr4[i15] + bArr2[i14 % bArr2.length]) & 255];
            this.f59233s = b13;
            byte b14 = bArr4[i15];
            bArr4[i15] = bArr4[b13 & 255];
            bArr4[b13 & 255] = b14;
        }
        this.f59232n = 0;
    }

    public int doFinal(byte[] bArr, int i11) throws DataLengthException, IllegalStateException {
        for (int i12 = 1; i12 < 25; i12++) {
            byte[] bArr2 = this.P;
            byte b11 = this.f59233s;
            byte b12 = this.f59232n;
            byte b13 = bArr2[(b11 + bArr2[b12 & 255]) & 255];
            this.f59233s = b13;
            byte b14 = this.f59237x4;
            byte b15 = this.f59236x3;
            byte b16 = bArr2[(b14 + b15 + i12) & 255];
            this.f59237x4 = b16;
            byte b17 = this.f59235x2;
            byte b18 = bArr2[(b15 + b17 + i12) & 255];
            this.f59236x3 = b18;
            byte b19 = this.f59234x1;
            byte b21 = bArr2[(b17 + b19 + i12) & 255];
            this.f59235x2 = b21;
            byte b22 = bArr2[(b19 + b13 + i12) & 255];
            this.f59234x1 = b22;
            byte[] bArr3 = this.T;
            byte b23 = this.f59231g;
            bArr3[b23 & Ascii.US] = (byte) (b22 ^ bArr3[b23 & Ascii.US]);
            bArr3[(b23 + 1) & 31] = (byte) (b21 ^ bArr3[(b23 + 1) & 31]);
            bArr3[(b23 + 2) & 31] = (byte) (b18 ^ bArr3[(b23 + 2) & 31]);
            bArr3[(b23 + 3) & 31] = (byte) (b16 ^ bArr3[(b23 + 3) & 31]);
            this.f59231g = (byte) ((b23 + 4) & 31);
            byte b24 = bArr2[b12 & 255];
            bArr2[b12 & 255] = bArr2[b13 & 255];
            bArr2[b13 & 255] = b24;
            this.f59232n = (byte) ((b12 + 1) & 255);
        }
        for (int i13 = 0; i13 < 768; i13++) {
            byte[] bArr4 = this.P;
            int i14 = i13 & 255;
            byte b25 = bArr4[(this.f59233s + bArr4[i14] + this.T[i13 & 31]) & 255];
            this.f59233s = b25;
            byte b26 = bArr4[i14];
            bArr4[i14] = bArr4[b25 & 255];
            bArr4[b25 & 255] = b26;
        }
        byte[] bArr5 = new byte[20];
        for (int i15 = 0; i15 < 20; i15++) {
            byte[] bArr6 = this.P;
            int i16 = i15 & 255;
            byte b27 = bArr6[(this.f59233s + bArr6[i16]) & 255];
            this.f59233s = b27;
            bArr5[i15] = bArr6[(bArr6[bArr6[b27 & 255] & 255] + 1) & 255];
            byte b28 = bArr6[i16];
            bArr6[i16] = bArr6[b27 & 255];
            bArr6[b27 & 255] = b28;
        }
        System.arraycopy(bArr5, 0, bArr, i11, 20);
        reset();
        return 20;
    }

    public String getAlgorithmName() {
        return "VMPC-MAC";
    }

    public int getMacSize() {
        return 20;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
            if (parametersWithIV.getParameters() instanceof KeyParameter) {
                byte[] iv2 = parametersWithIV.getIV();
                this.workingIV = iv2;
                if (iv2 == null || iv2.length < 1 || iv2.length > 768) {
                    throw new IllegalArgumentException("VMPC-MAC requires 1 to 768 bytes of IV");
                }
                this.workingKey = keyParameter.getKey();
                reset();
                return;
            }
            throw new IllegalArgumentException("VMPC-MAC Init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC-MAC Init parameters must include an IV");
    }

    public void reset() {
        initKey(this.workingKey, this.workingIV);
        this.f59232n = 0;
        this.f59237x4 = 0;
        this.f59236x3 = 0;
        this.f59235x2 = 0;
        this.f59234x1 = 0;
        this.f59231g = 0;
        this.T = new byte[32];
        for (int i11 = 0; i11 < 32; i11++) {
            this.T[i11] = 0;
        }
    }

    public void update(byte b11) throws IllegalStateException {
        byte[] bArr = this.P;
        byte b12 = this.f59233s;
        byte b13 = this.f59232n;
        byte b14 = bArr[(b12 + bArr[b13 & 255]) & 255];
        this.f59233s = b14;
        byte b15 = this.f59237x4;
        byte b16 = this.f59236x3;
        byte b17 = bArr[(b15 + b16) & 255];
        this.f59237x4 = b17;
        byte b18 = this.f59235x2;
        byte b19 = bArr[(b16 + b18) & 255];
        this.f59236x3 = b19;
        byte b21 = this.f59234x1;
        byte b22 = bArr[(b18 + b21) & 255];
        this.f59235x2 = b22;
        byte b23 = bArr[(b21 + b14 + ((byte) (b11 ^ bArr[(bArr[bArr[b14 & 255] & 255] + 1) & 255]))) & 255];
        this.f59234x1 = b23;
        byte[] bArr2 = this.T;
        byte b24 = this.f59231g;
        bArr2[b24 & Ascii.US] = (byte) (b23 ^ bArr2[b24 & Ascii.US]);
        bArr2[(b24 + 1) & 31] = (byte) (b22 ^ bArr2[(b24 + 1) & 31]);
        bArr2[(b24 + 2) & 31] = (byte) (b19 ^ bArr2[(b24 + 2) & 31]);
        bArr2[(b24 + 3) & 31] = (byte) (b17 ^ bArr2[(b24 + 3) & 31]);
        this.f59231g = (byte) ((b24 + 4) & 31);
        byte b25 = bArr[b13 & 255];
        bArr[b13 & 255] = bArr[b14 & 255];
        bArr[b14 & 255] = b25;
        this.f59232n = (byte) ((b13 + 1) & 255);
    }

    public void update(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalStateException {
        if (i11 + i12 <= bArr.length) {
            for (int i13 = 0; i13 < i12; i13++) {
                update(bArr[i11 + i13]);
            }
            return;
        }
        throw new DataLengthException("input buffer too short");
    }
}
