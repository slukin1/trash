package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

public final /* synthetic */ class zzkc implements Runnable {
    public final /* synthetic */ zzkg zza;
    public final /* synthetic */ zzet zzb;
    public final /* synthetic */ JobParameters zzc;

    public /* synthetic */ zzkc(zzkg zzkg, zzet zzet, JobParameters jobParameters) {
        this.zza = zzkg;
        this.zzb = zzet;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zzd(this.zzb, this.zzc);
    }
}
