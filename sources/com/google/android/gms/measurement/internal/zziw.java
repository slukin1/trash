package com.google.android.gms.measurement.internal;

final class zziw implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zziz zzb;

    public zziw(zziz zziz, long j11) {
        this.zzb = zziz;
        this.zza = j11;
    }

    public final void run() {
        this.zzb.zzt.zzd().zzf(this.zza);
        this.zzb.zza = null;
    }
}
