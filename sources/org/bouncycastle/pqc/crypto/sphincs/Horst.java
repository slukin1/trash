package org.bouncycastle.pqc.crypto.sphincs;

import android.support.v4.media.session.PlaybackStateCompat;
import com.sumsub.sns.internal.ml.autocapture.b;

class Horst {
    public static final int HORST_K = 32;
    public static final int HORST_LOGT = 16;
    public static final int HORST_SIGBYTES = 13312;
    public static final int HORST_SKBYTES = 32;
    public static final int HORST_T = 65536;
    public static final int N_MASKS = 32;

    public static void expand_seed(byte[] bArr, byte[] bArr2) {
        Seed.prg(bArr, 0, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, bArr2, 0);
    }

    public static int horst_sign(HashFunctions hashFunctions, byte[] bArr, int i11, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        byte[] bArr6 = new byte[2097152];
        byte[] bArr7 = new byte[4194272];
        expand_seed(bArr6, bArr3);
        for (int i12 = 0; i12 < 65536; i12++) {
            hashFunctions.hash_n_n(bArr7, (65535 + i12) * 32, bArr6, i12 * 32);
        }
        HashFunctions hashFunctions2 = hashFunctions;
        for (int i13 = 0; i13 < 16; i13++) {
            int i14 = 16 - i13;
            long j11 = (long) ((1 << i14) - 1);
            int i15 = 1 << (i14 - 1);
            long j12 = (long) (i15 - 1);
            int i16 = 0;
            while (i16 < i15) {
                hashFunctions.hash_2n_n_mask(bArr7, (int) ((((long) i16) + j12) * 32), bArr7, (int) ((((long) (i16 * 2)) + j11) * 32), bArr4, i13 * 2 * 32);
                i16++;
                i15 = i15;
                j12 = j12;
            }
        }
        int i17 = 2016;
        int i18 = i11;
        while (i17 < 4064) {
            bArr[i18] = bArr7[i17];
            i17++;
            i18++;
        }
        for (int i19 = 0; i19 < 32; i19++) {
            int i21 = i19 * 2;
            int i22 = (bArr5[i21] & 255) + ((bArr5[i21 + 1] & 255) << 8);
            int i23 = 0;
            while (i23 < 32) {
                bArr[i18] = bArr6[(i22 * 32) + i23];
                i23++;
                i18++;
            }
            int i24 = i22 + 65535;
            for (int i25 = 0; i25 < 10; i25++) {
                int i26 = (i24 & 1) != 0 ? i24 + 1 : i24 - 1;
                int i27 = 0;
                while (i27 < 32) {
                    bArr[i18] = bArr7[(i26 * 32) + i27];
                    i27++;
                    i18++;
                }
                i24 = (i26 - 1) / 2;
            }
        }
        for (int i28 = 0; i28 < 32; i28++) {
            bArr2[i28] = bArr7[i28];
        }
        return HORST_SIGBYTES;
    }

    public static int horst_verify(HashFunctions hashFunctions, byte[] bArr, byte[] bArr2, int i11, byte[] bArr3, byte[] bArr4) {
        int i12;
        HashFunctions hashFunctions2 = hashFunctions;
        byte[] bArr5 = bArr2;
        int i13 = i11;
        byte[] bArr6 = new byte[1024];
        int i14 = i13 + 2048;
        int i15 = 0;
        while (i15 < 32) {
            int i16 = i15 * 2;
            int i17 = (bArr4[i16] & 255) + ((bArr4[i16 + 1] & 255) << 8);
            if ((i17 & 1) == 0) {
                hashFunctions2.hash_n_n(bArr6, 0, bArr5, i14);
                for (int i18 = 0; i18 < 32; i18++) {
                    bArr6[i18 + 32] = bArr5[i14 + 32 + i18];
                }
            } else {
                hashFunctions2.hash_n_n(bArr6, 32, bArr5, i14);
                for (int i19 = 0; i19 < 32; i19++) {
                    bArr6[i19] = bArr5[i14 + 32 + i19];
                }
            }
            int i21 = i14 + 64;
            int i22 = 1;
            while (i22 < 10) {
                int i23 = i17 >>> 1;
                if ((i23 & 1) == 0) {
                    i12 = i22;
                    hashFunctions.hash_2n_n_mask(bArr6, 0, bArr6, 0, bArr3, (i22 - 1) * 2 * 32);
                    for (int i24 = 0; i24 < 32; i24++) {
                        bArr6[i24 + 32] = bArr5[i21 + i24];
                    }
                } else {
                    i12 = i22;
                    hashFunctions.hash_2n_n_mask(bArr6, 32, bArr6, 0, bArr3, (i12 - 1) * 2 * 32);
                    for (int i25 = 0; i25 < 32; i25++) {
                        bArr6[i25] = bArr5[i21 + i25];
                    }
                }
                i21 += 32;
                i22 = i12 + 1;
                i17 = i23;
            }
            int i26 = i17 >>> 1;
            hashFunctions.hash_2n_n_mask(bArr6, 0, bArr6, 0, bArr3, 576);
            for (int i27 = 0; i27 < 32; i27++) {
                if (bArr5[(i26 * 32) + i13 + i27] != bArr6[i27]) {
                    for (int i28 = 0; i28 < 32; i28++) {
                        bArr[i28] = 0;
                    }
                    return -1;
                }
            }
            i15++;
            i14 = i21;
        }
        for (int i29 = 0; i29 < 32; i29++) {
            hashFunctions.hash_2n_n_mask(bArr6, i29 * 32, bArr2, i13 + (i29 * 2 * 32), bArr3, b.f34944a);
        }
        for (int i30 = 0; i30 < 16; i30++) {
            hashFunctions.hash_2n_n_mask(bArr6, i30 * 32, bArr6, i30 * 2 * 32, bArr3, 704);
        }
        for (int i31 = 0; i31 < 8; i31++) {
            hashFunctions.hash_2n_n_mask(bArr6, i31 * 32, bArr6, i31 * 2 * 32, bArr3, 768);
        }
        for (int i32 = 0; i32 < 4; i32++) {
            hashFunctions.hash_2n_n_mask(bArr6, i32 * 32, bArr6, i32 * 2 * 32, bArr3, 832);
        }
        for (int i33 = 0; i33 < 2; i33++) {
            hashFunctions.hash_2n_n_mask(bArr6, i33 * 32, bArr6, i33 * 2 * 32, bArr3, 896);
        }
        hashFunctions.hash_2n_n_mask(bArr, 0, bArr6, 0, bArr3, 960);
        return 0;
    }
}
