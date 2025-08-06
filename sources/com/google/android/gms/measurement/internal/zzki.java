package com.google.android.gms.measurement.internal;

final class zzki implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzkp zzb;

    public zzki(zzkp zzkp, long j11) {
        this.zzb = zzkp;
        this.zza = j11;
    }

    public final void run() {
        zzkp.zzj(this.zzb, this.zza);
    }
}
