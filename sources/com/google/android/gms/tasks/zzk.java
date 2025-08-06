package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;

final class zzk implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzl zzb;

    public zzk(zzl zzl, Task task) {
        this.zzb = zzl;
        this.zza = task;
    }

    public final void run() {
        synchronized (this.zzb.zzb) {
            zzl zzl = this.zzb;
            if (zzl.zzc != null) {
                zzl.zzc.onFailure((Exception) Preconditions.checkNotNull(this.zza.getException()));
            }
        }
    }
}
