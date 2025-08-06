package com.google.android.play.core.review.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

final class zzm extends zzj {
    public final /* synthetic */ zzj zza;
    public final /* synthetic */ zzt zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzm(zzt zzt, TaskCompletionSource taskCompletionSource, zzj zzj) {
        super(taskCompletionSource);
        this.zzb = zzt;
        this.zza = zzj;
    }

    public final void zza() {
        zzt.zzm(this.zzb, this.zza);
    }
}
