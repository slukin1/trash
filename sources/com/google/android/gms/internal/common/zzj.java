package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jspecify.nullness.NullMarked;

@NullMarked
abstract class zzj implements Iterator {
    private Object zza;
    private int zzb = 2;

    public final boolean hasNext() {
        int i11 = this.zzb;
        if (i11 != 4) {
            int i12 = i11 - 1;
            if (i11 == 0) {
                throw null;
            } else if (i12 == 0) {
                return true;
            } else {
                if (i12 != 2) {
                    this.zzb = 4;
                    this.zza = zza();
                    if (this.zzb != 3) {
                        this.zzb = 1;
                        return true;
                    }
                }
                return false;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public final Object next() {
        if (hasNext()) {
            this.zzb = 2;
            Object obj = this.zza;
            this.zza = null;
            return obj;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public abstract Object zza();

    @CanIgnoreReturnValue
    public final Object zzb() {
        this.zzb = 3;
        return null;
    }
}
