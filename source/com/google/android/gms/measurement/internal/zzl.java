package com.google.android.gms.measurement.internal;

final class zzl implements Runnable {
    public final /* synthetic */ zzo zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzo zzo) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzo;
    }

    public final void run() {
        this.zzb.zza.zzq().zzT(this.zza);
    }
}
