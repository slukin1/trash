package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzfo implements Callable {
    public final /* synthetic */ zzfu zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfo(zzfu zzfu, String str) {
        this.zza = zzfu;
        this.zzb = str;
    }

    public final Object call() {
        return new zzn("internal.remoteConfig", new zzft(this.zza, this.zzb));
    }
}
