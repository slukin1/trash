package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzcu extends zzdu {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzef zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcu(zzef zzef, Bundle bundle) {
        super(zzef, true);
        this.zzb = zzef;
        this.zza = bundle;
    }

    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzb.zzj)).setConsentThirdParty(this.zza, this.zzh);
    }
}
