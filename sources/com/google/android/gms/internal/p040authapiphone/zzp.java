package com.google.android.gms.internal.p040authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzp  reason: invalid package */
final class zzp extends zzd {
    public final /* synthetic */ TaskCompletionSource zza;

    public zzp(zzr zzr, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(Status status, int i11) {
        TaskUtil.setResultOrApiException(status, Integer.valueOf(i11), this.zza);
    }
}
