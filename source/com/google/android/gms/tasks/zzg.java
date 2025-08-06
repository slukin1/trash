package com.google.android.gms.tasks;

final class zzg implements Runnable {
    public final /* synthetic */ zzh zza;

    public zzg(zzh zzh) {
        this.zza = zzh;
    }

    public final void run() {
        synchronized (this.zza.zzb) {
            zzh zzh = this.zza;
            if (zzh.zzc != null) {
                zzh.zzc.onCanceled();
            }
        }
    }
}
