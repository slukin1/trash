package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class PKCS12ParametersGenerator extends PBEParametersGenerator {
    public static final int IV_MATERIAL = 2;
    public static final int KEY_MATERIAL = 1;
    public static final int MAC_MATERIAL = 3;
    private Digest digest;

    /* renamed from: u  reason: collision with root package name */
    private int f59201u;

    /* renamed from: v  reason: collision with root package name */
    private int f59202v;

    public PKCS12ParametersGenerator(Digest digest2) {
        this.digest = digest2;
        if (digest2 instanceof ExtendedDigest) {
            this.f59201u = digest2.getDigestSize();
            this.f59202v = ((ExtendedDigest) digest2).getByteLength();
            return;
        }
        throw new IllegalArgumentException("Digest " + digest2.getAlgorithmName() + " unsupported");
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
        int i15 = this.f59202v;
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
            int i19 = this.f59202v;
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
            int i22 = this.f59202v;
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
        int i24 = this.f59202v;
        byte[] bArr10 = new byte[i24];
        int i25 = this.f59201u;
        int i26 = ((i14 + i25) - 1) / i25;
        byte[] bArr11 = new byte[i25];
        int i27 = 1;
        while (i27 <= i26) {
            this.digest.update(bArr3, i16, i15);
            this.digest.update(bArr9, i16, length3);
            this.digest.doFinal(bArr11, i16);
            for (int i28 = i18; i28 < this.iterationCount; i28++) {
                this.digest.update(bArr11, i16, i25);
                this.digest.doFinal(bArr11, i16);
            }
            for (int i29 = i16; i29 != i24; i29++) {
                bArr10[i29] = bArr11[i29 % i25];
            }
            int i30 = i16;
            while (true) {
                int i31 = this.f59202v;
                if (i30 == length3 / i31) {
                    break;
                }
                adjust(bArr9, i31 * i30, bArr10);
                i30++;
            }
            if (i27 == i26) {
                int i32 = i27 - 1;
                int i33 = this.f59201u;
                i13 = 0;
                System.arraycopy(bArr11, 0, bArr4, i32 * i33, i14 - (i32 * i33));
            } else {
                i13 = 0;
                System.arraycopy(bArr11, 0, bArr4, (i27 - 1) * this.f59201u, i25);
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
