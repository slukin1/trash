package com.google.android.gms.common;

import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zzd {
    public static int zza(int i11) {
        int[] iArr = {1, 2, 3};
        int i12 = 0;
        while (i12 < 3) {
            int i13 = iArr[i12];
            int i14 = i13 - 1;
            if (i13 == 0) {
                throw null;
            } else if (i14 == i11) {
                return i13;
            } else {
                i12++;
            }
        }
        return 1;
    }
}
