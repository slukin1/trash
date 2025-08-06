package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;

public final class zzef {
    private List zza = CollectionsKt__CollectionsKt.k();

    public final long zza(long[] jArr) {
        Iterator it2 = CollectionsKt___CollectionsKt.q0(this.zza, ArraysKt___ArraysKt.w0(jArr)).iterator();
        if (it2.hasNext()) {
            Object next = it2.next();
            while (it2.hasNext()) {
                next = Long.valueOf(((Number) next).longValue() ^ ((Number) it2.next()).longValue());
            }
            return ((Number) next).longValue();
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public final void zzb(long[] jArr) {
        this.zza = ArraysKt___ArraysKt.w0(jArr);
    }
}
