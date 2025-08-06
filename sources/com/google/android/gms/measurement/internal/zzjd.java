package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzjd implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzjz zzb;

    public zzjd(zzjz zzjz, zzq zzq) {
        this.zzb = zzjz;
        this.zza = zzq;
    }

    public final void run() {
        zzjz zzjz = this.zzb;
        zzej zzh = zzjz.zzb;
        if (zzh == null) {
            zzjz.zzt.zzaA().zzd().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzh.zzm(this.zza);
        } catch (RemoteException e11) {
            this.zzb.zzt.zzaA().zzd().zzb("Failed to reset data on the service: remote exception", e11);
        }
        this.zzb.zzQ();
    }
}
