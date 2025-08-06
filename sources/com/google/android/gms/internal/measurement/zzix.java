package com.google.android.gms.internal.measurement;

import java.util.Arrays;

public final class zzix extends zziu {
    public zzix() {
        super(4);
    }

    public final zzix zza(Object... objArr) {
        zzjd.zzb(objArr, 15);
        int i11 = this.zzb + 15;
        Object[] objArr2 = this.zza;
        int length = objArr2.length;
        if (length < i11) {
            int i12 = length + (length >> 1) + 1;
            if (i12 < i11) {
                int highestOneBit = Integer.highestOneBit(i11 - 1);
                i12 = highestOneBit + highestOneBit;
            }
            if (i12 < 0) {
                i12 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr2, i12);
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr2.clone();
            this.zzc = false;
        }
        System.arraycopy(objArr, 0, this.zza, this.zzb, 15);
        this.zzb += 15;
        return this;
    }

    public final zzja zzb() {
        this.zzc = true;
        return zzja.zzg(this.zza, this.zzb);
    }
}
