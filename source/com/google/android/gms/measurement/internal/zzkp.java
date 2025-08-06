package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzby;

public final class zzkp extends zzf {
    public final zzko zza = new zzko(this);
    public final zzkn zzb = new zzkn(this);
    public final zzkl zzc = new zzkl(this);
    /* access modifiers changed from: private */
    public Handler zzd;
    private boolean zze = true;

    public zzkp(zzgd zzgd) {
        super(zzgd);
    }

    public static /* bridge */ /* synthetic */ void zzj(zzkp zzkp, long j11) {
        zzkp.zzg();
        zzkp.zzp();
        zzkp.zzt.zzaA().zzj().zzb("Activity paused, time", Long.valueOf(j11));
        zzkp.zzc.zza(j11);
        if (zzkp.zzt.zzf().zzu()) {
            zzkp.zzb.zzb(j11);
        }
    }

    public static /* bridge */ /* synthetic */ void zzl(zzkp zzkp, long j11) {
        zzkp.zzg();
        zzkp.zzp();
        zzkp.zzt.zzaA().zzj().zzb("Activity resumed, time", Long.valueOf(j11));
        if (zzkp.zzt.zzf().zzs((String) null, zzeg.zzaG)) {
            if (zzkp.zzt.zzf().zzu() || zzkp.zze) {
                zzkp.zzb.zzc(j11);
            }
        } else if (zzkp.zzt.zzf().zzu() || zzkp.zzt.zzm().zzm.zzb()) {
            zzkp.zzb.zzc(j11);
        }
        zzkp.zzc.zzb();
        zzko zzko = zzkp.zza;
        zzko.zza.zzg();
        if (zzko.zza.zzt.zzJ()) {
            zzko.zzb(zzko.zza.zzt.zzax().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: private */
    public final void zzp() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new zzby(Looper.getMainLooper());
        }
    }

    public final boolean zzf() {
        return false;
    }

    public final void zzm(boolean z11) {
        zzg();
        this.zze = z11;
    }

    public final boolean zzo() {
        zzg();
        return this.zze;
    }
}
