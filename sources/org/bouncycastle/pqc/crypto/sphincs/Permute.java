package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.util.Pack;

class Permute {
    private static final int CHACHA_ROUNDS = 12;

    public static void permute(int i11, int[] iArr) {
        int[] iArr2 = iArr;
        int i12 = 16;
        if (iArr2.length != 16) {
            throw new IllegalArgumentException();
        } else if (i11 % 2 == 0) {
            char c11 = 0;
            int i13 = iArr2[0];
            int i14 = iArr2[1];
            int i15 = iArr2[2];
            int i16 = iArr2[3];
            int i17 = iArr2[4];
            int i18 = iArr2[5];
            int i19 = iArr2[6];
            int i21 = 7;
            int i22 = iArr2[7];
            int i23 = 8;
            int i24 = iArr2[8];
            int i25 = iArr2[9];
            int i26 = iArr2[10];
            int i27 = iArr2[11];
            int i28 = iArr2[12];
            int i29 = iArr2[13];
            int i30 = iArr2[14];
            int i31 = iArr2[15];
            int i32 = i30;
            int i33 = i29;
            int i34 = i28;
            int i35 = i27;
            int i36 = i26;
            int i37 = i25;
            int i38 = i24;
            int i39 = i22;
            int i40 = i19;
            int i41 = i18;
            int i42 = i17;
            int i43 = i16;
            int i44 = i15;
            int i45 = i14;
            int i46 = i13;
            int i47 = i11;
            while (i47 > 0) {
                int i48 = i46 + i42;
                int rotl = rotl(i34 ^ i48, i12);
                int i49 = i38 + rotl;
                int rotl2 = rotl(i42 ^ i49, 12);
                int i50 = i48 + rotl2;
                int rotl3 = rotl(rotl ^ i50, i23);
                int i51 = i49 + rotl3;
                int rotl4 = rotl(rotl2 ^ i51, i21);
                int i52 = i45 + i41;
                int rotl5 = rotl(i33 ^ i52, i12);
                int i53 = i37 + rotl5;
                int rotl6 = rotl(i41 ^ i53, 12);
                int i54 = i52 + rotl6;
                int rotl7 = rotl(rotl5 ^ i54, i23);
                int i55 = i53 + rotl7;
                int rotl8 = rotl(rotl6 ^ i55, i21);
                int i56 = i44 + i40;
                int rotl9 = rotl(i32 ^ i56, i12);
                int i57 = i36 + rotl9;
                int rotl10 = rotl(i40 ^ i57, 12);
                int i58 = i56 + rotl10;
                int rotl11 = rotl(rotl9 ^ i58, i23);
                int i59 = i57 + rotl11;
                int rotl12 = rotl(rotl10 ^ i59, i21);
                int i60 = i43 + i39;
                int rotl13 = rotl(i31 ^ i60, i12);
                int i61 = i35 + rotl13;
                int rotl14 = rotl(i39 ^ i61, 12);
                int i62 = i60 + rotl14;
                int rotl15 = rotl(rotl13 ^ i62, i23);
                int i63 = i61 + rotl15;
                int rotl16 = rotl(rotl14 ^ i63, 7);
                int i64 = i50 + rotl8;
                int rotl17 = rotl(rotl15 ^ i64, 16);
                int i65 = i59 + rotl17;
                int rotl18 = rotl(rotl8 ^ i65, 12);
                i46 = i64 + rotl18;
                i31 = rotl(rotl17 ^ i46, 8);
                i36 = i65 + i31;
                i41 = rotl(rotl18 ^ i36, 7);
                int i66 = i54 + rotl12;
                int rotl19 = rotl(rotl3 ^ i66, 16);
                int i67 = i63 + rotl19;
                int rotl20 = rotl(rotl12 ^ i67, 12);
                i45 = i66 + rotl20;
                i34 = rotl(rotl19 ^ i45, 8);
                i35 = i67 + i34;
                i40 = rotl(rotl20 ^ i35, 7);
                int i68 = i58 + rotl16;
                int rotl21 = rotl(rotl7 ^ i68, 16);
                int i69 = i51 + rotl21;
                int rotl22 = rotl(rotl16 ^ i69, 12);
                i44 = i68 + rotl22;
                i33 = rotl(rotl21 ^ i44, 8);
                i38 = i69 + i33;
                i39 = rotl(rotl22 ^ i38, 7);
                int i70 = i62 + rotl4;
                i12 = 16;
                int rotl23 = rotl(rotl11 ^ i70, 16);
                int i71 = i55 + rotl23;
                int rotl24 = rotl(rotl4 ^ i71, 12);
                i43 = i70 + rotl24;
                i32 = rotl(rotl23 ^ i43, 8);
                i37 = i71 + i32;
                i42 = rotl(rotl24 ^ i37, 7);
                i47 -= 2;
                i21 = 7;
                c11 = 0;
                i23 = 8;
            }
            iArr2[c11] = i46;
            iArr2[1] = i45;
            iArr2[2] = i44;
            iArr2[3] = i43;
            iArr2[4] = i42;
            iArr2[5] = i41;
            iArr2[6] = i40;
            iArr2[i21] = i39;
            iArr2[8] = i38;
            iArr2[9] = i37;
            iArr2[10] = i36;
            iArr2[11] = i35;
            iArr2[12] = i34;
            iArr2[13] = i33;
            iArr2[14] = i32;
            iArr2[15] = i31;
        } else {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
    }

    public static int rotl(int i11, int i12) {
        return (i11 >>> (-i12)) | (i11 << i12);
    }

    public void chacha_permute(byte[] bArr, byte[] bArr2) {
        int[] iArr = new int[16];
        for (int i11 = 0; i11 < 16; i11++) {
            iArr[i11] = Pack.littleEndianToInt(bArr2, i11 * 4);
        }
        permute(12, iArr);
        for (int i12 = 0; i12 < 16; i12++) {
            Pack.intToLittleEndian(iArr[i12], bArr, i12 * 4);
        }
    }
}
