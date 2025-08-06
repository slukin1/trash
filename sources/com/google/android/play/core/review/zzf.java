package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.internal.zzj;

final class zzf extends zzj {
    public final /* synthetic */ TaskCompletionSource zza;
    public final /* synthetic */ zzi zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzf(zzi zzi, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzb = zzi;
        this.zza = taskCompletionSource2;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.core.review.internal.zzf] */
    public final void zza() {
        try {
            ? zze = this.zzb.zza.zze();
            String zzc = this.zzb.zzc;
            Bundle zza2 = zzj.zza();
            zzi zzi = this.zzb;
            zze.zzc(zzc, zza2, new zzh(zzi, this.zza, zzi.zzc));
        } catch (RemoteException e11) {
            zzi.zzb.zzc(e11, "error requesting in-app review for %s", this.zzb.zzc);
            this.zza.trySetException(new RuntimeException(e11));
        }
    }
}
