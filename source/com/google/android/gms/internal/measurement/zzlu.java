package com.google.android.gms.internal.measurement;

final class zzlu extends zzlw {
    private zzlu() {
        super((zzlv) null);
    }

    public /* synthetic */ zzlu(zzlt zzlt) {
        super((zzlv) null);
    }

    public final void zza(Object obj, long j11) {
        ((zzli) zznu.zzf(obj, j11)).zzb();
    }

    public final void zzb(Object obj, Object obj2, long j11) {
        zzli zzli = (zzli) zznu.zzf(obj, j11);
        zzli zzli2 = (zzli) zznu.zzf(obj2, j11);
        int size = zzli.size();
        int size2 = zzli2.size();
        if (size > 0 && size2 > 0) {
            if (!zzli.zzc()) {
                zzli = zzli.zzd(size2 + size);
            }
            zzli.addAll(zzli2);
        }
        if (size > 0) {
            zzli2 = zzli;
        }
        zznu.zzs(obj, j11, zzli2);
    }
}
