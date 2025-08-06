package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

final class zzjb implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzq zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ zzjz zzd;

    public zzjb(zzjz zzjz, AtomicReference atomicReference, zzq zzq, boolean z11) {
        this.zzd = zzjz;
        this.zza = atomicReference;
        this.zzb = zzq;
        this.zzc = z11;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.zza) {
            try {
                zzjz zzjz = this.zzd;
                zzej zzh = zzjz.zzb;
                if (zzh == null) {
                    zzjz.zzt.zzaA().zzd().zza("Failed to get all user properties; not connected to service");
                    this.zza.notify();
                    return;
                }
                Preconditions.checkNotNull(this.zzb);
                this.zza.set(zzh.zze(this.zzb, this.zzc));
                this.zzd.zzQ();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e11) {
                try {
                    this.zzd.zzt.zzaA().zzd().zzb("Failed to get all user properties; remote exception", e11);
                    atomicReference = this.zza;
                } catch (Throwable th2) {
                    this.zza.notify();
                    throw th2;
                }
            }
        }
    }
}
