package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

final class zzfr extends zzfm {
    public final /* synthetic */ Iterable zza;
    public final /* synthetic */ int zzb;

    public zzfr(Iterable iterable, int i11) {
        this.zza = iterable;
        this.zzb = i11;
    }

    public final Iterator iterator() {
        Iterable iterable = this.zza;
        if (iterable instanceof List) {
            List list = (List) iterable;
            return list.subList(Math.min(list.size(), this.zzb), list.size()).iterator();
        }
        int i11 = this.zzb;
        Iterator it2 = iterable.iterator();
        Objects.requireNonNull(it2);
        zzff.zzb(i11 >= 0, "numberToAdvance must be nonnegative");
        for (int i12 = 0; i12 < i11 && it2.hasNext(); i12++) {
            it2.next();
        }
        return new zzfq(this, it2);
    }
}
