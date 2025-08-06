package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zze implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzf zzb;

    public zze(zzf zzf, Task task) {
        this.zzb = zzf;
        this.zza = task;
    }

    public final void run() {
        try {
            Task task = (Task) this.zzb.zzb.then(this.zza);
            if (task == null) {
                this.zzb.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.zza;
            task.addOnSuccessListener(executor, this.zzb);
            task.addOnFailureListener(executor, (OnFailureListener) this.zzb);
            task.addOnCanceledListener(executor, (OnCanceledListener) this.zzb);
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
