package com.google.zxing.oned.rss;

public final class RSSUtils {
    private RSSUtils() {
    }

    private static int combins(int i11, int i12) {
        int i13 = i11 - i12;
        if (i13 <= i12) {
            int i14 = i13;
            i13 = i12;
            i12 = i14;
        }
        int i15 = 1;
        int i16 = 1;
        while (i11 > i13) {
            i15 *= i11;
            if (i16 <= i12) {
                i15 /= i16;
                i16++;
            }
            i11--;
        }
        while (i16 <= i12) {
            i15 /= i16;
            i16++;
        }
        return i15;
    }

    public static int getRSSvalue(int[] iArr, int i11, boolean z11) {
        int[] iArr2 = iArr;
        int i12 = i11;
        int i13 = 0;
        for (int i14 : iArr2) {
            i13 += i14;
        }
        int length = iArr2.length;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int i18 = length - 1;
            if (i15 >= i18) {
                return i16;
            }
            int i19 = 1 << i15;
            i17 |= i19;
            int i21 = 1;
            while (i21 < iArr2[i15]) {
                int i22 = i13 - i21;
                int i23 = length - i15;
                int i24 = i23 - 2;
                int combins = combins(i22 - 1, i24);
                if (z11 && i17 == 0) {
                    int i25 = i23 - 1;
                    if (i22 - i25 >= i25) {
                        combins -= combins(i22 - i23, i24);
                    }
                }
                if (i23 - 1 > 1) {
                    int i26 = i22 - i24;
                    int i27 = 0;
                    while (i26 > i12) {
                        i27 += combins((i22 - i26) - 1, i23 - 3);
                        i26--;
                        int[] iArr3 = iArr;
                    }
                    combins -= i27 * (i18 - i15);
                } else if (i22 > i12) {
                    combins--;
                }
                i16 += combins;
                i21++;
                i17 &= ~i19;
                iArr2 = iArr;
            }
            i13 -= i21;
            i15++;
            iArr2 = iArr;
        }
    }
}
