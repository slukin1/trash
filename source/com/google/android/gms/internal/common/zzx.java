package com.google.android.gms.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.jspecify.nullness.NullMarked;

@NullMarked
public final class zzx {
    /* access modifiers changed from: private */
    public final zzo zza;
    /* access modifiers changed from: private */
    public final boolean zzb;
    private final zzu zzc;

    private zzx(zzu zzu, boolean z11, zzo zzo, int i11) {
        this.zzc = zzu;
        this.zzb = z11;
        this.zza = zzo;
    }

    public static zzx zzc(zzo zzo) {
        return new zzx(new zzu(zzo), false, zzn.zza, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: private */
    public final Iterator zzh(CharSequence charSequence) {
        return new zzt(this.zzc, this, charSequence);
    }

    public final zzx zzb() {
        return new zzx(this.zzc, true, this.zza, Integer.MAX_VALUE);
    }

    public final Iterable zzd(CharSequence charSequence) {
        return new zzv(this, charSequence);
    }

    public final List zzf(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        Iterator zzh = zzh(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzh.hasNext()) {
            arrayList.add((String) zzh.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
