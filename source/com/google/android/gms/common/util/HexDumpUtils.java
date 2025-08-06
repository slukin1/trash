package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

@KeepForSdk
public final class HexDumpUtils {
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public static String dump(byte[] bArr, int i11, int i12, boolean z11) {
        int length;
        if (bArr == null || (length = bArr.length) == 0 || i11 < 0 || i12 <= 0 || i11 + i12 > length) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder((z11 ? 75 : 57) * ((i12 + 15) / 16));
        int i13 = i12;
        int i14 = 0;
        int i15 = 0;
        while (i13 > 0) {
            if (i14 == 0) {
                if (i12 < 65536) {
                    sb2.append(String.format("%04X:", new Object[]{Integer.valueOf(i11)}));
                } else {
                    sb2.append(String.format("%08X:", new Object[]{Integer.valueOf(i11)}));
                }
                i15 = i11;
            } else if (i14 == 8) {
                sb2.append(" -");
            }
            sb2.append(String.format(" %02X", new Object[]{Integer.valueOf(bArr[i11] & 255)}));
            i13--;
            i14++;
            if (z11 && (i14 == 16 || i13 == 0)) {
                int i16 = 16 - i14;
                if (i16 > 0) {
                    for (int i17 = 0; i17 < i16; i17++) {
                        sb2.append("   ");
                    }
                }
                if (i16 >= 8) {
                    sb2.append("  ");
                }
                sb2.append("  ");
                for (int i18 = 0; i18 < i14; i18++) {
                    char c11 = (char) bArr[i15 + i18];
                    if (c11 < ' ' || c11 > '~') {
                        c11 = '.';
                    }
                    sb2.append(c11);
                }
            }
            if (i14 == 16 || i13 == 0) {
                sb2.append(10);
                i14 = 0;
            }
            i11++;
        }
        return sb2.toString();
    }
}
