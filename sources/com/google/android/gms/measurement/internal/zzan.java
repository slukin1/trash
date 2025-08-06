package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzby;

abstract class zzan {
    private static volatile Handler zza;
    private final zzgy zzb;
    private final Runnable zzc;
    /* access modifiers changed from: private */
    public volatile long zzd;

    public zzan(zzgy zzgy) {
        Preconditions.checkNotNull(zzgy);
        this.zzb = zzgy;
        this.zzc = new zzam(this, zzgy);
    }

    private final Handler zzf() {
        Handler handler;
        if (zza != null) {
            return zza;
        }
        synchronized (zzan.class) {
            if (zza == null) {
                zza = new zzby(this.zzb.zzaw().getMainLooper());
            }
            handler = zza;
        }
        return handler;
    }

    public final void zzb() {
        this.zzd = 0;
        zzf().removeCallbacks(this.zzc);
    }

    public abstract void zzc();

    public final void zzd(long j11) {
        zzb();
        if (j11 >= 0) {
            this.zzd = this.zzb.zzax().currentTimeMillis();
            if (!zzf().postDelayed(this.zzc, j11)) {
                this.zzb.zzaA().zzd().zzb("Failed to schedule delayed post. time", Long.valueOf(j11));
            }
        }
    }

    public final boolean zze() {
        return this.zzd != 0;
    }
}
