package com.google.android.play.core.review.internal;

import android.os.IBinder;

final class zzp extends zzj {
    public final /* synthetic */ IBinder zza;
    public final /* synthetic */ zzs zzb;

    public zzp(zzs zzs, IBinder iBinder) {
        this.zzb = zzs;
        this.zza = iBinder;
    }

    public final void zza() {
        this.zzb.zza.zzn = zze.zzb(this.zza);
        zzt.zzn(this.zzb.zza);
        this.zzb.zza.zzh = false;
        for (Runnable run : this.zzb.zza.zze) {
            run.run();
        }
        this.zzb.zza.zze.clear();
    }
}
