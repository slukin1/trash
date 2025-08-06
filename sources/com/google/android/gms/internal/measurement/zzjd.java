package com.google.android.gms.internal.measurement;

public final class zzjd {
    public static Object zza(Object obj, int i11) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i11);
    }

    public static Object[] zzb(Object[] objArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            zza(objArr[i12], i12);
        }
        return objArr;
    }
}
