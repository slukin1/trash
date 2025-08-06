package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzid implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzik zzb;

    public zzid(zzik zzik, AtomicReference atomicReference) {
        this.zzb = zzik;
        this.zza = atomicReference;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Double.valueOf(this.zzb.zzt.zzf().zza(this.zzb.zzt.zzh().zzl(), zzeg.zzO)));
                this.zza.notify();
            } catch (Throwable th2) {
                this.zza.notify();
                throw th2;
            }
        }
    }
}
