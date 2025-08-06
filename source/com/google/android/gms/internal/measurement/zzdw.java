package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzhg;

final class zzdw extends zzch {
    private final zzhg zza;

    public zzdw(zzhg zzhg) {
        this.zza = zzhg;
    }

    public final int zzd() {
        return System.identityHashCode(this.zza);
    }

    public final void zze(String str, String str2, Bundle bundle, long j11) {
        this.zza.onEvent(str, str2, bundle, j11);
    }
}
