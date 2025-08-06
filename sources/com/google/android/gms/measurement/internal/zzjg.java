package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class zzjg implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzjz zzb;

    public zzjg(zzjz zzjz, zzq zzq) {
        this.zzb = zzjz;
        this.zza = zzq;
    }

    public final void run() {
        zzjz zzjz = this.zzb;
        zzej zzh = zzjz.zzb;
        if (zzh == null) {
            zzjz.zzt.zzaA().zzd().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzh.zzj(this.zza);
            this.zzb.zzt.zzi().zzm();
            this.zzb.zzD(zzh, (AbstractSafeParcelable) null, this.zza);
            this.zzb.zzQ();
        } catch (RemoteException e11) {
            this.zzb.zzt.zzaA().zzd().zzb("Failed to send app launch to the service", e11);
        }
    }
}
