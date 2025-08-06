package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzu;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzfp implements Callable {
    public final /* synthetic */ zzfu zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfp(zzfu zzfu, String str) {
        this.zza = zzfu;
        this.zzb = str;
    }

    public final Object call() {
        return new zzu("internal.appMetadata", new zzfn(this.zza, this.zzb));
    }
}
