package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdo extends zzdu {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzef zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdo(zzef zzef, Bundle bundle) {
        super(zzef, true);
        this.zzb = zzef;
        this.zza = bundle;
    }

    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzb.zzj)).setDefaultEventParameters(this.zza);
    }
}
