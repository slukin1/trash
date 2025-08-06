package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzjo implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzau zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ zzjz zze;

    public zzjo(zzjz zzjz, boolean z11, zzq zzq, boolean z12, zzau zzau, String str) {
        this.zze = zzjz;
        this.zza = zzq;
        this.zzb = z12;
        this.zzc = zzau;
        this.zzd = str;
    }

    public final void run() {
        zzau zzau;
        zzjz zzjz = this.zze;
        zzej zzh = zzjz.zzb;
        if (zzh == null) {
            zzjz.zzt.zzaA().zzd().zza("Discarding data. Failed to send event to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjz zzjz2 = this.zze;
        if (this.zzb) {
            zzau = null;
        } else {
            zzau = this.zzc;
        }
        zzjz2.zzD(zzh, zzau, this.zza);
        this.zze.zzQ();
    }
}
