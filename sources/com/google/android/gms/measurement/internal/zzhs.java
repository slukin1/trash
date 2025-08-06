package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzhs implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzik zzb;

    public zzhs(zzik zzik, long j11) {
        this.zzb = zzik;
        this.zza = j11;
    }

    public final void run() {
        this.zzb.zzL(this.zza, true);
        this.zzb.zzt.zzt().zzu(new AtomicReference());
    }
}
