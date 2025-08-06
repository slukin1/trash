package com.google.android.recaptcha.internal;

import net.sf.scuba.smartcards.ISO7816;

final class zzly extends zzlx {
    public final int zza(int i11, byte[] bArr, int i12, int i13) {
        while (r9 < i13 && bArr[r9] >= 0) {
            i12 = r9 + 1;
        }
        if (r9 >= i13) {
            return 0;
        }
        while (r9 < i13) {
            int i14 = r9 + 1;
            byte b11 = bArr[r9];
            if (b11 < 0) {
                if (b11 < -32) {
                    if (i14 >= i13) {
                        return b11;
                    }
                    if (b11 >= -62) {
                        r9 = i14 + 1;
                        if (bArr[i14] > -65) {
                        }
                    }
                } else if (b11 < -16) {
                    if (i14 >= i13 - 1) {
                        return zzma.zza(bArr, i14, i13);
                    }
                    int i15 = i14 + 1;
                    byte b12 = bArr[i14];
                    if (b12 <= -65 && ((b11 != -32 || b12 >= -96) && (b11 != -19 || b12 < -96))) {
                        r9 = i15 + 1;
                        if (bArr[i15] > -65) {
                        }
                    }
                } else if (i14 >= i13 - 2) {
                    return zzma.zza(bArr, i14, i13);
                } else {
                    int i16 = i14 + 1;
                    byte b13 = bArr[i14];
                    if (b13 <= -65 && (((b11 << 28) + (b13 + ISO7816.INS_MANAGE_CHANNEL)) >> 30) == 0) {
                        int i17 = i16 + 1;
                        if (bArr[i16] <= -65) {
                            i14 = i17 + 1;
                            if (bArr[i17] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            r9 = i14;
        }
        return 0;
    }
}
