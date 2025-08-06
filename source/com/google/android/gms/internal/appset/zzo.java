package com.google.android.gms.internal.appset;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.appset.zzc;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzo extends zze {
    public final /* synthetic */ TaskCompletionSource zza;

    public zzo(zzp zzp, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(Status status, zzc zzc) {
        TaskUtil.setResultOrApiException(status, zzc != null ? new AppSetIdInfo(zzc.zzb(), zzc.zza()) : null, this.zza);
    }
}
