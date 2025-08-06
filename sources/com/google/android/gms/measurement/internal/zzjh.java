package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzjh implements Runnable {
    public final /* synthetic */ zzir zza;
    public final /* synthetic */ zzjz zzb;

    public zzjh(zzjz zzjz, zzir zzir) {
        this.zzb = zzjz;
        this.zza = zzir;
    }

    public final void run() {
        zzjz zzjz = this.zzb;
        zzej zzh = zzjz.zzb;
        if (zzh == null) {
            zzjz.zzt.zzaA().zzd().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzir zzir = this.zza;
            if (zzir == null) {
                zzh.zzq(0, (String) null, (String) null, zzjz.zzt.zzaw().getPackageName());
            } else {
                zzh.zzq(zzir.zzc, zzir.zza, zzir.zzb, zzjz.zzt.zzaw().getPackageName());
            }
            this.zzb.zzQ();
        } catch (RemoteException e11) {
            this.zzb.zzt.zzaA().zzd().zzb("Failed to send current screen to the service", e11);
        }
    }
}
