package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzjn implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzjz zzb;

    public zzjn(zzjz zzjz, zzq zzq) {
        this.zzb = zzjz;
        this.zza = zzq;
    }

    public final void run() {
        zzjz zzjz = this.zzb;
        zzej zzh = zzjz.zzb;
        if (zzh == null) {
            zzjz.zzt.zzaA().zzd().zza("Failed to send consent settings to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzh.zzp(this.zza);
            this.zzb.zzQ();
        } catch (RemoteException e11) {
            this.zzb.zzt.zzaA().zzd().zzb("Failed to send consent settings to the service", e11);
        }
    }
}
