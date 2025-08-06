package com.google.android.recaptcha.internal;

import android.util.Base64;
import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class zzmh {
    public static final Charset zza = StandardCharsets.UTF_16;

    public static int zza(int i11, int i12) {
        if (i11 % 2 != 0) {
            return (i11 | i12) - (i11 & i12);
        }
        return ((~i11) & i12) | ((~i12) & i11);
    }

    public static String zzb(String str, byte[] bArr, zzmi zzmi) {
        byte[] bArr2 = bArr;
        int i11 = 0;
        byte[] decode = Base64.decode(str, 0);
        char c11 = 12;
        byte[] bArr3 = new byte[12];
        int length = decode.length - 12;
        byte[] bArr4 = new byte[length];
        System.arraycopy(decode, 0, bArr3, 0, 12);
        System.arraycopy(decode, 12, bArr4, 0, length);
        int[] iArr = {511133343, 1277647508, 107287496, 338123662};
        if (bArr2.length == 32) {
            int i12 = 16;
            int[] iArr2 = new int[16];
            for (int i13 = 0; i13 < 4; i13++) {
                iArr2[i13] = zza(iArr[i13], 2131181306);
            }
            for (int i14 = 4; i14 < 12; i14++) {
                iArr2[i14] = zze(bArr2, (i14 - 4) * 4);
            }
            iArr2[12] = 1;
            for (int i15 = 13; i15 < 16; i15++) {
                iArr2[i15] = zze(bArr3, (i15 - 13) * 4);
            }
            int[] iArr3 = new int[16];
            System.arraycopy(iArr2, 0, iArr3, 0, 16);
            byte[] bArr5 = new byte[length];
            int i16 = length;
            int i17 = 1;
            int i18 = 0;
            while (i16 > 0) {
                System.arraycopy(iArr3, i11, iArr2, i11, i12);
                iArr2[c11] = i17;
                int i19 = i11;
                while (i19 < 10) {
                    int i21 = i19;
                    int[] iArr4 = iArr;
                    int i22 = i16;
                    byte[] bArr6 = bArr;
                    byte[] bArr7 = bArr5;
                    byte[] bArr8 = bArr3;
                    int[] iArr5 = iArr3;
                    int i23 = i17;
                    int[] iArr6 = iArr2;
                    int i24 = i12;
                    int[] iArr7 = iArr5;
                    zzc(0, 4, 8, 12, iArr4, bArr6, bArr8, i23, iArr2, iArr7);
                    zzc(1, 5, 9, 13, iArr4, bArr6, bArr8, i23, iArr2, iArr7);
                    zzc(2, 6, 10, 14, iArr4, bArr6, bArr8, i23, iArr2, iArr7);
                    zzc(3, 7, 11, 15, iArr4, bArr6, bArr8, i23, iArr2, iArr7);
                    zzc(0, 5, 10, 15, iArr4, bArr6, bArr8, i23, iArr2, iArr7);
                    zzc(1, 6, 11, 12, iArr4, bArr6, bArr8, i23, iArr2, iArr7);
                    zzc(2, 7, 8, 13, iArr4, bArr6, bArr8, i23, iArr2, iArr7);
                    zzc(3, 4, 9, 14, iArr4, bArr6, bArr8, i23, iArr2, iArr7);
                    i19 = i21 + 1;
                    i12 = i24;
                    i16 = i22;
                    bArr5 = bArr7;
                    iArr3 = iArr5;
                    byte[] bArr9 = bArr;
                }
                int i25 = i16;
                byte[] bArr10 = bArr5;
                int[] iArr8 = iArr3;
                int[] iArr9 = iArr2;
                int i26 = i12;
                byte[] bArr11 = new byte[64];
                for (int i27 = 0; i27 < i26; i27++) {
                    int i28 = iArr9[i27];
                    int i29 = i27 * 4;
                    bArr11[i29] = (byte) (i28 & 255);
                    bArr11[i29 + 1] = (byte) ((i28 >> 8) & 255);
                    bArr11[i29 + 2] = (byte) ((i28 >> 16) & 255);
                    bArr11[i29 + 3] = (byte) ((i28 >> 24) & 255);
                }
                for (int i30 = 0; i30 < Math.min(64, i25); i30++) {
                    int i31 = i18 + i30;
                    bArr10[i31] = (byte) zza(bArr11[i30], bArr4[i31]);
                }
                i17++;
                i16 = i25 - 64;
                i18 += 64;
                i12 = i26;
                bArr5 = bArr10;
                iArr3 = iArr8;
                iArr2 = iArr9;
                i11 = 0;
                c11 = 12;
                byte[] bArr12 = bArr;
            }
            return new String(bArr5, zza);
        }
        throw new IllegalArgumentException();
    }

    public static final void zzc(int i11, int i12, int i13, int i14, int[] iArr, byte[] bArr, byte[] bArr2, int i15, int[] iArr2, int[] iArr3) {
        zzd(i11, i12, i14, 16, iArr, bArr, bArr2, i15, iArr2, iArr3);
        zzd(i13, i14, i12, 12, iArr, bArr, bArr2, i15, iArr2, iArr3);
        zzd(i11, i12, i14, 8, iArr, bArr, bArr2, i15, iArr2, iArr3);
        zzd(i13, i14, i12, 7, iArr, bArr, bArr2, i15, iArr2, iArr3);
    }

    public static final void zzd(int i11, int i12, int i13, int i14, int[] iArr, byte[] bArr, byte[] bArr2, int i15, int[] iArr2, int[] iArr3) {
        int i16 = iArr2[i11] + iArr2[i12];
        iArr2[i11] = i16;
        int zza2 = zza(iArr2[i13], i16);
        iArr2[i13] = (zza2 << i14) | (zza2 >>> (32 - i14));
    }

    private static final int zze(byte[] bArr, int i11) {
        int i12 = (bArr[i11 + 1] & 255) << 8;
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | i12 | (bArr[i11] & 255) | ((bArr[i11 + 2] & 255) << 16);
    }
}
