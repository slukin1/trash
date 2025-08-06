package org.bouncycastle.pqc.crypto.frodo;

import com.tencent.android.tpush.common.Constants;
import java.security.SecureRandom;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

class FrodoEngine {
    private static final int len_chi = 16;
    private static final int len_chi_bytes = 2;
    private static final int len_seedA = 128;
    private static final int len_seedA_bytes = 16;
    private static final int len_z = 128;
    private static final int len_z_bytes = 16;
    private static final int mbar = 8;
    private static final int nbar = 8;
    private final int B;
    private final int D;
    private final short[] T_chi;
    private final Xof digest;
    private final FrodoMatrixGenerator gen;
    private final int len_ct_bytes;
    private final int len_k;
    private final int len_k_bytes;
    private final int len_mu;
    private final int len_mu_bytes;
    private final int len_pk_bytes;
    private final int len_pkh;
    private final int len_pkh_bytes;
    private final int len_s;
    private final int len_s_bytes;
    private final int len_seedSE;
    private final int len_seedSE_bytes;
    private final int len_sk_bytes;
    private final int len_ss;
    private final int len_ss_bytes;

    /* renamed from: n  reason: collision with root package name */
    private final int f59519n;

    /* renamed from: q  reason: collision with root package name */
    private final int f59520q;

    public FrodoEngine(int i11, int i12, int i13, short[] sArr, Xof xof, FrodoMatrixGenerator frodoMatrixGenerator) {
        this.f59519n = i11;
        this.D = i12;
        this.f59520q = 1 << i12;
        this.B = i13;
        int i14 = i13 * 8 * 8;
        this.len_mu = i14;
        this.len_seedSE = i14;
        this.len_s = i14;
        this.len_k = i14;
        this.len_pkh = i14;
        this.len_ss = i14;
        this.len_mu_bytes = i14 / 8;
        this.len_seedSE_bytes = i14 / 8;
        int i15 = i14 / 8;
        this.len_s_bytes = i15;
        this.len_k_bytes = i14 / 8;
        int i16 = i14 / 8;
        this.len_pkh_bytes = i16;
        this.len_ss_bytes = i14 / 8;
        int i17 = ((i12 * i11) * 8) / 8;
        this.len_ct_bytes = (((i12 * 8) * 8) / 8) + i17;
        int i18 = i17 + 16;
        this.len_pk_bytes = i18;
        this.len_sk_bytes = i15 + i18 + (i11 * 2 * 8) + i16;
        this.T_chi = sArr;
        this.digest = xof;
        this.gen = frodoMatrixGenerator;
    }

