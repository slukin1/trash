package com.google.android.gms.tasks;

final class zzm implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzn zzb;

    public zzm(zzn zzn, Task task) {
        this.zzb = zzn;
        this.zza = task;
    }

    public final void run() {
        synchronized (this.zzb.zzb) {
            zzn zzn = this.zzb;
            if (zzn.zzc != null) {
                zzn.zzc.onSuccess(this.zza.getResult());
            }
        }
    }
}
