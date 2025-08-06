package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzic implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzik zzb;

    public zzic(zzik zzik, AtomicReference atomicReference) {
        this.zzb = zzik;
        this.zza = atomicReference;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Integer.valueOf(this.zzb.zzt.zzf().zze(this.zzb.zzt.zzh().zzl(), zzeg.zzN)));
                this.zza.notify();
            } catch (Throwable th2) {
                this.zza.notify();
                throw th2;
            }
        }
    }
}
