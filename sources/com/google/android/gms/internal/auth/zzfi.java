package com.google.android.gms.internal.auth;

final class zzfi extends zzfk {
    private zzfi() {
        super((zzfj) null);
    }

    public /* synthetic */ zzfi(zzfh zzfh) {
        super((zzfj) null);
    }

    public final void zza(Object obj, long j11) {
        ((zzey) zzhi.zzf(obj, j11)).zzb();
    }

    public final void zzb(Object obj, Object obj2, long j11) {
        zzey zzey = (zzey) zzhi.zzf(obj, j11);
        zzey zzey2 = (zzey) zzhi.zzf(obj2, j11);
        int size = zzey.size();
        int size2 = zzey2.size();
        if (size > 0 && size2 > 0) {
            if (!zzey.zzc()) {
                zzey = zzey.zzd(size2 + size);
            }
            zzey.addAll(zzey2);
        }
        if (size > 0) {
            zzey2 = zzey;
        }
        zzhi.zzp(obj, j11, zzey2);
    }
}
