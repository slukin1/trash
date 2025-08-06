package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzt;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzfq implements Callable {
    public final /* synthetic */ zzfu zza;

    public /* synthetic */ zzfq(zzfu zzfu) {
        this.zza = zzfu;
    }

    public final Object call() {
        return new zzt(this.zza.zze);
    }
}
