package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzhw implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzik zzb;

    public zzhw(zzik zzik, AtomicReference atomicReference) {
        this.zzb = zzik;
        this.zza = atomicReference;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Boolean.valueOf(this.zzb.zzt.zzf().zzs(this.zzb.zzt.zzh().zzl(), zzeg.zzK)));
                this.zza.notify();
            } catch (Throwable th2) {
                this.zza.notify();
                throw th2;
            }
        }
    }
}
