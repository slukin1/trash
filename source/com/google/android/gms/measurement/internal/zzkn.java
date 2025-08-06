package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzph;
import com.hbg.lib.network.pro.core.util.Period;

final class zzkn {
    public long zza;
    public long zzb;
    public final /* synthetic */ zzkp zzc;
    private final zzan zzd;

    public zzkn(zzkp zzkp) {
        this.zzc = zzkp;
        this.zzd = new zzkm(this, zzkp.zzt);
        long elapsedRealtime = zzkp.zzt.zzax().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    public final void zza() {
        this.zzd.zzb();
        this.zza = 0;
        this.zzb = 0;
    }

    public final void zzb(long j11) {
        this.zzd.zzb();
    }

    public final void zzc(long j11) {
        this.zzc.zzg();
        this.zzd.zzb();
        this.zza = j11;
        this.zzb = j11;
    }

    public final boolean zzd(boolean z11, boolean z12, long j11) {
        this.zzc.zzg();
        this.zzc.zza();
        zzph.zzc();
        if (!this.zzc.zzt.zzf().zzs((String) null, zzeg.zzaf)) {
            this.zzc.zzt.zzm().zzj.zzb(this.zzc.zzt.zzax().currentTimeMillis());
        } else if (this.zzc.zzt.zzJ()) {
            this.zzc.zzt.zzm().zzj.zzb(this.zzc.zzt.zzax().currentTimeMillis());
        }
        long j12 = j11 - this.zza;
        if (z11 || j12 >= 1000) {
            if (!z12) {
                j12 = j11 - this.zzb;
                this.zzb = j11;
            }
            this.zzc.zzt.zzaA().zzj().zzb("Recording user engagement, ms", Long.valueOf(j12));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j12);
            zzlp.zzK(this.zzc.zzt.zzs().zzj(!this.zzc.zzt.zzf().zzu()), bundle, true);
            if (!z12) {
                this.zzc.zzt.zzq().zzG(TtmlNode.TEXT_EMPHASIS_AUTO, "_e", bundle);
            }
            this.zza = j11;
            this.zzd.zzb();
            this.zzd.zzd(Period.MIN60_MILLS);
            return true;
        }
        this.zzc.zzt.zzaA().zzj().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j12));
        return false;
    }
}
