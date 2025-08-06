package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzos;
import com.google.android.gms.internal.measurement.zzqu;

final class zzko {
    public final /* synthetic */ zzkp zza;

    public zzko(zzkp zzkp) {
        this.zza = zzkp;
    }

    public final void zza() {
        this.zza.zzg();
        if (this.zza.zzt.zzm().zzk(this.zza.zzt.zzax().currentTimeMillis())) {
            this.zza.zzt.zzm().zzg.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzt.zzaA().zzj().zza("Detected application was in foreground");
                zzc(this.zza.zzt.zzax().currentTimeMillis(), false);
            }
        }
    }

    public final void zzb(long j11, boolean z11) {
        this.zza.zzg();
        this.zza.zzp();
        if (this.zza.zzt.zzm().zzk(j11)) {
            this.zza.zzt.zzm().zzg.zza(true);
            zzqu.zzc();
            if (this.zza.zzt.zzf().zzs((String) null, zzeg.zzan)) {
                this.zza.zzt.zzh().zzo();
            }
        }
        this.zza.zzt.zzm().zzj.zzb(j11);
        if (this.zza.zzt.zzm().zzg.zzb()) {
            zzc(j11, z11);
        }
    }

    public final void zzc(long j11, boolean z11) {
        this.zza.zzg();
        if (this.zza.zzt.zzJ()) {
            this.zza.zzt.zzm().zzj.zzb(j11);
            this.zza.zzt.zzaA().zzj().zzb("Session started, time", Long.valueOf(this.zza.zzt.zzax().elapsedRealtime()));
            Long valueOf = Long.valueOf(j11 / 1000);
            this.zza.zzt.zzq().zzY(TtmlNode.TEXT_EMPHASIS_AUTO, "_sid", valueOf, j11);
            this.zza.zzt.zzm().zzk.zzb(valueOf.longValue());
            this.zza.zzt.zzm().zzg.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.zza.zzt.zzf().zzs((String) null, zzeg.zzab) && z11) {
                bundle.putLong("_aib", 1);
            }
            this.zza.zzt.zzq().zzH(TtmlNode.TEXT_EMPHASIS_AUTO, "_s", j11, bundle);
            zzos.zzc();
            if (this.zza.zzt.zzf().zzs((String) null, zzeg.zzae)) {
                String zza2 = this.zza.zzt.zzm().zzp.zza();
                if (!TextUtils.isEmpty(zza2)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_ffr", zza2);
                    this.zza.zzt.zzq().zzH(TtmlNode.TEXT_EMPHASIS_AUTO, "_ssr", j11, bundle2);
                }
            }
        }
    }
}
