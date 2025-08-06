package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzgn implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzgv zzb;

    public zzgn(zzgv zzgv, zzq zzq) {
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
        zzhb zzc2 = zzhb.zzc(zzq.zzv, 100);
        zzhb zzq2 = zzc.zzq(zzq.zza);
        zzc.zzaA().zzj().zzc("Setting consent, package, consent", zzq.zza, zzc2);
        zzc.zzV(zzq.zza, zzc2);
        if (zzc2.zzm(zzq2)) {
            zzc.zzQ(zzq);
        }
    }
}
