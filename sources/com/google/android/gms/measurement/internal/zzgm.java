package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzgm implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzgv zzb;

    public zzgm(zzgv zzgv, zzq zzq) {
        this.zzb = zzgv;
        this.zza = zzq;
    }

    public final void run() {
        this.zzb.zza.zzA();
        zzlh zzc = this.zzb.zza;
        zzq zzq = this.zza;
        zzc.zzaB().zzg();
        zzc.zzB();
        Preconditions.checkNotEmpty(zzq.zza);
        zzc.zzd(zzq);
    }
}
