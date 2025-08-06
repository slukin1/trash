package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.jspecify.nullness.NullMarked;

@NullMarked
public final class zzah {
    @CanIgnoreReturnValue
    public static Object[] zza(Object[] objArr, int i11) {
        int i12 = 0;
        while (i12 < i11) {
            if (objArr[i12] != null) {
                i12++;
            } else {
                throw new NullPointerException("at index " + i12);
            }
        }
        return objArr;
    }
}
