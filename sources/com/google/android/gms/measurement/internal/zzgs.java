package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class zzgs implements Callable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzgv zzb;

    public zzgs(zzgv zzgv, String str) {
        this.zzb = zzgv;
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.zzb.zza.zzA();
        return this.zzb.zza.zzh().zzu(this.zza);
    }
}
