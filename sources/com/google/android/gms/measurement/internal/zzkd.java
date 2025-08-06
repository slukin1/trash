package com.google.android.gms.measurement.internal;

import android.content.Intent;

public final /* synthetic */ class zzkd implements Runnable {
    public final /* synthetic */ zzkg zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzet zzc;
    public final /* synthetic */ Intent zzd;

    public /* synthetic */ zzkd(zzkg zzkg, int i11, zzet zzet, Intent intent) {
        this.zza = zzkg;
        this.zzb = i11;
        this.zzc = zzet;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zzc(this.zzb, this.zzc, this.zzd);
    }
}
