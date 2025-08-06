package com.google.android.gms.measurement.internal;

final class zzkh implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzkp zzb;

    public zzkh(zzkp zzkp, long j11) {
        this.zzb = zzkp;
        this.zza = j11;
    }

    public final void run() {
        zzkp.zzl(this.zzb, this.zza);
    }
}
