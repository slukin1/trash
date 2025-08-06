package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.hbg.lib.network.pro.core.util.Period;

final class zzkq {
    private final Clock zza;
    private long zzb;

    public zzkq(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.zza = clock;
    }

    public final void zza() {
        this.zzb = 0;
    }

    public final void zzb() {
        this.zzb = this.zza.elapsedRealtime();
    }

    public final boolean zzc(long j11) {
        return this.zzb == 0 || this.zza.elapsedRealtime() - this.zzb >= Period.MIN60_MILLS;
    }
}
