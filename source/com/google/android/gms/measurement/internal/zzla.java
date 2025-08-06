package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

final class zzla implements Callable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzlh zzb;

    public zzla(zzlh zzlh, zzq zzq) {
        this.zzb = zzlh;
        this.zza = zzq;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzhb zzq = this.zzb.zzq((String) Preconditions.checkNotNull(this.zza.zza));
        zzha zzha = zzha.ANALYTICS_STORAGE;
        if (zzq.zzj(zzha) && zzhb.zzc(this.zza.zzv, 100).zzj(zzha)) {
            return this.zzb.zzd(this.zza).zzw();
        }
        this.zzb.zzaA().zzj().zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
