package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.internal.zzi;
import com.google.android.play.core.review.internal.zzt;

class zzg extends com.google.android.play.core.review.internal.zzg {
    public final zzi zza;
    public final TaskCompletionSource zzb;
    public final /* synthetic */ zzi zzc;

    public zzg(zzi zzi, zzi zzi2, TaskCompletionSource taskCompletionSource) {
        this.zzc = zzi;
        this.zza = zzi2;
        this.zzb = taskCompletionSource;
    }

    public void zzb(Bundle bundle) throws RemoteException {
        zzt zzt = this.zzc.zza;
        if (zzt != null) {
            zzt.zzr(this.zzb);
        }
        this.zza.zzd("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
