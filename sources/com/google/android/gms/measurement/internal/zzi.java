package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class zzi implements Runnable {
    public final /* synthetic */ zzcf zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzcf;
    }

    public final void run() {
        this.zzb.zza.zzt().zzt(this.zza);
    }
}
