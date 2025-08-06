package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzcw extends zzdu {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzef zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcw(zzef zzef, long j11) {
        super(zzef, true);
        this.zzb = zzef;
        this.zza = j11;
    }

    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzb.zzj)).setSessionTimeoutDuration(this.zza);
    }
}
