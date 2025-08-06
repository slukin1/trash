package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzji implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ Bundle zzb;
    public final /* synthetic */ zzjz zzc;

    public zzji(zzjz zzjz, zzq zzq, Bundle bundle) {
        this.zzc = zzjz;
        this.zza = zzq;
        this.zzb = bundle;
    }

    public final void run() {
        zzjz zzjz = this.zzc;
        zzej zzh = zzjz.zzb;
        if (zzh == null) {
            zzjz.zzt.zzaA().zzd().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzh.zzr(this.zzb, this.zza);
        } catch (RemoteException e11) {
            this.zzc.zzt.zzaA().zzd().zzb("Failed to send default event parameters to service", e11);
        }
    }
}
