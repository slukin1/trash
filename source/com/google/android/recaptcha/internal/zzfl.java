package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Objects;
import java.util.Queue;

public final class zzfl extends zzfp implements Serializable {
    public final int zza;
    private final Queue zzb;

    private zzfl(int i11) {
        if (i11 >= 0) {
            this.zzb = new ArrayDeque(i11);
            this.zza = i11;
            return;
        }
        throw new IllegalArgumentException(zzfi.zza("maxSize (%s) must >= 0", Integer.valueOf(i11)));
    }

    public static zzfl zza(int i11) {
        return new zzfl(i11);
    }

    public final boolean add(Object obj) {
        Objects.requireNonNull(obj);
        if (this.zza == 0) {
            return true;
        }
        if (size() == this.zza) {
            this.zzb.remove();
        }
        this.zzb.add(obj);
        return true;
    }

    public final boolean addAll(Collection collection) {
        int size = collection.size();
        if (size < this.zza) {
            return zzfs.zza(this, collection.iterator());
        }
        clear();
        int i11 = size - this.zza;
        zzff.zzb(i11 >= 0, "number to skip cannot be negative");
        return zzfs.zza(this, new zzfr(collection, i11).iterator());
    }

    public final boolean offer(Object obj) {
        add(obj);
        return true;
    }

    public final /* synthetic */ Object zzb() {
        return this.zzb;
    }

    public final /* synthetic */ Collection zzc() {
        return this.zzb;
    }

    public final Queue zzd() {
        return this.zzb;
    }
}
