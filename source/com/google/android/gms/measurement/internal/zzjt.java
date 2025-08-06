package com.google.android.gms.measurement.internal;

final class zzjt implements Runnable {
    public final /* synthetic */ zzej zza;
    public final /* synthetic */ zzjy zzb;

    public zzjt(zzjy zzjy, zzej zzej) {
        this.zzb = zzjy;
        this.zza = zzej;
    }

    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzL()) {
                this.zzb.zza.zzt.zzaA().zzj().zza("Connected to service");
                this.zzb.zza.zzJ(this.zza);
            }
        }
    }
}
