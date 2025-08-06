package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzhf;

final class zzdv extends zzch {
    private final zzhf zza;

    public zzdv(zzhf zzhf) {
        this.zza = zzhf;
    }

    public final int zzd() {
        return System.identityHashCode(this.zza);
    }

    public final void zze(String str, String str2, Bundle bundle, long j11) {
        this.zza.interceptEvent(str, str2, bundle, j11);
    }
}
