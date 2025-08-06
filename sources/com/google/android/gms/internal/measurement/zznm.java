package com.google.android.gms.internal.measurement;

import java.io.IOException;

final class zznm extends zznk {
    public final /* synthetic */ int zza(Object obj) {
        return ((zznl) obj).zza();
    }

    public final /* synthetic */ int zzb(Object obj) {
        return ((zznl) obj).zzb();
    }

    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzlb zzlb = (zzlb) obj;
        zznl zznl = zzlb.zzc;
        if (zznl != zznl.zzc()) {
            return zznl;
        }
        zznl zzf = zznl.zzf();
        zzlb.zzc = zzf;
        return zzf;
    }

    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzlb) obj).zzc;
    }

    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zznl.zzc().equals(obj2)) {
            return obj;
        }
        if (zznl.zzc().equals(obj)) {
            return zznl.zze((zznl) obj, (zznl) obj2);
        }
        ((zznl) obj).zzd((zznl) obj2);
        return obj;
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i11, long j11) {
        ((zznl) obj).zzj(i11 << 3, Long.valueOf(j11));
    }

    public final void zzg(Object obj) {
        ((zzlb) obj).zzc.zzh();
    }

    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzlb) obj).zzc = (zznl) obj2;
    }

    public final /* synthetic */ void zzi(Object obj, zzoc zzoc) throws IOException {
        ((zznl) obj).zzk(zzoc);
    }
}
