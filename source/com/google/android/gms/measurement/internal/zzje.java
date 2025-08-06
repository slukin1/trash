package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

final class zzje implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzq zzb;
    public final /* synthetic */ zzjz zzc;

    public zzje(zzjz zzjz, AtomicReference atomicReference, zzq zzq) {
        this.zzc = zzjz;
        this.zza = atomicReference;
        this.zzb = zzq;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.zza) {
            try {
                if (!this.zzc.zzt.zzm().zzc().zzj(zzha.ANALYTICS_STORAGE)) {
                    this.zzc.zzt.zzaA().zzl().zza("Analytics storage consent denied; will not get app instance id");
                    this.zzc.zzt.zzq().zzO((String) null);
                    this.zzc.zzt.zzm().zze.zzb((String) null);
                    this.zza.set((Object) null);
                    this.zza.notify();
                    return;
                }
                zzjz zzjz = this.zzc;
                zzej zzh = zzjz.zzb;
                if (zzh == null) {
                    zzjz.zzt.zzaA().zzd().zza("Failed to get app instance id");
                    this.zza.notify();
                    return;
                }
                Preconditions.checkNotNull(this.zzb);
                this.zza.set(zzh.zzd(this.zzb));
                String str = (String) this.zza.get();
                if (str != null) {
                    this.zzc.zzt.zzq().zzO(str);
                    this.zzc.zzt.zzm().zze.zzb(str);
                }
                this.zzc.zzQ();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e11) {
                try {
                    this.zzc.zzt.zzaA().zzd().zzb("Failed to get app instance id", e11);
                    atomicReference = this.zza;
                } catch (Throwable th2) {
                    this.zza.notify();
                    throw th2;
                }
            }
        }
    }
}
