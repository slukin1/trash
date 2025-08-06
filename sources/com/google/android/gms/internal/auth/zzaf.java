package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

final class zzaf extends zzah {
    public final /* synthetic */ zzag zza;

    public zzaf(zzag zzag) {
        this.zza = zzag;
    }

    public final void zzc(boolean z11) {
        this.zza.setResult(new zzak(z11 ? Status.RESULT_SUCCESS : zzal.zza));
    }
}