    private byte[] ctselect(byte[] bArr, byte[] bArr2, short s11) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr3[i11] = (byte) (((~s11) & bArr[i11] & 255) | (bArr2[i11] & s11 & 255));
        }
        return bArr3;
    }

    private short ctverify(short[] sArr, short[] sArr2, short[] sArr3, short[] sArr4) {
        short s11 = 0;
        for (short s12 = 0; s12 < sArr.length; s12 = (short) (s12 + 1)) {
            s11 = (short) (s11 | (sArr[s12] ^ sArr3[s12]));
        }
        for (short s13 = 0; s13 < sArr2.length; s13 = (short) (s13 + 1)) {
            s11 = (short) ((sArr2[s13] ^ sArr4[s13]) | s11);
        }
        return s11 == 0 ? (short) 0 : -1;
    }

    private byte[] decode(short[] sArr) {
        int i11 = this.B;
        short s11 = (short) ((1 << i11) - 1);
        short s12 = (short) ((1 << this.D) - 1);
        byte[] bArr = new byte[(i11 * 8)];
        int i12 = 0;
        for (int i13 = 0; i13 < 8; i13++) {
            long j11 = 0;
            for (int i14 = 0; i14 < 8; i14++) {
                int i15 = this.D;
                int i16 = this.B;
                j11 |= ((long) (((short) (((sArr[i12] & s12) + (1 << ((i15 - i16) - 1))) >> (i15 - i16))) & s11)) << (i16 * i14);
                i12++;
            }
            int i17 = 0;
            while (true) {
                int i18 = this.B;
                if (i17 >= i18) {
                    break;
                }
                bArr[(i18 * i13) + i17] = (byte) ((int) ((j11 >> (i17 * 8)) & 255));
                i17++;
            }
        }
        return bArr;
    }

    private short[] encode(byte[] bArr) {
        int i11;
        short[] sArr = new short[64];
        int i12 = 0;
        byte b11 = 1;
        for (int i13 = 0; i13 < 8; i13++) {
            for (int i14 = 0; i14 < 8; i14++) {
                int i15 = 0;
                int i16 = 0;
                while (true) {
                    i11 = this.B;
                    if (i15 >= i11) {
                        break;
                    }
                    if ((bArr[i12] & b11) == b11) {
                        i16 += 1 << i15;
                    }
                    b11 = (byte) (b11 << 1);
                    if (b11 == 0) {
                        i12++;
                        b11 = 1;
                    }
                    i15++;
                }
                sArr[(i13 * 8) + i14] = (short) (i16 * (this.f59520q / (1 << i11)));
            }
        }
        return sArr;
    }

    private short[] matrix_add(short[] sArr, short[] sArr2, int i11, int i12) {
        short[] sArr3 = new short[(i11 * i12)];
        for (int i13 = 0; i13 < i11; i13++) {
            for (int i14 = 0; i14 < i12; i14++) {
                int i15 = (i13 * i12) + i14;
                sArr3[i15] = (short) (((sArr[i15] & Constants.PROTOCOL_NONE) + (65535 & sArr2[i15])) % this.f59520q);
            }
        }
        return sArr3;
    }

    private short[] matrix_mul(short[] sArr, int i11, int i12, short[] sArr2, int i13, int i14) {
        short[] sArr3 = new short[(i11 * i14)];
        for (int i15 = 0; i15 < i11; i15++) {
            for (int i16 = 0; i16 < i14; i16++) {
                for (int i17 = 0; i17 < i12; i17++) {
                    int i18 = (i15 * i14) + i16;
                    sArr3[i18] = (short) (65535 & ((sArr3[i18] & Constants.PROTOCOL_NONE) + ((sArr[(i15 * i12) + i17] & Constants.PROTOCOL_NONE) * (sArr2[(i17 * i14) + i16] & Constants.PROTOCOL_NONE))));
                }
                int i19 = (i15 * i14) + i16;
                sArr3[i19] = (short) (65535 & ((sArr3[i19] & Constants.PROTOCOL_NONE) % this.f59520q));
            }
        }
        return sArr3;
    }

    private short[] matrix_sub(short[] sArr, short[] sArr2, int i11, int i12) {
        short[] sArr3 = new short[(i11 * i12)];
        for (int i13 = 0; i13 < i11; i13++) {
            for (int i14 = 0; i14 < i12; i14++) {
                int i15 = (i13 * i12) + i14;
                sArr3[i15] = (short) (((sArr[i15] - sArr2[i15]) & 65535) % this.f59520q);
            }
        }
        return sArr3;
    }

    private short[] matrix_transpose(short[] sArr, int i11, int i12) {
        short[] sArr2 = new short[(i11 * i12)];
        for (int i13 = 0; i13 < i12; i13++) {
            for (int i14 = 0; i14 < i11; i14++) {
                sArr2[(i13 * i11) + i14] = sArr[(i14 * i12) + i13];
            }
        }
        return sArr2;
    }

    private byte[] pack(short[] sArr) {
        short[] sArr2 = sArr;
        int length = sArr2.length;
        int i11 = (this.D * length) / 8;
        byte[] bArr = new byte[i11];
        short s11 = 0;
        short s12 = 0;
        byte b11 = 0;
        short s13 = 0;
        while (s11 < i11 && (s12 < length || (s12 == length && b11 > 0))) {
            byte b12 = 0;
            while (b12 < 8) {
                int i12 = 8 - b12;
                int min = Math.min(i12, b11);
                int i13 = b11 - min;
                bArr[s11] = (byte) (bArr[s11] + (((byte) (((short) ((1 << min) - 1)) & (s13 >> i13))) << (i12 - min)));
                b12 = (byte) (b12 + min);
                b11 = (byte) i13;
                if (b11 == 0) {
                    if (s12 >= length) {
                        break;
                    }
                    short s14 = sArr2[s12];
                    s12 = (short) (s12 + 1);
                    s13 = s14;
                    b11 = (byte) this.D;
                }
            }
            if (b12 == 8) {
                s11 = (short) (s11 + 1);
            }
        }
        return bArr;
    }

    private short sample(short s11) {
        short s12 = s11 & Constants.PROTOCOL_NONE;
        short s13 = (short) (s12 >>> 1);
        int i11 = 0;
        short s14 = 0;
        while (true) {
            short[] sArr = this.T_chi;
            if (i11 >= sArr.length) {
                break;
            }
            if (s13 > sArr[i11]) {
                s14 = (short) (s14 + 1);
            }
            i11++;
        }
        return s12 % 2 == 1 ? (short) ((s14 * -1) & 65535) : s14;
    }

    private short[] sample_matrix(short[] sArr, int i11, int i12, int i13) {
        short[] sArr2 = new short[(i12 * i13)];
        for (int i14 = 0; i14 < i12; i14++) {
            for (int i15 = 0; i15 < i13; i15++) {
                int i16 = (i14 * i13) + i15;
                sArr2[i16] = sample(sArr[i16 + i11]);
            }
        }
        return sArr2;
    }

    private short[] unpack(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = bArr;
        int i13 = i11 * i12;
        short[] sArr = new short[i13];
        short s11 = 0;
        short s12 = 0;
        byte b11 = 0;
        byte b12 = 0;
        while (s11 < i13 && (s12 < bArr2.length || (s12 == bArr2.length && b11 > 0))) {
            byte b13 = 0;
            while (true) {
                int i14 = this.D;
                if (b13 >= i14) {
                    break;
                }
                int min = Math.min(i14 - b13, b11);
                short s13 = (short) (((1 << min) - 1) & 65535);
                sArr[s11] = (short) (((sArr[s11] & Constants.PROTOCOL_NONE) + ((((byte) ((((b12 & 255) >>> ((b11 & 255) - min)) & (s13 & Constants.PROTOCOL_NONE)) & 255)) & 255) << ((this.D - (b13 & 255)) - min))) & 65535);
                b13 = (byte) (b13 + min);
                byte b14 = (byte) (b11 - min);
                byte b15 = (byte) ((~(s13 << b14)) & b12);
                if (b14 == 0) {
                    if (s12 >= bArr2.length) {
                        b12 = b15;
                        b11 = b14;
                        break;
                    }
                    byte b16 = bArr2[s12];
                    b11 = 8;
                    s12 = (short) (s12 + 1);
                    b12 = b16;
                } else {
                    b12 = b15;
                    b11 = b14;
                }
            }
            if (b13 == this.D) {
                s11 = (short) (s11 + 1);
            }
        }
        return sArr;
    }

    public int getCipherTextSize() {
        return this.len_ct_bytes;
    }

    public int getPrivateKeySize() {
        return this.len_sk_bytes;
    }

    public int getPublicKeySize() {
        return this.len_pk_bytes;
    }

    public int getSessionKeySize() {
        return this.len_ss_bytes;
    }

    public void kem_dec(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = bArr2;
        byte[] bArr5 = bArr3;
        int i11 = (((this.f59519n * 8) * this.D) / 8) + 0;
        byte[] copyOfRange = Arrays.copyOfRange(bArr4, 0, i11);
        byte[] copyOfRange2 = Arrays.copyOfRange(bArr4, i11, ((this.D * 64) / 8) + i11);
        int i12 = this.len_s_bytes + 0;
        byte[] copyOfRange3 = Arrays.copyOfRange(bArr5, 0, i12);
        int i13 = i12 + 16;
        byte[] copyOfRange4 = Arrays.copyOfRange(bArr5, i12, i13);
        int i14 = (((this.D * this.f59519n) * 8) / 8) + i13;
        byte[] copyOfRange5 = Arrays.copyOfRange(bArr5, i13, i14);
        int i15 = (((this.f59519n * 8) * 16) / 8) + i14;
        byte[] copyOfRange6 = Arrays.copyOfRange(bArr5, i14, i15);
        short[] sArr = new short[(this.f59519n * 8)];
        for (int i16 = 0; i16 < 8; i16++) {
            int i17 = 0;
            while (true) {
                int i18 = this.f59519n;
                if (i17 >= i18) {
                    break;
                }
                sArr[(i16 * i18) + i17] = Pack.littleEndianToShort(copyOfRange6, (i18 * i16 * 2) + (i17 * 2));
                i17++;
            }
        }
        short[] matrix_transpose = matrix_transpose(sArr, 8, this.f59519n);
        byte[] copyOfRange7 = Arrays.copyOfRange(bArr5, i15, this.len_pkh_bytes + i15);
        short[] unpack = unpack(copyOfRange, 8, this.f59519n);
        short[] unpack2 = unpack(copyOfRange2, 8, 8);
        int i19 = this.f59519n;
        short[] sArr2 = unpack2;
        short[] sArr3 = unpack;
        byte[] decode = decode(matrix_sub(sArr2, matrix_mul(unpack, 8, i19, matrix_transpose, i19, 8), 8, 8));
        byte[] bArr6 = new byte[(this.len_seedSE_bytes + this.len_k_bytes)];
        this.digest.update(copyOfRange7, 0, this.len_pkh_bytes);
        this.digest.update(decode, 0, this.len_mu_bytes);
        this.digest.doFinal(bArr6, 0, this.len_seedSE_bytes + this.len_k_bytes);
        int i21 = this.len_seedSE_bytes;
        byte[] copyOfRange8 = Arrays.copyOfRange(bArr6, i21, this.len_k_bytes + i21);
        int i22 = ((this.f59519n * 16) + 64) * 2;
        byte[] bArr7 = new byte[i22];
        this.digest.update((byte) -106);
        this.digest.update(bArr6, 0, this.len_seedSE_bytes);
        this.digest.doFinal(bArr7, 0, i22);
        int i23 = (this.f59519n * 16) + 64;
        short[] sArr4 = new short[i23];
        for (int i24 = 0; i24 < i23; i24++) {
            sArr4[i24] = Pack.littleEndianToShort(bArr7, i24 * 2);
        }
        short[] sample_matrix = sample_matrix(sArr4, 0, 8, this.f59519n);
        int i25 = this.f59519n;
        short[] sample_matrix2 = sample_matrix(sArr4, i25 * 8, 8, i25);
        short[] genMatrix = this.gen.genMatrix(copyOfRange4);
        int i26 = this.f59519n;
        int i27 = i26;
        short[] matrix_add = matrix_add(matrix_mul(sample_matrix, 8, i26, genMatrix, i27, i27), sample_matrix2, 8, this.f59519n);
        short[] sample_matrix3 = sample_matrix(sArr4, this.f59519n * 16, 8, 8);
        short[] unpack3 = unpack(copyOfRange5, this.f59519n, 8);
        int i28 = this.f59519n;
        byte[] ctselect = ctselect(copyOfRange8, copyOfRange3, ctverify(sArr3, sArr2, matrix_add, matrix_add(matrix_add(matrix_mul(sample_matrix, 8, i28, unpack3, i28, 8), sample_matrix3, 8, 8), encode(decode), 8, 8)));
        this.digest.update(copyOfRange, 0, copyOfRange.length);
        byte[] bArr8 = copyOfRange2;
        this.digest.update(bArr8, 0, bArr8.length);
        this.digest.update(ctselect, 0, ctselect.length);
        this.digest.doFinal(bArr, 0, this.len_ss_bytes);
    }

    public void kem_enc(byte[] bArr, byte[] bArr2, byte[] bArr3, SecureRandom secureRandom) {
        byte[] bArr4 = bArr3;
        byte[] copyOfRange = Arrays.copyOfRange(bArr4, 0, 16);
        byte[] copyOfRange2 = Arrays.copyOfRange(bArr4, 16, this.len_pk_bytes);
        byte[] bArr5 = new byte[this.len_mu_bytes];
        secureRandom.nextBytes(bArr5);
        byte[] bArr6 = new byte[this.len_pkh_bytes];
        this.digest.update(bArr4, 0, this.len_pk_bytes);
        this.digest.doFinal(bArr6, 0, this.len_pkh_bytes);
        byte[] bArr7 = new byte[(this.len_seedSE + this.len_k)];
        this.digest.update(bArr6, 0, this.len_pkh_bytes);
        this.digest.update(bArr5, 0, this.len_mu_bytes);
        this.digest.doFinal(bArr7, 0, this.len_seedSE_bytes + this.len_k_bytes);
        byte[] copyOfRange3 = Arrays.copyOfRange(bArr7, 0, this.len_seedSE_bytes);
        int i11 = this.len_seedSE_bytes;
        byte[] copyOfRange4 = Arrays.copyOfRange(bArr7, i11, this.len_k_bytes + i11);
        int i12 = ((this.f59519n * 16) + 64) * 2;
        byte[] bArr8 = new byte[i12];
        this.digest.update((byte) -106);
        this.digest.update(copyOfRange3, 0, copyOfRange3.length);
        this.digest.doFinal(bArr8, 0, i12);
        int i13 = i12 / 2;
        short[] sArr = new short[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            sArr[i14] = Pack.littleEndianToShort(bArr8, i14 * 2);
        }
        short[] sample_matrix = sample_matrix(sArr, 0, 8, this.f59519n);
        int i15 = this.f59519n;
        short[] sample_matrix2 = sample_matrix(sArr, i15 * 8, 8, i15);
        short[] genMatrix = this.gen.genMatrix(copyOfRange);
        int i16 = this.f59519n;
        byte[] pack = pack(matrix_add(matrix_mul(sample_matrix, 8, i16, genMatrix, i16, i16), sample_matrix2, 8, this.f59519n));
        short[] sample_matrix3 = sample_matrix(sArr, this.f59519n * 16, 8, 8);
        short[] unpack = unpack(copyOfRange2, this.f59519n, 8);
        int i17 = this.f59519n;
        byte[] pack2 = pack(matrix_add(matrix_add(matrix_mul(sample_matrix, 8, i17, unpack, i17, 8), sample_matrix3, 8, 8), encode(bArr5), 8, 8));
        System.arraycopy(Arrays.concatenate(pack, pack2), 0, bArr, 0, this.len_ct_bytes);
        this.digest.update(pack, 0, pack.length);
        this.digest.update(pack2, 0, pack2.length);
        this.digest.update(copyOfRange4, 0, this.len_k_bytes);
        this.digest.doFinal(bArr2, 0, this.len_s_bytes);
    }

    public void kem_keypair(byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        byte[] bArr5 = new byte[(this.len_s_bytes + this.len_seedSE_bytes + 16)];
        secureRandom.nextBytes(bArr5);
        byte[] copyOfRange = Arrays.copyOfRange(bArr5, 0, this.len_s_bytes);
        int i11 = this.len_s_bytes;
        byte[] copyOfRange2 = Arrays.copyOfRange(bArr5, i11, this.len_seedSE_bytes + i11);
        int i12 = this.len_s_bytes;
        int i13 = this.len_seedSE_bytes;
        byte[] copyOfRange3 = Arrays.copyOfRange(bArr5, i12 + i13, i12 + i13 + 16);
        byte[] bArr6 = new byte[16];
        this.digest.update(copyOfRange3, 0, copyOfRange3.length);
        this.digest.doFinal(bArr6, 0, 16);
        short[] genMatrix = this.gen.genMatrix(bArr6);
        int i14 = this.f59519n * 2 * 8 * 2;
        byte[] bArr7 = new byte[i14];
        this.digest.update((byte) 95);
        this.digest.update(copyOfRange2, 0, copyOfRange2.length);
        this.digest.doFinal(bArr7, 0, i14);
        int i15 = this.f59519n * 2 * 8;
        short[] sArr = new short[i15];
        for (int i16 = 0; i16 < i15; i16++) {
            sArr[i16] = Pack.littleEndianToShort(bArr7, i16 * 2);
        }
        short[] sample_matrix = sample_matrix(sArr, 0, 8, this.f59519n);
        short[] matrix_transpose = matrix_transpose(sample_matrix, 8, this.f59519n);
        int i17 = this.f59519n;
        short[] sample_matrix2 = sample_matrix(sArr, i17 * 8, i17, 8);
        int i18 = this.f59519n;
        System.arraycopy(Arrays.concatenate(bArr6, pack(matrix_add(matrix_mul(genMatrix, i18, i18, matrix_transpose, i18, 8), sample_matrix2, this.f59519n, 8))), 0, bArr3, 0, this.len_pk_bytes);
        int i19 = this.len_pkh_bytes;
        byte[] bArr8 = new byte[i19];
        this.digest.update(bArr3, 0, bArr3.length);
        this.digest.doFinal(bArr8, 0, i19);
        System.arraycopy(Arrays.concatenate(copyOfRange, bArr3), 0, bArr4, 0, this.len_s_bytes + this.len_pk_bytes);
        for (int i21 = 0; i21 < 8; i21++) {
            int i22 = 0;
            while (true) {
                int i23 = this.f59519n;
                if (i22 >= i23) {
                    break;
                }
                System.arraycopy(Pack.shortToLittleEndian(sample_matrix[(i23 * i21) + i22]), 0, bArr4, this.len_s_bytes + this.len_pk_bytes + (this.f59519n * i21 * 2) + (i22 * 2), 2);
                i22++;
            }
        }
        int i24 = this.len_sk_bytes;
        int i25 = this.len_pkh_bytes;
        System.arraycopy(bArr8, 0, bArr4, i24 - i25, i25);
    }
}
