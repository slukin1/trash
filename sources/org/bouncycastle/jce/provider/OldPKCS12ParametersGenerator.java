package org.bouncycastle.jce.provider;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

class OldPKCS12ParametersGenerator extends PBEParametersGenerator {
    public static final int IV_MATERIAL = 2;
    public static final int KEY_MATERIAL = 1;
    public static final int MAC_MATERIAL = 3;
    private Digest digest;

    /* renamed from: u  reason: collision with root package name */
    private int f59363u;

    /* renamed from: v  reason: collision with root package name */
    private int f59364v;

    public OldPKCS12ParametersGenerator(Digest digest2) {
        this.digest = digest2;
        if (digest2 instanceof MD5Digest) {
            this.f59363u = 16;
        } else if (!(digest2 instanceof SHA1Digest) && !(digest2 instanceof RIPEMD160Digest)) {
            throw new IllegalArgumentException("Digest " + digest2.getAlgorithmName() + " unsupported");
        } else {
            this.f59363u = 20;
        }
        this.f59364v = 64;
    }

    private void adjust(byte[] bArr, int i11, byte[] bArr2) {
        int i12 = (bArr2[bArr2.length - 1] & 255) + (bArr[(bArr2.length + i11) - 1] & 255) + 1;
        bArr[(bArr2.length + i11) - 1] = (byte) i12;
        int i13 = i12 >>> 8;
        for (int length = bArr2.length - 2; length >= 0; length--) {
            int i14 = i11 + length;
            int i15 = i13 + (bArr2[length] & 255) + (bArr[i14] & 255);
            bArr[i14] = (byte) i15;
            i13 = i15 >>> 8;
        }
    }

    private byte[] generateDerivedKey(int i11, int i12) {
        byte[] bArr;
        byte[] bArr2;
        int i13;
        int i14 = i12;
        int i15 = this.f59364v;
        byte[] bArr3 = new byte[i15];
        byte[] bArr4 = new byte[i14];
        int i16 = 0;
        for (int i17 = 0; i17 != i15; i17++) {
            bArr3[i17] = (byte) i11;
        }
        byte[] bArr5 = this.salt;
        int i18 = 1;
        if (bArr5 == null || bArr5.length == 0) {
            bArr = new byte[0];
        } else {
            int i19 = this.f59364v;
            int length = i19 * (((bArr5.length + i19) - 1) / i19);
            bArr = new byte[length];
            for (int i21 = 0; i21 != length; i21++) {
                byte[] bArr6 = this.salt;
                bArr[i21] = bArr6[i21 % bArr6.length];
            }
        }
        byte[] bArr7 = this.password;
        if (bArr7 == null || bArr7.length == 0) {
            bArr2 = new byte[0];
        } else {
            int i22 = this.f59364v;
            int length2 = i22 * (((bArr7.length + i22) - 1) / i22);
            bArr2 = new byte[length2];
            for (int i23 = 0; i23 != length2; i23++) {
                byte[] bArr8 = this.password;
                bArr2[i23] = bArr8[i23 % bArr8.length];
            }
        }
        int length3 = bArr.length + bArr2.length;
        byte[] bArr9 = new byte[length3];
        System.arraycopy(bArr, 0, bArr9, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr9, bArr.length, bArr2.length);
        int i24 = this.f59364v;
        byte[] bArr10 = new byte[i24];
        int i25 = this.f59363u;
        int i26 = ((i14 + i25) - 1) / i25;
        int i27 = 1;
        while (i27 <= i26) {
            int i28 = this.f59363u;
            byte[] bArr11 = new byte[i28];
            this.digest.update(bArr3, i16, i15);
            this.digest.update(bArr9, i16, length3);
            this.digest.doFinal(bArr11, i16);
            for (int i29 = i18; i29 != this.iterationCount; i29++) {
                this.digest.update(bArr11, i16, i28);
                this.digest.doFinal(bArr11, i16);
            }
            for (int i30 = i16; i30 != i24; i30++) {
                bArr10[i27] = bArr11[i30 % i28];
            }
            int i31 = i16;
            while (true) {
                int i32 = this.f59364v;
                if (i31 == length3 / i32) {
                    break;
                }
                adjust(bArr9, i32 * i31, bArr10);
                i31++;
            }
            if (i27 == i26) {
                int i33 = i27 - 1;
                int i34 = this.f59363u;
                i13 = 0;
                System.arraycopy(bArr11, 0, bArr4, i33 * i34, i14 - (i33 * i34));
            } else {
                i13 = 0;
                System.arraycopy(bArr11, 0, bArr4, (i27 - 1) * this.f59363u, i28);
            }
            i27++;
            i16 = i13;
            i18 = 1;
        }
        return bArr4;
    }

    public CipherParameters generateDerivedMacParameters(int i11) {
        int i12 = i11 / 8;
        return new KeyParameter(generateDerivedKey(3, i12), 0, i12);
    }

    public CipherParameters generateDerivedParameters(int i11) {
        int i12 = i11 / 8;
        return new KeyParameter(generateDerivedKey(1, i12), 0, i12);
    }

    public CipherParameters generateDerivedParameters(int i11, int i12) {
        int i13 = i11 / 8;
        int i14 = i12 / 8;
        byte[] generateDerivedKey = generateDerivedKey(1, i13);
        return new ParametersWithIV(new KeyParameter(generateDerivedKey, 0, i13), generateDerivedKey(2, i14), 0, i14);
    }
}
