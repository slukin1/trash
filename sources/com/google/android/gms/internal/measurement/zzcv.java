package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzcv extends zzdu {
    public final /* synthetic */ zzef zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcv(zzef zzef) {
        super(zzef, true);
        this.zza = zzef;
    }

    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zza.zzj)).resetAnalyticsData(this.zzh);
    }
}
