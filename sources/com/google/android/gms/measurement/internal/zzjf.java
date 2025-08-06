package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;

final class zzjf implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzcf zzb;
    public final /* synthetic */ zzjz zzc;

    public zzjf(zzjz zzjz, zzq zzq, zzcf zzcf) {
        this.zzc = zzjz;
        this.zza = zzq;
        this.zzb = zzcf;
    }

    public final void run() {
        zzgd zzgd;
        String str = null;
        try {
            if (!this.zzc.zzt.zzm().zzc().zzj(zzha.ANALYTICS_STORAGE)) {
                this.zzc.zzt.zzaA().zzl().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzt.zzq().zzO((String) null);
                this.zzc.zzt.zzm().zze.zzb((String) null);
                zzgd = this.zzc.zzt;
            } else {
                zzjz zzjz = this.zzc;
                zzej zzh = zzjz.zzb;
                if (zzh == null) {
                    zzjz.zzt.zzaA().zzd().zza("Failed to get app instance id");
                    zzgd = this.zzc.zzt;
                } else {
                    Preconditions.checkNotNull(this.zza);
                    str = zzh.zzd(this.zza);
                    if (str != null) {
                        this.zzc.zzt.zzq().zzO(str);
                        this.zzc.zzt.zzm().zze.zzb(str);
                    }
                    this.zzc.zzQ();
                    zzgd = this.zzc.zzt;
                }
            }
        } catch (RemoteException e11) {
            this.zzc.zzt.zzaA().zzd().zzb("Failed to get app instance id", e11);
            zzgd = this.zzc.zzt;
        } catch (Throwable th2) {
            this.zzc.zzt.zzv().zzW(this.zzb, (String) null);
            throw th2;
        }
        zzgd.zzv().zzW(this.zzb, str);
    }
}
