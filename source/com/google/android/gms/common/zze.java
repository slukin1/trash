package com.google.android.gms.common;

import java.util.concurrent.Callable;

public final /* synthetic */ class zze implements Callable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzj zzc;

    public /* synthetic */ zze(boolean z11, String str, zzj zzj) {
        this.zza = z11;
        this.zzb = str;
        this.zzc = zzj;
    }

    public final Object call() {
        return zzn.zzd(this.zza, this.zzb, this.zzc);
    }
}
