package org.bouncycastle.pqc.crypto.saber;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.util.Arrays;

class SABEREngine {
    public static final int SABER_EP = 10;
    public static final int SABER_EQ = 13;
    private static final int SABER_HASHBYTES = 32;
    private static final int SABER_KEYBYTES = 32;
    public static final int SABER_N = 256;
    private static final int SABER_NOISE_SEEDBYTES = 32;
    private static final int SABER_SEEDBYTES = 32;
    private final int SABER_BYTES_CCA_DEC;
    private final int SABER_ET;
    private final int SABER_INDCPA_PUBLICKEYBYTES;
    private final int SABER_INDCPA_SECRETKEYBYTES;
    private final int SABER_L;
    private final int SABER_MU;
    private final int SABER_POLYBYTES;
    private final int SABER_POLYCOINBYTES;
    private final int SABER_POLYCOMPRESSEDBYTES;
    private final int SABER_POLYVECBYTES;
    private final int SABER_POLYVECCOMPRESSEDBYTES;
    private final int SABER_PUBLICKEYBYTES;
    private final int SABER_SCALEBYTES_KEM;
    private final int SABER_SECRETKEYBYTES;
    private final int defaultKeySize;

    /* renamed from: h1  reason: collision with root package name */
    private final int f59603h1;

    /* renamed from: h2  reason: collision with root package name */
    private final int f59604h2;
    private final Poly poly;
    private final Utils utils;

    public SABEREngine(int i11, int i12) {
        this.defaultKeySize = i12;
        this.SABER_L = i11;
        int i13 = 3;
        if (i11 == 2) {
            this.SABER_MU = 10;
        } else if (i11 == 3) {
            this.SABER_MU = 8;
            this.SABER_ET = 4;
            this.SABER_POLYCOINBYTES = (this.SABER_MU * 256) / 8;
            this.SABER_POLYBYTES = 416;
            int i14 = i11 * 416;
            this.SABER_POLYVECBYTES = i14;
            this.SABER_POLYCOMPRESSEDBYTES = 320;
            int i15 = i11 * 320;
            this.SABER_POLYVECCOMPRESSEDBYTES = i15;
            int i16 = this.SABER_ET;
            int i17 = (i16 * 256) / 8;
            this.SABER_SCALEBYTES_KEM = i17;
            int i18 = i15 + 32;
            this.SABER_INDCPA_PUBLICKEYBYTES = i18;
            this.SABER_INDCPA_SECRETKEYBYTES = i14;
            this.SABER_PUBLICKEYBYTES = i18;
            this.SABER_SECRETKEYBYTES = i14 + i18 + 32 + 32;
            this.SABER_BYTES_CCA_DEC = i15 + i17;
            this.f59603h1 = 4;
            this.f59604h2 = (256 - (1 << ((10 - i16) - 1))) + 4;
            this.utils = new Utils(this);
            this.poly = new Poly(this);
        } else {
            i13 = 6;
            this.SABER_MU = 6;
        }
        this.SABER_ET = i13;
        this.SABER_POLYCOINBYTES = (this.SABER_MU * 256) / 8;
        this.SABER_POLYBYTES = 416;
        int i142 = i11 * 416;
        this.SABER_POLYVECBYTES = i142;
        this.SABER_POLYCOMPRESSEDBYTES = 320;
        int i152 = i11 * 320;
        this.SABER_POLYVECCOMPRESSEDBYTES = i152;
        int i162 = this.SABER_ET;
        int i172 = (i162 * 256) / 8;
        this.SABER_SCALEBYTES_KEM = i172;
        int i182 = i152 + 32;
        this.SABER_INDCPA_PUBLICKEYBYTES = i182;
        this.SABER_INDCPA_SECRETKEYBYTES = i142;
        this.SABER_PUBLICKEYBYTES = i182;
        this.SABER_SECRETKEYBYTES = i142 + i182 + 32 + 32;
        this.SABER_BYTES_CCA_DEC = i152 + i172;
        this.f59603h1 = 4;
        this.f59604h2 = (256 - (1 << ((10 - i162) - 1))) + 4;
        this.utils = new Utils(this);
        this.poly = new Poly(this);
    }

