package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzit implements Runnable {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzir zzb;
    public final /* synthetic */ zzir zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ zziz zze;

    public zzit(zziz zziz, Bundle bundle, zzir zzir, zzir zzir2, long j11) {
        this.zze = zziz;
        this.zza = bundle;
        this.zzb = zzir;
        this.zzc = zzir2;
        this.zzd = j11;
    }

    public final void run() {
        zziz.zzp(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
