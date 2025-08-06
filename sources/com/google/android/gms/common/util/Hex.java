package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
@KeepForSdk
public class Hex {
    private static final char[] zza = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] zzb = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @KeepForSdk
    public static String bytesToStringLowercase(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length + length)];
        int i11 = 0;
        for (byte b11 : bArr) {
            byte b12 = b11 & 255;
            int i12 = i11 + 1;
            char[] cArr2 = zzb;
            cArr[i11] = cArr2[b12 >>> 4];
            cArr[i12] = cArr2[b12 & 15];
            i11 = i12 + 1;
        }
        return new String(cArr);
    }

    @KeepForSdk
    public static String bytesToStringUppercase(byte[] bArr) {
        return bytesToStringUppercase(bArr, false);
    }

    @KeepForSdk
    public static byte[] stringToBytes(String str) throws IllegalArgumentException {
        int length = str.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[(length / 2)];
            int i11 = 0;
            while (i11 < length) {
                int i12 = i11 + 2;
                bArr[i11 / 2] = (byte) Integer.parseInt(str.substring(i11, i12), 16);
                i11 = i12;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Hex string has odd number of characters");
    }

    @KeepForSdk
    public static String bytesToStringUppercase(byte[] bArr, boolean z11) {
        int length = bArr.length;
        StringBuilder sb2 = new StringBuilder(length + length);
        int i11 = 0;
        while (i11 < length && (!z11 || i11 != length - 1 || (bArr[i11] & 255) != 0)) {
            char[] cArr = zza;
            sb2.append(cArr[(bArr[i11] & 240) >>> 4]);
            sb2.append(cArr[bArr[i11] & 15]);
            i11++;
        }
        return sb2.toString();
    }
}
