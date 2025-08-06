package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class zzm implements Runnable {
    public final /* synthetic */ zzcf zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ AppMeasurementDynamiteService zzd;

    public zzm(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf, String str, String str2) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzcf;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void run() {
        this.zzd.zza.zzt().zzv(this.zza, this.zzb, this.zzc);
    }
}
