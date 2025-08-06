package com.google.android.gms.tasks;

final class zzc implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzd zzb;

    public zzc(zzd zzd, Task task) {
        this.zzb = zzd;
        this.zza = task;
    }

    public final void run() {
        if (this.zza.isCanceled()) {
            this.zzb.zzc.zzc();
            return;
        }
        try {
            this.zzb.zzc.zzb(this.zzb.zzb.then(this.zza));
        } catch (RuntimeExecutionException e11) {
            if (e11.getCause() instanceof Exception) {
                this.zzb.zzc.zza((Exception) e11.getCause());
            } else {
                this.zzb.zzc.zza(e11);
            }
        } catch (Exception e12) {
            this.zzb.zzc.zza(e12);
        }
    }
}
