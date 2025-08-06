package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzqo;

public final /* synthetic */ class zzkj implements Runnable {
    public final /* synthetic */ zzkk zza;

    public /* synthetic */ zzkj(zzkk zzkk) {
        this.zza = zzkk;
    }

    public final void run() {
        zzkk zzkk = this.zza;
        zzkl zzkl = zzkk.zzc;
        long j11 = zzkk.zza;
        long j12 = zzkk.zzb;
        zzkl.zza.zzg();
        zzkl.zza.zzt.zzaA().zzc().zza("Application going to the background");
        zzkl.zza.zzt.zzm().zzm.zza(true);
        zzkl.zza.zzm(true);
        if (!zzkl.zza.zzt.zzf().zzu()) {
            zzkl.zza.zzb.zzb(j12);
            zzkl.zza.zzb.zzd(false, false, j12);
        }
        zzqo.zzc();
        if (zzkl.zza.zzt.zzf().zzs((String) null, zzeg.zzaB)) {
            zzkl.zza.zzt.zzaA().zzi().zzb("Application backgrounded at: timestamp_millis", Long.valueOf(j11));
        } else {
            zzkl.zza.zzt.zzq().zzH(TtmlNode.TEXT_EMPHASIS_AUTO, "_ab", j11, new Bundle());
        }
    }
}