    public static void cmov(byte[] bArr, byte[] bArr2, int i11, int i12, byte b11) {
        byte b12 = (byte) (-b11);
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[i13] = (byte) (bArr[i13] ^ ((bArr2[i13 + i11] ^ bArr[i13]) & b12));
        }
    }

    private void indcpa_kem_dec(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        Class<short> cls = short.class;
        int i11 = this.SABER_L;
        int[] iArr = new int[2];
        iArr[1] = 256;
        iArr[0] = i11;
        short[][] sArr = (short[][]) Array.newInstance(cls, iArr);
        int i12 = this.SABER_L;
        int[] iArr2 = new int[2];
        iArr2[1] = 256;
        iArr2[0] = i12;
        short[][] sArr2 = (short[][]) Array.newInstance(cls, iArr2);
        short[] sArr3 = new short[256];
        short[] sArr4 = new short[256];
        this.utils.BS2POLVECq(bArr, 0, sArr);
        this.utils.BS2POLVECp(bArr2, sArr2);
        this.poly.InnerProd(sArr2, sArr, sArr3);
        this.utils.BS2POLT(bArr2, this.SABER_POLYVECCOMPRESSEDBYTES, sArr4);
        for (int i13 = 0; i13 < 256; i13++) {
            sArr3[i13] = (short) ((((sArr3[i13] + this.f59604h2) - (sArr4[i13] << (10 - this.SABER_ET))) & 65535) >> 9);
        }
        this.utils.POLmsg2BS(bArr3, sArr3);
    }

    private void indcpa_kem_enc(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = bArr3;
        byte[] bArr6 = bArr4;
        Class<short> cls = short.class;
        int i11 = this.SABER_L;
        int[] iArr = new int[3];
        iArr[2] = 256;
        iArr[1] = i11;
        int i12 = 0;
        iArr[0] = i11;
        short[][][] sArr = (short[][][]) Array.newInstance(cls, iArr);
        int i13 = this.SABER_L;
        int[] iArr2 = new int[2];
        iArr2[1] = 256;
        iArr2[0] = i13;
        short[][] sArr2 = (short[][]) Array.newInstance(cls, iArr2);
        int i14 = this.SABER_L;
        int[] iArr3 = new int[2];
        iArr3[1] = 256;
        iArr3[0] = i14;
        short[][] sArr3 = (short[][]) Array.newInstance(cls, iArr3);
        int i15 = this.SABER_L;
        int[] iArr4 = new int[2];
        iArr4[1] = 256;
        iArr4[0] = i15;
        short[][] sArr4 = (short[][]) Array.newInstance(cls, iArr4);
        short[] sArr5 = new short[256];
        short[] sArr6 = new short[256];
        this.poly.GenMatrix(sArr, Arrays.copyOfRange(bArr5, this.SABER_POLYVECCOMPRESSEDBYTES, bArr5.length));
        this.poly.GenSecret(sArr2, bArr2);
        this.poly.MatrixVectorMul(sArr, sArr2, sArr3, 0);
        int i16 = 0;
        while (i16 < this.SABER_L) {
            for (int i17 = i12; i17 < 256; i17++) {
                sArr3[i16][i17] = (short) (((sArr3[i16][i17] + this.f59603h1) & 65535) >>> 3);
            }
            i16++;
            i12 = 0;
        }
        this.utils.POLVECp2BS(bArr6, sArr3);
        this.utils.BS2POLVECp(bArr5, sArr4);
        this.poly.InnerProd(sArr4, sArr2, sArr6);
        this.utils.BS2POLmsg(bArr, sArr5);
        for (int i18 = 0; i18 < 256; i18++) {
            sArr6[i18] = (short) ((((sArr6[i18] - (sArr5[i18] << 9)) + this.f59603h1) & 65535) >>> (10 - this.SABER_ET));
        }
        this.utils.POLT2BS(bArr6, this.SABER_POLYVECCOMPRESSEDBYTES, sArr6);
    }

    private void indcpa_kem_keypair(byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        Class<short> cls = short.class;
        int i11 = this.SABER_L;
        int[] iArr = new int[3];
        iArr[2] = 256;
        iArr[1] = i11;
        iArr[0] = i11;
        short[][][] sArr = (short[][][]) Array.newInstance(cls, iArr);
        int i12 = this.SABER_L;
        int[] iArr2 = new int[2];
        iArr2[1] = 256;
        iArr2[0] = i12;
        short[][] sArr2 = (short[][]) Array.newInstance(cls, iArr2);
        int i13 = this.SABER_L;
        int[] iArr3 = new int[2];
        iArr3[1] = 256;
        iArr3[0] = i13;
        short[][] sArr3 = (short[][]) Array.newInstance(cls, iArr3);
        byte[] bArr3 = new byte[32];
        byte[] bArr4 = new byte[32];
        secureRandom.nextBytes(bArr3);
        SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
        sHAKEDigest.update(bArr3, 0, 32);
        sHAKEDigest.doFinal(bArr3, 0, 32);
        secureRandom.nextBytes(bArr4);
        this.poly.GenMatrix(sArr, bArr3);
        this.poly.GenSecret(sArr2, bArr4);
        this.poly.MatrixVectorMul(sArr, sArr2, sArr3, 1);
        for (int i14 = 0; i14 < this.SABER_L; i14++) {
            for (int i15 = 0; i15 < 256; i15++) {
                sArr3[i14][i15] = (short) (((sArr3[i14][i15] + this.f59603h1) & 65535) >>> 3);
            }
        }
        this.utils.POLVECq2BS(bArr2, sArr2);
        this.utils.POLVECp2BS(bArr, sArr3);
        System.arraycopy(bArr3, 0, bArr, this.SABER_POLYVECCOMPRESSEDBYTES, 32);
    }

    public static int verify(byte[] bArr, byte[] bArr2, int i11) {
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j11 |= (long) (bArr[i12] ^ bArr2[i12]);
        }
        return (int) ((-j11) >>> 63);
    }

    public int crypto_kem_dec(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[this.SABER_BYTES_CCA_DEC];
        byte[] bArr5 = new byte[64];
        byte[] bArr6 = new byte[64];
        byte[] copyOfRange = Arrays.copyOfRange(bArr3, this.SABER_INDCPA_SECRETKEYBYTES, bArr3.length);
        indcpa_kem_dec(bArr3, bArr2, bArr5);
        for (int i11 = 0; i11 < 32; i11++) {
            bArr5[i11 + 32] = bArr3[(this.SABER_SECRETKEYBYTES - 64) + i11];
        }
        SHA3Digest sHA3Digest = new SHA3Digest(256);
        SHA3Digest sHA3Digest2 = new SHA3Digest(512);
        sHA3Digest2.update(bArr5, 0, 64);
        sHA3Digest2.doFinal(bArr6, 0);
        indcpa_kem_enc(bArr5, Arrays.copyOfRange(bArr6, 32, 64), copyOfRange, bArr4);
        int verify = verify(bArr2, bArr4, this.SABER_BYTES_CCA_DEC);
        sHA3Digest.update(bArr2, 0, this.SABER_BYTES_CCA_DEC);
        sHA3Digest.doFinal(bArr6, 32);
        cmov(bArr6, bArr3, this.SABER_SECRETKEYBYTES - 32, 32, (byte) verify);
        byte[] bArr7 = new byte[32];
        sHA3Digest.update(bArr6, 0, 64);
        sHA3Digest.doFinal(bArr7, 0);
        System.arraycopy(bArr7, 0, bArr, 0, this.defaultKeySize / 8);
        return 0;
    }

    public int crypto_kem_enc(byte[] bArr, byte[] bArr2, byte[] bArr3, SecureRandom secureRandom) {
        byte[] bArr4 = new byte[64];
        byte[] bArr5 = new byte[64];
        byte[] bArr6 = new byte[32];
        secureRandom.nextBytes(bArr6);
        SHA3Digest sHA3Digest = new SHA3Digest(256);
        SHA3Digest sHA3Digest2 = new SHA3Digest(512);
        sHA3Digest.update(bArr6, 0, 32);
        sHA3Digest.doFinal(bArr6, 0);
        System.arraycopy(bArr6, 0, bArr5, 0, 32);
        sHA3Digest.update(bArr3, 0, this.SABER_INDCPA_PUBLICKEYBYTES);
        sHA3Digest.doFinal(bArr5, 32);
        sHA3Digest2.update(bArr5, 0, 64);
        sHA3Digest2.doFinal(bArr4, 0);
        indcpa_kem_enc(bArr5, Arrays.copyOfRange(bArr4, 32, 64), bArr3, bArr);
        sHA3Digest.update(bArr, 0, this.SABER_BYTES_CCA_DEC);
        sHA3Digest.doFinal(bArr4, 32);
        byte[] bArr7 = new byte[32];
        sHA3Digest.update(bArr4, 0, 64);
        sHA3Digest.doFinal(bArr7, 0);
        System.arraycopy(bArr7, 0, bArr2, 0, this.defaultKeySize / 8);
        return 0;
    }

    public int crypto_kem_keypair(byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        indcpa_kem_keypair(bArr, bArr2, secureRandom);
        for (int i11 = 0; i11 < this.SABER_INDCPA_PUBLICKEYBYTES; i11++) {
            bArr2[this.SABER_INDCPA_SECRETKEYBYTES + i11] = bArr[i11];
        }
        SHA3Digest sHA3Digest = new SHA3Digest(256);
        sHA3Digest.update(bArr, 0, this.SABER_INDCPA_PUBLICKEYBYTES);
        sHA3Digest.doFinal(bArr2, this.SABER_SECRETKEYBYTES - 64);
        byte[] bArr3 = new byte[32];
        secureRandom.nextBytes(bArr3);
        System.arraycopy(bArr3, 0, bArr2, this.SABER_SECRETKEYBYTES - 32, 32);
        return 0;
    }

    public int getCipherTextSize() {
        return this.SABER_BYTES_CCA_DEC;
    }

    public int getPrivateKeySize() {
        return this.SABER_SECRETKEYBYTES;
    }

    public int getPublicKeySize() {
        return this.SABER_PUBLICKEYBYTES;
    }

    public int getSABER_EP() {
        return 10;
    }

    public int getSABER_ET() {
        return this.SABER_ET;
    }

    public int getSABER_KEYBYTES() {
        return 32;
    }

    public int getSABER_L() {
        return this.SABER_L;
    }

    public int getSABER_MU() {
        return this.SABER_MU;
    }

    public int getSABER_N() {
        return 256;
    }

    public int getSABER_NOISE_SEEDBYTES() {
        return 32;
    }

    public int getSABER_POLYBYTES() {
        return this.SABER_POLYBYTES;
    }

    public int getSABER_POLYCOINBYTES() {
        return this.SABER_POLYCOINBYTES;
    }

    public int getSABER_POLYVECBYTES() {
        return this.SABER_POLYVECBYTES;
    }

    public int getSABER_SEEDBYTES() {
        return 32;
    }

    public int getSessionKeySize() {
        return this.defaultKeySize / 8;
    }

    public Utils getUtils() {
        return this.utils;
    }
}
