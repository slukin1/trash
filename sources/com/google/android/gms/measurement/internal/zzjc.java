package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzjc implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzlk zzc;
    public final /* synthetic */ zzjz zzd;

    public zzjc(zzjz zzjz, zzq zzq, boolean z11, zzlk zzlk) {
        this.zzd = zzjz;
        this.zza = zzq;
        this.zzb = z11;
        this.zzc = zzlk;
    }

    public final void run() {
        zzlk zzlk;
        zzjz zzjz = this.zzd;
        zzej zzh = zzjz.zzb;
        if (zzh == null) {
            zzjz.zzt.zzaA().zzd().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjz zzjz2 = this.zzd;
        if (this.zzb) {
            zzlk = null;
        } else {
            zzlk = this.zzc;
        }
        zzjz2.zzD(zzh, zzlk, this.zza);
        this.zzd.zzQ();
    }
}
